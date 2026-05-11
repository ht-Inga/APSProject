package com.APSProject.entities;
import com.APSProject.components.*;

public class Enemy extends ActorEntity {
    public Enemy(
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
}
