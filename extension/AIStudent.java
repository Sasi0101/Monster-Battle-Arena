
public class AIStudent extends Student{
	//String name;
	AIStudent(String name) {
		super(name, 6, 7, 7, 5, 3);
	}
	
	//special abilities
	public void machineLearning(Character enemy) throws Exception {
		if(enemy != null) {
			if(this.currentKP==this.maxKP) {
				this.increaseEP(4);
				this.currentKP = 0;
				int damageTaken = (int) ((2*(100*this.getAttack()))/(100+enemy.getDefence()));
				enemy.decreaseHP(damageTaken);
				if(enemy.getHP()==0) this.increaseEP(4);
				}
			else throw new Exception("AIStudent machineLearning method not working");
		}
	}
		
	public void naturalLanguageProcessing() throws Exception{
		if(this.currentKP==this.maxKP) {
			this.increaseEP(4);
			this.currentKP = 0;
			this.increaseHP((int)this.getDefence());
		}
		else throw new Exception("AIStudent naturalLanguageLearning not working");
	}
}
