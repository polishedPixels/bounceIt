package bounceIt.Game.textures;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

public class TextureHandler {

	public static Map<String, Sprite> sprites = new HashMap<String, Sprite>();
	public static int textSize = 32;

	public static void loadAndPutSprite(String key) {

		// Load
		
		Sprite tempSprite;
		try {
			tempSprite = loadSpritePNG(key);
		} catch (FileNotFoundException e) {

			tempSprite = null;
		}
		// Put
		addSprite(key, tempSprite);

	}

	public static Sprite getSprite(String key) {

		if (sprites.containsKey(key)) {

			return sprites.get(key);

		} else {
			return null;

		}

	}

	public static void addSprite(String key, Sprite sprite) {

		sprites.put(key, sprite);

	}

	public static Sprite loadSpritePNG(String key)
			throws FileNotFoundException {

		Texture tempText;

		try {
			tempText = TextureLoader.getTexture("PNG", new FileInputStream(
					new File("res/sprites/" + key + ".png")));
		} catch (IOException e) {
			
			System.err.println(key + " Texture Failed to Load!");
			return null;
		}

		return new Sprite(tempText);

	}

}
