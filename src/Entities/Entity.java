package Entities;

import Game.Main;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Entity {

    public int health;
    public int speed;
    public int value;
    public int position;
    public boolean survived;

    public Entity(int health, int speed, int value, int position, boolean survived) {

    this.health = health;
    this.speed = speed;
    this.value = value;
    this.position = position;
    this.survived = survived;

    }

    public abstract void Update(Graphics2D graphics);

    protected void Draw(Graphics2D graphics, BufferedImage sprite, int maxHP) {
        if (health > 0) {
            if (position < 830) {

                graphics.drawImage(sprite, position, 390, 40, 40, null);

                //drawing health bar
                graphics.setColor(Color.green);
                graphics.fillRect(position, 390 + 45, (health*35)/maxHP, 5);
                position += speed;
            }
            else if (survived) {
                survived = false;
                Main.lives--;
                Main.livingEnemies--;
            }

        }
        else if (survived){

            Main.gold += value;
            survived = false;
            Main.livingEnemies--;

        }
    }

}
