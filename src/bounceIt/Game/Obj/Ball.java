package bounceIt.Game.Obj;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glTexCoord2d;
import static org.lwjgl.opengl.GL11.glVertex2d;
import bounceIt.Game.Main;
import bounceIt.Game.Levels.Level;
import bounceIt.Game.Time.Time;
import bounceIt.Game.textures.TextureHandler;

public class Ball {

	double posX, posY;
	double velX, velY;
	int type; // 0 = green
	int dir; // 0 = N, 1 = E, 2 = S, 3 = W
	final double size = 16;
	Point colPoint;
	Tile startTile = null;

	public Ball(double X, double Y, int Type) {

		posX = X;
		posY = Y;
		type = Type;
		colPoint = new Point(X, Y);

		velX = 1;
		velY = 1;

		for (int x = 0; x < TileMap.worldSize[0]; x++) {
			for (int y = 0; y < TileMap.worldSize[1]; y++) {

				if (TileMap.tileMap[x][y].type == 4) {
					startTile = TileMap.tileMap[x][y];
				}

			}
		}

		resetBall();

	}
	public void Update() {
		physics();
		colUpdate();
		posCorrection();
	}
	private void resetBall() {
		dir = 3;
		posX = (startTile.posX * TileMap.tileSize) - TileMap.tileSize / 2;
		posY = (startTile.posY * TileMap.tileSize) + TileMap.tileSize / 2;
	}

	private void posCorrection() {

		if (colPoint.curTile.type == 0) {
			if (dir == 0 || dir == 2) {
				double x1 = (colPoint.curTile.posX * TileMap.tileSize)
						+ TileMap.tileSize / 2;
				posX = x1;
			}
			if (dir == 1 || dir == 3) {
				double y1 = (colPoint.curTile.posY * TileMap.tileSize)
						+ TileMap.tileSize / 2;
				posY = y1;

			}
		}

	}
	private void physics() {

		switch (dir) {
			case 0 :
				posY -= velY * Time.getDelta();
				break;
			case 1 :
				posX += velX * Time.getDelta();
				break;
			case 2 :
				posY += velY * Time.getDelta();
				break;
			case 3 :
				posX -= velX * Time.getDelta();
				break;

			default :
				break;
		}

		colPoint = new Point(posX, posY);
	}
	private void colUpdate() {
		if (colPoint.curTile.type == 1) {
			// change direction
			switch (dir) {
				case 0 :
					dir = 2;
					break;
				case 1 :
					dir = 3;
					break;

				case 2 :
					dir = 0;
					break;

				case 3 :
					dir = 1;
					break;

				default :
					break;
			}
		} else if (colPoint.curTile.type == 4 && type == 0) {
			// change direction
			switch (dir) {
				case 0 :
					dir = 2;
					break;
				case 1 :
					dir = 3;
					break;

				case 2 :
					dir = 0;
					break;

				case 3 :
					dir = 1;
					break;

				default :
					break;
			}
		} else if (colPoint.curTile.type == 2) {
			switch (dir) {
				case 0 :
					dir = 1;
					break;
				case 1 :
					dir = 0;
					break;

				case 2 :
					dir = 3;
					break;

				case 3 :
					dir = 2;
					break;

				default :
					break;
			}
		} else if (colPoint.curTile.type == 3) {
			switch (dir) {
				case 0 :
					dir = 3;
					break;
				case 1 :
					dir = 2;
					break;
				case 2 :
					dir = 1;
					break;
				case 3 :
					dir = 0;
					break;

				default :
					break;
			}
		} else if (colPoint.curTile.type == 5) {
			resetBall();
			Level.load(1);
		}
	}

	public void draw() {
		switch (type) {
			case 0 :
				TextureHandler.getSprite("greenBall").texture.bind();
				break;

			default :
				break;
		}
		glBegin(GL_QUADS);
		{
			glTexCoord2d(0, 0);
			glVertex2d(posX - size / 2, posY - size / 2);
			glTexCoord2d(1, 0);
			glVertex2d(posX + size / 2, posY - size / 2);
			glTexCoord2d(1, 1);
			glVertex2d(posX + size / 2, posY + size / 2);
			glTexCoord2d(0, 1);
			glVertex2d(posX - size / 2, posY + size / 2);

		}
		glEnd();
	}

}
