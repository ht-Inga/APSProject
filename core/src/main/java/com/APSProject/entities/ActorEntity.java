package com.APSProject.entities;
import com.APSProject.components.*;

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
}
