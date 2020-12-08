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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewContent extends JFrame {

	private JPanel contentPane;
	private JTextField txtPhone;
	private JTextField txtRoadName;
	private JTextField txtName;
	private JTextField txtCleanName;
	private JTextField txtPostal;
	private JTextField txtBranchName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewContent frame = new NewContent();
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
	public NewContent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 387, 286);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		txtPhone.setBounds(69, 137, 116, 21);
		contentPane.add(txtPhone);
		
		JLabel lblEmail = new JLabel("\uC5F0\uB77D\uCC98");
		lblEmail.setBounds(12, 140, 57, 15);
		contentPane.add(lblEmail);
		
		JLabel lblPw = new JLabel("\uC9C0\uBC88\uC8FC\uC18C");
		lblPw.setBounds(12, 84, 57, 15);
		contentPane.add(lblPw);
		
		txtRoadName = new JTextField();
		txtRoadName.setColumns(10);
		txtRoadName.setBounds(69, 56, 290, 21);
		contentPane.add(txtRoadName);
		
		JLabel lblId = new JLabel("\uB3C4\uB85C\uBA85");
		lblId.setBounds(12, 59, 68, 15);
		contentPane.add(lblId);
		
		JLabel lblNewLabel = new JLabel("\uC774\uB984");
		lblNewLabel.setBounds(12, 34, 57, 15);
		contentPane.add(lblNewLabel);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(69, 31, 116, 21);
		contentPane.add(txtName);
		
		JButton btnInputOK = new JButton("\uD655\uC778");
		btnInputOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnInputOK.setBounds(193, 201, 81, 32);
		contentPane.add(btnInputOK);
		
		JButton btnExit = new JButton("\uCDE8\uC18C");
		btnExit.setBounds(278, 201, 81, 32);
		contentPane.add(btnExit);
		
		JLabel lblPw_1 = new JLabel("\uC6B0\uD3B8\uBC88\uD638");
		lblPw_1.setBounds(12, 112, 57, 15);
		contentPane.add(lblPw_1);
		
		JLabel lblEmail_1 = new JLabel("\uAD6C\uBD84");
		lblEmail_1.setBounds(197, 34, 57, 15);
		contentPane.add(lblEmail_1);
		
		JComboBox coboDivision = new JComboBox();
		coboDivision.setModel(new DefaultComboBoxModel(new String[] {"\uD734\uAC8C\uC74C\uC2DD\uC810", "\uC77C\uBC18\uC74C\uC2DD\uC810", "\uC0C1\uAC00", "\uC624\uD53C\uC2A4\uD154", "\uBC31\uD654\uC810", "\uB300\uD615\uB9C8\uD2B8", "\uC885\uAD50\uC9D1\uD68C\uC7A5", "\uBB38\uD654\uC9D1\uD68C\uC2DC\uC124", "\uC544\uD30C\uD2B8", "\uD559\uAD50", "\uC9C0\uD558\uCCA0", "\uC2DD\uD488\uC811\uAC1D\uC5C5"}));
		coboDivision.setBounds(248, 31, 111, 21);
		contentPane.add(coboDivision);
		
		JLabel lblEmail_2 = new JLabel("\uC18C\uB3C5\uC5C5\uCCB4");
		lblEmail_2.setBounds(12, 175, 57, 15);
		contentPane.add(lblEmail_2);
		
		txtCleanName = new JTextField();
		txtCleanName.setColumns(10);
		txtCleanName.setBounds(69, 170, 130, 21);
		contentPane.add(txtCleanName);
		
		txtPostal = new JTextField();
		txtPostal.setColumns(10);
		txtPostal.setBounds(69, 109, 111, 21);
		contentPane.add(txtPostal);
		
		JLabel lblNewLabel_1 = new JLabel("\uC2E0\uADDC \uCD94\uAC00");
		lblNewLabel_1.setBounds(12, 9, 68, 15);
		contentPane.add(lblNewLabel_1);
		
		txtBranchName = new JTextField();
		txtBranchName.setColumns(10);
		txtBranchName.setBounds(69, 81, 290, 21);
		contentPane.add(txtBranchName);
	}
}
