
public class CashDispenser extends ATM{

	private static double cashOnHand = 100000;
	
	public CashDispenser(){}
	
	public static double getCashOnHand() {
		return cashOnHand;
	}

	public static void setCashOnHand(double x) {
		cashOnHand = x;
	}
}
