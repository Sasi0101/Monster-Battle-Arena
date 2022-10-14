import java.util.*;

public class Speed implements Comparator<Character>{
	
	public int compare(Character c1, Character c2) {
		return ((Integer)c1.getSpeed()).compareTo((Integer)c2.getSpeed());
	}
}
