package banking_dev;

/*
 * Message //parent
 * -------------------------
 * +perform: Process enum
 * +success: boolean = false
 * +id: int = auto					//auto generated from date
 * +sessionID: int = 0				//continued login
 * +why: String	= ""				//why fail
 * -------------------------
 * +Message()
 * +Message(sessionID, perform) 	//subclass use
 * +Message(sessionID, id, success)	//server: detailed success
 * +Message(Message, success)		//server: simple success
 * +Message(Message, why)			//server: fail
 */

public class AddAccount extends Message {
	public Account account;
	public int customerID;
	public Customer customer;
	
	public AddAccount(Customer customer, int sessionID, Account account) {
		super(sessionID, Process.ADD_ACCOUNT);
		
		this.account = account;
		customerID = customer.getID();
	}
	
	//Server use, success
	public AddAccount(Message m, Customer customer) {
		super(m, true);
		this.customer = customer;
	}
	
	//Server use, fail
	public AddAccount(Message m, String why) {
		super(m, why);
	}
}
