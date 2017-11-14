import java.awt.Point;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;

public class PlayerShip extends Observable implements GamePiece, PowerUpInterface {

	int x, y;
	Grid grid;
	GamePiece[][] map;
	ShipMovementInterface shipMovementStrat;
	Random rand = new Random();
	ArrayList<PowerUpDecorator> decoratorList = new ArrayList<PowerUpDecorator>();
	public PlayerShip(){
		grid = grid.getInstance();
		map = grid.getMap();
		x = rand.nextInt(map.length);
		y = rand.nextInt(map[0].length);
		grid.addShip(x, y, this);
		shipMovementStrat = new BasicShipMovement(this);
	}
	
	@Override
	public void move(int xPos, int yPos) {
		//not implemented because the ship moves according to an interface
	}

	//returns a value that can be displayed on the map
	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return "S";
	}

	//returns the game object
	@Override
	public GamePiece getObject() {
		// TODO Auto-generated method stub
		return this;
	}
	
	//Increments the x variable how you see fit (+1 or -1 usually)
	public void incrementX(int i){
		x = x + i;
	}
	
	//Increments the y variable how you see fit (+1 or -1 usually)
	public void incrementY(int i){
		y = y + i; 
	}
	
	//Change the way you want the ship to move
	public void changeMovementStrat(ShipMovementInterface movementStrat) {
		shipMovementStrat = movementStrat;
	}
	
	public void addDecorator(PowerUpDecorator a){
		decoratorList.add(a);
	}

	@Override
	public Point getLocation() {
		// TODO Auto-generated method stub
		return new Point(x,y);
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "SHIP";
	}

	@Override
	public void power() {
		// TODO Auto-generated method stub
		
	}

}
