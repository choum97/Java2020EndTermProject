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

public class ChangeContent extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangeContent frame = new ChangeContent();
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
	public ChangeContent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 380, 277);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBounds(0, 0, 371, 247);
		contentPane.add(contentPane_1);
		
		JLabel lblNewLabel_1 = new JLabel("\uC815\uBCF4 \uC218\uC815");
		lblNewLabel_1.setBounds(12, 9, 68, 15);
		contentPane_1.add(lblNewLabel_1);
		
		JButton btnExit = new JButton("\uCDE8\uC18C");
		btnExit.setBounds(278, 205, 81, 32);
		contentPane_1.add(btnExit);
		
		JButton btnInputOK = new JButton("\uD655\uC778");
		btnInputOK.setBounds(193, 205, 81, 32);
		contentPane_1.add(btnInputOK);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(69, 174, 130, 21);
		contentPane_1.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(69, 141, 116, 21);
		contentPane_1.add(textField_1);
		
		JLabel lblEmail = new JLabel("\uC5F0\uB77D\uCC98");
		lblEmail.setBounds(12, 144, 57, 15);
		contentPane_1.add(lblEmail);
		
		JLabel lblEmail_2 = new JLabel("\uC18C\uB3C5\uC5C5\uCCB4");
		lblEmail_2.setBounds(12, 179, 57, 15);
		contentPane_1.add(lblEmail_2);
		
		JLabel lblPw_1 = new JLabel("\uC6B0\uD3B8\uBC88\uD638");
		lblPw_1.setBounds(12, 116, 57, 15);
		contentPane_1.add(lblPw_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(69, 113, 111, 21);
		contentPane_1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(69, 85, 290, 21);
		contentPane_1.add(textField_3);
		
		JLabel lblPw = new JLabel("\uC9C0\uBC88\uC8FC\uC18C");
		lblPw.setBounds(12, 88, 57, 15);
		contentPane_1.add(lblPw);
		
		JLabel lblId = new JLabel("\uB3C4\uB85C\uBA85");
		lblId.setBounds(12, 63, 68, 15);
		contentPane_1.add(lblId);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(69, 60, 290, 21);
		contentPane_1.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(69, 35, 116, 21);
		contentPane_1.add(textField_5);
		
		JLabel lblNewLabel = new JLabel("\uC774\uB984");
		lblNewLabel.setBounds(12, 38, 57, 15);
		contentPane_1.add(lblNewLabel);
		
		JLabel lblEmail_1 = new JLabel("\uAD6C\uBD84");
		lblEmail_1.setBounds(197, 38, 57, 15);
		contentPane_1.add(lblEmail_1);
		
		JComboBox coboDivision = new JComboBox();
		coboDivision.setBounds(248, 35, 111, 21);
		contentPane_1.add(coboDivision);
	}
}
