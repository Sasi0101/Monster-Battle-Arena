import java.io.*;
public class TowerOfMonsters {
	BufferedReader reader;
	String firstLine, name, type, monsterLevel;
	int level;
	boolean fileIsReady = false;
	
	public static void main(String[] args) {
		//InputStream is;
		String filename = "monsters.txt";
		if(args.length > 0) {
			filename = args[0];
		}
		AIStudent aistudent1 = new AIStudent("AI1");
		CSStudent csstudent1 = new CSStudent("CS1");
		CyberStudent cyberstudent1 = new CyberStudent("Cyber1");
		SEStudent sestudent1 = new SEStudent("SE1");
		AIStudent aistudent2 = new AIStudent("AI2");
		CSStudent csstudent2 = new CSStudent("CS2");
		CyberStudent cyberstudent2 = new CyberStudent("Cyber2");
		SEStudent sestudent2 = new SEStudent("SE2");
		Team studentTeam = new StudentTeam("studentTeam");
		Team enemyTeam = new MonsterTeam("enemyTeam");
		Guild guild = new Guild();
		Team winnerTeam;
		int wave=0;
		
		//for the extension part please uncomment this part
		AEEStudent aeestudent1 = new AEEStudent("AEE1");
		AEEStudent aeestudent2 = new AEEStudent("AEE2");
		BEEStudent beestudent1 = new BEEStudent("BEE1");
		BEEStudent beestudent2 = new BEEStudent("BEE2");
		EEStudent eestudent1 = new EEStudent("EE1");
		EEEStudent eeestudent1 = new EEEStudent("EEE1");
		EEEStudent eeestudent2 = new EEEStudent("EEE2");
		ElecEStudent elecestudent1 = new ElecEStudent("ElecE1");
		ElecEStudent elecestudent2 = new ElecEStudent("ElecE2");
		MEStudent mestudent1 = new MEStudent("MES1");
		MEStudent mestudent2 = new MEStudent("MES2");
		
		try {
			guild.addMember(aistudent1);
			guild.addMember(csstudent1);
			guild.addMember(cyberstudent1);
			guild.addMember(sestudent1);
			guild.addMember(aistudent2);
			guild.addMember(csstudent2);
			guild.addMember(cyberstudent2);
			guild.addMember(sestudent2);
			//the extension part
			guild.addMember(aeestudent1);
			guild.addMember(aeestudent2);
			guild.addMember(beestudent1);
			guild.addMember(beestudent2);
			guild.addMember(eestudent1);
			guild.addMember(eeestudent1);
			guild.addMember(eeestudent2);
			guild.addMember(elecestudent1);
			guild.addMember(elecestudent2);
			guild.addMember(mestudent1);
			guild.addMember(mestudent2);
		} catch  (Exception e) {
			System.out.println("guild addition was not successfull");
		}
		TowerOfMonsters towerOfMonsters = new TowerOfMonsters();
		towerOfMonsters.fileReader(filename);
		winnerTeam = studentTeam;
		while((towerOfMonsters.fileReady())&&(winnerTeam == studentTeam)) {
			studentTeam.clearTeam();
			for(Character student : studentTeam.getMembers()) {
				System.out.println(student.getName());
			}
			studentTeam = new StudentTeam("studentTeam");
			studentTeam = guild.getTeam(enemyTeam);
			towerOfMonsters.monsterTeam(enemyTeam);
			System.out.println("Student team:");
			for(Character student : studentTeam.getMembers()) {
				System.out.println(student.getName() + " has " + student.getHP());
			}
			Battle battle = new Battle(studentTeam, enemyTeam);
			winnerTeam = battle.fight();
			wave++;
			System.out.println("************************");
			System.out.println("Wave compeleted " + wave);
			System.out.println("************************");
			System.out.println("\n");
		}
		if((towerOfMonsters.fileReady() == false) &&(winnerTeam.equals(studentTeam))) {
			System.out.println("Winners are the students");
		} else {
			System.out.println("Winners are the monsters");
		}
	}
	
	public void fileReader(String inputFile) {
		try {
			reader = new BufferedReader(new FileReader(inputFile));
		} catch (Exception e) {
			System.out.println("fileReader method exception ***" + e);
		}
	}

