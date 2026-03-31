package com.APSProject.entities;
import com.APSProject.components.Position;
import com.APSProject.components.Sprite;

public class Entity {

    public long id;
    public Position position;
    public Sprite path;

    public Entity (long id, Position position, Sprite path) {

        this.id = id;
        this.position = position;
        this.path = path;

    }

}
