package com.pest.demo;
import java.util.*;

public class Map {
	public int size;
	public char [][] tiles; //all elements are 0



	public boolean setMapSize(int x, int y){
		if ((Game.game.players.length>=2&&Game.game.players.length<=4&&x>=5&&x<=50) || (Game.game.players.length>=5&&Game.game.players.length<=8&&x>=8&&x<=50)) {
			tiles=new char[x][y];
			size=x;
			//generate();
			return true;
		} else {
			return false;
		}
	}

	public boolean generate() {
		//Step1: Create rows and columns
		//tiles = new char[size][size];
		//Step2: Apply random function
		Random r = new Random();
		int randomRow = r.nextInt(size); //r.nextInt(size-1)+1
		int randomCol = r.nextInt(size);
		tiles[randomRow][randomCol] = 'c'; //treasure tile

		String possibleValues="ab";
		
		for(int i=0; i<size;i++){
			for(int j=0;j<size;j++){
				if(tiles[i][j] == 'c'){
					System.out.print(tiles[i][j] +",");
					continue;
				} else {				
					tiles[i][j]=possibleValues.charAt(r.nextInt(possibleValues.length()));
				}
				System.out.print(tiles[i][j] +",");
			}
			System.out.println("\n");

		}
		return true;
}

	public char getTileType(int x, int y){	
		return tiles[x][y];
	}
}
