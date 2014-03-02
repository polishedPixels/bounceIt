package bounceIt.Game.Obj;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor3d;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2d;

public class Ball {

	double posX, posY;
	double velX, velY;
	Tile curTile;
	int type; // 0 = green
	int dir; // 0 = N, 1 = E, 2 = S, 3 = W
	final double size = 30;
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
	}

	private void physics() {

		switch (dir) {
			case 0 :
				//posY -= velY * Time.getDelta();
				break;
			case 1 :
				//posX += velX * Time.getDelta();
				break;
			case 2 :
			//	posY += velY * Time.getDelta();
				break;
			case 3 :
			//	posX -= velX * Time.getDelta();
				break;

			default :
				break;
		}

		colPoint = new Point(posX, posY);

		System.out.println(colPoint.curTile.type);
	}

	public void draw() {
		switch (type) {
			case 0 :
				glColor3d(0, 1, 0.067);
				break;

			default :
				break;
		}
		glBegin(GL_QUADS);
		{
			glVertex2d(posX, posY);
			glVertex2d(posX + size, posY);
			glVertex2d(posX + size, posY + size);
			glVertex2d(posX, posY + size);
		}
		glEnd();
	}

}
