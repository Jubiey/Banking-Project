package banking_dev;
import java.util.Date;
import java.io.Serializable;
import java.util.ArrayList;

public class Customer implements Serializable {
	
	private final int id;
	private String name;
	private String passcode;
	private int PIN;
	private int numSavings;
	private int numChecking;
	private ArrayList<Account> accounts = new ArrayList<>();
	private Date opened = new Date();
	private Date closed = null;
	
	//TODO cardConnected boolean, hashmap of cards to id, delete card to customer table fr db
	
	
	public Customer(String name, String passcode) {
		this.id = 0;
		this.name = name;
		this.passcode = passcode;
	}
	
	//full constructor for loading from file; collections can be set separately
	public Customer(
			int id, String name,
			String passcode, int numSavings,
			int numChecking, int PIN, 
			Date opened) {
		
		this.name = name;
		this.passcode = passcode;
		this.id = id;
		this.passcode = passcode;
		this.numSavings = numSavings;
		this.numChecking = numChecking;
		this.PIN = PIN;
		this.opened = opened;
	}
	


	public String getName() { return this.name; }
	public void setName(String n) { this.name = n; }
	
	public String getPasscode() { return this.passcode; }
	public void setPasscode(String p) { this.passcode = p; }
	
	public Date getOpened() { return this.opened; }
	public void setOpened(Date d) { this.opened = d; }
	
	public Date getClosed() { return this.closed; }
	public void setClosed(Date d) { this.closed = d; }
	
	public int getPIN() { return this.PIN; }
	public void setPIN(int PIN) { this.PIN = PIN; }
	
	public ArrayList<Account> getAccounts() { return this.accounts; }
	public void setAccounts(ArrayList<Account> a) { this.accounts = a; }
	
	public void addAccount(Account a) { this.accounts.add(a); }
	
	public int getID() { return this.id; }
	
	public int getNumSavings() { 
		int num = 0;
		for (Account account: accounts) {
			if (account.getType() == AccountType.SAVINGS) num += 1;
		}
		return num; 
	}
	
	public int getNumChecking() { 
		int num = 0;
		for (Account account: accounts) {
			if (account.getType() == AccountType.CHECKING) num += 1;
		}
		return num;  
	}
	
	public Account findAccount(int id) {
		for (Account a: this.accounts) {
			if (a.getID() == id) return a;	//if found stop search
		}
		return null;
	}
	
	public boolean removeAccount(int id) {
		Account target;
		
		if ((target = findAccount(id)) == null) return false; //fail to find
		
		accounts.remove(target);
		return true;
	}
	
	public String toString() {
		String out;
		out = "#"+ id +" "+ name;
		if (closed != null && closed.after(opened)) {
			out += " closed:"+ closed.getMonth() +"/"+ closed.getDate() +"/"+ (closed.getYear() - 100);
		}
		out += "\n";
		
		for(Account a: accounts) {
			if (a.getClosed() != null && a.getClosed().after(a.getOpened())) continue;
			else out += a +"\n";
		}
		return out;
	}
	
	public String details() {
		String out;
		out = "#"+ id +" "+ name +" opened:"+ 
				opened.getMonth() +"/"+ opened.getDate() +"/"+ (opened.getYear() - 100);
		if (closed != null && closed.after(opened)) {
			out += " closed:"+ closed.getMonth() +"/"+ closed.getDate() +"/"+ (closed.getYear() - 100);
		}
		out += "\n";
		
		for(Account a: accounts) out += a.details() +"\n";
		return out;
	}
	
	
	
}
