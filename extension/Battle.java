import java.util.*;

public class Battle {
	Team studentTeam;
	Team enemyTeam;
	Team winningTeam;
	int deadMembers=0;
	ArrayList<Character> membersInBattle = new ArrayList<Character>();
	Battle(Team studentTeam, Team enemyTeam){
		this.studentTeam = studentTeam;
		this.enemyTeam = enemyTeam;
	}
	
	public Team fight() {
		for(int i=0; i<30; i++) {
			getOrder();
			for(Character character : membersInBattle) {
				if(character.getHP() > 0) {
					if(character.getTeam() == studentTeam) {
						try {
							Thread.sleep(250);
							studentTeam.move(character, enemyTeam);
							System.out.println("move method used by " + character.getName());
						} catch (Exception e) {
							System.out.println(e);
						}
					}
					if(character instanceof Monster) {
						try {
							Thread.sleep(250);
							enemyTeam.move(character, studentTeam);
							System.out.println("move method used by " + character.getName());
						} catch (Exception e) {
							System.out.println(e);
						}
					}
				}
			}
			getStats(i);
			for(Character member : enemyTeam.members) {
				if(member.currentHP<=0) {
					deadMembers++;
				}
			}
			if(deadMembers == enemyTeam.members.size()) {
				winningTeam = studentTeam;
				break;
			} else {
				deadMembers = 0;
			}
			
			for(Character member : studentTeam.members) {
				if(member.currentHP<=0) {
					deadMembers++;
				}
			}
			if(deadMembers == studentTeam.members.size()) {
				winningTeam = enemyTeam;
				break;
			} else {
				deadMembers = 0;
			}
			if(i == 29) {
				return null;
			}
		}
		//at the end return the winning team
		return winningTeam;
	}
	
	public void getStats(int roundNumber) {
		System.out.println("\n\n");
		System.out.println("Round" + (roundNumber+1));
		System.out.println("\n");
		System.out.println("Monster team ");
		for(Character monster : enemyTeam.members) {
			if(monster.currentHP <= 0 ) {
				System.out.println(monster.name +" is dead");
			} else {
				System.out.println(monster.name + " has " + monster.currentHP + " HP");
			}
		}
		System.out.println("Student Team");
		for(Character student : studentTeam.members) {
			if(student.currentHP <= 0) {
				System.out.println(student.name + " is dead");
			} else {
				System.out.println(student.name + " has " + student.currentHP + " HP");
			}
		}
		System.out.println();
	}

	public void getOrder(){
		membersInBattle.clear();
		for(Character student : studentTeam.members) {
			if(student.currentHP>0) {
				membersInBattle.add(student);
			}
		}
		for(Character monster : enemyTeam.members) {
			if(monster.currentHP>0) {
				membersInBattle.add(monster);
			}
		}
		Collections.sort(membersInBattle, new Speed());
		Collections.reverse(membersInBattle);
	}
}
