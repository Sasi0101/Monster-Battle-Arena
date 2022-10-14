
public class EEEStudent extends Student{
///EEEStudents (Electrical and Electronic Engineering) are as fast as the lightning having a speed of 30
	EEEStudent(String name) {
		super(name, 7, 6, 8, 30, 5);
	}
	
	//this special ability kills the lowest HP monster instantly
	public void nanoelectronics(Character enemy) throws Exception{
		if(this.currentKP == this.maxKP) {
			this.increaseEP(4);
			this.currentKP = 0;
			enemy.currentHP = 0;
			//since the enemy is dead the student gaines more EP
			this.increaseEP(4);
		}else throw new Exception("EEEStudent nanoelectronics method not working");
	}
	
	//this special ability lets the student to increase his baseAtk
	public void quantumDevices() throws Exception{
		if(this.currentKP == this.maxKP) {
			this.increaseEP(4);
			this.currentKP = 0;
			this.baseAtk = this.baseAtk + 2;
		} throw new Exception("EEEStudent quantumDevices method not working");
	}
}
