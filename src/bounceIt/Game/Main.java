package bounceIt.Game;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import bounceIt.Game.Levels.Level;
import bounceIt.Game.Obj.Ball;
import bounceIt.Game.Obj.Tile;
import bounceIt.Game.Obj.TileMap;
import bounceIt.Game.Time.Time;
import bounceIt.Game.textures.TextureHandler;

public class Main {

	public static final String WINDOW_TITLE = "Sample Program";
	public static final int[] WINDOW_DIMENSIONS = {640, 640};
	public static final int Sync = 60;

	public static Ball greenBall;
	public static Level curLevel;

	private static void render() {
		glClear(GL_COLOR_BUFFER_BIT);

		TileMap.draw();
		greenBall.draw();

	}

	private static void input() {
		mouseCheck();
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
	private static void setUpTextures() {

		TextureHandler.loadAndPutSprite("open");
		TextureHandler.loadAndPutSprite("closed");
		TextureHandler.loadAndPutSprite("negSlope");
		TextureHandler.loadAndPutSprite("posSlope");
		TextureHandler.loadAndPutSprite("greenBall");
		TextureHandler.loadAndPutSprite("greenStart");
		TextureHandler.loadAndPutSprite("orangeStart");
	}

	private static void setUpObjects() {
		TileMap.Init();
		Level.levelSetUp(3);
		Level.load(0);
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
	private static void mouseCheck() {
		double posX = Mouse.getX();
		double posY = WINDOW_DIMENSIONS[1] - Mouse.getY();

		Tile mouseTile;
		try {
			mouseTile = TileMap.getTilefromDouble(posX, posY);
		} catch (Exception e) {
			mouseTile = TileMap.getTilefromArray(0, 0);
		}

		while (Mouse.next()) {
			if (Mouse.getEventButtonState()) {
				if (Mouse.isButtonDown(0)) {
					switch (mouseTile.type) {
						case 2 :
							TileMap.setTile(mouseTile.posX, mouseTile.posY, 3);
							break;
						case 3 :
							TileMap.setTile(mouseTile.posX, mouseTile.posY, 2);
							break;

						default :
							break;
					}
				}
			}
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