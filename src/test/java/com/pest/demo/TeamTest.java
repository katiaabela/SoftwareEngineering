package testPackage;

import static org.junit.Assert.*;
import sourcePackage.*;

import org.junit.Test;
import org.junit.Before;
import java.util.List;

import sourcePackage.Game;
import sourcePackage.Player;
import sourcePackage.Position;
import static org.hamcrest.CoreMatchers.*;

public class TeamTest {

		Team team = new Team();

	
	@Test
	public void attachTest() {
		Player player1 = null;
		Player player2 = new Player();
		
		//add a new player to the team
		assertTrue(team.attach(player2));
		//add a null player to the team
		assertFalse(team.attach(player1));
	}
	
	@Test
	public void notifyTeamTest(){
		Game.changeState=true;
		Player player0 = new Player();
		Player player1 = new Player();
		Position p1 = new Position();
		Position p2 = new Position();
		p1.x=1;
		p1.y=1;
		p2.x=3;
		p2.y=2;
		
		team.attach(player0);
		team.attach(player1);
		
		player0.visitedPositions.add(p1);
		player1.visitedPositions.add(p2);
		
		assertTrue(team.notifyTeam());
		
		Game.changeState=false;
		assertFalse(team.notifyTeam());
	}

}
