import java.util.ArrayList;

public abstract class Team{
    String name;
    ArrayList<Character> members = new ArrayList<Character>();
    
    //constructor
    Team(String name){
        this.name = name;
    }
    
    //getter method
    public String getName(){
        return name;
    }
    
    //transforming it to an array
    public Character[] getMembers(){
        Character[] array = members.toArray(new Character[0]);
        return array;
    }
    
    public int addMember(Character newMember) {
        for(Character i: members)
    	   if(i == newMember) return -1;
    	if(members.size()>=5) return -2;
    	members.add(newMember);
    	return members.size();
    	}
    public Character getMember(int amount) {
    	return members.get(amount);
    }
    public abstract void move(Character member, Team enemyTeam) throws Exception;
    
    public void clearTeam() {
    	 members = new ArrayList<Character>();
    }
}