package com.APSProject.managers;
import com.APSProject.entities.Entity;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;

public class EntityManager {
    private List<Entity> entities = new ArrayList<>();
        public void AddEntity(
        Entity entity
    ) {
        entities.add(entity);
    }
    public void Update(float deltatime){
            for(
                Entity entity:entities
            ){
                entity.Update(deltatime);
            }
    }
    public void Draw(SpriteBatch batch){
        for(
            Entity entity:entities
        ){
            entity.Draw(batch);
        }
    }
}
