package sourcePackage;


public class SafeMapCreator extends MapCreator{
	
	public Map generate(int x, int y) {
		Map SM;
		SM= SafeMap.getInstance(x,y);
		SM.generate();
		return SM;
	}
}

