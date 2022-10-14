
public class MonsterTeam extends Team{
	MonsterTeam(String name) {
		super(name);
	}

	public void move(Character member, Team enemyTeam) throws Exception {
		if(member.currentHP>0) {
			Character enemyToAttack = null;
			//select the last alive member of the enemy team
			for(Character enemy : enemyTeam.getMembers()) {
				if(enemy.currentHP>0) enemyToAttack = enemy;
			}
			((Monster)member).strike(enemyToAttack);
		} else {
			throw new Exception ("MonsterTeam character is dead");
		}
	}
	
}
