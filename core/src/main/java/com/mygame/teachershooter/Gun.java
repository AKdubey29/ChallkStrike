package com.mygame.teachershooter;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.Gdx;

public class Gun {
    private final GameScreen gameScreen;
    private final Sound gunShotSound;

    public Gun(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
        this.gunShotSound = Gdx.audio.newSound(Gdx.files.internal("sounds/gunshot.wav"));
    }

    public void shoot() {
        gunShotSound.play(); // Play gunshot sound
        gameScreen.shoot(); // Call shoot method in GameScreen
    }

    public void dispose() {
        gunShotSound.dispose();
    }
}