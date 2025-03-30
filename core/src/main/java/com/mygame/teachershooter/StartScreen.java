package com.mygame.teachershooter;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class StartScreen implements Screen {

    private final TeacherShooter game;
    private final SpriteBatch batch;
    private final Texture background;


    public StartScreen(TeacherShooter game) {
        this.game = game;
        batch = new SpriteBatch();
        background = game.assetManager.get("backgrounds/lab_background.png", Texture.class);

    }

    @Override
    public void render(float delta) {
        if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
            game.setScreen(new GameScreen()); // Start game on Enter key
        }

        batch.begin();
        batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();

    }

    public void show() {}
    public void resize(int width, int height) {}
    public void pause() {}
    public void resume() {}
    public void hide() {}
}
