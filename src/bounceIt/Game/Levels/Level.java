package bounceIt.Game.Levels;

import bounceIt.Game.Obj.Tile;
import bounceIt.Game.Obj.TileMap;

public class Level {

	//must be same size as TileMap.tileMap
	static int[][] map = {{1,1,1,1,1,1,1,1,1,1}, 
						  {1,2,0,0,0,0,0,0,3,1}, 
						  {1,0,2,0,0,0,0,3,0,1}, 
						  {1,0,0,2,0,0,3,0,0,1}, 
						  {1,0,0,0,2,3,0,0,0,4}, 
						  {1,0,0,0,3,0,0,0,0,1}, 
						  {1,0,0,3,0,2,0,0,0,1}, 
						  {1,0,3,0,0,0,2,0,0,1}, 
						  {1,3,0,0,0,0,0,2,0,1}, 
						  {1,1,1,1,1,1,1,1,1,1}}; 
	public static Level[] levels = new Level[2];											
	public boolean complete = false;
	
	public static void load() {
		
		for (int x = 0; x < TileMap.worldSize[0]; x++) {
			for (int y = 0; y < TileMap.worldSize[1]; y++) {
				TileMap.tileMap[y][x] = new Tile(y, x, map[x][y]);
			}

		}
	}

}