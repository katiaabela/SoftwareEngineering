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

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class MapCreatorTest {
	
	@Before
	public void Before(){
		Game.game.setNumPlayers(2);
	}
	@Test
	public void generateTest() {
		MapCreator MC = new MapCreator();
		Map m1 = MC.generate(5,5);
		
		MapCreator MC2 = new MapCreator();
		Map m2 = MC2.generate('h',5,5);
		MapCreator MC3 = new MapCreator();
		Map m3 = MC2.generate('s',5,5);
		
		assertThat(m2, is(not(m3)));
	}
	
	@Test
	public void findCreatorForTypeTest(){
		MapCreator m = new MapCreator();
		MapCreator mc1 = m.findMapCreatorForType('s');
		MapCreator mc2 = m.findMapCreatorForType('h');
		MapCreator mc3 = m.findMapCreatorForType('a');

		assertTrue(mc1 instanceof SafeMapCreator);
		assertTrue(mc2 instanceof HazardousMapCreator);
		assertNull(mc3);
	}
	
	

}
