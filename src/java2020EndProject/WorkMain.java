package java2020EndProject;

import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.omg.CORBA.PUBLIC_MEMBER;

import sub.Login;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WorkMain extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WorkMain frame = new WorkMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @return 
	 */
	public WorkMain(String userName) {
		String uName = userName; 
	}
	public WorkMain() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1156, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLogOut = new JButton("\uB85C\uADF8\uC544\uC6C3");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login log = new Login();
				JOptionPane.showMessageDialog(null, "로그아웃 되었습니다.");
				log.setVisible(true);
				dispose();
			}
		});
		btnLogOut.setBounds(1033, 20, 95, 23);
		contentPane.add(btnLogOut);
		
		JLabel lbluserName = new JLabel("\uAE40\uC694\uD55C\uB2D8");
		lbluserName.setBounds(964, 24, 57, 15);
		lbluserName.setText(getName());
		contentPane.add(lbluserName);
		
		
		JLabel lblNewLabel_1 = new JLabel("\uC0AC\uC6A9\uC790 :");
		lblNewLabel_1.setBounds(906, 24, 57, 15);
		contentPane.add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\uC8FC\uC18C\uB85C \uAC80\uC0C9", "\uC0C1\uD638\uB85C \uAC80\uC0C9"}));
		comboBox.setBounds(37, 21, 109, 23);
		contentPane.add(comboBox);
		
		JButton btnNewButton_1 = new JButton("\uAC80\uC0C9");
		btnNewButton_1.setBounds(551, 20, 63, 23);
		contentPane.add(btnNewButton_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(161, 20, 378, 24);
		contentPane.add(textArea);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(37, 132, 1091, 246);
		contentPane.add(tabbedPane);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("\uAC80\uC0C9", null, tabbedPane_1, null);
		
		JTabbedPane tabbedPane_3 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("1\uBD84\uAE30", null, tabbedPane_3, null);
		
		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("2\uBD84\uAE30", null, tabbedPane_2, null);
		
		JTabbedPane tabbedPane_4 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("3\uBD84\uAE30", null, tabbedPane_4, null);
		
		JTabbedPane tabbedPane_5 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("4\uBD84\uAE30", null, tabbedPane_5, null);
		
		JTabbedPane tabbedPane_5_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("\uAD00\uB9AC\uBA85\uB2E8", null, tabbedPane_5_1, null);
		
		JButton btnNewButton_1_2 = new JButton("\uC2E0\uADDC");
		btnNewButton_1_2.setBounds(841, 400, 63, 23);
		contentPane.add(btnNewButton_1_2);
		
		JButton btnNewButton_1_3 = new JButton("\uC0AD\uC81C");
		btnNewButton_1_3.setBounds(916, 400, 63, 23);
		contentPane.add(btnNewButton_1_3);
		
		JButton btnNewButton_1_4 = new JButton("\uC785\uB825");
		btnNewButton_1_4.setBounds(790, 86, 69, 23);
		contentPane.add(btnNewButton_1_4);
		
		JButton btnNewButton_1_5 = new JButton("\uC885\uB8CC");
		btnNewButton_1_5.setBounds(1065, 400, 63, 23);
		contentPane.add(btnNewButton_1_5);
		
		JButton btnNewButton_1_3_1 = new JButton("\uC218\uC815");
		btnNewButton_1_3_1.setBounds(990, 400, 63, 23);
		contentPane.add(btnNewButton_1_3_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uB9C8\uD3EC\uAD6C \uC6D4\uB4DC\uCEF5\uB85C 120 1\uCE35");
		lblNewLabel_2.setBounds(196, 90, 164, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("7\uBC88\uAC00 \uD53C\uC790 \uC11C\uAD50\uB9DD\uC6D0\uC810");
		lblNewLabel_2_1.setBounds(47, 90, 152, 15);
		contentPane.add(lblNewLabel_2_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1\uC6D4", "2\uC6D4", "3\uC6D4", "4\uC6D4", "5\uC6D4", "6\uC6D4", "7\uC6D4", "8\uC6D4", "9\uC6D4", "10\uC6D4", "11\uC6D4", "12\uC6D4"}));
		comboBox_1.setBounds(552, 86, 85, 23);
		contentPane.add(comboBox_1);
		
		textField = new JTextField();
		textField.setText("22");
		textField.setBounds(671, 88, 69, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\uC77C");
		lblNewLabel_3.setBounds(752, 94, 26, 15);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2_2 = new JLabel("\uB9C8\uD3EC\uAD6C \uC6D4\uB4DC\uCEF5\uB85C 120 1\uCE35");
		lblNewLabel_2_2.setBounds(372, 90, 152, 15);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_4 = new JLabel("\uC0C1\uD638");
		lblNewLabel_4.setBounds(37, 65, 57, 23);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("\uC9C0\uBC88 \uC8FC\uC18C");
		lblNewLabel_4_1.setBounds(362, 65, 85, 23);
		contentPane.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("\uB3C4\uB85C\uBA85 \uC8FC\uC18C");
		lblNewLabel_4_2.setBounds(187, 65, 95, 23);
		contentPane.add(lblNewLabel_4_2);
		
		JButton btnNewButton_2 = new JButton("\uC791\uC5C5\uB0B4\uC5ED");
		btnNewButton_2.setBounds(1033, 53, 95, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("\uAD00\uB9AC\uC124\uC815");
		btnNewButton_2_1.setBounds(1033, 86, 95, 23);
		contentPane.add(btnNewButton_2_1);
	}
}
