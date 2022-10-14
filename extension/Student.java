public class Student extends Character {
	int maxKP=0, currentKP=0;
	Team hisTeam;
	Student(String name, int baseHP, int baseAtk, int baseDef, int baseSpd, int maxKP) {
		super(name, baseHP, baseAtk, baseDef, baseSpd);
		this.maxKP=maxKP;
	}
	public int getMaxKP(){
	    return this.maxKP;
	}
	public void increaseKP(int amount) {
		if(currentKP+amount<=maxKP)
			currentKP = currentKP + amount;
		else currentKP=maxKP;
	}
	public int getKP() {
		return currentKP;
	}
	public void javaProgramming(Character enemy) {
		if(enemy != null) {
		if((this.getHP()>0)&&(enemy.getHP()>0)) {
		this.increaseEP(3);
		this.increaseKP(1);
		int damageTaken = (int) ((100*(this.getAttack()))/(100+enemy.getDefence()));
		enemy.decreaseHP(damageTaken);
       	        enemy.increaseEP(2);
		if(enemy instanceof Student) 
			((Student)enemy).increaseKP(3);
		if(enemy.getHP()<=0) this.increaseEP(4);
		}
	}
		}
	public void selfStudy() {
		this.increaseHP(2);
		this.increaseEP(6);
		this.increaseKP(2);
	}
}
