<<<<<<< HEAD
package sourcePackage;
=======
package com.pest.demo;
>>>>>>> fdfd0e7ce1499dc6924b65a066cce5a0161104bd
import java.util.Scanner;
import java.io.*;

public class Game {
	int turns;
	public Player[] players;
	public Map map = new Map();

	Scanner sc = new Scanner(System.in);

	public static Game game = new Game();

	int num=0;

	public static void main(String args[]){
		game.startGame();
	}


	public void startGame(){
		System.out.println("How many players will be playing this game? Minimum:2, Maximum:8");
		boolean p = setNumPlayers(sc.nextInt());
		boolean a = startPlayers(p);
		for(;;){
			if(!a) {
				System.out.println("Please enter a number in the range 2-8");
				p=setNumPlayers(sc.nextInt());

			} else {
				break;
			}
		}
		System.out.println("Please enter the map size:\nCriteria:\n1)Minimum map size for 2-4 players is 5x5\n2)Minimum map size for 5-8 players is 8x8\n3)Maximum map size is 50x50");

		map.size=sc.nextInt();
		boolean b=map.setMapSize(map.size, map.size);		
		boolean c = startMap(b);
		for(;;){
			if(!c) {
				System.out.println("Please enter a number which adheres to the above criteria");
				b=map.setMapSize(sc.nextInt(), sc.nextInt());

			} else {
				break;
			}
		}
		
		
		
		map.generate();
		startAndHTML();
		startPlayGame();
		//After assigning a start position to each player, they must take it in turns to move



	}

	public boolean setNumPlayers(int n){
		if(n>=2 && n<=8) {
			players = new Player[n]; //setting the size of the array players			
			return true;
		} else{
			return false;
		}
	}

	public void generateHTMLFiles(int n){
		boolean count=false;
		FileWriter fWriter = null;
		BufferedWriter writer = null;
		String code="";
		try {



			//fWriter = new FileWriter("map_player_"+n+".html");

			File f = new File("map_player_"+n+".html");

			if(f.exists()){
				FileWriter fw = new FileWriter(f.getAbsoluteFile());
				BufferedWriter bw = new BufferedWriter(fw);
				//code="";
				bw.write(code);
				bw.close(); 
				//System.exit(0);
			} 


			fWriter = new FileWriter("map_player_"+n+".html");	
			writer = new BufferedWriter(fWriter);

			code+="<html>\n<head>\n<title>HTML Table for Player</title>\n</head>\n</body>\n<table border=\"5\" style=\"width:100%; height:100%\">\n";


			for(int i=0; i<map.size;i++){
				code+="<tr>";
				for(int j=0;j<map.size;j++){
					for(int k=0; k<players[n].visitedPositions.size();k++){


						if(i==players[n].visitedPositions.get(k).x && j==players[n].visitedPositions.get(k).y){
							if(map.tiles[i][j]=='a'){

								code+="<td bgcolor=#00FF00>";
								count=true;
								break;

							} else if(map.tiles[i][j]=='b'){
								code+="<td bgcolor=#0000FF>";
								count=true;
								break;

							} else if(map.tiles[i][j]=='c'){
								code+="<td bgcolor=#FFFF00>";
								count=true;
								break;
							} 
							
							
						} else {
							count=false;
						}
					}
					if(!count){
						code+="<td bgcolor=#BDBDBD>";
					} else {
						//continue;
					}

					if(players[n].position.x==i &&players[n].position.y==j){
						code+="X</td>\n";
					}


				}

			}
			writer.write(code);
			writer.close();


		} catch (Exception e) {
			e.printStackTrace();
		}


	}


	public boolean startPlayers(boolean p){
		if (p) {
			return true;
		} else {
			return false;
		}


	}




	public boolean startMap(boolean a){
			if (a) {
				return true;
				
			} else {
				return false;

			}
	}
	public boolean startAndHTML(){
		for(int i=0; i<players.length;i++){

			if(players[i]==null){
				players[i]=new Player();
				players[i].position = players[i].setStartPosition(); //set the current position of the player to the start position 
				generateHTMLFiles(i);
			}
		}
		return true;
	}

	public boolean startPlayGame(){
		for(;;){
			for (int i=0;i<players.length;i++){
				Position oldPosition = new Position();
				oldPosition = players[i].position;
				System.out.println("Player " +i);
				System.out.println("Please enter the next move. Enter U/D/R/L");
				char direction = sc.next().charAt(0);
				players[i].move(direction); //the position is updated to the new tile
				if(players[i].position==oldPosition){
					//check
					oldPosition.visited=true; 
					System.out.println("Please enter a new direction");
					direction = sc.next().charAt(0);
					players[i].move(direction);
				} else {
					//update trail
					players[i].position.visited=true;
					generateHTMLFiles(i);
					continue;
				}

			}
			determineTiles();

		}
		//return true;
	}
	
	
	
	public boolean determineTiles(){
		int counter=0;
		for(int i=0; i<players.length; i++){

			char tileType = map.getTileType(players[i].position.x, players[i].position.y);
			switch(tileType){
			case 'a':
				System.out.println("This is a green tile");
				players[i].position = players[i].position;
				break;

			case 'b':
				System.out.println("You have lost the game. Relocating...");
				players[i].position = players[i].startPosition;
				break;

			case 'c':
				counter+=1;
				System.out.println("You have won the game! :-)");
				break;
			}
		

		}

		if(counter>=1){
			System.out.println("The game has been won");
			
		}
		turns++;
		return true;
	}
	


}
