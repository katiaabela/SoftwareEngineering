package sourcePackage;


public class HazardousMapCreator extends MapCreator{
	public Map generate(int x, int y) {
		System.out.println("HazardousMapCreator");
		Map HM;
		HM= HazardousMap.getInstance(x,y);
		HM.generate();
		return HM; 
	}

}
