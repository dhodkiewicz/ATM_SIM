import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.security.auth.x500.X500Principal;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Window;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class ATM{

	/**
	 *  Welcome to the ATM simulator the following 
	 */
	private JFrame frame;
	private JPasswordField jpass_passfield;
	char[] password = new char[5]; // field for our password
	private StringBuilder tempPin = new StringBuilder(); // temporary pin placeholder
	private static List<Account> listOfAccounts = new ArrayList<Account>(); // list of the banks accounts
	private static List<JButton> btnList = new ArrayList<JButton>();
	private static Account currentAccount; // field for the current account
	private static CashDispenser cashDispencer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ATM window = new ATM();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ATM() {
		initialize();
		InstantiateAccList(listOfAccounts); // instantiate our list of accounts including clients names/pin/balance
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 508, 481);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		jpass_passfield = new JPasswordField();
		jpass_passfield.setHorizontalAlignment(SwingConstants.CENTER);
		jpass_passfield.setFont(new Font("Tahoma", Font.PLAIN, 30));
		jpass_passfield.setToolTipText("please enter a valid 4 digit pin number using the numeric buttons below");
		jpass_passfield.setEditable(false);
		jpass_passfield.setBounds(114, 113, 233, 41);
		getFrame().getContentPane().add(jpass_passfield);
		
		//button 1
		JButton btn_1 = new JButton("1");
		btn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddToPassword("1"); // add to temporary placeholder
				jpass_passfield.setText(GetPin()); // set the actual text of the password field
				if(CheckPinLength()) { 				// check the length of the pin SB if >= 5
					DisableKeypad(); //disable buttons
				}
			}
		});
		
		
		btn_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn_1.setBounds(22, 256, 89, 23);
		getFrame().getContentPane().add(btn_1);
		
		//button 2
		JButton btn_2 = new JButton("2");
		btn_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddToPassword("2");
				jpass_passfield.setText(GetPin());
				CheckPinLength(); // check the length of the pin SB
				if(CheckPinLength()) { 				// check the length of the pin SB if >= 5
					DisableKeypad(); //disable buttons
				}
			}
		});
		btn_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn_2.setBounds(128, 256, 89, 23);
		getFrame().getContentPane().add(btn_2);
		
		//button 3
		JButton btn_3 = new JButton("3");
		btn_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddToPassword("3");
				jpass_passfield.setText(GetPin());
				CheckPinLength(); // check the length of the pin SB
				if(CheckPinLength()) { 				// check the length of the pin SB if >= 5
					DisableKeypad(); //disable buttons
				}
			}
		});
		btn_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn_3.setBounds(229, 256, 89, 23);
		getFrame().getContentPane().add(btn_3);
		
		//button 4
		JButton btn_4 = new JButton("4");
		btn_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddToPassword("4");
				jpass_passfield.setText(GetPin());
				CheckPinLength(); // check the length of the pin SB
				if(CheckPinLength()) { 				// check the length of the pin SB if >= 5
					DisableKeypad(); //disable buttons
				}
			}
		});
		btn_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn_4.setBounds(22, 301, 89, 23);
		getFrame().getContentPane().add(btn_4);
		
		//button 5
		JButton btn_5 = new JButton("5");
		btn_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddToPassword("5");
				jpass_passfield.setText(GetPin());
				CheckPinLength(); // check the length of the pin SB
				if(CheckPinLength()) { 				// check the length of the pin SB if >= 5
					DisableKeypad(); //disable buttons
				}
			}
		});
		btn_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn_5.setBounds(128, 301, 89, 23);
		getFrame().getContentPane().add(btn_5);
		
		//button 6
		JButton btn_6 = new JButton("6");
		btn_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddToPassword("6");
				jpass_passfield.setText(GetPin());
				CheckPinLength(); // check the length of the pin SB
				if(CheckPinLength()) { 				// check the length of the pin SB if >= 5
					DisableKeypad(); //disable buttons
				}
			}
		});
		btn_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn_6.setBounds(229, 301, 89, 23);
		getFrame().getContentPane().add(btn_6);
		
		//button 7
		JButton btn_7 = new JButton("7");
		btn_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddToPassword("7");
				jpass_passfield.setText(GetPin());
				CheckPinLength(); // check the length of the pin SB
				if(CheckPinLength()) { 				// check the length of the pin SB if >= 5
					DisableKeypad(); //disable buttons
				}
			}
		});
		btn_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn_7.setBounds(22, 347, 89, 23);
		getFrame().getContentPane().add(btn_7);
		
		//button 8
		JButton btn_8 = new JButton("8");
		btn_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddToPassword("8");
				jpass_passfield.setText(GetPin());
				CheckPinLength(); // check the length of the pin SB
				if(CheckPinLength()) { 				// check the length of the pin SB if >= 5
					DisableKeypad(); //disable buttons
				}
			}
		});
		btn_8.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn_8.setBounds(128, 347, 89, 23);
		getFrame().getContentPane().add(btn_8);
		
		//button 9
		JButton btn_9 = new JButton("9");
		btn_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddToPassword("9");
				jpass_passfield.setText(GetPin());
				CheckPinLength(); // check the length of the pin SB
				if(CheckPinLength()) { 				// check the length of the pin SB if >= 5
					DisableKeypad(); //disable buttons
				}
			}
		});
		btn_9.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn_9.setBounds(229, 347, 89, 23);
		getFrame().getContentPane().add(btn_9);
		
		//button 0
		JButton btn_0 = new JButton("0");
		btn_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddToPassword("1");
				jpass_passfield.setText(GetPin());
				CheckPinLength(); // check the length of the pin SB
				if(CheckPinLength()) { 				// check the length of the pin SB if >= 5
					DisableKeypad(); //disable buttons
				}
			}
		});
		
		btn_0.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn_0.setBounds(128, 389, 89, 23);
		getFrame().getContentPane().add(btn_0);
		
		// cancel button
		JButton btn_cancel = new JButton("CANCEL");
		btn_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getFrame().dispose();
			}
		});
		
		btn_cancel.setBackground(new Color(255, 0, 0));
		btn_cancel.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn_cancel.setBounds(328, 256, 127, 23);
		getFrame().getContentPane().add(btn_cancel);

		// clear button
		JButton btn_clear = new JButton("CLEAR");
		btn_clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClearTempPin(); // clear our temporary pin
				jpass_passfield.setText(""); // clear the password field
				EnableKeypad();
			}
		});
		btn_clear.setBackground(Color.YELLOW);
		btn_clear.setForeground(Color.BLACK);
		btn_clear.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn_clear.setBounds(328, 301, 127, 23);
		getFrame().getContentPane().add(btn_clear);
		
		// enter button
		JButton btn_enter = new JButton("ENTER");
		btn_enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isPinValid()) {
					OptionsMenu frame2 = new OptionsMenu(frame);
					ClearTempPin(); // clear our temporary pin
					ClearPassField();
					EnableKeypad();
					frame2.setVisible(true);
					getFrame().dispose();
				}
			}
		});
		btn_enter.setBackground(Color.GREEN);
		btn_enter.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn_enter.setBounds(328, 347, 127, 23);
		getFrame().getContentPane().add(btn_enter);		
		
		JLabel lblNewLabel = new JLabel("Enter Pin");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel.setBounds(179, 79, 114, 23);
		getFrame().getContentPane().add(lblNewLabel);
		
		JLabel lblWelcomePlease = new JLabel("INVESCO ATM");
		lblWelcomePlease.setForeground(new Color(0, 128, 0));
		lblWelcomePlease.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblWelcomePlease.setBounds(144, 11, 189, 23);
		getFrame().getContentPane().add(lblWelcomePlease);
		
		//add buttons to our list
		AddBtnsToList(btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_0);
	}
	
	// method to instantiate list of accounts
	public static void InstantiateAccList(List<Account> x) {
		final Account a = new Account("Henry", "Ford", 10000, 12345);
		final Account b = new Account("Martha", "Stewart", 3454453, 22345);
		final Account c = new Account("Cletus", "Shines", 199, 32345);
		final Account d = new Account("Warren", "Scruffet", 28488, 42345);
		
		x.add(a);
		x.add(b);
		x.add(c);
		x.add(d);
		
	}
	
	//method to validate client PIN
	// if pin is correct return true
	// otherwise return false
	
	public boolean isPinValid() {
		for(Account y : listOfAccounts) { 
			if(y.getPin() == Integer.parseInt(GetPin())) {
				Account x = new Account();
				x = y;
				SetCurrentAccount(x);
				return true;
			}
		} 
		return false;
	}
	
	// Method for adding buttons to the list of buttons
	public static void AddBtnsToList(JButton a, JButton b, JButton c, JButton d, JButton e,
			JButton f, JButton g, JButton h, JButton i, JButton j) {
		btnList.add(a);
		btnList.add(b);
		btnList.add(c);
		btnList.add(d);
		btnList.add(e);
		btnList.add(f);
		btnList.add(g);
		btnList.add(h);
		btnList.add(i);
		btnList.add(j);
	}
	
	// method for adding string to the temporary pin string we will be comparing to
	
	public void AddToPassword(String x) {
		StringBuilder s = new StringBuilder(x);
		this.tempPin.append(s);
	}
	// gets the current pin string
	public String GetPin() {
		return this.tempPin.toString();
	}
	// clears the temporary pin placeholder
	public void ClearTempPin() {
		this.tempPin.setLength(0);
	}
	
	// checks to see if pin is at 5 characters
	public boolean CheckPinLength() {
		String temp = this.tempPin.toString();
		if (temp.length() == 5) {
			return true;
		}
		else { return false;}
	}
	
	//method to disable keypad if length is at 5
	public void DisableKeypad() {
		for(JButton y : btnList) {
			y.setEnabled(false);
		}
	}
		
		//method to Enable under a particular condition
		public void EnableKeypad() {
			for(JButton y : btnList) {
				y.setEnabled(true);
			}
	}
		//method to get the current account
		public static Account GetCurrentAccount() {
			return currentAccount;
		}
		
		//method to set the current account
		public void SetCurrentAccount(Account x) {
			ATM.currentAccount = x;
		}
		
		//method to return our original ATM screen
		public JFrame getFrame() {
			return frame;
		}

		public void setFrame(JFrame frame) {
			this.frame = frame;
		}

		
		public JPasswordField GetJPassField() {
			return this.jpass_passfield;
		}
		
		public void ClearPassField() {
			this.jpass_passfield.setText("");
		}

		public static CashDispenser getCashDispencer() {
			return cashDispencer;
		}

		public static void setCashDispencer(CashDispenser cashDispencer) {
			ATM.cashDispencer = cashDispencer;
		}

}
