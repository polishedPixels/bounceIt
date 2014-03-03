package bounceIt.Game.Obj;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor3d;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glTexCoord2d;
import static org.lwjgl.opengl.GL11.glVertex2d;
import bounceIt.Game.Obj.TileMap;
import bounceIt.Game.textures.TextureHandler;

public class Tile {

	public int posX, posY;
	public int type;
	public double size;

	public Tile(int X, int Y, int Type) {
		posX = X;
		posY = Y;
		type = Type;
		size = TileMap.tileSize;
	}
	public void draw() {

		switch (type) {
			case 0 :
				TextureHandler.getSprite("open").texture.bind();
				break;
			case 1 :
				TextureHandler.getSprite("closed").texture.bind();
				break;
			case 2:
				TextureHandler.getSprite("posSlope").texture.bind();
				break;
			case 3:
				TextureHandler.getSprite("negSlope").texture.bind();
				break;
			case 4: 
				TextureHandler.getSprite("greenStart").texture.bind();
				break;
			case 5: 
				TextureHandler.getSprite("orangeStart").texture.bind();
				break;
			default :
				//no valid type
				System.err.println(type + " is not a valid Tile Type");
				glColor3d(0.831, 0, 1);
				break;
		}
		glBegin(GL_QUADS);
		{
			glTexCoord2d(0,0); 
			glVertex2d((posX * size), (posY * size));
			glTexCoord2d(1,0); 
			glVertex2d((posX * size) + size, (posY * size));
			glTexCoord2d(1,1); 
			glVertex2d((posX * size) + size, (posY * size) + size);
			glTexCoord2d(0,1); 
			glVertex2d((posX * size), (posY * size) + size);

		}
		glEnd();

	}

}
