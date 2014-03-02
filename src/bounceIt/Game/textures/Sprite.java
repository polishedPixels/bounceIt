package bounceIt.Game.textures;



import org.newdawn.slick.opengl.Texture;

import bounceIt.Game.Obj.Point;

public class Sprite {

	public Texture texture;
	int x;
	int y;

	public Point[][] textTiles;

	public Sprite(Texture text) {

		texture = text;
		try {
			x = texture.getImageHeight() / TextureHandler.textSize;
			y = texture.getImageWidth() / TextureHandler.textSize;

			textTiles = new Point[x][y];

			

		} catch (Exception e) {

			System.err.println("ADD TEXTHEIGHT (TextureHandler Class)");

			System.exit(1);

		}

	}

}
