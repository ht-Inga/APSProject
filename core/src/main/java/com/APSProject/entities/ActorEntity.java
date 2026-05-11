package com.APSProject.entities;
import com.APSProject.components.*;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ActorEntity extends Entity{

    public Velocity velocity;
    public Health health;

    public ActorEntity(
        long id,
        Position position,
        Sprite path,
        Velocity velocity,
        Health health
    ) {
        super(
            id,
            position,
            path
        );

        this.velocity = velocity;
        this.health = health;

    }
    @Override
    public void Draw(SpriteBatch batch){
        batch.draw(new Texture(this.path.path), this.position.x, this.position.y);
        for (int i = 0; i < this.health.hp; i++) {
            batch.draw(new Texture("sprites/ht.png"), this.position.x-this.health.maxHP*0.8f+i*3.5f, this.position.y+16, 5,5);}
        for (int i = this.health.hp; i < this.health.maxHP; i++) {
            batch.draw(new Texture("sprites/emptyht.png"), this.position.x-10.5f+i*3.5f, this.position.y+16, 5,5);}

    }
}
