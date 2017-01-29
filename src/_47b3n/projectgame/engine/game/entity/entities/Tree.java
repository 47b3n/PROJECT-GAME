package _47b3n.projectgame.engine.game.entity.entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import _47b3n.projectgame.engine.game.entity.Entity;
import _47b3n.projectgame.engine.game.entity.EntityID;
import _47b3n.projectgame.engine.gamestate.gamestates.InGame;
import _47b3n.projectgame.engine.gfx.ImageLoader;
import _47b3n.projectgame.engine.gfx.SpriteSheet;

public class Tree extends Entity {

	private float width = 32, height = 32;
	private BufferedImage texture;
	
	public Tree(float x, float y, EntityID id, InGame inGame) {
		super(x, y, id, inGame);
		
		texture = SpriteSheet.grabImage(ImageLoader.loadImage("/gfx/sheet.png"), 16, 1, 32, 32);
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(texture, (int) x, (int) y, null);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, (int) width, (int) height);
	}

	public float getWidth() {
		return width;
	}

	public float getHeight() {
		return height;
	}

}
