package com.APSProject.entities;
import com.APSProject.components.*;

public class Enemy extends ActorEntity {
    Player player;
    public Enemy(
        long id,
        Position position,
        Sprite path,
        Velocity velocity,
        Health health,
        Player player
    ){
        super(
            id,
            position,
            path,
            velocity,
            health
        );

        this.player = player;
    }
    @Override
    public void Update(float deltatime){
        float dx = player.position.x - this.position.x;
        float dy = player.position.y - this.position.y;

        float distance = (float)Math.sqrt(dx*dx+dy*dy);

        if(distance > 0){

            dx /= distance;
            dy /= distance;

            this.position.x += dx * this.velocity.vx*deltatime;
            this.position.y += dy * this.velocity.vy*deltatime;
        }
    }
}
