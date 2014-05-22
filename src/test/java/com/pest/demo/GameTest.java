

package testPackage;

import static org.junit.Assert.assertEquals;

import org.junit.Before;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.io.File;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

import org.junit.Test;

import sourcePackage.*;


public class GameTest {
	
	@Before
	public void Before(){
		Game.game.setNumPlayers(4);
		Game.game.players[0]=new Player();
		Game.game.players[1]=new Player();
		Game.game.players[2]=new Player();
		Game.game.players[3]=new Player();

	}
	
	/*@Test
	public void setNumPlayersTest(){
		//true
		assertEquals(true, Game.game.setNumPlayers(2));
		assertEquals(true, Game.game.setNumPlayers(8));
		//false
		assertEquals(false, Game.game.setNumPlayers(1));
		assertEquals(false, Game.game.setNumPlayers(20));
	}
	
	@Test
	public void setNumTeamsTest(){		
		assertTrue(Game.game.setNumTeams(2));
		//more teams than players-false
		assertFalse(Game.game.setNumTeams(5));
	}

	@Test
	public void generateHTMLFilesTest(){
		Map map = HazardousMap.getInstance(5,5);
		Game.game.mapSize=5;
		map.setSize(5,5);
		map.generate();


		File f0 = new File("map_player_0.html");
		File f1 = new File("map_player_1.html");

		Position p = new Position();
		//green tile
		Game.game.players[1].setStartPosition();
		Game.game.generateHTMLFiles(1);
		//blue tile
		for(int i=0; i<Game.game.mapSize;i++){
			for(int j=0; j<Game.game.mapSize;j++){
				if(Map.map.tiles[i][j]=='b'){
					p.x=i;
					p.y=j;
				}
			}
		}

		Game.game.players[0].position=p;
		Game.game.players[0].visitedPositions.add(p);
		Game.game.generateHTMLFiles(0);
		//treasure tile
		for(int i=0; i<Game.game.mapSize;i++){
			for(int j=0; j<Game.game.mapSize;j++){
				if(Map.map.map.tiles[i][j]=='c'){
					p.x=i;
					p.y=j;
				}
			}
		}

		Game.game.players[2].position=p;
		Game.game.players[2].visitedPositions.add(p);
		Game.game.generateHTMLFiles(2);

		//check if the required files have been created
		assertTrue(f0.exists());
		assertTrue(f1.exists());
	}

	@Test
	public void assignPlayersToTeamsTest(){
		Game.game.setNumPlayers(5);
		Game.game.numOfTeams=3;	

		Team team1 = new Team();
		Team team2 = new Team();
		Team team3 = new Team();


		
		assertTrue(Game.game.assignPlayersToTeams());

	}
	
	@Test
	public void assignPlayersToTeamsTest2(){
		Player player1 = null;
		Player player2 = new Player();
		Player player3 = new Player();

		
		Game.game.setNumTeams(3);
		
		Game.game.numOfTeams=3;

		assertTrue(Game.game.assignPlayersToTeams());
	}
	
	@Test
	public void assignPlayersToTeamsTest3(){
		Game.game.setNumTeams(3);

		Game.game.players[3]=null;

		Game.game.teams[0]=new Team();
		Game.game.teams[1]=new Team();
		Game.game.teams[2]=new Team();
		
		assertTrue(Game.game.assignPlayersToTeams());

	}
	
	@Test
	public void determineTileTypeTest(){


			Position p0 = new Position();
			p0.x=0;
			p0.y=0;
			Position p1 = new Position();
			p1.x=4;
			p1.y=2;
			Position p2 = new Position();
			p2.x=3;
			p2.y=4;
			Position p3 = new Position();
			p3.x=2;
			p3.y=2;
			
			Map.map.tiles[p0.x][p0.y]='a';
			Map.map.tiles[p1.x][p1.y]='b';
			Map.map.tiles[p2.x][p2.y]='c';
			Map.map.tiles[p3.x][p3.y]='d'; //incorrect value 

			Game.game.players[0].position=p0;
			Game.game.players[1].position=p1;
			Game.game.players[2].position=p2;
			Game.game.players[3].position=p3;

			assertEquals(0, Game.game.determineTileType(0,0));
			assertEquals(0, Game.game.determineTileType(1,0));
			assertEquals(1, Game.game.determineTileType(2,0));
			assertEquals(0, Game.game.determineTileType(3,0));	
	}
	
	@Test
	public void updateTeamPositionAndAssignStartPositionsTest(){
		Game.game.setNumTeams(2);
		Game.game.collaborative=true;

		Game.game.teams[0] = new Team();
		Game.game.teams[1] = new Team();

		
		Game.game.teams[0].playersInTeam.add(Game.game.players[0]);
		Game.game.teams[0].playersInTeam.add(Game.game.players[1]);
		Game.game.teams[1].playersInTeam.add(Game.game.players[2]);
		Game.game.teams[1].playersInTeam.add(Game.game.players[3]);

		Game.game.players[0].position.x=0;
		Game.game.players[0].position.y=0;
		Game.game.players[1].position.x=2;
		Game.game.players[1].position.y=3;
		
		assertTrue(Game.game.updateTeamPosition(0));
		
		
		Game.game.players[2].startPosition.x=0;
		Game.game.players[2].startPosition.y=1;
		Game.game.players[3].startPosition.x=3;
		Game.game.players[3].startPosition.y=3;
		
		assertTrue(Game.game.assignStartPositions());
	}
	
	@Test
	public void assignStartPositionsTest2(){
		Game.game.players[1]=null;
		Game.game.collaborative=false;
		assertTrue(Game.game.assignStartPositions());

	}
	
	@Test
	public void createMapTest(){
		Game.game.mapSize=5;
		Game.game.mapType='s';
		assertTrue(Game.game.createMap());
	}*/
	
	@Test
	public void startGameTest(){
		
	
			
			
			Game.game.setNumPlayers(2);
			Game.game.players[0]=new Player();
			Game.game.players[1]=new Player();
			Map.map.setSize(5,5);
			Game.game.players[0].startPosition.x = 1;
			Game.game.players[0].startPosition.y = 3;
			Game.game.players[1].startPosition.x = 4;
			Game.game.players[1].startPosition.y = 4;

			  String input = "\n2\n5\ns\nn\nL\nL\nD\nU\nD\nL\nR\nU\n";
			
			System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));
			Game.game.sc = new Scanner(System.in);
			Map.map.tiles[2][2]='c';
			Map.map.tiles[1][3]='a';		
			Map.map.tiles[4][4]='a';		
			Map.map.tiles[1][2]='a';		
			Map.map.tiles[4][3]='a';
			
			Game.game.startGame();
		}
	

}