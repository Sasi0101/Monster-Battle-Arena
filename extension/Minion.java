import java.util.Random;

public class Minion extends Character implements Monster{
    Minion(String name) {
        super(name, 5, 5, 5, 5);
    }

    public void strike(Character enemy) {
    	if(enemy != null) {
    		Random rand = new Random();
        	int percentage = rand.nextInt(100);
        	if(percentage<=74) SyntaxError(enemy);
        	else if(percentage<=84) ArrayIndexOutOfBoundException(enemy);
        	else if(percentage<=99) NullPointerException();
    	}
    }

    public void SyntaxError(Character enemy) {
    	if(enemy != null) {
    		if((this.getHP()>0)&&(enemy.getHP()>0)) {
        	this.increaseEP(3);
        	int damageTaken = (int) ((100*this.getAttack()/(100+enemy.getDefence())));
        	enemy.decreaseHP(damageTaken);
        	enemy.increaseEP(3);
        	if(enemy instanceof Student) ((Student)enemy).increaseKP(3);
        	if(enemy.getHP()<=0) this.increaseEP(4);
        	}
    	}
    }

    public void NullPointerException() {
    	if(this != null) {
    		if(this.getHP()>0) {
        	this.increaseEP(3);
        	int increase = (int) this.getDefence();
        	this.increaseHP(increase);
        	}
    	}
    }
    
    public void ArrayIndexOutOfBoundException(Character enemy) {
    	if((enemy != null)&&(this != null)) {
    		if((this.getHP()>0) && (enemy.getHP()>0)) {
        	this.increaseEP(3);
        	int damageTaken = (int) (2*(100*this.getAttack()/(100+enemy.getDefence())));
        	enemy.decreaseHP(damageTaken);
        	enemy.increaseEP(3);
        	if(enemy instanceof Student) ((Student)enemy).increaseKP(3);
        	if(enemy.getHP()<=0) this.increaseEP(4);
        	}
    	}
    }

}
