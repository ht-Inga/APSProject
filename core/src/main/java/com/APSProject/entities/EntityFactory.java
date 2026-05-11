package com.APSProject.entities;
import com.APSProject.components.*;

public class EntityFactory {
    public Player CreatePlayer (
        Position position,
        Velocity velocity,
        Health health
    ) {
        return new Player (
            0,
            position,
            new Sprite("sprites/bixin.png"),
            velocity,
            health
        );
    }

    public Enemy CreateEnemy (
        Position position,
        Velocity velocity,
        Health health,
        Player player
    )   {
        return new Enemy(
            0,
            position,
            new Sprite("sprites/malvadeza.png"),
            velocity,
            health,
            player
        );
    }
}

