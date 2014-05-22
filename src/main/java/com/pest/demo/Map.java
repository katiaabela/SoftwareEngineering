package sourcePackage;

public abstract class Map {
	
	protected char type;
	public static int size;
	public static char [][] tiles;
	public static Map map=null;
	
	public Map(int x, int y){
		setSize(x,y);
	}
	
	public static boolean setSize(int x,int y){
		if ((Game.game.players.length>=2&&Game.game.players.length<=4&&x>=5&&x<=50) || (Game.game.players.length>=5&&Game.game.players.length<=8&&x>=8&&x<=50)) {
			tiles=new char[x][y];
			size=x;
			return true;
		} else {
			return false;
		}
	}
	
	public static char getTileType(int x, int y){
		return tiles[x][y];
	}

	public abstract boolean generate();

}