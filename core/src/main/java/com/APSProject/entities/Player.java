package com.APSProject.entities;
import com.APSProject.components.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class Player extends ActorEntity{

    public Player(
        long id,
        Position position,
        Sprite path,
        Velocity velocity,
        Health health
    ){
        super(
            id,
            position,
            path,
            velocity,
            health
        );
    }
    @Override
    public void Update(float deltaTime){
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            this.position.y += this.velocity.vy*deltaTime;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            this.position.y -= this.velocity.vy*deltaTime;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            this.position.x -= this.velocity.vx*deltaTime;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            this.position.x += this.velocity.vx*deltaTime;
        }
    }
}
