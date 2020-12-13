package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import db.DAO;
import db.dataDTO;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class SetManage extends JFrame {

	private JPanel contentPane;
	private JTextField txt3;
	private JTextField txt4;
	private JTextField txt5;
	private JTextField txt6;
	private JTextField txt7;
	private JTextField txt12;
	private JTextField txt2;
	private JTextField txt1;
	private JTextField txt11;
	private JTextField txt10;
	private JTextField txt9;
	private JTextField txt8;
	DAO dao = new DAO();

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
		setBounds(100, 100, 449, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("\uC0C1\uAC00");
		lblNewLabel.setBounds(12, 43, 57, 15);
		contentPane.add(lblNewLabel);

		JButton btnExit = new JButton("\uCDE8\uC18C"); // 취소
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		btnExit.setBounds(308, 288, 69, 23);
		contentPane.add(btnExit);

		JButton btnOk = new JButton("\uD655\uC778"); // 확인
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (txt1.getText().trim().equals("") && txt2.getText().trim().equals("")
						&& txt3.getText().trim().equals("") && txt4.getText().trim().equals("")
						&& txt5.getText().trim().equals("") && txt6.getText().trim().equals("")
						&& txt7.getText().trim().equals("") && txt8.getText().trim().equals("")
						&& txt9.getText().trim().equals("") && txt10.getText().trim().equals("")
						&& txt11.getText().trim().equals("") && txt12.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "날짜를 입력해주세요 ");
				} else {
					dao.timeSet(1, txt1.getText());
					dao.timeSet(2, txt2.getText());
					dao.timeSet(3, txt3.getText());
					dao.timeSet(4, txt4.getText());
					dao.timeSet(5, txt5.getText());
					dao.timeSet(6, txt6.getText());
					dao.timeSet(7, txt7.getText());
					dao.timeSet(8, txt8.getText());
					dao.timeSet(9, txt9.getText());
					dao.timeSet(10, txt10.getText());
					dao.timeSet(11, txt11.getText());
					dao.timeSet(12, txt12.getText());
					
					
					
				}
			}
		});
		btnOk.setBounds(212, 288, 69, 23);
		contentPane.add(btnOk);

		JLabel lblNewLabel_1 = new JLabel("\uC624\uD53C\uC2A4\uD154");
		lblNewLabel_1.setBounds(12, 76, 57, 15);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\uBC31\uD654\uC810");
		lblNewLabel_2.setBounds(12, 111, 57, 15);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("\uB300\uD615\uB9C8\uD2B8");
		lblNewLabel_3.setBounds(12, 147, 57, 15);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("\uC885\uAD50\uC9D1\uD68C\uC7A5");
		lblNewLabel_4.setBounds(12, 184, 77, 15);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_6 = new JLabel("\uBB38\uD654\uC9D1\uD68C\uC2DC\uC124");
		lblNewLabel_6.setBounds(225, 43, 85, 15);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("\uC544\uD30C\uD2B8");
		lblNewLabel_7.setBounds(225, 76, 57, 15);
		contentPane.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("\uD559\uAD50");
		lblNewLabel_8.setBounds(225, 111, 57, 15);
		contentPane.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("\uC9C0\uD558\uCCA0");
		lblNewLabel_9.setBounds(225, 147, 57, 15);
		contentPane.add(lblNewLabel_9);

		JLabel lblNewLabel_4_1 = new JLabel("\uD734\uAC8C\uC74C\uC2DD\uC810");
		lblNewLabel_4_1.setBounds(225, 184, 77, 15);
		contentPane.add(lblNewLabel_4_1);

		JLabel lblNewLabel_4_2 = new JLabel("\uC2DD\uD488\uC811\uAC1D\uC5C5");
		lblNewLabel_4_2.setBounds(12, 219, 77, 15);
		contentPane.add(lblNewLabel_4_2);

		JLabel lblNewLabel_4_1_1 = new JLabel("\uC77C\uBC18\uC74C\uC2DD\uC810");
		lblNewLabel_4_1_1.setBounds(225, 219, 77, 15);
		contentPane.add(lblNewLabel_4_1_1);

		JLabel lblNewLabel_5 = new JLabel("\uAD00\uB9AC \uBA85\uB2E8 \uC124\uC815");
		lblNewLabel_5.setBounds(12, 10, 90, 15);
		contentPane.add(lblNewLabel_5);

		txt3 = new JTextField();
		txt3.setBounds(92, 40, 108, 21);
		contentPane.add(txt3);
		txt3.setColumns(10);

		txt4 = new JTextField();
		txt4.setColumns(10);
		txt4.setBounds(92, 73, 108, 21);
		contentPane.add(txt4);

		txt5 = new JTextField();
		txt5.setColumns(10);
		txt5.setBounds(92, 108, 108, 21);
		contentPane.add(txt5);

		txt6 = new JTextField();
		txt6.setColumns(10);
		txt6.setBounds(92, 144, 108, 21);
		contentPane.add(txt6);

		txt7 = new JTextField();
		txt7.setColumns(10);
		txt7.setBounds(92, 181, 108, 21);
		contentPane.add(txt7);

		txt12 = new JTextField();
		txt12.setColumns(10);
		txt12.setBounds(92, 216, 108, 21);
		contentPane.add(txt12);

		txt2 = new JTextField();
		txt2.setColumns(10);
		txt2.setBounds(306, 216, 115, 21);
		contentPane.add(txt2);
		
		txt1 = new JTextField();
		txt1.setColumns(10);
		txt1.setBounds(306, 181, 115, 21);
		contentPane.add(txt1);

		txt11 = new JTextField();
		txt11.setColumns(10);
		txt11.setBounds(306, 144, 115, 21);

		contentPane.add(txt11);

		txt10 = new JTextField();
		txt10.setColumns(10);
		txt10.setBounds(306, 108, 115, 21);
		contentPane.add(txt10);

		txt9 = new JTextField();
		txt9.setColumns(10);
		txt9.setBounds(306, 73, 115, 21);
		contentPane.add(txt9);
		
		txt8 = new JTextField();
		txt8.setColumns(10);
		txt8.setBounds(306, 40, 115, 21);
		contentPane.add(txt8);
		
		txt1.setText(dao.timeShow("1"));
		txt2.setText(dao.timeShow("2"));
		txt3.setText(dao.timeShow("3"));
		txt4.setText(dao.timeShow("4"));
		txt5.setText(dao.timeShow("5"));
		txt6.setText(dao.timeShow("6"));
		txt7.setText(dao.timeShow("7"));
		txt8.setText(dao.timeShow("8"));
		txt9.setText(dao.timeShow("9"));
		txt10.setText(dao.timeShow("10"));
		txt11.setText(dao.timeShow("11"));
		txt12.setText(dao.timeShow("12"));
		
		//txt3.setText(dao.timeShow(3));
		
	}

}
