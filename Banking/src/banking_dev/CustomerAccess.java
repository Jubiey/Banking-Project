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

public class CustomerAccess extends Message {
	public String passcode = "";
	public int customerID = 0;
	public Customer customer = null;
	
	//Teller
	public CustomerAccess(int sessionID, String passcode, int customerID){
		super(sessionID, Process.CUSTOMER_ACCESS);
		this.passcode = passcode;
		this.customerID = customerID;
	}
	
	//Server success
	public CustomerAccess(Customer c, Message m){
		super(m.sessionID, m.id, true);
		this.customer = c;
	}
	
	//Server fail
	public CustomerAccess(Message m, String why){
		super(m, why);
	}
}
