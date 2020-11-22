package java2020EndProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class NewRecord extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField_1;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewRecord frame = new NewRecord();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NewRecord() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 387, 286);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(69, 137, 116, 21);
		contentPane.add(textField);
		
		JLabel lblEmail = new JLabel("\uC5F0\uB77D\uCC98");
		lblEmail.setBounds(12, 140, 57, 15);
		contentPane.add(lblEmail);
		
		JLabel lblPw = new JLabel("\uC9C0\uBC88\uC8FC\uC18C");
		lblPw.setBounds(12, 84, 57, 15);
		contentPane.add(lblPw);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(69, 81, 290, 21);
		contentPane.add(passwordField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(69, 56, 290, 21);
		contentPane.add(textField_1);
		
		JLabel lblId = new JLabel("\uB3C4\uB85C\uBA85");
		lblId.setBounds(12, 59, 68, 15);
		contentPane.add(lblId);
		
		JLabel lblNewLabel = new JLabel("\uC0C1\uD638");
		lblNewLabel.setBounds(12, 34, 57, 15);
		contentPane.add(lblNewLabel);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(69, 31, 116, 21);
		contentPane.add(textField_2);
		
		JButton btnNewButton_1 = new JButton("\uD655\uC778");
		btnNewButton_1.setBounds(193, 201, 81, 32);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("\uCDE8\uC18C");
		btnNewButton.setBounds(278, 201, 81, 32);
		contentPane.add(btnNewButton);
		
		JLabel lblPw_1 = new JLabel("\uC6B0\uD3B8\uBC88\uD638");
		lblPw_1.setBounds(12, 112, 57, 15);
		contentPane.add(lblPw_1);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(69, 110, 97, 21);
		contentPane.add(passwordField_1);
		
		JLabel lblEmail_1 = new JLabel("\uAD6C\uBD84");
		lblEmail_1.setBounds(207, 112, 57, 15);
		contentPane.add(lblEmail_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\uD734\uAC8C\uC74C\uC2DD\uC810", "\uC77C\uBC18\uC74C\uC2DD\uC810", "\uC0C1\uAC00", "\uC624\uD53C\uC2A4\uD154", "\uBC31\uD654\uC810", "\uB300\uD615\uB9C8\uD2B8", "\uC885\uAD50\uC9D1\uD68C\uC7A5", "\uBB38\uD654\uC9D1\uD68C\uC2DC\uC124", "\uC544\uD30C\uD2B8", "\uD559\uAD50", "\uC9C0\uD558\uCCA0", "\uC2DD\uD488\uC811\uAC1D\uC5C5"}));
		comboBox.setBounds(248, 109, 111, 21);
		contentPane.add(comboBox);
		
		JLabel lblEmail_2 = new JLabel("\uC18C\uB3C5\uC5C5\uCCB4");
		lblEmail_2.setBounds(12, 175, 57, 15);
		contentPane.add(lblEmail_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(69, 170, 290, 21);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(248, 137, 111, 21);
		contentPane.add(textField_4);
		
		JLabel lblEmail_3 = new JLabel("\uC5F0\uB77D\uCC982");
		lblEmail_3.setBounds(193, 138, 57, 15);
		contentPane.add(lblEmail_3);
		
		JLabel lblNewLabel_1 = new JLabel("\uC2E0\uADDC \uCD94\uAC00");
		lblNewLabel_1.setBounds(12, 9, 68, 15);
		contentPane.add(lblNewLabel_1);
	}
}
