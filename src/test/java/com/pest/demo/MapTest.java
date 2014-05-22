package testPackage;
import sourcePackage.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class MapTest {



	@Test
	public void testsetSize(){

		Game.game.setNumPlayers(5);

		Game.game.players[0]=new Player();
		Game.game.players[1]=new Player();
		Game.game.players[2]=new Player(); 
		Game.game.players[3]=new Player();
		Game.game.players[4]=new Player();
		
		assertEquals("Map size set to 5x5 for 5 players should not be accepted", false , Map.setSize(5, 5));
		assertEquals("Map size set to 8x8 for 5 players should be accepted", true , Map.setSize(8, 8));

	}

	@Test
	public void testGetTileType() {
		Game.game.setNumPlayers(2);

		Game.game.players[0]=new Player();
		Game.game.players[1]=new Player();
		Map.setSize(5, 5);
		Position p = new Position();
		p.x=2;
		p.y=3;
		Game.game.players[0].position=p;
		Map.map.tiles[p.x][p.y]='b';
		
		assertEquals( 'b', Map.getTileType(Game.game.players[0].position.x, Game.game.players[0].position.y));
	}

}
