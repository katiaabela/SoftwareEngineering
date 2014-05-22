package sourcePackage;

import java.util.*;

public class Player extends Observer{
	public Position position = new Position(); //current position
	
	public Position startPosition = new Position();
	
	public List<Position> visitedPositions = new ArrayList<Position>();

	int id;
	
	public boolean move(char direction){
		Position updatePosition = new Position();
		switch(direction){
		case 'U': 
			updatePosition.x=position.x-1;
			updatePosition.y=position.y;
			boolean a = setPosition(updatePosition);
			if(!a){
				updatePosition=position;
			} else {
				position=updatePosition;
				position.visited=true;
				visitedPositions.add(position);
			}
			break;
			
		case 'D':
			updatePosition.x=position.x+1;
			updatePosition.y=position.y;
			boolean b = setPosition(updatePosition);
			if(!b){
				updatePosition=position;
			} else {
				position=updatePosition;
				visitedPositions.add(position);

			}
			break;
			
		case 'L':
			updatePosition.x=position.x;
			updatePosition.y=position.y-1;
			boolean c = setPosition(updatePosition);
			if(!c){
				updatePosition=position;
			} else {
				position=updatePosition;
				visitedPositions.add(position);

			}
			break;
			
		case 'R':
			updatePosition.x=position.x;
			updatePosition.y=position.y+1;
			boolean d = setPosition(updatePosition);
			if(!d){
				updatePosition=position;
			} else {
				position=updatePosition;
				visitedPositions.add(position);

			}
			break;
		
		default:
			System.out.println("Invalid. Please enter U/D/L/R");
			return false;
		
		}
		return true;
	}
	
	//p - current position
	public boolean setPosition(Position p){
		if(p.x<0||p.y<0||p.x>=Game.game.mapSize||p.y>=Game.game.mapSize){
			return false;
		} else if(Math.abs(position.x-p.x)>=2 || Math.abs(position.y-p.y)>=2){
			return false;
		} else {
			
			return true;
		}
	}
	
	public Position setStartPosition() {
		Random r = new Random();
		int randomRow = r.nextInt(Game.game.mapSize); 
		int randomCol = r.nextInt(Game.game.mapSize);
		
		//check for duplicates
		for(int i=0;i<Game.game.players.length;i++){
			if(Game.game.players[i]!=null && Game.game.players[i].startPosition.x==randomRow && Game.game.players[i].startPosition.y==randomCol){
				randomRow = r.nextInt(Game.game.mapSize);
				randomCol = r.nextInt(Game.game.mapSize);
			} else {
				continue;
			}
		}	
		
		//assign start positions
		for(;;){
			if(Map.tiles[randomRow][randomCol]=='a'){		
				startPosition.x=randomRow;
				startPosition.y=randomCol;
				startPosition.visited=true;
				visitedPositions.add(startPosition);

				//visitedPositions[0]=startPosition;
				System.out.println("Start: "+startPosition.x+" " +startPosition.y);
				return startPosition;
			} else {
				randomRow = r.nextInt(Game.game.mapSize);
				randomCol = r.nextInt(Game.game.mapSize);
			}
		}

	}
	
	public void update(){
		this.visitedPositions=getUpdate();
	}
	
	public void setUpdate(List<Position> u){
		this.visitedPositions=u;
	}
	
	public List<Position> getUpdate(){
		return visitedPositions;
	}

}