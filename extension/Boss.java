import java.util.Random;
public class Boss extends Character implements Monster{

    Boss(String name) {
        super(name, 8, 7, 8, 7);
    }

    public void strike(Character enemy) {
        Random rand = new Random();
        int percentage = rand.nextInt(100);
        if(percentage<=49) SyntaxError(enemy);
        else if(percentage<=64) ArrayIndexOutOfBoundException(enemy);
        else if(percentage<=74) ConcurrentModificationException(enemy.getTeam());
        else if(percentage <= 89) NullPointerException();
        else if(percentage <=99) NoneTermination();
    }

    public void SyntaxError(Character enemy) {
        if((this.getHP()>0)&&(enemy.getHP()>0)) {
            this.increaseEP(3);
            enemy.increaseEP(3);
            int damageTaken = (int) ((100*this.getAttack()/(100+enemy.getDefence())));
            enemy.decreaseHP(damageTaken);
            if(enemy instanceof Student) ((Student)enemy).increaseKP(3);
            if(enemy.getHP()<=0) this.increaseEP(4);
            }
    }

    public void NullPointerException() {
        if(this.getHP()>0) {
            this.increaseEP(3);
            int increase = (int) this.getDefence();
            this.increaseHP(increase);
            }
    }

    public void ArrayIndexOutOfBoundException(Character enemy) {
        if((this.getHP()>0) && (enemy.getHP()>0)) {
            this.increaseEP(3);
            int damageTaken = (int) (2*(100*this.getAttack()/(100+enemy.getDefence())));
            enemy.decreaseHP(damageTaken);
            enemy.increaseEP(3);
            if(enemy instanceof Student) ((Student)enemy).increaseKP(3);
            if(enemy.getHP()<=0) this.increaseEP(4);
            }
    }
    
    public void NoneTermination() {
        if(this.getHP()>0) {
            this.increaseEP(3);
            for(Character member : this.getTeam().getMembers()) {
                if(member.getHP()<=0) {
                    member.currentHP = (int) member.baseHP;
                }
            }
        }
    }
    
    public void ConcurrentModificationException(Team enemyTeam) {
        if(this.getHP()>0) {
            this.increaseEP(3);
            for(Character enemy : enemyTeam.getMembers()) {
                if(enemy.getHP()>0) {
                    int damageTaken = (int) ((100*this.getAttack()/(100+enemy.getDefence())));
                    enemy.decreaseHP(damageTaken);
                    enemy.increaseEP(3);
                    if(enemy instanceof Student) ((Student) enemy).increaseKP(3);
                    if(enemy.getHP()<=0) this.increaseEP(4);
                }
            }
        }
    }
    
}
