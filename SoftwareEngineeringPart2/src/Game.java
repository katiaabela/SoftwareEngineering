import java.util.Scanner;


public class Game {
	int turns;
	Player[] players;
	Map map;

	Scanner sc = new Scanner(System.in);
	int numOfPlayers=0;

	public static void main(String args[]){
		Game game = new Game();
		game.startGame();
	}


	public void startGame(){
		System.out.println("How many players will be playing this game? Minimum:2, Maximum:8");
		numOfPlayers = sc.nextInt();
		for(;;){
			boolean p=setNumPlayers(numOfPlayers);
			if (p) {
				break;
			} else {
				System.out.println("Please enter a number in the range 2-8");
				numOfPlayers = sc.nextInt();
			}
		}

	}

	public boolean setNumPlayers(int n){
		if(n>=2 && n<=8) {
			numOfPlayers=n;
			return true;
		} else{
			return false;
		}
	}

	public void generateHTMLFiles(){

	}
}
