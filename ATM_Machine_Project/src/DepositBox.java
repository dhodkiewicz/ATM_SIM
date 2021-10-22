import java.awt.Component;

import javax.swing.JOptionPane;

public class DepositBox extends Account{
	

private double balance;

DepositBox(){}

public boolean AcceptDeposit(String x) {
	if(x.matches("^[0-9]+$")) {
		if(x.length() < 7) {
		this.balance = (Double.parseDouble(x)/100);
		return true;
		}
		else {
			Component frame = null;
			JOptionPane.showMessageDialog(frame,
					"Deposit is too large to be accepted due to security concerns", "Unable to Process",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
	else {
		Component frame = null;
		JOptionPane.showMessageDialog(frame,
				"Unable to process Transaction", "Numbers only please",
				JOptionPane.ERROR_MESSAGE);
		return false;
	}
}

public double getBalance() {
	return this.balance;
}

}
