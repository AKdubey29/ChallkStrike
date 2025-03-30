package com.mygame.teachershooter;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
public class TeacherShooter extends Game {
    public AssetManager assetManager;

    @Override
    public void create() {
        assetManager = new AssetManager();

        // Load assets
        assetManager.load("characters/player.png", Texture.class);
        assetManager.load("characters/enemy.png", Texture.class);
        assetManager.load("backgrounds/lab_background.png", Texture.class);
        assetManager.load("sounds/gunshot.wav", Sound.class);


        assetManager.finishLoading(); // Wait until everything is loaded

        // Start the game from StartScreen
        this.setScreen(new StartScreen(this));


    }

    @Override
    public void dispose() {
        assetManager.dispose();
    }
}


