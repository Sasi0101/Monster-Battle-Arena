
public class EEStudent extends Student{
//EEStudents (Electronic Engineering) have an insanely high HP which makes them to be able to defend for the team
	EEStudent(String name) {
		super(name, 18, 1, 5, 1, 10);
	}
	
	//special ability lets the EEStudent to heal to the maximum
	public void sosSignal() throws Exception{
		if(this.currentKP == this.maxKP) {
			this.increaseEP(4);
			this.currentKP = 0;
			this.currentHP = this.getMaxHP();
		} else throw new Exception("EEStudents sosSignal method not working");
	}
}
