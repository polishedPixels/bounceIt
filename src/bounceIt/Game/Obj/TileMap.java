package bounceIt.Game.Obj;

public class TileMap {

	public static final double tileSize = 64;
	public static final int[] worldSize = {10, 10};
	public static Tile[][] tileMap = new Tile[worldSize[0]][worldSize[1]];

	public static void Init() {
		for (int x = 0; x < worldSize[0]; x++) {
			for (int y = 0; y < worldSize[1]; y++) {

				tileMap[x][y] = new Tile(x, y, 1);

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
	public static Tile getTilefromArray(int X, int Y) {

		return tileMap[X][Y];

	}
	public static Tile getTilefromDouble(double X, double Y) {

		int x = (int) (X / tileSize);
		int y = (int) (Y / tileSize);

		return tileMap[x][y];

	}

}
