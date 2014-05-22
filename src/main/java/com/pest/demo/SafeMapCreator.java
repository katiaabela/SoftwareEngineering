package sourcePackage;


public class SafeMapCreator extends MapCreator{
	
	public Map generate(int x, int y) {
		System.out.println("SafeMapCreator");
		Map SM;
		SM= SafeMap.getInstance(x,y);
		System.out.println("Generating");
		SM.generate();
		return SM; 
	}
}
