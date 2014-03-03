package bounceIt.Game.Levels;

import bounceIt.Game.Obj.Tile;
import bounceIt.Game.Obj.TileMap;

public class Level {

	//must be same size as TileMap.tileMap
	public static int[][] map1 = {{1,1,1,1,1,1,1,1,1,1}, 
						  		{1,2,0,0,0,0,0,0,2,1}, 
						  		{1,0,3,0,0,0,0,2,0,1}, 
						  		{1,0,0,2,0,0,3,0,0,1}, 
						  		{1,0,0,0,2,3,0,0,0,4}, 
						  		{1,0,0,0,2,0,0,0,0,5}, 
						  		{1,0,0,3,0,2,0,0,0,1}, 
						  		{1,0,2,0,0,0,2,0,0,1}, 
						  		{1,2,0,0,0,0,0,3,0,1}, 
						  		{1,1,1,1,1,1,1,1,1,1}}; 
	public static int[][] curMap;
	public static Level[] levels = new Level[2];										
	
	public static void load(int [][]loadMap) {
		
		curMap = loadMap;
		
		for (int x = 0; x < TileMap.worldSize[0]; x++) {
			for (int y = 0; y < TileMap.worldSize[1]; y++) {
				TileMap.tileMap[y][x] = new Tile(y, x, curMap[x][y]);
			}

		}
	}

}