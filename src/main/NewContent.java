package main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import db.DAO;
import db.dataDTO;

public class NewContent extends JFrame {

	private JPanel contentPane;
	private JTextField txtPhone;
	private JTextField txtRoadName;
	private JTextField txtName;
	private JTextField txtCleanName;
	private JTextField txtPostal;
	private JTextField txtBranchName;

	DAO dao = new DAO();
	dataDTO ddto = new dataDTO();

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
		txtName.setBounds(69, 31, 290, 21);
		contentPane.add(txtName);

		JButton btnExit = new JButton("\uCDE8\uC18C"); // 취소
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setBounds(278, 201, 81, 32);
		contentPane.add(btnExit);

		JLabel lblPw_1 = new JLabel("\uC6B0\uD3B8\uBC88\uD638");
		lblPw_1.setBounds(12, 112, 57, 15);
		contentPane.add(lblPw_1);

		JLabel lblEmail_1 = new JLabel("\uAD6C\uBD84");
		lblEmail_1.setBounds(210, 112, 57, 15);
		contentPane.add(lblEmail_1);

		JComboBox coboDivision = new JComboBox();
		coboDivision.setModel(new DefaultComboBoxModel(new String[] { "휴게음식점", "일반음식점", "상가", "오피스텔", "백화점", "대형마트",
				"종교집회장", "문화집회시설", "아파트", "학교", "지하철", "식품접객업" }));
		coboDivision.setBounds(248, 109, 111, 21);
		contentPane.add(coboDivision);

		JLabel lblEmail_2 = new JLabel("\uC18C\uB3C5\uC5C5\uCCB4");
		lblEmail_2.setBounds(12, 175, 57, 15);
		contentPane.add(lblEmail_2);

		txtCleanName = new JTextField();
		txtCleanName.setColumns(10);
		txtCleanName.setBounds(69, 170, 116, 21);
		contentPane.add(txtCleanName);

		txtPostal = new JTextField();
		txtPostal.setColumns(10);
		txtPostal.setBounds(69, 109, 116, 21);
		contentPane.add(txtPostal);

		JLabel lblNewLabel_1 = new JLabel("\uC2E0\uADDC \uCD94\uAC00");
		lblNewLabel_1.setBounds(12, 9, 68, 15);
		contentPane.add(lblNewLabel_1);

		txtBranchName = new JTextField();
		txtBranchName.setColumns(10);
		txtBranchName.setBounds(69, 81, 290, 21);
		contentPane.add(txtBranchName);

		JButton btnInputOK = new JButton("\uD655\uC778");
		btnInputOK.addActionListener(new ActionListener() { // 확인
			public void actionPerformed(ActionEvent e) {
				ddto.setcName(txtName.getText());
				ddto.setcRoadName(txtRoadName.getText());
				ddto.setcBranchName(txtBranchName.getText());
				ddto.setcPostal(txtPostal.getText());
				ddto.setcDivision((String) coboDivision.getSelectedItem());
				ddto.setcPhone(txtPhone.getText());
				ddto.setcCleanName(txtCleanName.getText());

				DAO dao = DAO.getInstance();
				int result = dao.insertData(ddto);
				if (result != 1) {
					JOptionPane.showMessageDialog(null, "입력 실패");
				} else {
					JOptionPane.showMessageDialog(null, "입력 성공");
					dispose();
				}
			}
		});
		btnInputOK.setBounds(193, 201, 81, 32);
		contentPane.add(btnInputOK);
	}
}
