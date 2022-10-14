
public class MEStudent extends Student{
//MEStudent (Mechatronic Engineering)
	MEStudent(String name) {
		super(name, 7, 10, 10, 5, 7);
	}

	//this special ability allows the student to raise a friends base speed and defence
	public void controlEngineering(Character friend) throws Exception{
		if(this.currentKP >= this.getMaxKP()) {
			this.increaseEP(4);
			this.currentKP = 0;
			friend.baseSpd = friend.baseSpd + 2;
			friend.baseDef = friend.baseDef + 2;
		} throw new Exception("MEStudent controlEngineering method not working");
	}
	
	//this special ability allows the student to steal attack and defence from a monster and raise his and this ability has a 1/3 chance to happen
	public void electromechanical(Character enemy) throws Exception{
		if(this.currentKP >= this.getMaxKP()) {
			this.increaseEP(4);
			this.currentKP = 0;
			enemy.baseAtk = enemy.baseAtk - 2;
			this.baseAtk = this.baseAtk + 2;
			enemy.baseDef = enemy.baseDef -2;
			this.baseDef = this.baseDef +2;
		} else throw new Exception("MEStudent electromechanical method not working");
	}
}
