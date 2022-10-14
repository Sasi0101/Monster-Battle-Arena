
public class BEEStudent extends Student{
//BEEStudent(Biomedical Electronic Engineering student) have a high HP but they are no good for attack they serve as healers to their teams
	BEEStudent(String name) {
		super(name, 10, 6, 6, 5, 13);
	}
	
	//special ability allows the student to heal all alive members to the maximum
	public void biomedicine() throws Exception{
		if(this.currentKP == this.maxKP) {
			this.increaseEP(4);
			this.currentKP = 0;
			if(hisTeam != null) {
				for(Character friend : hisTeam.getMembers()) {
					friend.currentHP = friend.getMaxHP();
				}
			}
		} else throw new Exception("BEEStudent biomedicine method is not working");
	}
	
	//the other special ability lets the student to revive a dead student and increase their EP as well
	public void healLostFella() throws Exception{
		if(this.currentKP == this.maxKP) {
			this.increaseEP(4);
			this.currentKP = 0;
			if(hisTeam != null) {
				for(Character friend : hisTeam.getMembers()) {
					if(friend.getHP()<=0) {
						friend.currentHP = friend.getMaxHP();
						friend.increaseEP(8);
						break;
					}
				}
			}
		}else throw new Exception("BEEStudent healLostFella method not working");
	}
}
