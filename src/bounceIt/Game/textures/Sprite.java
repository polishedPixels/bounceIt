package bounceIt.Game.textures;

import org.newdawn.slick.opengl.Texture;

public class Sprite {
	
	public Texture texture;
	public int types;
	public int frames;

	public Sprite(Texture text) {

		texture = text;
		try {
			types = texture.getImageHeight() / TextureHandler.textSize;
			frames = texture.getImageWidth() / TextureHandler.textSize;

		} catch (Exception e) {

			System.err.println("ADD TEXTHEIGHT (TextureHandler Class)");

			System.exit(1);

		}

	}

}
