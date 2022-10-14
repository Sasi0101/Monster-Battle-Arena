//import java.util.ArrayList;
//import java.util.Collection;
import java.util.*;

public class Guild{
	ArrayList<Character> guildMembers = new ArrayList<Character>();
	ArrayList<Character> guildMembersCheck = new ArrayList<Character>();
    StudentTeam studentTeam = new StudentTeam("studentTeam");
    int membersInTeam = 0;
    int membersInGuild=0;
    int numberOfRounds=1;
	Guild(){
		
	}
	
	
	public void addMember(Character newGuildMember) throws Exception{
		if(newGuildMember.getHP()>0) {
			if(guildMembers.contains(newGuildMember)){
				throw new Exception ("Member is already in the guild");
			} else {
				guildMembers.add(newGuildMember);
				newGuildMember.setTeam(studentTeam);
			}
		}
	}
	
	
	public ArrayList<Character> getMembers() {
		return guildMembers;
	}
	
	//the best strategy i found is if we have at least one of each possible students and the rest is not important
	public Team getTeam(Team enemyTeam) {
		guildMembersCheck = new ArrayList<Character>();
		ArrayList<Character> check = new ArrayList<Character>();
		studentTeam = new StudentTeam("studentTeam");
		int membersInTeam = 0;
		//we are checking for the dead students and removing them from the guildMembers
		if(numberOfRounds > 1) {
			for(Character members : guildMembers) {
				if(members.getHP()>0) {
					guildMembersCheck.add(members);
				}
			}
			guildMembers = guildMembersCheck;
		}
		numberOfRounds++;
		//if there are 5 or less members in guildMembers we just fill the studentTeam with them
		if(guildMembers.size()<=5) {
			for(Character member : guildMembers) {
				if(member.currentHP>0) {
					//studentTeam.addMember(member);
					member.setTeam(studentTeam);
				}
			}
		}
		else {
			for(Character member : guildMembers) {
				if((member instanceof AIStudent) &&(member.getHP()>0)) {
					//studentTeam.addMember(member);
					membersInTeam++;
					member.setTeam(studentTeam);
					check.add(member);
					break;
				}
			}
			for(Character member : guildMembers) {
				if((member instanceof CSStudent)&&(member.getHP()>0)) {
					//studentTeam.addMember(member);
					membersInTeam++;
					member.setTeam(studentTeam);
					check.add(member);
					break;
				}
			}
			for(Character member : guildMembers) {
				if((member instanceof BEEStudent)&&(member.getHP()>0)) {
					//studentTeam.addMember(member);
					membersInTeam++;
					member.setTeam(studentTeam);
					check.add(member);
					break;
				}
			}
			for(Character member : guildMembers) {
				if((member instanceof CyberStudent)&&(member.getHP()>0)) {
					//studentTeam.addMember(member);
					membersInTeam++;
					member.setTeam(studentTeam);
					check.add(member);
					break;
				}
			}
			for(Character member : guildMembers) {
				if((member instanceof EEStudent) &&(member.getHP()>0)) {
					//studentTeam.addMember(member);
					membersInTeam++;
					member.setTeam(studentTeam);
					check.add(member);
					break;
				}
			}
			for(Character member : guildMembers) {
				if((member instanceof SEStudent)&&(member.getHP()>0)) {
					//studentTeam.addMember(member);
					membersInTeam++;
					member.setTeam(studentTeam);
					check.add(member);
					break;
				}
			}
			int whileChecker = 0;
			whileChecker++;
			while(membersInTeam <5) {
				for(Character member : guildMembers) {
					int numberOfSimilarities = 0;
					for(Character checkMember : check) {
						if(member == checkMember) {
							numberOfSimilarities++;
							break;
						}
					}
					if((numberOfSimilarities <= 0)&&(membersInTeam<5)&&(member.getHP()>0)) {
						membersInTeam++;
						member.setTeam(studentTeam);
						//studentTeam.addMember(member);
						check.add(member);
						
					}
				}
				if(whileChecker > 10) break; 
			}
			
		}
		return studentTeam;
	}
}
