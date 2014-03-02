package bounceIt.Game.Obj;

public class Point {
	public double posX,posY;
	public Tile curTile;
	
	public Point(double X,double Y){
		posX = X;
		posY = Y;
		
		curTile = TileMap.getTilefromDouble(X, Y);
	}
	public void setPos(double X, double Y){
		posX = X;
		posY = Y;
		
		curTile = TileMap.getTilefromDouble(X, Y);
	}
	
}
