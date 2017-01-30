package _47b3n.yseldar.engine.game;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import _47b3n.yseldar.engine.game.entity.Entity;
import _47b3n.yseldar.engine.game.entity.EntityID;
import _47b3n.yseldar.engine.game.entity.entities.LevelEnd;
import _47b3n.yseldar.engine.gamestate.gamestates.InGame;
import _47b3n.yseldar.engine.gfx.ImageLoader;
import _47b3n.yseldar.engine.gfx.SpriteSheet;

public class Player {

	private float x, y;
	private float velX, velY;
	private float width = 32, height = 32;
<<<<<<< HEAD:src/_47b3n/projectgame/engine/game/Player.java
	private float speed = 2;
=======
	private float speed = 4;
>>>>>>> e99294df5adae7fa6f8dc926b47474e1193681f2:src/_47b3n/yseldar/engine/game/Player.java

	private BufferedImage texture;

	private InGame inGame;
	private LinkedList<Entity> entities;

	public Player(int x, int y, InGame inGame) {
		this.x = x;
		this.y = y;
		this.inGame = inGame;

		entities = inGame.getEntities();

		texture = SpriteSheet.grabImage(ImageLoader.loadImage("/gfx/sheet.png"), 9, 8, 32, 32);
	}

	public void tick() {
		x += velX;
		y += velY;

		collision();
	}

	private void collision() {
		if (entities.isEmpty() || entities.size() <= 0) {
			return;
		}
		for (int i = 0; i < entities.size(); i++) {

			if (entities.get(i).getID() != EntityID.Enemy) {
				Entity entity = entities.get(i);

				if (entity.getID() == EntityID.LevelEnd) {
					LevelEnd end = (LevelEnd) entity;

					if (getBounds().intersects(end.getBounds())) {
						inGame.levelUp();
					}
				}

				if (getBoundsTop().intersects(entity.getBounds())) {
					y = entity.getY() + entity.getHeight();
					velY = 0;
				}

				if (getBoundsBottom().intersects(entity.getBounds())) {
					y = entity.getY() - entity.getHeight();
					velY = 0;
				}

				if (getBoundsLeft().intersects(entity.getBounds())) {
					x = entity.getX() + entity.getWidth();
					velX = 0;
				}

				if (getBoundsRight().intersects(entity.getBounds())) {
					x = entity.getX() - entity.getWidth();
					velX = 0;
				}
			}

			if (entities.get(i).getID() == EntityID.Enemy) {
				if (getBounds().intersects(entities.get(i).getBounds())) {
					inGame.changeHealth(-0.2F);
				} else {
					inGame.changeHealth(0);
				}
			}

		}
	}

	public void render(Graphics g) {
		g.drawImage(texture, (int) x, (int) y, null);
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public float getVelX() {
		return velX;
	}

	public float getVelY() {
		return velY;
	}

	public void setVelX(float velX) {
		this.velX = velX;
	}

	public void setVelY(float velY) {
		this.velY = velY;
	}

	public float getWidth() {
		return width;
	}

	public float getHeight() {
		return height;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, (int) width, (int) height);
	}

	public Rectangle getBoundsBottom() {
		return new Rectangle((int) x + ((int) width / 2) - ((int) (width / 2) / 2), (int) y + ((int) height / 2),
				(int) width / 2, (int) height / 2);
	}

	public Rectangle getBoundsTop() {
		return new Rectangle((int) x + ((int) width / 2) - ((int) (width / 2) / 2), (int) y, (int) width / 2,
				(int) height / 2);
	}

	public Rectangle getBoundsRight() {
		return new Rectangle((int) x + (int) width - 5, (int) y + 5, (int) 5, (int) height - 10);
	}

	public Rectangle getBoundsLeft() {
		return new Rectangle((int) x, (int) y + 5, (int) 5, (int) height - 10);
	}

}