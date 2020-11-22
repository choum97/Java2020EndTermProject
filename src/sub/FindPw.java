package sub;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import sub.process.DbConnect;
import sub.process.MemberDAO;

public class FindPw extends JFrame {

	private JPanel contentPane;
	private JTextField txtEmail;
	private JTextField txtId;
	private JTextField txtName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		DbConnect testDB = new DbConnect();
		testDB.openCon(); // DB연결

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FindPw frame = new FindPw();
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
	public FindPw() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 231, 205);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNo = new JButton("\uCDE8\uC18C");
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNo.setBounds(115, 128, 81, 32);
		contentPane.add(btnNo);

		JButton btnOk = new JButton("\uD655\uC778");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtName.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "이름을 입력해주세요");
				} else if (txtId.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "아이디를 입력해주세요");
				} else if (txtEmail.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "이메일을 입력해주세요");
				} else {
					String username = txtName.getText();
					String userid = txtId.getText();
					String uemail = txtEmail.getText();
					DbConnect dao = DbConnect.getInstance();
					String result = dao.findUserPassword(username, userid, uemail);
					if (result != null) {
						JOptionPane.showMessageDialog(null, "비밀번호는 : " + result);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "가입하신 회원이 아닙니다.");
					}

				}
			}
		});
		btnOk.setBounds(22, 128, 81, 32);
		contentPane.add(btnOk);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(68, 97, 116, 21);
		contentPane.add(txtEmail);

		JLabel lblEmail = new JLabel("E-Mail");
		lblEmail.setBounds(12, 100, 57, 15);
		contentPane.add(lblEmail);

		txtId = new JTextField();
		txtId.setColumns(10);
		txtId.setBounds(68, 66, 116, 21);
		contentPane.add(txtId);

		JLabel lblId = new JLabel("ID ");
		lblId.setBounds(12, 69, 57, 15);
		contentPane.add(lblId);

		JLabel lblNewLabel = new JLabel("\uC131\uBA85 ");
		lblNewLabel.setBounds(12, 44, 57, 15);
		contentPane.add(lblNewLabel);

		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(68, 41, 116, 21);
		contentPane.add(txtName);

		JLabel lblNewLabel_1 = new JLabel("\uBE44\uBC00\uBC88\uD638 \uCC3E\uAE30");
		lblNewLabel_1.setBounds(22, 10, 104, 21);
		contentPane.add(lblNewLabel_1);
	}
}
