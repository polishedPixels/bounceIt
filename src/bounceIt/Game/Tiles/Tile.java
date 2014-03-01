package bounceIt.Game.Tiles;

import static org.lwjgl.opengl.GL11.*;

public class Tile {

	int posX, posY;
	int type;// 0 = open, 1 = closed
	double size;

	public Tile(int X, int Y, int Type) {
		posX = X;
		posY = Y;
		type = Type;
		size = TileMap.tileSize;
	}
	public void draw() {

		switch (type) {
			case 0 :
				glColor3d(0, 0, 0);
				break;
			case 1 :
				glColor3d(1, 1, 1);
				break;
			default :
				System.err.println(type + " is not a valid Tile Type");
				glColor3d(0.831, 0, 1);
				break;
		}
		glBegin(GL_QUADS);
		{
			glVertex2d((posX * size), (posY * size));
			glVertex2d((posX * size) + size, (posY * size));
			glVertex2d((posX * size) + size, (posY * size) + size);
			glVertex2d((posX * size), (posY * size) + size);

		}
		glEnd();

	}

}
