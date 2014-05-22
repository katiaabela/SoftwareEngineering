package sourcePackage;

import java.util.Random;

public class SafeMap extends Map {
	private char type = 's';
	
	public SafeMap(int x, int y){
		super(x,y);
	}
	
	public static char getTileType(int x, int y){	
		return tiles[x][y];
	}
	
	
	public static Map getInstance(int x, int y){
		if(Map.map == null||!(Map.map instanceof SafeMap))
			map = new SafeMap(x,y);
		return Map.map;
	}
	
	
	public boolean generate() {
		System.out.println("Generate");
		Random r = new Random();
		int randomRow = r.nextInt(size); 
		int randomCol = r.nextInt(size);
		tiles[randomRow][randomCol] = 'c';
		int randomRowBlue, randomColumnBlue, randomNumberOfBlueTiles;
		
		int check = (int)(((size*size)-1)*0.1);
		randomNumberOfBlueTiles = r.nextInt(check);
		
		for(int index=0; index<randomNumberOfBlueTiles;index++){
			System.out.println("Loop");
			randomRowBlue = r.nextInt(size);
			randomColumnBlue = r.nextInt(size);
			if(tiles[randomRowBlue][randomColumnBlue]=='c'){
				continue;
			}
			tiles[randomRowBlue][randomColumnBlue]='b';
		}
		for(int i=0; i<size;i++){
			for(int j=0; j<size;j++){
				if(tiles[i][j]=='c'|| tiles[i][j]=='b'){
					System.out.print(tiles[i][j] +",");
				}
				else {
					tiles[i][j]='a';
					System.out.print(tiles[i][j] +",");
				}
			}
			System.out.println("\n");
		}	
		return true;
	}
}
