package testing;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import game.*;

class NaoufalOceanMapTest {
	
	@Test
	void MapCreation() {
		OceanMap Map = game.Grid.getInstance()OceanMap.getMapInstance();
		assertTrue(Map != null);
	}
	
	// Checked with Equals method
	@Test
	void NoDuplicates() {
		OceanMap Map = OceanMap.getMapInstance();
		OceanMap Map2 = OceanMap.getMapInstance();
		assertTrue(Map.equals(Map2));
	}
	
	// Checking with double equals
	@Test
	void NoDuplicates2() {
		OceanMap Map = OceanMap.getMapInstance();
		OceanMap Map2 = OceanMap.getMapInstance();
		assertTrue(Map == Map2);
	}
	
	
	// Checks that Islands count is correct
	@Test
	void MapIslandPlacement() {
		OceanMap Map = OceanMap.getMapInstance();
		char[][] Ocean = Map.getMap();
		double islandCount = Map.islandCount;
		double count = 0;
		for (int i = 0; i < Map.getDimensions().getX(); i++) {
			for (int j = 0; j < Map.getDimensions().getY(); j++) {
				if (Ocean[i][j] == 'i') {
					count +=1;
				}
			}
		}
		assertTrue(count == islandCount);
	}
	

}
