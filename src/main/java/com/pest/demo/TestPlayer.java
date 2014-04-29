package com.pest.demo;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;


import static org.hamcrest.CoreMatchers.*;


public class TestPlayer{

	
	@Before
	public void Before() {
		Game.game.setNumPlayers(4);
		Game.game.players[0]=new Player();
		Game.game.players[1]=new Player();
		Game.game.players[2]=new Player();
		Game.game.players[3]=new Player();

		Game.game.map.setMapSize(5,5);
		Game.game.map.generate();	
	}
	
	@Test
	public void setStartPositionTest(){
		Position p = Game.game.players[0].setStartPosition();
		Position p1 = Game.game.players[1].setStartPosition();

		//check that the variable startPosition does hold the actual start position of the player
		assertEquals(Game.game.players[0].startPosition, p);
		assertEquals(Game.game.players[1].startPosition, p1);
		//check that the start position for each player is a green tile
		assertEquals('a', Game.game.map.getTileType((Game.game.players[0].startPosition.x),(Game.game.players[0].startPosition.y)));
		assertEquals('a', Game.game.map.getTileType((Game.game.players[1].startPosition.x),(Game.game.players[1].startPosition.y)));
		//check that a different start position has been generated for each player
		assertThat(p, not(equalTo(p1)));

	}
	
	@Test
	public void setPositionTest(){
		Game.game.players[0].position.x=0;
		Game.game.players[0].position.y=0;
		Game.game.players[1].position.x=2;
		Game.game.players[1].position.y=3;
		
		Position p0 = new Position();
		p0.x=-1;
		p0.y=-1;
		
		Position p1 = new Position();
		p1.x=4;
		p1.y=3;
		
		Position p01 = new Position();
		p01.x=0;
		p01.y=1;
		
		Position p11 = new Position();
		p11.x=2;
		p11.y=4;
		
		Position p12 = new Position();
		p12.x=0;
		p12.y=5;
		//out of bounds position 
		assertEquals(false, Game.game.players[0].setPosition(p0));		
		assertEquals(false, Game.game.players[1].setPosition(p12));

		//set position to a tile where 2 or more moves are needed
		assertEquals(false, Game.game.players[0].setPosition(p1));
		//good positions
		assertEquals(true, Game.game.players[0].setPosition(p01));
		assertEquals(true, Game.game.players[1].setPosition(p11));
	}
	
	@Test
	public void MoveTest(){
		Game.game.players[0].position.x=4;
		Game.game.players[0].position.y=0;
		Game.game.players[1].position.x=4;
		Game.game.players[1].position.y=4;
		Game.game.players[2].position.x=0;
		Game.game.players[2].position.y=0;
		Game.game.players[3].position.x=0;
		Game.game.players[3].position.y=4;


		//Up
		assertEquals(true, Game.game.players[0].move('U'));
		//Down
		assertEquals(true, Game.game.players[0].move('D'));
		//Left
		assertEquals(true,Game.game.players[0].move('L') );


		//Left
		assertEquals(true, Game.game.players[1].move('L'));
		//Right
		assertEquals(true, Game.game.players[1].move('R'));
		//down
		assertEquals(true, Game.game.players[1].move('D'));

		//Up
		assertEquals(true, Game.game.players[2].move('U'));
//Right
		assertEquals(true, Game.game.players[3].move('R'));

		//Wrong input
		assertEquals(false, Game.game.players[1].move('B'));
		

	}
	
}
