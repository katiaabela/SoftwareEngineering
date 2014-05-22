package sourcePackage;

public abstract class Subject {
	//when a new player is added to a team
	public abstract boolean attach(Observer obs);
	//when a player from a team updates his position, the rest of the team is notified
	public abstract boolean notifyTeam();
}
