package bounceIt.Game;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import bounceIt.Game.Levels.Level;
import bounceIt.Game.Obj.Ball;
import bounceIt.Game.Obj.TileMap;
import bounceIt.Game.Time.Time;
import bounceIt.Game.textures.TextureHandler;

public class Main {

	public static final String WINDOW_TITLE = "Sample Program";
	public static final int[] WINDOW_DIMENSIONS = {600, 600};
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
		glOrtho(0, 640, 640, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		glEnable(GL_TEXTURE_2D);
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		System.out.println("Penis");

	}

	private static void update() {
		Display.update();
		Display.sync(Sync);
		
		greenBall.Update();
		
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
	private static void setUpTextures(){
		
		TextureHandler.loadAndPutSprite("open");
		TextureHandler.loadAndPutSprite("closed");
		TextureHandler.loadAndPutSprite("negSlope");
		TextureHandler.loadAndPutSprite("posSlope");
		TextureHandler.loadAndPutSprite("greenBall");
		TextureHandler.loadAndPutSprite("greenStart");
	}

	private static void setUpObjects() {
		TileMap.Init();
		Level.load();
		greenBall = new Ball(100, 200, 0);
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
		setUpTextures();
		enterGameLoop();
		cleanUp(false);
	}

}