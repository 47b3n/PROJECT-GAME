package _47b3n.projectgame.engine.game.object.objects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import _47b3n.projectgame.engine.game.object.Entity;
import _47b3n.projectgame.engine.game.object.EntityID;
import _47b3n.projectgame.engine.gamestate.gamestates.InGame;
import _47b3n.projectgame.engine.gfx.ImageLoader;
import _47b3n.projectgame.engine.gfx.SpriteSheet;

public class StoneBlock extends Entity {

	private int width = 32, height = 32;
	private BufferedImage texture;
	
	public StoneBlock(float x, float y, EntityID id, InGame inGame) {
		super(x, y, id, inGame);
		
		texture = SpriteSheet.grabImage(ImageLoader.loadImage("/gfx/sheet.png"), 1, 1, 32, 32);
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
