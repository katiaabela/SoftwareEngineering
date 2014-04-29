

package testPackage;

import sourcePackage.*;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.io.File;

import org.junit.Test;


public class TestGame {

	
	
	@Test
	public void setNumPlayersTest(){
		//true
		assertEquals(true, Game.game.setNumPlayers(2));
		assertEquals(true, Game.game.setNumPlayers(8));
		//false
		assertEquals(false, Game.game.setNumPlayers(1));
		assertEquals(false, Game.game.setNumPlayers(20));
	}
	
	@Test
	public void generateHTMLFilesTest(){
		Game.game.setNumPlayers(4);
		Game.game.players[0]=new Player();
		Game.game.players[1]=new Player();
		Game.game.players[2]=new Player();
		Game.game.players[3]=new Player();

		Game.game.map.setMapSize(5,5);
		Game.game.map.generate();
		
		
		File f0 = new File("map_player_0.html");
		File f1 = new File("map_player_1.html");

		Position p = new Position();
		//green tile
		Game.game.players[1].setStartPosition();
		Game.game.generateHTMLFiles(1);
		//blue tile
		for(int i=0; i<Game.game.map.size;i++){
			for(int j=0; j<Game.game.map.size;j++){
				if(Game.game.map.tiles[i][j]=='b'){
					p.x=i;
					p.y=j;
				}
			}
		}
		
		Game.game.players[0].position=p;
		Game.game.players[0].visitedPositions.add(p);
		Game.game.generateHTMLFiles(0);
		//treasure tile
		for(int i=0; i<Game.game.map.size;i++){
			for(int j=0; j<Game.game.map.size;j++){
				if(Game.game.map.tiles[i][j]=='c'){
					p.x=i;
					p.y=j;
				}
			}
		}
		
		Game.game.players[2].position=p;
		Game.game.players[2].visitedPositions.add(p);
		Game.game.generateHTMLFiles(2);
		//should throw an exception since player 4 does not exist
		//Game.game.generateHTMLFiles(3);
		
	
		
		//check if the required files have been created
		assertTrue(f0.exists());
		assertTrue(f1.exists());
	}
		
	@Test
	public void startPlayersTest(){
		assertTrue(Game.game.startPlayers(true));
		assertFalse(Game.game.startPlayers(false));
	}
	
	@Test
	public void startMapTest(){
		assertTrue(Game.game.startMap(true));
		assertFalse(Game.game.startMap(false));
	}
	
	@Test
	public void startAndHTMLTest(){
		Game.game.setNumPlayers(2);
		Game.game.players[0]=null;
		Game.game.players[1]=null;
		assertTrue(Game.game.startAndHTML()); 
	}
	
	@Test
	public void determineTilesTest(){
		Game.game.setNumPlayers(3);
		Game.game.players[0]=new Player();
		Game.game.players[1]=new Player();
		Game.game.players[2]=new Player();

		Game.game.players[0].setStartPosition();
		assertTrue(Game.game.determineTiles());
		
		Position p = new Position();
		for(int i=0; i<Game.game.map.size;i++){
			for(int j=0; j<Game.game.map.size;j++){
				if(Game.game.map.tiles[i][j]=='b'){
					p.x=i;
					p.y=j;
				}
			}
		}
		Game.game.players[1].position=p;
		assertTrue(Game.game.determineTiles());
		for(int i=0; i<Game.game.map.size;i++){
			for(int j=0; j<Game.game.map.size;j++){
				if(Game.game.map.tiles[i][j]=='c'){
					p.x=i;
					p.y=j;
				}
			}
		}

		Game.game.players[2].position=p;
		assertTrue(Game.game.determineTiles());
	}
	
}