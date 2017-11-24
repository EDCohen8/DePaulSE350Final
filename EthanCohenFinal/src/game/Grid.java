package game;
import java.util.Random;

//SINGLETON CLASS
public class Grid {

	private static Grid uniqueInstance;
	private GamePiece[][] map;
	int x,y;

	Random rand = new Random();
	int islandCount, wantedIslands, monsterValue;

	//private constructor that is called if there is no current instance
	private Grid(){
		map = new GamePiece[50][50];
		islandCount = 0;
		monsterValue = 0;
	}
	//gets or creates the singleton instance
	public static Grid getInstance(){
		if (uniqueInstance == null) {
			uniqueInstance = new Grid();
		}
		return uniqueInstance;
	}
	//populates the map with Oceans, Islands, Pirates, the Treasure, and the Ship
	public void populateMap(){
		for(int i = 0; i < map[0].length; i++){
			for (int j = 0; j < map.length; j++){
				if(!(map[i][j] instanceof PlayerShip)){
					map[i][j] = new OceanPiece(j, i); //might need to be (i,j) 
					System.out.println("TRUE");
				}
			}
		}
		placeIslands();
	}
	
	//instantiates islands onto the grid.
	public void placeIslands() {
		int randIslandNum = rand.nextInt(500);
		while(randIslandNum < 250){
			randIslandNum = rand.nextInt(500);
		}
		int islandX, islandY;
		while(randIslandNum > 0){
			islandX = rand.nextInt(map.length);
			islandY = rand.nextInt(map[0].length);
			if(map[islandY][islandX] instanceof OceanPiece){
				randIslandNum--;
				map[islandY][islandX] = new IslandPiece(islandX, islandY);
			}
		}
	}
	//adds the ship to the map
	public void addShip(int x, int y, PlayerShip s){
		map[y][x] = s;

	}
	//adds the pirate ship to the map
	public void addPirateShip(int x, int y, PirateShip p) {
		map[y][x] = p;
	}
	//adds the treasure to the map
	public void addTreasure(int x, int y) {
		
	}
	
	public void addMonster(int x, int y){

		monsterValue++;
	}

	//returns the array map so other objects can implement it
	public GamePiece[][] getMap() {
		return map;
	}

	//Displays the map in the console for testing purposes
	public void displayMap() {
		for(int i = 0; i < map[0].length; i++) {
			for(int j = 0; j < map.length; j++) {
				System.out.print(map[i][j].getValue() + " ");
			}
			System.out.println();
		}
	}	

}
