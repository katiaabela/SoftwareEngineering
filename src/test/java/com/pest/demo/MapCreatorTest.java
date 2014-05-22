package testPackage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Before;

import java.io.File;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

import org.junit.Test;

import sourcePackage.*;

public class MapCreatorTest {
	
	@Before
	public void Before(){
		Game.game.setNumPlayers(2);
	}
	@Test
	public void createMapTest() {
		MapCreator MC = new MapCreator();
		Map m1 = MC.generate('s',5,5);
		
		Map mapS=SafeMap.getInstance(5,5);
		MC.findMapCreatorForType('h');
		
	}
	
	/*@Test
	public void createMapTest2(){
		MapCreator MC2 = new MapCreator();
		Map m2 = MC2.createMap('h',5,5);
		MC2.createMap(5,5);
		Map mapH=HazardousMap.getInstance(5,5);
		mapH.generate();
		assertEquals(m2,mapH);
	}*/

}
