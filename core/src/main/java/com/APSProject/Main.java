package com.APSProject;

import com.APSProject.components.Health;
import com.APSProject.components.Position;
import com.APSProject.components.Velocity;
import com.APSProject.entities.Player;
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
    private SpriteBatch batch;
    private Texture image;
    private Player player;
    private OrthographicCamera camera;
    private Player player2;
    private Texture image2;
    private Player player3;
    private Texture image3;
    private Texture heart;
    private Texture emptyheart;

    @Override
    public void create() {
        batch = new SpriteBatch();
        image = new Texture("sprites/bixin.png");
        image2 = new Texture("sprites/nixib.png");
        image3 = new Texture("sprites/malvadeza.png");
        heart = new Texture("sprites/ht.png");
        emptyheart = new Texture("sprites/emptyht.png");
        camera = new OrthographicCamera(1280, 720);
        player = new Player(new Position(0, 0), new Velocity(50, 50), new Health(100, 50));
        player2 = new Player(new Position(0, 0), new Velocity(0, 0), new Health(100, 100));
        player3 = new Player(new Position(100, 0), new Velocity(0, 0), new Health(100, 100));
    }

    @Override
    public void render() {
        float deltaTime = Gdx.graphics.getDeltaTime();
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            player.position.y += player.velocity.vy*deltaTime;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            player.position.y -= player.velocity.vy*deltaTime;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            player.position.x -= player.velocity.vx*deltaTime;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            player.position.x += player.velocity.vx*deltaTime;
        }
        camera.position.set(new Vector2(player.position.x+8, player.position.y+8),0);
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
        batch.draw(image, player.position.x, player.position.y);
        batch.draw(image2, player2.position.x, player2.position.y);
        batch.draw(image3, player3.position.x, player3.position.y);
        for (int i = 0; i < player.health.hp/10; i++) {batch.draw(heart, player.position.x-10.5f+i*3.5f, player.position.y+16, 5,5);}
        for (int i = player.health.hp/10; i < 10; i++) {batch.draw(emptyheart, player.position.x-10.5f+i*3.5f, player.position.y+16, 5,5);}
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
    }
}
