import java.util.Random;

public class AEEStudent extends Student{
String name;
//the AEEStudents (Aerospace Electronic Engineering) 
	AEEStudent(String name) {
		super(name, 7, 5, 8, 7, 5);
	}
	
	//special ability that lets the AEEStudent to increase the EP of a chosen friend by the amount of the students defence
	
	public void nasaProject(Character friend) throws Exception{
		if(this.currentKP == this.getMaxKP()) {
			this.increaseEP(4);
			this.currentKP = 0;
			int increase = (int) this.getDefence();
			friend.increaseEP(increase);
		} else throw new Exception("AEEStudent NasaProject method not working");
	}
	
	//the other special ability lets the
	
	public void flightEfficiency() throws Exception{
		if(this.currentKP == this.getMaxKP()) {
			Random random = new Random();
        	int chance = random.nextInt(15);
        	this.increaseEP(4);
        	this.currentKP = 0;
        	this.increaseEP(chance-5);
        	this.increaseHP(chance-5);
		} else throw new Exception("AEEStudent flightEfficinecy method is not working");
	}
}
