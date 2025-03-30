package com.mygame.teachershooter;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class Enemy {
    private final Texture texture;
    private final Vector2 position;
    private boolean isAlive;
    private final Player player;
   private float speed=50;
   private float changeDirectionTimer=0;
   private Vector2 direction;
    private final float enemyWidth;
    private float enemyHeight;
    public Enemy(float x, float y, Player player) {
        texture = new Texture("characters/enemy.png");
        position = new Vector2(x, y);
        isAlive = true;
        enemyWidth=texture.getWidth();
        enemyHeight=texture.getHeight();
        this.player = player;
        pickRandomDirection();
    }
    private void pickRandomDirection() {
        float angle=MathUtils.random(0f,360f);
        direction =new Vector2(MathUtils.cosDeg(angle),MathUtils.sinDeg(angle)).nor();
    }

    public void update(float delta) {
        if (isAlive) {
            // Move towards the player
            float dx =  position.x- player.getPosition().x;
            float dy =  position.y-player.getPosition().y;
            float length = (float) Math.sqrt(dx * dx + dy * dy);

            if (position.x <= 0 ||position.x+enemyWidth>=1280 ||position.y <= 0 ||position.y+enemyHeight>=720) {
               position.set(640-enemyWidth/2,360-enemyHeight/2);
            }


            direction.nor();
            if (length > 5) { // Prevent shaking at close range
                // Enemy movement speed
                float speed = 150f;
                position.x += (dx /length) * speed * delta;
                position.y += (dy /length) * speed * delta;
            }
            changeDirectionTimer +=delta;
            float changeDirectionInterval = 2f;
            if(changeDirectionTimer>= changeDirectionInterval){
                pickRandomDirection();
                changeDirectionTimer=0;
            }
            position.add(direction.scl(speed*delta));;
        }
    }

    public void draw(SpriteBatch batch) {
        if (isAlive) {
            batch.draw(texture, position.x, position.y);
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(position.x, position.y, texture.getWidth(), texture.getHeight());
    }

    public void kill() {
        isAlive = false;
    }

    public boolean isAlive() {
        return isAlive;
    }
}