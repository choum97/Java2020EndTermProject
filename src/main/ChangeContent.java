package main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.xml.crypto.Data;

import db.DAO;
import db.dataDTO;

public class ChangeContent extends JFrame {

	private JPanel contentPane;
	private JTextField txtCleanName;
	private JTextField txtPhone;
	private JTextField txtPostal;
	private JTextField txtBranchName;
	private JTextField txtRoadName;
	private JTextField txtName;
	
	DAO dao = new DAO();
	dataDTO ddto = new dataDTO();
	private JTextField txtCleanDay;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangeContent frame = new ChangeContent(0,"1", "2", "3","4", "5", "6", "7", "8");
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
	public ChangeContent(int num,String cName,String rName,String bName, String postal, String division, String phone, String cleanName, String cleanDay) {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 387, 288);
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
		btnExit.addActionListener(new ActionListener() {  // 취소
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setBounds(285, 205, 69, 32);
		contentPane_1.add(btnExit);
		
		
		txtCleanName = new JTextField();
		txtCleanName.setColumns(10);
		txtCleanName.setBounds(69, 174, 116, 21);
		contentPane_1.add(txtCleanName);
		
		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		txtPhone.setBounds(69, 141, 116, 21);
		contentPane_1.add(txtPhone);
		
		JLabel lblEmail = new JLabel("\uC5F0\uB77D\uCC98");
		lblEmail.setBounds(12, 144, 57, 15);
		contentPane_1.add(lblEmail);
		
		JLabel lblEmail_2 = new JLabel("\uC18C\uB3C5 \uC5C5\uCCB4");
		lblEmail_2.setBounds(12, 179, 57, 15);
		contentPane_1.add(lblEmail_2);
		
		JLabel lblPw_1 = new JLabel("\uC6B0\uD3B8\uBC88\uD638");
		lblPw_1.setBounds(12, 116, 57, 15);
		contentPane_1.add(lblPw_1);
		
		txtPostal = new JTextField();
		txtPostal.setColumns(10);
		txtPostal.setBounds(69, 113, 116, 21);
		contentPane_1.add(txtPostal);
		
		txtBranchName = new JTextField();
		txtBranchName.setColumns(10);
		txtBranchName.setBounds(69, 85, 285, 21);
		contentPane_1.add(txtBranchName);
		
		JLabel lblPw = new JLabel("\uC9C0\uBC88\uC8FC\uC18C");
		lblPw.setBounds(12, 88, 57, 15);
		contentPane_1.add(lblPw);
		
		JLabel lblId = new JLabel("\uB3C4\uB85C\uBA85");
		lblId.setBounds(12, 63, 68, 15);
		contentPane_1.add(lblId);
		
		txtRoadName = new JTextField();
		txtRoadName.setColumns(10);
		txtRoadName.setBounds(69, 60, 285, 21);
		contentPane_1.add(txtRoadName);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(69, 35, 285, 21);
		contentPane_1.add(txtName);
		
		JLabel lblNewLabel = new JLabel("\uC774\uB984");
		lblNewLabel.setBounds(12, 38, 57, 15);
		contentPane_1.add(lblNewLabel);
		
		JLabel lblEmail_1 = new JLabel("\uAD6C\uBD84");
		lblEmail_1.setBounds(209, 116, 57, 15);
		contentPane_1.add(lblEmail_1);
		
		JComboBox coboDivision = new JComboBox();
		coboDivision.setModel(new DefaultComboBoxModel(new String[] { "휴게음식점", "일반음식점", "상가", "오피스텔", "백화점", "대형마트",
				"종교집회장", "문화집회시설", "아파트", "학교", "지하철", "식품접객업" }));
		coboDivision.setBounds(243, 113, 111, 21);
		contentPane_1.add(coboDivision);

		txtCleanDay = new JTextField();
		txtCleanDay.setColumns(10);
		txtCleanDay.setBounds(69, 211, 116, 21);
		contentPane_1.add(txtCleanDay);

		
		txtName.setText(cName);
		txtRoadName.setText(rName);
		txtBranchName.setText(bName);
		txtPostal.setText(postal);
		coboDivision.setSelectedItem(division);
		txtPhone.setText(phone);
		txtCleanName.setText(cleanName);
		txtCleanDay.setText(cleanDay);
		
		JButton btnInputOK = new JButton("\uD655\uC778");
		btnInputOK.addActionListener(new ActionListener() {  //수정
			public void actionPerformed(ActionEvent e) {
				
				ddto.setcNum(num);
				ddto.setcName(txtName.getText());
				ddto.setcRoadName(txtRoadName.getText());
				ddto.setcBranchName(txtBranchName.getText());
				ddto.setcPostal(txtPostal.getText());
				ddto.setcDivision((String) coboDivision.getSelectedItem());
				ddto.setcPhone(txtPhone.getText());
				ddto.setcCleanName(txtCleanName.getText());
				ddto.setcCleanDay(txtCleanDay.getText());
				
				
				DAO dao = DAO.getInstance();
				int result = dao.chagetData(ddto);
				if (result != 1) {
					JOptionPane.showMessageDialog(null, "수정 실패");
				} else {
					JOptionPane.showMessageDialog(null, "데이터 수정 성공");
					dispose();
				}
			}
		});
		btnInputOK.setBounds(204, 205, 69, 32);
		contentPane_1.add(btnInputOK);
		
		JLabel lblEmail_2_1 = new JLabel("\uC18C\uB3C5 \uB0A0\uC9DC");
		lblEmail_2_1.setBounds(12, 214, 57, 15);
		contentPane_1.add(lblEmail_2_1);
		
		
	}
}
