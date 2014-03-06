package bounceIt.Game.Levels;

import bounceIt.Game.Obj.Tile;
import bounceIt.Game.Obj.TileMap;

public class Level {

	//must be same size as TileMap.tileMap
	public int[][] map = 		{{1,1,1,1,1,1,1,1,1,1}, 
						  		{1,2,0,0,0,0,0,0,2,1}, 
						  		{1,0,3,0,0,0,0,2,0,1}, 
						  		{1,0,0,2,0,0,3,0,0,1}, 
						  		{1,0,0,0,2,3,0,0,0,4}, 
						  		{1,0,0,0,2,0,0,0,0,5}, 
						  		{1,0,0,3,0,2,0,0,0,1}, 
						  		{1,0,2,0,0,0,2,0,0,1}, 
						  		{1,2,0,0,0,0,0,3,0,1}, 
						  		{1,1,1,1,1,1,1,1,1,1}}; 
	public static int curLevel;
	public static Level[] levels = new Level[2];									
	
	public static void load(int loadLevel) {
		
		curLevel = loadLevel;
		Level loadMap = levels[curLevel];
		
		for(int x = 0; x < TileMap.worldSize[0]; x++){
			for(int y = 0; y < TileMap.worldSize[1]; y++){
				
				TileMap.setTile(x, y, loadMap.map[y][x]);
				
			}
		}
	}

}