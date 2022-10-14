import java.util.Random;

//import java.util.*;
public class StudentTeam extends Team {

	StudentTeam(String name) {
		super(name);
	}

	public void move(Character member, Team enemyTeam) throws Exception {
		int numberOfFriendsToHeal=0;
		Character monsterToAttack = null;
		Character strongestFriend = null;
		Character lowestHPFriend = null;
		
		if(member.currentHP>0) {
			//find the lowest HP minion if two of them are the same than the stronger one
			for(Character enemy : enemyTeam.getMembers()) {
				if((enemy instanceof Minion) && (enemy.currentHP>0) && (enemy != null)) {
					if(monsterToAttack == null) {
						monsterToAttack = enemy;
					}
					if(enemy.currentHP<monsterToAttack.currentHP) {
						monsterToAttack = enemy;
					}
					if((enemy.currentHP==monsterToAttack.currentHP)&&(enemy.currentAtk>monsterToAttack.currentAtk)) {
							monsterToAttack = enemy;
					}
				}
			}
			//finding the lowestHP boss if two of them are the same than the stronger one
			for(Character enemy : enemyTeam.getMembers()) {
				if((enemy instanceof Boss) && (enemy.currentHP>0) && (enemy != null)) {
					monsterToAttack = enemy;
				}
			}
			//finding the strongest friend thats not the member
			for(Character friend : member.hisTeam.getMembers()) {
				if((friend.currentHP>0)&&(friend!=member)) {
					if(strongestFriend==null) {
						strongestFriend = friend;
					}
					if(strongestFriend.currentAtk>friend.currentAtk) {
						strongestFriend = friend;
					}
				}
			}
			//finding the lowestHP friend thats not the member
			for(Character friend : member.hisTeam.getMembers()) {
				if((friend.currentHP>0)&&(friend!=member)) {
					if(lowestHPFriend == null) {
						lowestHPFriend = friend;
					}
					else if(lowestHPFriend.currentHP>friend.currentHP) {
						lowestHPFriend = friend;
					}
				}
			}
			
			
			//if the member is an AIStudnet
			if(member instanceof AIStudent) {
				if(((Student)member).currentHP<=(int)((Student)member).getMaxHP()/2) {
					if(((Student)member).currentKP >=((Student)member).getMaxKP()) {
						((AIStudent)member).naturalLanguageProcessing();
					} else {
						((AIStudent)member).selfStudy();
					}
				}
				else if(((Student)member).currentKP >=((Student)member).getMaxKP()) {
					((AIStudent)member).machineLearning(monsterToAttack);
				}
				else {
					((AIStudent)member).javaProgramming(monsterToAttack);
				}
			}
			
			
			//if the member is a CSStudent
			if(member instanceof CSStudent) {
				if(lowestHPFriend !=null) {
					if((lowestHPFriend.currentHP<(int)(lowestHPFriend.getMaxHP()/2))&&(lowestHPFriend!=null)) {
						if(((CSStudent) member).currentKP>=((CSStudent)member).getMaxKP()) {
							((CSStudent) member).support(lowestHPFriend);
						}
					}
				}
				else if(member.currentHP<(int)(member.getMaxHP()/2)) {
					((CSStudent) member).selfStudy();
				}
				else if(((CSStudent) member).currentKP>=((CSStudent)member).getMaxKP()) {
					((CSStudent) member).pairWorking(member, strongestFriend);
				}
				else {
					((CSStudent) member).selfStudy();
				}
			}
			
			
			//if the member is a CyberStudent
			if(member instanceof CyberStudent) {
				if(((CyberStudent) member).currentKP>=((CyberStudent)member).getMaxKP()) {
					((CyberStudent) member).cyberAttack(enemyTeam);
				}
				else if(member.currentHP<(int)(member.getMaxHP()/2)) {
					((CyberStudent) member).selfStudy();
				}
				else {
					((CyberStudent) member).javaProgramming(monsterToAttack);
				}
			}
			
			
			//if the member is a SEStudent
			if(member instanceof SEStudent) {
				if(((SEStudent) member).currentKP>=((SEStudent)member).getMaxKP()){
					for(Character friend : member.hisTeam.getMembers()) {
						if(friend.currentHP>0) {
							if(friend.currentHP<(int)(friend.getMaxHP()/2)) {
								numberOfFriendsToHeal++;
							}
						}
					}
					if(numberOfFriendsToHeal>2) {
						((SEStudent) member).groupDiscussion();
					}
				}
				else if(((SEStudent) member).currentKP>=((SEStudent)member).getMaxKP()) {
					((SEStudent) member).groupWork(monsterToAttack);
				}
				else if(member.currentHP<(int)(member.getMaxHP()/2)) {
					((SEStudent) member).selfStudy();
				}
				else ((SEStudent) member).javaProgramming(monsterToAttack);
			}
			
			//if the member is AEEStudent
			if(member instanceof AEEStudent) {
				if(((AEEStudent) member).currentKP>=((AEEStudent)member).getMaxKP()) {
					Random aEEStudentMethod = new Random();
					int methodToChose = aEEStudentMethod.nextInt(5);
					if(methodToChose > 2) {
						((AEEStudent)member).nasaProject(strongestFriend);
					} else {
						((AEEStudent)member).flightEfficiency();
					}
				} else {
					if(member.getHP() < (int)(member.getMaxHP()/2)) {
						((AEEStudent)member).selfStudy();
					} else {
						((AEEStudent)member).javaProgramming(monsterToAttack);
					}
				}
			}
			
			//if the member is a BEEStudent
			if(member instanceof BEEStudent) {
				if(((BEEStudent) member).currentKP>=((BEEStudent)member).getMaxKP()){
					int deadMembers = 0;
					for(Character friendToRevive : member.hisTeam.getMembers()) {
						if(friendToRevive.currentHP<=0) {
							deadMembers++;
						}
					}
					if(deadMembers > 1) {
						((BEEStudent) member).healLostFella();
					} else {
						((BEEStudent) member).biomedicine();
					}
				} else if(member.getHP() < (int)(member.getMaxHP()/2)) {
					((BEEStudent)member).selfStudy();
				} else if(member.getHP() >= (int)(member.getMaxHP()/2)) {
					((BEEStudent)member).javaProgramming(monsterToAttack);
				}
			}
			
			//if the member is a EEStudent
			if(member instanceof EEStudent) {
				if(((EEStudent)member).currentKP >= ((EEStudent)member).maxKP) {
					((EEStudent)member).sosSignal();
				} else if(member.getHP() < (int)(member.getMaxHP()/2)) {
					((EEStudent)member).selfStudy();
				} else if(member.getHP() >= (int)(member.getMaxHP()/2)) {
					((EEStudent)member).javaProgramming(monsterToAttack);
				}
			}
			
			//if the member is a EEEStudent
			if(member instanceof EEEStudent) {
				if(((EEEStudent)member).currentKP >= ((EEEStudent)member).getMaxKP()) {
					if(member.baseAtk < 15) {
						((EEEStudent)member).quantumDevices();
					} else {
						((EEEStudent)member).nanoelectronics(monsterToAttack);
					}
				} else if(member.getHP() < (int)(member.getMaxHP()/2)) {
					((EEEStudent)member).selfStudy();
				}else if(member.getHP() >= (int)(member.getMaxHP()/2)) {
					((EEEStudent)member).javaProgramming(monsterToAttack);
				}
			}
			
			//if the member is a ElecEStudent
			if(member instanceof ElecEStudent) {
				if(((ElecEStudent)member).currentKP >= ((ElecEStudent)member).getMaxKP()) {
					((ElecEStudent)member).novelSuperconducting();
				} else if(member.getHP() < (int)(member.getMaxHP()/2)) {
					((ElecEStudent)member).selfStudy();
				}else if(member.getHP() >= (int)(member.getMaxHP()/2)) {
					((ElecEStudent)member).javaProgramming(monsterToAttack);
				}
			}
			
			//if the member is a MEStudent
			if(member instanceof MEStudent) {
				if(((MEStudent)member).currentKP >= ((MEStudent)member).getMaxKP()) {
					Random random = new Random();
		        	int randomNumber = random.nextInt(99);
		        	if(randomNumber < 33) {
		        		((MEStudent)member).electromechanical(monsterToAttack);
		        	} else {
		        		((MEStudent)member).controlEngineering(lowestHPFriend);
		        	}
				} else if(member.getHP() < (int)(member.getMaxHP()/2)) {
					((MEStudent)member).selfStudy();
				}else if(member.getHP() >= (int)(member.getMaxHP()/2)) {
					((MEStudent)member).javaProgramming(monsterToAttack);
				}
			}
			
	}
  }
}
