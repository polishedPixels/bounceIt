package bounceIt.Game.Levels;

import bounceIt.Game.Obj.Tile;
import bounceIt.Game.Obj.TileMap;

public class Level {

	//must be same size as TileMap.tileMap
	public static int[][] map1 = {{1,1,1,1,1,1,1,1,1,1}, 
								  {1,0,0,0,0,0,0,0,0,1}, 
								  {1,0,0,0,0,0,0,0,0,1}, 
								  {1,0,0,0,0,0,0,0,0,1}, 
								  {1,0,0,0,3,0,0,0,0,4}, 
								  {1,0,0,0,0,0,0,0,0,1}, 
								  {1,0,0,0,0,0,0,0,0,1}, 
								  {1,0,0,0,0,0,0,0,0,1}, 
								  {1,0,0,0,0,0,0,0,0,1}, 
								  {1,1,1,1,5,1,1,1,1,1}}; 
	
	public static int[][] map2 = {{1,1,1,1,1,1,1,1,1,1}, 
  								  {1,0,0,0,0,0,0,0,0,1}, 
  								  {1,0,0,0,0,0,0,0,0,1}, 
  								  {1,0,0,0,0,0,0,0,0,1}, 
  								  {5,0,0,0,2,0,0,0,0,4}, 
  								  {1,0,0,0,0,0,0,0,0,1}, 
  								  {1,0,0,0,0,0,0,0,0,1}, 
  								  {1,0,0,0,0,0,0,0,0,1}, 
  								  {1,0,0,0,0,0,0,0,0,1}, 
  								  {1,1,1,1,1,1,1,1,1,1}}; 
	
	public static int[][] map3 = {{1,1,1,1,1,1,1,1,1,1}, 
								  {1,0,0,0,0,0,0,0,0,1}, 
								  {1,0,0,0,2,0,0,1,0,1}, 
								  {1,0,0,0,0,0,0,0,0,1}, 
								  {5,0,2,1,3,0,0,2,0,4}, 
								  {1,0,0,0,0,0,0,0,0,1}, 
								  {1,0,0,0,0,0,0,0,0,1}, 
								  {1,0,2,0,2,0,0,1,0,1}, 
								  {1,0,0,0,0,0,0,0,0,1}, 
								  {1,1,1,1,1,1,1,1,1,1}}; 
		 
		 
	public static int levelNum;
	public static int curLevelIndex = 0;
	public static int[/*X*/][/*Y*/][/*lvlIndex*/] levels;
	public static void levelSetUp(int levelnum){
		levels = new int[TileMap.worldSize[0]][TileMap.worldSize[1]][levelnum];	
		for (int l = 0; l < levelnum; l++) {
			for (int x = 0; x < TileMap.worldSize[0]; x++) {
				for (int y = 0; y < TileMap.worldSize[1]; y++) {
					switch (l) {
						case 0 :
							levels[x][y][l] = map1[x][y];
							break;
						case 1 :
							levels[x][y][l] = map2[x][y];
							break;
						case 2 :
							levels[x][y][l] = map3[x][y];
							break;

						default :
							break;
					}
					
				
				}

			}
		}
	}
	public static void load(int loadLevel) {
		
		int [][]curMap = new int [TileMap.worldSize[0]][TileMap.worldSize[1]];
		
		for (int x = 0; x < TileMap.worldSize[0]; x++) {
			for (int y = 0; y < TileMap.worldSize[1]; y++) {
				curMap[x][y] = levels[y][x][loadLevel];
			}

		}
		
		for (int x = 0; x < TileMap.worldSize[0]; x++) {
			for (int y = 0; y < TileMap.worldSize[1]; y++) {
				TileMap.tileMap[x][y] = new Tile(x, y, curMap[x][y]);
			}

		}
	}

}