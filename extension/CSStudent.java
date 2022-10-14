
public class CSStudent extends Student{
    String name;
    CSStudent(String name) {
        super(name, 7, 6, 6, 6, 4);
    }
    
    //special abilities
    public void pairWorking(Character friend, Character enemy) throws Exception{
        if(this.currentKP==this.maxKP) {
            this.increaseEP(4);
            this.currentKP=0;
            int damageTaken = (int) ((100*this.getAttack())/(100+enemy.getDefence()));
            enemy.decreaseHP(damageTaken);
            damageTaken = (int) ((100*friend.getAttack())/(100+enemy.getDefence()));
            enemy.decreaseHP(damageTaken);
            if(enemy.getHP()==0) this.increaseEP(4);
        }
        else throw new Exception("CSStudent pariWorking not wokring");
    }
    public void support(Character friend) throws Exception {
        if(this.currentKP==this.maxKP) {
            this.increaseEP(4);
            this.currentKP=0;
            ((Student)friend).increaseHP((int)this.getDefence());
        }
        else throw new Exception("CSStudent support not working");
    }
}
