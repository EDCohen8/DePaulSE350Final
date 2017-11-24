package game;
import java.awt.Point;

public class OceanPiece implements GamePiece{

	int x,y;
	//OCEAN CONSTRUCTOR
	public OceanPiece(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void move(int xPos, int yPos) {
		// TODO Auto-generated method stub
		System.out.println("OCEAN CANNOT MOVE");
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return "O";
	}

	@Override
	public GamePiece getObject() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public Point getLocation() {
		// TODO Auto-generated method stub
		return new Point(x,y);
	}

}
