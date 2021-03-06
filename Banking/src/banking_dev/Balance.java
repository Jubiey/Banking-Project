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

public class Balance extends Message {
	public Money amount;
	public int accountID; 

	//ATM use
	public Balance(int sessionID, int accountID) {
		super(sessionID, Process.BALANCE);
		this.accountID = accountID;
	}

	//Server success
	public Balance(Money amount, Message m) {
		super(m.sessionID, m.id, true);
		this.amount = amount;
	}
	
	//Server fail
		public Balance(Message m, String why) {
			super(m, why);
		}
}
