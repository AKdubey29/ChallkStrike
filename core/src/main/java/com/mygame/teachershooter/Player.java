package com.mygame.teachershooter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.audio.Sound;
public class Player {
    private Texture texture;
    private Vector2 position;
    private Array<Bullet> bullets;
    private float x;
    private float y;
    private final Sound gunShotSound;

    public Player(float x, float y) {
        gunShotSound = Gdx.audio.newSound(Gdx.files.internal("sounds/gunshot.wav"));;
        texture = new Texture("characters/player.png"); // Ensure the file exists in assets
        position = new Vector2(x, y);
        bullets = new Array<>();

    }
    public void update(float delta) {
        float speed = 200f;
        if (Gdx.input.isKeyPressed(Input.Keys.W)) position.y += speed * delta;
        if (Gdx.input.isKeyPressed(Input.Keys.S)) position.y -= speed * delta;
        if (Gdx.input.isKeyPressed(Input.Keys.A)) position.x -= speed * delta;
        if (Gdx.input.isKeyPressed(Input.Keys.D)) position.x += speed * delta;

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            bullets.add(new Bullet(position.x + (float) texture.getWidth() / 2, position.y));
            gunShotSound.play();
        }

        for (Bullet bullet : bullets) {
            bullet.update(delta);
        }
    }

    public void draw(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y);
        for (Bullet bullet : bullets) {
            bullet.draw(batch);
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(position.x, position.y, texture.getWidth(), texture.getHeight());
    }

    public Array<Bullet> getBullets() {
        return bullets;
    }

    public Vector2 getPosition() {
    return new Vector2(x,y);
    }
    public void dispose() {
        gunShotSound.dispose();
    }
}