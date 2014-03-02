package bounceIt.Game.Obj;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor3d;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2d;
import bounceIt.Game.Time.Time;

public class Ball {

	double posX, posY;
	double velX,velY;
	Tile curTile;
	int type; // 0 = green
	final double size = 16;

	public Ball(double X, double Y, int Type) {

		posX = X;
		posY = Y;
		type = Type;

		curTile = TileMap.getTilefromDouble(X, Y);
		
		velX = 1;
		velY = 1;

	}
	public void Update(){
		physics();
	}
	
	private void physics(){
		posX +=velX * Time.getDelta();
		posY +=velY * Time.getDelta();
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
