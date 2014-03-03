package bounceIt.Game.Obj;

public abstract class TileMap {

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

		int px = (int) (X / tileSize);
		int py = (int) (Y / tileSize);

		return tileMap[px][py];

	}
	public static void setTile(int X,int Y,int ChangeTo){
		tileMap[X][Y] = new Tile(X, Y, ChangeTo);
	}

}
