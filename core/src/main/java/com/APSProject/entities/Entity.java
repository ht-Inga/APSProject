package com.APSProject.entities;
import com.APSProject.components.Position;
import com.APSProject.components.Sprite;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Entity {

    public long id;
    public Position position;
    public Sprite path;

    public Entity(
        long id,
        Position position,
        Sprite path

    ) {
        this.id = id;
        this.position = position;
        this.path = path;
    }
    public void Update(float deltatime){

    }
    public void Draw(SpriteBatch batch){
        batch.draw(new Texture(this.path.path), this.position.x, this.position.y);
    }

}
