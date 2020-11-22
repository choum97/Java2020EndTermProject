package sub;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import sub.process.DbConnect;

public class Membership extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtId;
	private JTextField txtEmail;
	private JPasswordField txtPw;
	static DbConnect testDB = new DbConnect();
	static int idCk = 0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {


		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Membership frame = new Membership();
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
	public Membership() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 227);
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
		btnNo.setBounds(196, 146, 81, 32);
		contentPane.add(btnNo);

		JButton btnOk = new JButton("\uD655\uC778");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtName.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "이름을 입력해주세요");
				} else if (txtId.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "아이디를 입력해주세요");
				} else if (txtPw.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "비밀번호를 입력해주세요");
				} else if (txtEmail.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "이메일을 입력해주세요");
				} else if (idCk != 1 )
					JOptionPane.showMessageDialog(null, "아이디 중복확인을 해주세요");
					
				else {
					String username = txtName.getText();
					String userid = txtId.getText();
					String password = txtPw.getText();
					String uemail = txtEmail.getText();
					testDB.insertData(username, userid, password, uemail);
					dispose();
				}
			}
		});
		btnOk.setBounds(103, 146, 81, 32);
		contentPane.add(btnOk);

		JLabel lblNewLabel = new JLabel("\uC131\uBA85 ");
		lblNewLabel.setBounds(12, 40, 57, 15);
		contentPane.add(lblNewLabel);

		JLabel lblPw = new JLabel("PW ");
		lblPw.setBounds(12, 90, 57, 15);
		contentPane.add(lblPw);

		JLabel lblId = new JLabel("ID ");
		lblId.setBounds(12, 65, 57, 15);
		contentPane.add(lblId);

		JLabel lblEmail = new JLabel("E-Mail");
		lblEmail.setBounds(12, 118, 57, 15);
		contentPane.add(lblEmail);

		txtName = new JTextField();
		txtName.setBounds(68, 37, 116, 21);
		contentPane.add(txtName);
		txtName.setColumns(10);

		txtId = new JTextField();
		txtId.setColumns(10);
		txtId.setBounds(68, 62, 116, 21);
		contentPane.add(txtId);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(68, 115, 116, 21);
		contentPane.add(txtEmail);

		txtPw = new JPasswordField();
		txtPw.setBounds(68, 87, 116, 21);
		contentPane.add(txtPw);

		JButton btnIdCheck = new JButton("\uC911\uBCF5\uD655\uC778");
		btnIdCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userid = txtId.getText();
				DbConnect dao = DbConnect.getInstance();
				int result = dao.idCheck(userid);
				if (result == 0)
					JOptionPane.showMessageDialog(null, "사용중인 ID입니다");
				if (result == 1) {
					btnIdCheck.setEnabled(false);
					JOptionPane.showMessageDialog(null, "사용 가능한 ID입니다");
					idCk = 1;
				}
			}
		});
		btnIdCheck.setBounds(196, 62, 81, 21);
		contentPane.add(btnIdCheck);

		JLabel lblNewLabel_1 = new JLabel("\uD68C\uC6D0\uAC00\uC785");
		lblNewLabel_1.setBounds(12, 10, 57, 15);
		contentPane.add(lblNewLabel_1);
	}
}
