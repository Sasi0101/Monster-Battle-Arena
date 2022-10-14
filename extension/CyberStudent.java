
public class CyberStudent extends Student {
        //String name;
    CyberStudent(String name) {
        super(name, 7, 7, 5, 6, 6);
    }
    
    //special abilities
    public void cyberAttack(Team enemyTeam) throws Exception{
        if(this.getKP()>=this.maxKP) {
            this.increaseEP(4);
            this.currentKP=0;
            for(Character enemy : enemyTeam.getMembers()){
                int damageTaken = (int) ((100*this.getAttack())/(100+enemy.getDefence()));
                enemy.decreaseHP(damageTaken);
                if(enemy.getHP()<=0) this.increaseEP(4);
            }
        }
        else throw new Exception("CyberStudent cyberAttack not working");
    }
}
