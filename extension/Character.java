import java.lang.Math;

public class Character{
    public String name;
    public int baseHP, baseAtk, baseDef, baseSpd, level=1;
    public int  currentAtk, currentDef, currentSpd;
    public int currentHP, currentEP;
    public int maxHP;
    Team hisTeam;
    
    //Making the Character constructor
    Character(String name, int baseHP, int baseAtk, int baseDef, int baseSpd){
    this.name = name;
    this.baseHP = baseHP;
    this.baseAtk = baseAtk;
    this.baseDef = baseDef;
    this.baseSpd = baseSpd;
    currentHP = baseHP;
    }
    
    //Making their getter methods according to their levels
    
    public String getName(){
        return name;
    }
    public int getMaxHP(){
        if(level>1)
            return (int) Math.round(baseHP*(Math.pow(level, 1.2)));
        else 
            return baseHP;
    }
    public int getAttack(){
        currentAtk = (int) Math.round(baseAtk*(Math.pow(level, 1.2)));
    	return currentAtk;
    }
    public int getDefence(){
        currentDef = (int) Math.round(baseDef*(Math.pow(level, 1.2)));
        return currentDef;
    }
    public int getSpeed(){
        currentSpd = (int) Math.round(baseSpd*(Math.pow(level, 1.2)));
        return currentSpd;
    }
    public int getTargetEP(){
        return (int) Math.round(10*(Math.pow(level, 1.5)));
    }
    
    //defining the accessor and mutator methods
    
    public int getHP(){
        return (int) currentHP;
    }
    public int getEP(){
        return (int) currentEP;
    }
    public void increaseHP(int amount){
        if(currentHP+amount<=getMaxHP()) 
            currentHP = currentHP + amount;
        else currentHP=getMaxHP();
    }
    public void decreaseHP(int amount){
        if(currentHP-amount>=0)
            currentHP = currentHP - amount;
        else currentHP = 0;
    }
    public void increaseEP(int amount){
        if(currentEP + amount >= getTargetEP()){
            level = level +1;
            getMaxHP(); getAttack(); getDefence(); getSpeed(); getHP(); getEP();
            currentHP = getMaxHP();
            currentEP = 0;
        }
        else {
           currentEP = getEP() + amount; 
        }
    }
    
    //setter and getter method for the characters Team
    public Team setTeam(Team team) {
        team.addMember(this);
        this.hisTeam = team;
        return hisTeam;
    }
    public Team getTeam() {
    	return hisTeam;
    }

}