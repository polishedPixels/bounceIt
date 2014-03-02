package bounceIt.Game.Tiles;


public class TileMap {

	public static final double tileSize = 32;
	public static final int[] worldSize = {10, 10};
	public static Tile[][] tileMap = new Tile[worldSize[0]][worldSize[1]];

	public static void Init() {
		for (int x = 0; x < worldSize[0]; x++) {
			for (int y = 0; y < worldSize[1]; y++) {

				tileMap[x][y] = new Tile(x, y, 0);

			}
		}

	}
	public static void draw() {
		for (int x = 0; x < worldSize[0]; x++) {
			for (int y = 0; y < worldSize[1]; y++) {

				tileMap[x][y].draw();

			}
		}
	}

}
