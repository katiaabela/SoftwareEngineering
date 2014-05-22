package testPackage;
import sourcePackage.Map;
import sourcePackage.Game;
import sourcePackage.Player;
import sourcePackage.Position;

import org.junit.Test;

import sourcePackage.HazardousMap;
import static org.junit.Assert.*;

import org.junit.Test;

public class HazardousMapTest {


	@Test
	public void testgetTileType()
	{
		Game.game.setNumPlayers(3);

		Game.game.players[0]=new Player();
		Game.game.players[1]=new Player();
		Game.game.players[1]=new Player();
		Map map= HazardousMap.getInstance(5,5);
		Map.map.setSize(5, 5);
		
		Position p = new Position();
		p.x = 0;
		p.y=0;
		Map.tiles[p.x][p.y]='b';
		assertEquals(Map.map.getTileType(p.x,p.y), 'b');
		//assertEquals( 'b', HazardousMap.getTileType(Game.game.players[0].position.x, Game.game.players[0].position.y));

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


}