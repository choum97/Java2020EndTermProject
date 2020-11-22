package java2020EndProject;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;

public class SetManage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetManage frame = new SetManage();
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
	public SetManage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 347, 332);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(81, 39, 61, 23);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("\uC0C1\uAC00");
		lblNewLabel.setBounds(12, 43, 57, 15);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\uCDE8\uC18C");
		btnNewButton.setBounds(247, 260, 69, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uD655\uC778");
		btnNewButton_1.setBounds(166, 260, 69, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("\uC624\uD53C\uC2A4\uD154");
		lblNewLabel_1.setBounds(12, 76, 57, 15);
		contentPane.add(lblNewLabel_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(81, 72, 61, 23);
		contentPane.add(comboBox_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uBC31\uD654\uC810");
		lblNewLabel_2.setBounds(12, 111, 57, 15);
		contentPane.add(lblNewLabel_2);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(81, 107, 61, 23);
		contentPane.add(comboBox_2);
		
		JLabel lblNewLabel_3 = new JLabel("\uB300\uD615\uB9C8\uD2B8");
		lblNewLabel_3.setBounds(12, 147, 57, 15);
		contentPane.add(lblNewLabel_3);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(81, 143, 61, 23);
		contentPane.add(comboBox_3);
		
		JLabel lblNewLabel_4 = new JLabel("\uC885\uAD50\uC9D1\uD68C\uC7A5");
		lblNewLabel_4.setBounds(12, 184, 77, 15);
		contentPane.add(lblNewLabel_4);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(81, 180, 61, 23);
		contentPane.add(comboBox_4);
		
		JLabel lblNewLabel_6 = new JLabel("\uBB38\uD654\uC9D1\uD68C\uC2DC\uC124");
		lblNewLabel_6.setBounds(166, 43, 85, 15);
		contentPane.add(lblNewLabel_6);
		
		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setBounds(249, 39, 61, 23);
		contentPane.add(comboBox_6);
		
		JLabel lblNewLabel_7 = new JLabel("\uC544\uD30C\uD2B8");
		lblNewLabel_7.setBounds(166, 76, 57, 15);
		contentPane.add(lblNewLabel_7);
		
		JComboBox comboBox_7 = new JComboBox();
		comboBox_7.setBounds(249, 72, 61, 23);
		contentPane.add(comboBox_7);
		
		JLabel lblNewLabel_8 = new JLabel("\uD559\uAD50");
		lblNewLabel_8.setBounds(166, 111, 57, 15);
		contentPane.add(lblNewLabel_8);
		
		JComboBox comboBox_8 = new JComboBox();
		comboBox_8.setBounds(249, 107, 61, 23);
		contentPane.add(comboBox_8);
		
		JLabel lblNewLabel_9 = new JLabel("\uC9C0\uD558\uCCA0");
		lblNewLabel_9.setBounds(166, 147, 57, 15);
		contentPane.add(lblNewLabel_9);
		
		JComboBox comboBox_9 = new JComboBox();
		comboBox_9.setBounds(249, 143, 61, 23);
		contentPane.add(comboBox_9);
		
		JComboBox comboBox_4_1 = new JComboBox();
		comboBox_4_1.setBounds(249, 180, 61, 23);
		contentPane.add(comboBox_4_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("\uD734\uAC8C\uC74C\uC2DD\uC810");
		lblNewLabel_4_1.setBounds(166, 184, 77, 15);
		contentPane.add(lblNewLabel_4_1);
		
		JComboBox comboBox_4_2 = new JComboBox();
		comboBox_4_2.setBounds(81, 215, 61, 23);
		contentPane.add(comboBox_4_2);
		
		JLabel lblNewLabel_4_2 = new JLabel("\uC2DD\uD488\uC811\uAC1D\uC5C5");
		lblNewLabel_4_2.setBounds(12, 219, 77, 15);
		contentPane.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("\uC77C\uBC18\uC74C\uC2DD\uC810");
		lblNewLabel_4_1_1.setBounds(166, 219, 77, 15);
		contentPane.add(lblNewLabel_4_1_1);
		
		JComboBox comboBox_4_1_1 = new JComboBox();
		comboBox_4_1_1.setBounds(249, 215, 61, 23);
		contentPane.add(comboBox_4_1_1);
		
		JLabel lblNewLabel_5 = new JLabel("\uAD00\uB9AC \uBA85\uB2E8 \uC124\uC815");
		lblNewLabel_5.setBounds(12, 10, 90, 15);
		contentPane.add(lblNewLabel_5);
	}
}
