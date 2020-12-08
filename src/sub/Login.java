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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java2020EndProject.WorkMain;
import sub.process.DAO;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtId, txtPw;

	DAO testDB = new DAO();


	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 285, 199);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewMember = new JButton("\uD68C\uC6D0\uAC00\uC785");
		btnNewMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Membership ms = new Membership(); // ȸ������ ȭ�� ����
				ms.setVisible(true);
			}
		});
		btnNewMember.setBounds(12, 123, 124, 29);
		contentPane.add(btnNewMember);

		JButton btnLogin = new JButton("\uB85C\uADF8\uC778");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtId.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "���̵� �Է����ּ���");
				} else if (txtPw.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "��й�ȣ�� �Է����ּ���");
				} else {
					String uid = txtId.getText();
					String password = txtPw.getText();
					DAO dao = DAO.getInstance();
					int result = dao.login(uid, password);
					if (result == 1) {
						JOptionPane.showMessageDialog(null, "�α��� ����");
						WorkMain wMain = new WorkMain(txtId.getText());
						wMain.setVisible(true);
						dispose();
					} else if (result == 0)
						JOptionPane.showMessageDialog(null, "��й�ȣ�� Ȯ�����ּ���");
					else if (result == -1) {
						JOptionPane.showMessageDialog(null, "���̵� �����ϴ�");
					}
				}
			}
		});

		btnLogin.setBounds(176, 51, 84, 29);
		contentPane.add(btnLogin);

		JLabel lblNewLabel = new JLabel("PW :");
		lblNewLabel.setBounds(12, 93, 57, 15);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("ID  :");
		lblNewLabel_1.setBounds(12, 58, 57, 15);
		contentPane.add(lblNewLabel_1);

		txtId = new JTextField();
		txtId.setBounds(53, 53, 111, 24);
		contentPane.add(txtId);

		txtPw = new JPasswordField();
		txtPw.setBounds(53, 89, 111, 24);
		contentPane.add(txtPw);

		JButton btnPwOK = new JButton("\uBE44\uBC00\uBC88\uD638 \uCC3E\uAE30");
		btnPwOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FindPw fw = new FindPw(); // ��й�ȣ ã�� ȭ�� ����
				fw.setVisible(true);
			}
		});
		btnPwOK.setBounds(137, 123, 124, 29);
		contentPane.add(btnPwOK);

		JButton btnOFF = new JButton("\uC885\uB8CC");
		btnOFF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnOFF.setBounds(176, 86, 84, 29);
		contentPane.add(btnOFF);

		JLabel lblNewLabel_2 = new JLabel("\uB85C\uADF8\uC778");
		lblNewLabel_2.setBounds(12, 10, 75, 33);
		contentPane.add(lblNewLabel_2);
	}
}
