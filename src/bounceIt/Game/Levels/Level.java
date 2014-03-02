package bounceIt.Game.Levels;

import bounceIt.Game.Obj.Tile;
import bounceIt.Game.Obj.TileMap;

public class Level {

	//must be same size as TileMap.tileMap
	static int[][] map = {{1,1,1,1,1,1,1,1,1,1}, 
						  {1,0,0,0,0,0,0,0,0,1}, 
						  {1,0,0,0,0,0,0,0,0,1}, 
						  {1,0,0,0,0,0,0,0,0,1}, 
						  {1,0,0,0,0,0,0,0,0,1}, 
						  {1,0,0,0,0,0,0,0,0,1}, 
						  {1,0,0,0,0,0,0,0,0,1}, 
						  {1,0,0,0,0,0,0,0,0,1}, 
						  {1,0,0,0,0,0,0,0,0,1}, 
						  {1,1,1,1,1,1,1,1,1,1}}; 
												
	
	public static void load() {
		
		for (int x = 0; x < TileMap.worldSize[0]; x++) {
			for (int y = 0; y < TileMap.worldSize[1]; y++) {
				TileMap.tileMap[x][y] = new Tile(x, y, map[x][y]);
			}

		}
	}

}
