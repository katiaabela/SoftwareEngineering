package sourcePackage;



public class MapCreator {
	//Factory method
	public Map generate(char type, int x, int y){
		MapCreator creator = findMapCreatorForType(type);
		return creator.generate(x,y);
	}
	
	public MapCreator findMapCreatorForType(char c){
		//MapCreator mc=null;
		if(c=='s') {
			System.out.println("Safe Map");
			return new SafeMapCreator();
		} else if (c=='h'){
			return new HazardousMapCreator();	
		} else {
		return null;
		}
	}
	
	//default if no type is called
	public Map generate(int x, int y){
		return new SafeMapCreator().generate(x,y);
		//return null;
	}
	
	
	
}
