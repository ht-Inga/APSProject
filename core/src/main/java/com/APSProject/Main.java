package com.APSProject;

import com.APSProject.components.Health;
import com.APSProject.components.Position;
import com.APSProject.components.Velocity;
import com.APSProject.entities.EntityFactory;
import com.APSProject.entities.Player;
import com.APSProject.managers.EntityManager;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

import java.security.Key;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    private EntityManager entityManager;
    private EntityFactory entityFactory;
    private SpriteBatch batch;
    private OrthographicCamera camera;
    private Texture heart;
    private Texture emptyheart;

    @Override
    public void create() {
        entityManager = new EntityManager();
        entityFactory = new EntityFactory();
        batch = new SpriteBatch();
        heart = new Texture("sprites/ht.png");
        emptyheart = new Texture("sprites/emptyht.png");
        camera = new OrthographicCamera(1280, 720);
        entityManager.AddEntity(entityFactory.CreatePlayer(new Position(0, 0), new Velocity(15, 15), new Health(5, 5)));
        entityManager.AddEntity(entityFactory.CreateEnemy(new Position(0, 0), new Velocity(15, 15), new Health(3, 3)));
    }

    @Override
    public void render() {
        float deltaTime = Gdx.graphics.getDeltaTime();
        entityManager.Update(deltaTime);
        //camera.position.set(new Vector2(player.position.x+8, player.position.y+8),0);
        if (Gdx.input.isKeyPressed(Input.Keys.MINUS)) {
            camera.zoom += 0.1f;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.EQUALS)) {
            camera.zoom -= 0.1f;
        }
        camera.zoom = MathUtils.clamp(camera.zoom, 0.2f, 3);
        camera.update();

        //desenho
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        entityManager.Draw(batch);
        //for (int i = 0; i < player.health.hp/10; i++) {batch.draw(heart, player.position.x-10.5f+i*3.5f, player.position.y+16, 5,5);}
        //for (int i = player.health.hp/10; i < 10; i++) {batch.draw(emptyheart, player.position.x-10.5f+i*3.5f, player.position.y+16, 5,5);}
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
