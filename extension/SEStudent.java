
public class SEStudent extends Student {
        //String name;
	SEStudent(String name) {
		super(name, 8, 5, 8, 4, 10);
	}
	
	//special ability
	public void groupWork(Character enemy) throws Exception{
 		if((this.getKP()>=this.maxKP)&&(this.getHP()>0)&&(enemy.getHP()>0)) {
			this.increaseEP(4);
			this.currentKP=0;
			for(Character friend : this.getTeam().getMembers()){
			    if(friend.getHP()>0){
			        int damageTaken = (int) (((100*friend.getAttack())/(100+enemy.getDefence())));
			        enemy.decreaseHP(damageTaken);
			     }
			 }
			 if(enemy.getHP()==0) this.increaseEP(4);
		}
	        else throw new Exception ("SEStudent groupWork not working");
	}
	
	public void groupDiscussion() throws Exception{
		if(this.getKP()>=this.maxKP) {
		    this.increaseEP(4);
		    this.currentKP=0;
		    for(Character friend : getTeam().getMembers()){
		        if(friend.getHP()>0){
		            int increase = (int) this.getDefence()/2;
		            friend.increaseHP(increase);
		          }
		      }
		}else throw new Exception("SEStudent groupDiscussion not working");
	}

}
