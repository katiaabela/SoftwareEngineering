package sourcePackage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Game {
	int turns;
	public Player[] players;
	public Team[] teams;

	public static Scanner sc = new Scanner(System.in);

	public static Game game = new Game();
	public static boolean changeState;
	int num=0;
	public int mapSize=0;
	public int numOfTeams=0;
	public static char mapType;
	public static boolean collaborative = false;

	public static void main(String args[]){
		game.startGame();
	}

	public void startGame(){
		System.out.println("How many players will be playing this game? Minimum:2, Maximum:8");
		boolean p=setNumPlayers(sc.nextInt());


		for(;;){
			if (p) {
				break;
			} else {
				System.out.println("Please enter a number in the range 2-8");
				p=setNumPlayers(sc.nextInt());
			}
		}

		System.out.println("Please enter the map size:\nCriteria:\n1)Minimum map size for 2-4 players is 5x5\n2)Minimum map size for 5-8 players is 8x8\n3)Maximum map size is 50x50");
		mapSize=sc.nextInt();

		boolean a=Map.setSize(mapSize, mapSize);

		for(;;){
			if (a) {

				break;
			} else {
				System.out.println("Please enter a number which adheres to the above criteria");
				mapSize=sc.nextInt();
				a=Map.setSize(mapSize, mapSize);
			}
		}


		System.out.println("Would you like to play on a safe or a hazardous map? Enter S or H");
		mapType = sc.next().charAt(0);
		System.out.println("Calling create map from main");
		MapCreator creator = new MapCreator();
		creator.generate(mapType,mapSize,mapSize);
		//createMap();


		System.out.println("Would you like to play in collaborative mode? Players will be assigned randomly to teams\nEnter y or n");
		char teamChoice = sc.next().charAt(0);
		for(;;){
			if(teamChoice == 'y' || teamChoice=='n' || teamChoice=='Y'|| teamChoice=='N'){
				if(teamChoice=='y'||teamChoice=='Y'){
					collaborative=true;
				} else {
					collaborative=false;
				}
				break;
			} else{
				System.out.println("Please enter Y or N");
				teamChoice=sc.next().charAt(0);
			}
		}

		if(collaborative){
			System.out.println("Please enter the number of teams\n");
			numOfTeams = sc.nextInt();
			boolean teamNum = setNumTeams(numOfTeams);

			for(;;){
				if(!teamNum) {
					System.out.println("You cannot have more teams than players. Please enter a new number");
					teamNum=setNumTeams(sc.nextInt());

				} else {
					break;
				}
			}

			assignPlayersToTeams();
			assignStartPositions();
		} else {
			assignStartPositions();
		}


		for(;;){
			for (int i=0;i<players.length;i++){
				Position oldPosition = new Position();
				oldPosition = players[i].position;
				System.out.println("For loop outer");
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

					//if collaborative, different players in the same team should be able to view their team members' start positions
					if(collaborative){
						updateTeamPosition(i);
					}



					generateHTMLFiles(i);
					continue;
				}

			}

			int counter=0;
			for(int i=0; i<players.length; i++){

				counter = determineTileType(i,counter);

			}

			if(counter>=1){
				System.out.println("The game has been won. GAME OVER");
				break;
			}
			turns++;

		}


	}
	
	public int determineTileType(int i, int counter){
		char tileType = Map.map.getTileType(players[i].position.x, players[i].position.y);
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
			
		default:
			break;
		}
		return counter;
	}


	public boolean createMap(){
		MapCreator creator = new MapCreator();
		creator.generate(mapType,mapSize,mapSize);
		return true;
	}

	public boolean setNumPlayers(int n){
		if(n>=2 && n<=8) {
			players = new Player[n]; //setting the size of the array players			
			return true;
		} else{
			return false;
		}
	}

	public boolean assignPlayersToTeams(){
		int random=0;		
		int counterTeams = numOfTeams;

		Random r = new Random();
		for(int i=0; i<players.length;i++){
			if(counterTeams!=0){
				System.out.println("Team: "+i);
				System.out.println("Player: "+i);

				if(players[i] == null){
					players[i]=new Player();
					teams[i]=new Team();
					System.out.println(teams[i]);
					System.out.println(players[i]);
					ArrayList<Team> teamArr = new ArrayList<Team>(Arrays.asList(teams));
					teamArr.get(i).playersInTeam.add(players[i]);
					
					teamArr.get(i).attach(players[i]);
					
					for(int c=0; c< teamArr.get(random).playersInTeam.size();c++){
						teamArr.get(i).playersInTeam.get(c).id=i;
					}

				}				
				counterTeams--;
			} else{
				System.out.println("Else");
				random = r.nextInt(numOfTeams);
				System.out.println("Team: "+random);
				System.out.println("Player: "+i);
				if(players[i] == null){
					players[i]=new Player();
					System.out.println(players[i]);
					ArrayList<Team> teamArr = new ArrayList<Team>(Arrays.asList(teams));
					teamArr.get(random).playersInTeam.add(players[i]);
					//teamArr.get(i).attach(players[i]);
					teamArr.get(random).attach(players[i]);

					for(int c=0; c< teamArr.get(random).playersInTeam.size();c++){
						teamArr.get(random).playersInTeam.get(c).id=i;
					}
					System.out.println("Team: "+random);
				}
			}
		}
		return true;
	}

	public boolean assignStartPositions(){
		for(int i=0; i<players.length;i++){

			if(players[i]==null){
				players[i]=new Player();
			}
			//	players[i].setStartPosition();
			players[i].position = players[i].setStartPosition(); //set the current position of the player to the start position 
			players[i].startPosition.visited=true;
		

			//if collaborative, different players in the same team should be able to view their team members' start positions
			if(collaborative){
				for(int j=0; j<teams.length; j++){
					if(teams[j].playersInTeam.contains(players[i]) && teams[j].playersInTeam.size()>1){
						//loop through the arraylist players in team to find all the different players
						for(int k=0; k<teams[j].playersInTeam.size();k++){
							//loop through the visited positions array of each player to find all the different positions
							players[i].visitedPositions.add(teams[j].playersInTeam.get(k).startPosition);
							changeState=true;
							players[i].setUpdate(players[i].visitedPositions);
							changeState=false;
						}
					}
				}
			}
			

		}

		for(int i=0; i<players.length;i++){
			generateHTMLFiles(i);
		}

		return true;
	}


	public boolean updateTeamPosition(int i){
		for(int j=0; j<teams.length; j++){
			if(teams[j].playersInTeam.contains(players[i]) && teams[j].playersInTeam.size()>1){
				//loop through the arraylist players in team to find all the different players
				for(int k=0; k<teams[j].playersInTeam.size();k++){
					//loop through the visited positions array of each player to find all the different positions


					for(int l=0; l<teams[j].playersInTeam.size();l++){
						System.out.println("Team: "+j+" Player: "+l);
						teams[j].playersInTeam.get(l).visitedPositions.add(players[i].position);
						
						
						changeState=true;
						players[i].setUpdate(players[i].visitedPositions);
						changeState=false;
						
						
						generateHTMLFiles(teams[j].playersInTeam.get(l).id);
					}
					//teams[j].playersInTeam.get(k).visitedPositions.add(players[i].position);
					System.out.println("Visited positions for player: " +teams[j].playersInTeam.get(k).position.x + " " + teams[j].playersInTeam.get(k).position.y );
					generateHTMLFiles(i);

				}

			}								
		}
		return true;
	}

	public void generateHTMLFiles(int n){
		boolean count=false;
		FileWriter fWriter = null;
		BufferedWriter writer = null;
		String code="";
		try {


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

			code+="<html>\n<head>\n<title>HTML Table for Player</title>\n</head>\n</body>\n<table border=\"5\" style=\"width:100%; height:100%; table-layout:fixed;\">\n";


			for(int i=0; i<mapSize;i++){
				code+="<tr>";
				for(int j=0;j<mapSize;j++){
					for(int k=0; k<players[n].visitedPositions.size();k++){


						//System.out.println(players[n].visitedPositions.get(k).x + "" + players[n].visitedPositions.get(k).y);
						if(i==players[n].visitedPositions.get(k).x && j==players[n].visitedPositions.get(k).y){
							if(Map.map.tiles[i][j]=='a'){

								code+="<td bgcolor=#00FF00>";
								count=true;
								break;

							} else if(Map.map.tiles[i][j]=='b'){
								code+="<td bgcolor=#0000FF>";
								count=true;
								break;

							} else if(Map.map.tiles[i][j]=='c'){
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
			return;
		}


	}


	public boolean setNumTeams(int n){
		if(n<=players.length){
			teams = new Team[n];
			return true;
		} else {
			return false;
		}
	}


}
