import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.Action;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;

//the second form with our options menu
public class OptionsMenu extends ATM{

	/**
	 * 
	 */

	private JFrame frame;
	private JTextField tb_deposit;
	private JLabel lbl_middle_display;
	private JLabel lbl_inquiry;
	private JLabel lbl_withdrawal;
	private JLabel lbl_deposit;
	private JLabel lbl_exit;
	private JButton btn_get20;
	private JButton btn_get40;
	private JButton btn_get60;
	private JButton btn_get100;
	private JButton btn_get200;
	private JButton btn_balance;
	private JButton btn_withdrawal;
	private JButton btn_deposit;
	private JButton btn_exit;
	private JButton btn_cancel;
	private static JFrame frame2;
	private int requestedAmount;
	DecimalFormat df = new DecimalFormat("0.00");

	/**
	 * Launch the application.
	 */
	
	  public static void main(String[] args) { EventQueue.invokeLater(new
			  Runnable() { public void run() { try { OptionsMenu window = new
	 OptionsMenu(frame2); window.frame.setVisible(true); } catch (Exception e) {
		 e.printStackTrace(); } } }); }
	 

	/**
	 * Create the application.
	 */
	public OptionsMenu(JFrame x) {
		initialize(x);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(JFrame x) {
		frame = new JFrame();
		frame2 = new JFrame();
		frame2 = x;
		frame.setBounds(100, 100, 490, 461);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btn_balance = new JButton("1");
		btn_balance.setForeground(new Color(0, 0, 205));
		btn_balance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DisplayBalance(GetCurrentAccount(), tb_deposit, lbl_middle_display); // display the balance
				lbl_middle_display.setText("Current Balance");
				tb_deposit.setVisible(true);
			}
		});
		btn_balance.setFont(new Font("Tahoma", Font.BOLD, 25));
		btn_balance.setBounds(207, 267, 64, 31);
		frame.getContentPane().add(btn_balance);
		
		btn_withdrawal = new JButton("2");
		btn_withdrawal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HideForWithdraw(); // use method to hide irrelevant buttons and show relevant buttons
			}
		});
		btn_withdrawal.setForeground(new Color(255, 0, 0));
		btn_withdrawal.setFont(new Font("Tahoma", Font.BOLD, 25));
		btn_withdrawal.setBounds(207, 301, 64, 31);
		frame.getContentPane().add(btn_withdrawal);
		
		btn_deposit = new JButton("3");
		btn_deposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HideForDeposit();
			}
		});
		btn_deposit.setForeground(new Color(0, 100, 0));
		btn_deposit.setFont(new Font("Tahoma", Font.BOLD, 25));
		btn_deposit.setBounds(207, 335, 64, 31);
		frame.getContentPane().add(btn_deposit);
		
		/// exit button
		btn_exit = new JButton("4");
		btn_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(frame,
			            "Do you want to Exit ?", "Exit Confirmation",
			            JOptionPane.YES_NO_OPTION);
			        if (result == JOptionPane.YES_OPTION) {
			          frame.dispose();
			          ATM atm = new ATM();
			          atm.setFrame(frame2);
			          atm.getFrame().setVisible(true);
			          frame.setVisible(false);
			        }
			}
		});
		
		btn_exit.setFont(new Font("Tahoma", Font.BOLD, 25));
		btn_exit.setBounds(207, 369, 64, 31);
		frame.getContentPane().add(btn_exit);
		
		lbl_inquiry = new JLabel("BALANCE INQUIRY:");
		lbl_inquiry.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_inquiry.setBounds(37, 267, 160, 31);
		frame.getContentPane().add(lbl_inquiry);
		
		lbl_withdrawal = new JLabel("WITHDRAWAL:");
		lbl_withdrawal.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_withdrawal.setBounds(72, 309, 116, 19);
		frame.getContentPane().add(lbl_withdrawal);
		
		lbl_deposit = new JLabel("DEPOSIT:");
		lbl_deposit.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_deposit.setBounds(114, 339, 74, 19);
		frame.getContentPane().add(lbl_deposit);
		
		lbl_exit = new JLabel("EXIT:");
		lbl_exit.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_exit.setBounds(140, 369, 48, 14);
		frame.getContentPane().add(lbl_exit);
		
		btn_get20 = new JButton("$20");
		btn_get20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processWithdrawal(20);
			}
		});
		btn_get20.setBounds(10, 34, 89, 23);
		frame.getContentPane().add(btn_get20);
		
		btn_get40 = new JButton("$40");
		btn_get40.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processWithdrawal(40);
			}
		});
		btn_get40.setBounds(10, 80, 89, 23);
		frame.getContentPane().add(btn_get40);
		
		btn_get60 = new JButton("$60");
		btn_get60.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processWithdrawal(60);
			}
		});
		btn_get60.setBounds(10, 127, 89, 23);
		frame.getContentPane().add(btn_get60);
		
		btn_get100 = new JButton("$100");
		btn_get100.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processWithdrawal(100);
			}
		});
		btn_get100.setBounds(338, 34, 89, 23);
		frame.getContentPane().add(btn_get100);
		
		btn_get200 = new JButton("$200");
		btn_get200.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processWithdrawal(200);
			}
		});
		btn_get200.setBounds(338, 80, 89, 23);
		frame.getContentPane().add(btn_get200);
		
		btn_cancel = new JButton("CANCEL");
		btn_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(frame,
			            "Are you sure you want to cancel the transaction?", "Please Confirm Cancellation",
			            JOptionPane.YES_NO_OPTION);
			        if (result == JOptionPane.YES_OPTION) {
			        	EnableMenu();
			        }
			}
		});
		btn_cancel.setBounds(338, 127, 89, 23);
		frame.getContentPane().add(btn_cancel);
		
		
		tb_deposit = new JTextField(6); // allows for no deposits over 9999 due to safety concerns
		tb_deposit.setFont(new Font("Tahoma", Font.BOLD, 15));
		tb_deposit.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	Account a = new Account();
		    	a = GetCurrentAccount();
		    	DepositBox dbox = new DepositBox();
		    	tb_deposit.setEnabled(true);
		    	if(dbox.AcceptDeposit(tb_deposit.getText())) {
			    	a.depositToBalance(dbox.getBalance());
			    	JOptionPane.showMessageDialog(frame,
							   "You now have $" + df.format(a.getBalance()));
			    	EnableMenu();
		    	}
		    }
		});
		
		tb_deposit.setBounds(128, 128, 182, 36);
		frame.getContentPane().add(tb_deposit);
		
		lbl_middle_display = new JLabel("Current Balance");
		lbl_middle_display.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_middle_display.setForeground(new Color(0, 100, 0));
		lbl_middle_display.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_middle_display.setBounds(72, 65, 290, 49);
		frame.getContentPane().add(lbl_middle_display);
		HideButtons(btn_get20, btn_get40, btn_get60, btn_get100, btn_get200, btn_cancel, tb_deposit, lbl_middle_display);
		
		JLabel lbl_welcome = new JLabel("");
		lbl_welcome.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_welcome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_welcome.setBounds(109, 11, 219, 31);
		frame.getContentPane().add(lbl_welcome);
		GreetClient(lbl_welcome); // greet the client
		
		JLabel lbl_currentBalance = new JLabel("");
		lbl_currentBalance.setBounds(173, 186, 48, 14);
		frame.getContentPane().add(lbl_currentBalance);
	}
	
	public JFrame GetFrame2() {
		return this.frame;
	}
	
	public void setVisible(boolean b) {
        frame.setVisible(b);
    }
	
	//hide all the irrelevant buttons on load
	public void HideButtons(JButton a, JButton b, JButton c, JButton d, JButton e, JButton f, JTextField g, JLabel h) {
		a.setVisible(false);
		b.setVisible(false);
		c.setVisible(false);
		d.setVisible(false);
		e.setVisible(false);
		f.setVisible(false);
		g.setVisible(false);	
		h.setVisible(false);
	}
	//show all the buttons for deposit amounts and the textfield for deposit amt
	public void ShowButtons(JButton a, JButton b, JButton c, JButton d, JButton e, JButton f, JTextField g) {
		a.setVisible(true);
		b.setVisible(true);
		c.setVisible(true);
		d.setVisible(true);
		e.setVisible(true);
		f.setVisible(true);
		g.setVisible(true);	
	}
	// greet our client
	public void GreetClient(JLabel label) {
		Account a = new Account();
		a = GetCurrentAccount();
		String fname = a.getClient_first_name();
		String lname = a.getClient_last_name();		
		label.setText("Greetings " + fname + " " + lname + "!");
		label.setVisible(true);
	}
	// Display the balance
	public void DisplayBalance(Account x, JTextField l, JLabel z) {
		l.setText("$" + String.valueOf(df.format(x.getBalance())));
		l.setVisible(true);
		l.setEditable(false); // disable editability
		z.setVisible(true);
	}
	
	// when withdraw option selected hide some irrelevant form components to the transaction
	public void HideForWithdraw() {
		lbl_inquiry.setVisible(false);
		lbl_withdrawal.setVisible(false);
		lbl_deposit.setVisible(false);
		lbl_middle_display.setText("Enter Amount on Keypad");
		tb_deposit.setText("");
		btn_get20.setVisible(true);
		btn_get40.setVisible(true);
		btn_get60.setVisible(true);
		btn_get100.setVisible(true);
		btn_get200.setVisible(true);
		btn_cancel.setVisible(true);
		btn_balance.setEnabled(false);
		btn_withdrawal.setEnabled(false);
		btn_deposit.setEnabled(false);
	}
	
	// disable unneeded options for deposit
	public void HideForDeposit() {
		lbl_inquiry.setEnabled(false);
		lbl_withdrawal.setEnabled(false);
		lbl_deposit.setEnabled(false);
		lbl_middle_display.setText("Enter amount in cents and press enter");
		lbl_middle_display.setVisible(true);
		tb_deposit.setText("");
		tb_deposit.setVisible(true);
		tb_deposit.setEnabled(true);
		tb_deposit.setEditable(true);
		btn_balance.setEnabled(false);
		btn_withdrawal.setEnabled(false);
		btn_deposit.setEnabled(false);
	}
	
	public void EnableMenu() {
			lbl_inquiry.setVisible(true);
			lbl_withdrawal.setVisible(true);
			lbl_deposit.setVisible(true);
			lbl_inquiry.setEnabled(true);
			lbl_withdrawal.setEnabled(true);
			lbl_deposit.setEnabled(true);
			lbl_middle_display.setText("Select an Option");
			lbl_middle_display.setVisible(true);
			tb_deposit.setText("");
			tb_deposit.setEnabled(false);
			btn_get20.setVisible(false);
			btn_get40.setVisible(false);
			btn_get60.setVisible(false);
			btn_get100.setVisible(false);
			btn_get200.setVisible(false);
			btn_cancel.setVisible(false);
			btn_balance.setEnabled(true);
			btn_withdrawal.setEnabled(true);
			btn_deposit.setEnabled(true);
	}


	public int GetRequestedAmount() {
		return requestedAmount;
	}


	public void SetRequestedAmount(int requestedAmount) {
		this.requestedAmount = requestedAmount;
	}
	
	//boolean to check if amount requested is greater than account balance
	public boolean ReqAmtGreaterThanBalance() {
		if(GetRequestedAmount()> GetCurrentAccount().getBalance()) {
			lbl_middle_display.setText("Sorry, insufficient funds..");
			return true;
		}
		return false;
	}
	
	//boolean to check if amount requested is greater than ATM's cash on-hand
	public boolean ReqOverAvailOnHand() {
		if(GetRequestedAmount()>CashDispenser.getCashOnHand()) {
			return true;
		}
		return false;
	}
	
	// helper method to shorten redundant code for withdrawal transaction
	public void processWithdrawal(int x) {
		int result = JOptionPane.showConfirmDialog(frame,
	            "Are you sure you want to withdraw $" + x + "?", "Please Confirm Withdrawal",
	            JOptionPane.YES_NO_OPTION);
	        if (result == JOptionPane.YES_OPTION) {
	        	SetRequestedAmount(x);
				if (ReqAmtGreaterThanBalance()) {
					SetRequestedAmount(0);
					JOptionPane.showMessageDialog(frame,
							"Unable to process Transaction", "Insufficient funds",
							JOptionPane.ERROR_MESSAGE);
				}
				else {
					if(ReqOverAvailOnHand()) {
						lbl_middle_display.setText("Sorry ATM's funds insufficient");
						SetRequestedAmount(0);
						JOptionPane.showMessageDialog(frame,
								"Sorry ATM's funds insufficient");
					}
					else {
						Account acc = new Account();
						acc = GetCurrentAccount();
						acc.setBalance(x);
						JOptionPane.showMessageDialog(frame,
							   "You now have $" + df.format(acc.getBalance()));
					}
				}
	        }
	        EnableMenu();
	}
	
	
	
}
