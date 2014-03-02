package bounceIt.Game;

import static org.lwjgl.opengl.GL11.GL_BLEND;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glBlendFunc;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import bounceIt.Game.Obj.Ball;
import bounceIt.Game.Obj.TileMap;
import bounceIt.Game.Time.Time;

public class Main {

	public static final String WINDOW_TITLE = "Sample Program";
	public static final int[] WINDOW_DIMENSIONS = {800, 600};
	public static final int Sync = 60;
	
	public static Ball greenBall;

	private static void render() {
		glClear(GL_COLOR_BUFFER_BIT);

		TileMap.draw();
		greenBall.draw();
	}

	private static void input() {

	}

	private static void cleanUp(boolean asCrash) {
		Display.destroy();
		System.exit(asCrash ? 1 : 0);
	}

	private static void setUpMatrices() {
		glMatrixMode(GL_PROJECTION);
		glOrtho(0, 640, 480, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		glEnable(GL_TEXTURE_2D);
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);

	}

	private static void update() {
		Display.update();
		Display.sync(Sync);
		
		greenBall.Update();
		
		System.out.println(Time.getDelta());

	}

	private static void enterGameLoop() {
		while (!Display.isCloseRequested()) {
			Time.lastFrame = Time.getTime();
			render();
			input();
			update();
			Time.getDelta();
		}
	}

	private static void setUpObjects() {
		TileMap.Init();
		greenBall = new Ball(100, 100, 0);
	}

	private static void setUpDisplay() {
		try {
			Display.setDisplayMode(new DisplayMode(WINDOW_DIMENSIONS[0],
					WINDOW_DIMENSIONS[1]));
			Display.setTitle(WINDOW_TITLE);
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
			cleanUp(true);
		}
	}

	public static void main(String[] args) {
		setUpDisplay();
		setUpObjects();
		setUpMatrices();
		enterGameLoop();
		cleanUp(false);
	}

}