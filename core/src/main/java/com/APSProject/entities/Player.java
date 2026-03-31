package com.APSProject.entities;
import com.APSProject.components.Health;
import com.APSProject.components.Position;
import com.APSProject.components.Velocity;
import com.APSProject.components.Health;

public class Player {

    public Velocity velocity;
    public Health health;
    public Position position;

    public Player (Position position, Velocity velocity, Health health) {
        this.position = position;
        this.velocity = velocity;
        this.health = health;
    }
}
