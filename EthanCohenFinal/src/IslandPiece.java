import java.awt.Point;

public class IslandPiece implements GamePiece {

	int x, y;
	
	public IslandPiece(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void move(int xPos, int yPos) {
		System.out.println("ISLAND CANNOT MOVE");
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return "I";
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
