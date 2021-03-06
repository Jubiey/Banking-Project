package banking_dev;
import java.util.HashSet;
import java.util.Set;

/*
 * Handles unique IDs with a hash set that will only retain unique values.
 * All values used are added to set.
 */

public class UniqueIDs {
	
	private HashSet<Integer> idSet = new HashSet<>();
	private int count = 0;	//helps to generate new ID values
	
	//ensure id does not already exist
	public synchronized boolean addID(int id) {
		count += 1;
		
		if (!idSet.contains(id)) idSet.add(id);
		else return false;
		return true;
	}
	
	public synchronized int findNewID() {
		int newID = ++count;
		
		while (true) {
			if (!idSet.contains(newID)) break;
			count += 1;
			if (!idSet.contains(++newID)) break;
			count += 1;
			if (!idSet.contains(++newID)) break;
			count += 1;
			newID = newID*newID/2;
		}
		return newID;
	}
	
	public synchronized void removeID(int id) {
		idSet.remove(id);
	}
	
}
