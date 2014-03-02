package bounceIt.Game.Obj;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor3d;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glTexCoord2d;
import static org.lwjgl.opengl.GL11.glVertex2d;
import bounceIt.Game.Time.Time;
import bounceIt.Game.textures.TextureHandler;

public class Ball {

	double posX, posY;
	double velX, velY;
	Tile curTile;
	int type; // 0 = green
	int dir; // 0 = N, 1 = E, 2 = S, 3 = W
	final double size = 16;
	Point colPoint;

	public Ball(double X, double Y, int Type) {

		posX = X;
		posY = Y;
		type = Type;
		colPoint = new Point(X, Y);

		curTile = TileMap.getTilefromDouble(X, Y);

		velX = 1;
		velY = 1;

	}
	public void Update() {
		physics();
		colUpdate();
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
			glTexCoord2d(0,0); 
			glVertex2d(posX - size/2, posY - size/2);
			glTexCoord2d(1,0); 
			glVertex2d(posX + size/2, posY - size/2);
			glTexCoord2d(1,1); 
			glVertex2d(posX + size/2, posY + size/2);
			glTexCoord2d(0,1); 
			glVertex2d(posX - size/2, posY + size/2);
		
		}
		glEnd();
	}

}
