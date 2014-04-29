package testPackage;
import static org.junit.Assert.*;

import org.junit.Test;

import sourcePackage.Game;
import sourcePackage.Player;


public class TestMap {

	@Test
	public void testSetMapSize(){
		
		
		Game.game.setNumPlayers(5);
		
		Game.game.players[0]=new Player();
		Game.game.players[1]=new Player();
		Game.game.players[2]=new Player();
		Game.game.players[3]=new Player();
		Game.game.players[4]=new Player();
		
		assertEquals("Map size set to 5x5 for 5 players should not be accepted", false , Game.game.map.setMapSize(5, 5));

	}

	@Test
	public void testGenerate() {
		
		Game.game.setNumPlayers(5);
		
		Game.game.players[0]=new Player();
		Game.game.players[1]=new Player();
		Game.game.players[2]=new Player();
		Game.game.players[3]=new Player();
		Game.game.players[4]=new Player();
		Game.game.map.setMapSize(8, 8);

		Game.game.map.size = 8;
		Game.game.map.generate();
		
		assertEquals("There should be one treasure tile", 1, CountElem());
	}

	public int CountElem()
	{
		  int count = 0;
		   for(int i = 0; i < (Game.game.map.tiles.length); i++)
		   {
		    	for(int j =0; j < (Game.game.map.tiles[i].length); j++)
		    	{
		    
		    		if(( Game.game.map.tiles[i][j] == 'c'))
		    		{
		    			count++; 
		    		}
		    }
		  }
		return count;
	}
	
	
	@Test
	public void testGetTileType() {
		
		Game.game.setNumPlayers(2);
	
		Game.game.players[0]=new Player();
		Game.game.players[1]=new Player();
		Game.game.map.setMapSize(5, 5);

		Game.game.map.size = 5;
		
		assertEquals( 'b', Game.game.map.getTileType(Game.game.players[0].position.x, Game.game.players[0].position.y));
		
	}

}

