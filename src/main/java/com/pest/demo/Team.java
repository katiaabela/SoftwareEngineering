package sourcePackage;

import java.util.*;

public class Team extends Subject{
	public ArrayList<Player> playersInTeam = new ArrayList<Player>();
	ArrayList<Observer> observerList = new ArrayList<Observer>();

	@Override
	public boolean attach(Observer obs) {
		if(obs==null){
			return false;
		} else{
			observerList.add(obs);
			return true;
		}
	}

	@Override
	public boolean notifyTeam() {
		if(Game.changeState){
			//if the state has been changed, this must be reflected in the visited positions of all players in the same team
			for(int i=0; i<observerList.size();i++){
				observerList.get(i).update();
			}
			return true;
		} else {
			return false;
		}
	}


}