	public String getLine() {
		try {
			firstLine = reader.readLine();
		} catch (Exception e) {
			System.out.println("getLine method exception " + e);
		}
		return firstLine;
	}

	public boolean fileReady() {
		try {
			if(reader.ready()) fileIsReady = true;
			else fileIsReady = false;
		} catch (Exception e) {
			System.out.println("fileReady method exception " + e);
		}
		return fileIsReady;
	}

	public Team monsterTeam(Team enemyTeam) {
		fileReady();
		String monsters[];
		String attributes[];
		Minion minion1=null, minion2=null, minion3=null, minion4=null, minion5=null;
		Boss boss1=null, boss2=null, boss3=null, boss4=null, boss5=null;
		//clear the enemyTeam and make a new one
		for(int i=0; i<5; i++) {
			enemyTeam.members.clear();
		}
		enemyTeam.clearTeam();
		//enemyTeam = new MonsterTeam("enemyTeam");
		if(fileIsReady == true) {
			getLine();
			monsters = firstLine.split(";");
			System.out.println("Monster team: ");
			for(int i=0; i<5; i++) {
				attributes = monsters[i].split("\\(");
				name = attributes[0];
				//System.out.println(name);
				attributes = attributes[1].split(",");
				type = attributes[0];
				//System.out.println(type);
				attributes = attributes[1].split("\\)");
				monsterLevel = attributes[0];
				level = Integer.parseInt(monsterLevel);
				System.out.println(name + " " + type + " " + level);
				//adding the minions to the enemyTeam
				if(type.equals("Minion")) {
					if(minion1 == null) {
						minion1 = new Minion(name);
						enemyTeam.addMember(minion1);
						minion1.setTeam(enemyTeam);
						for(int j=1; j<level; j++) {
							minion1.increaseEP(999);
						}
					} else if(minion2 == null) {
						minion2 = new Minion(name);
						enemyTeam.addMember(minion2);
						minion1.setTeam(enemyTeam);
						for(int j=1; j<level; j++) {
							minion2.increaseEP(999);
						}
					} else if(minion3 == null) {
						minion3 = new Minion(name);
						enemyTeam.addMember(minion3);
						minion1.setTeam(enemyTeam);
						for(int j=1; j<level; j++) {
							minion3.increaseEP(999);
						}
					}else if(minion4 == null) {
						minion4 = new Minion(name);
						enemyTeam.addMember(minion4);
						minion1.setTeam(enemyTeam);
						for(int j=1; j<level; j++) {
							minion4.increaseEP(999);
						}
					}else if(minion5 == null) {
						minion5 = new Minion(name);
						enemyTeam.addMember(minion5);
						minion1.setTeam(enemyTeam);
						for(int j=1; j<level; j++) {
							minion5.increaseEP(999);
						}
					}
					//adding the boss(es) to the enemyTeam
				} else if(type.equals("Boss")) {
					if(boss1 == null) {
						boss1 = new Boss(name);
						enemyTeam.addMember(boss1);
						minion1.setTeam(enemyTeam);
						for(int j=1; j<level; j++) {
							boss1.increaseEP(999);
						}
					} else if(boss2 == null) {
						boss2 = new Boss(name);
						enemyTeam.addMember(boss2);
						minion1.setTeam(enemyTeam);
						for(int j=1;j<level; j++) {
							boss2.increaseEP(999);
						}
					} else if(boss3 == null) {
						boss3 = new Boss(name);
						enemyTeam.addMember(boss3);
						minion1.setTeam(enemyTeam);
						for(int j=1;j<level;j++) {
							boss3.increaseEP(999);
						}
					} else if(boss4 == null) {
						boss4 = new Boss(name);
						enemyTeam.addMember(boss4);
						minion1.setTeam(enemyTeam);
						for(int j=1; j<level; j++) {
							boss4.increaseEP(999);
						}
					} else if(boss5 == null) {
						boss5 = new Boss(name);
						enemyTeam.addMember(boss5);
						minion1.setTeam(enemyTeam);
						for(int j=1; j<level; j++) {
							boss5.increaseEP(999);
						}
					}
				}
			} // end of for cycle
		}//end of fileIsReady
		return enemyTeam;
	}//end of monsterTeam
}
