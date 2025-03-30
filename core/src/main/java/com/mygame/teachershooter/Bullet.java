package com.mygame.teachershooter;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.Gdx;

public class Bullet {
    static final float SPEED = 400;
    private final Texture texture;
    private float x, y;
    private final Rectangle bounds;

    public Bullet(float x, float y) {
        this.texture = new Texture(Gdx.files.internal("bullet.png"));
        this.x = x;
        this.y = y;
        this.bounds = new Rectangle(x, y, texture.getWidth(), texture.getHeight());
    }



    public void draw(SpriteBatch batch) {
        batch.draw(texture, x, y,texture.getWidth(), texture.getHeight());
    }

    public boolean isOutOfBounds() {
        return y > Gdx.graphics.getHeight();
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void dispose() {
        texture.dispose();
    }

    public void update(float delta) {
    }
}