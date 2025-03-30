package com.mygame.teachershooter;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.audio.Sound;
public class GameScreen implements Screen {
    private SpriteBatch batch;
    private Player player;
    private Array<Enemy> enemies;
    private final Sound hitsound;
    private final Sound nothitsound;
    public GameScreen() {
        batch = new SpriteBatch();
        player = new Player(200, 50);
        enemies = new Array<>();
       hitsound = Gdx.audio.newSound(Gdx.files.internal("sounds/hit_sound.wav"));;
        spawnEnemies();
        nothitsound = Gdx.audio.newSound(Gdx.files.internal("sounds/laughing.wav"));;
        spawnEnemies();
    }

    private void spawnEnemies() {
        for (int i = 0; i < 5; i++) {
            enemies.add(new Enemy(MathUtils.random(100, 600), MathUtils.random(300, 500), player));
        }
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();

        player.update(delta);
        player.draw(batch);

        for (Enemy enemy : enemies) {
            enemy.update(delta);
            enemy.draw(batch);
        }

        checkCollisions();

        batch.end();
    }

    private void checkCollisions() {
        for (Enemy enemy : enemies) {
            for (Bullet bullet : player.getBullets()) {
                if (bullet.getBounds().overlaps(enemy.getBounds()) && enemy.isAlive()) {
                    enemy.kill();
                    hitsound.play();
                }

            }
        }
    }

    @Override
    public void dispose() {
        batch.dispose();
    }

    // Other required override methods (empty for now)
    @Override public void resize(int width, int height) {}
    @Override public void show() {}
    @Override public void hide() {}
    @Override public void pause() {}
    @Override public void resume() {}

    public void shoot() {
    }
}