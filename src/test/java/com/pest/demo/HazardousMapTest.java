package testPackage;
import sourcePackage.*;


import org.junit.Test;

import sourcePackage.HazardousMap;
import static org.junit.Assert.*;

import org.junit.Test;

public class HazardousMapTest {


	@Test
	public void testgetTileType()
	{
		char c = HazardousMap.getTileType(Game.game.players[0].position.x, Game.game.players[0].position.y);
		assertNotNull(c);
	}
	
	@Test
	public void testGenerate() {

		Game.game.setNumPlayers(5);

		Game.game.players[0]=new Player();
		Game.game.players[1]=new Player();
		Game.game.players[2]=new Player();
		Game.game.players[3]=new Player();
		Game.game.players[4]=new Player();
		Game.game.mapSize=8;
		Map.setSize(8, 8);
		Map map = HazardousMap.getInstance(8,8);
	
		map.generate();

		assertEquals("There should be one treasure tile", 1, CountElem());
	}
	
	public int CountElem()
	{
		  int count = 0;
		   for(int i = 0; i < (Map.map.tiles.length); i++)
		   {
		    	for(int j =0; j < (Map.map.tiles[i].length); j++)
		    	{

		    		if((Map.map.tiles[i][j] == 'c'))
		    		{
		    			count++; 
		    		}
		    }
		  }
		return count;
	}
	
	@Test
	public void getInstanceTest(){
		Map.map=null;
		HazardousMap.getInstance(5,5);
		
		assertTrue(Map.map instanceof HazardousMap);
		
		Map.map = SafeMap.getInstance(5,5);
		HazardousMap.getInstance(5,5);
		assertTrue(Map.map instanceof HazardousMap);


	}


}