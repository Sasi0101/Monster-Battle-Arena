
public class ElecEStudent extends Student{
//ElectEStudents (Electrical Engineering) student have high defence but low attack
	ElecEStudent(String name) {
		super(name, 8, 5, 15, 7, 14);
	}

	//the special ability allows the student to raise every friends KP to maxKP
	public void novelSuperconducting() throws Exception{
		if(this.currentKP >= this.getMaxKP()) {
			this.increaseEP(4);
			this.currentKP = 0;
			for(Character friend : hisTeam.getMembers()) {
				((Student)friend).currentKP = ((Student)friend).getMaxKP();
			}
		}else throw new Exception("ElecEStudents novelSuperconducting method not working");
	}
}
