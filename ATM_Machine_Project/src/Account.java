

public class Account {

	private double balance; // field for Client's balance
	private int pin; // field for client's pin number
	private String client_first_name; // field for client's first name
	private String client_last_name; // field for client's last name
	private DepositBox depBox;
	
	// create a default constructor for the account
	
	public Account() {
	}
	
	// a multi-arguement constructor
	public Account(String fName, String lName, int initialBal, int setPin) {
		this.client_first_name = fName;
		this.client_last_name = lName;
		this.balance = initialBal;
		this.pin = setPin;
	}

	public double getBalance() { // get the client's balance
		return balance;
	}
	
	public void setBalance(double x) {
		balance = balance - x;
	}
	
	public void depositToBalance(double x) {
		balance = balance + x;
	}


	public int getPin() { // get the client pin number
		return pin;
	}


	public String getClient_first_name() { // get's the clients first name
		return client_first_name;
	}


	public String getClient_last_name() { //  gets the client's last name
		return client_last_name;
	}

	public DepositBox getDepBox() {
		return depBox;
	}

	public void setDepBox(DepositBox depBox) {
		this.depBox = depBox;
	}



}
