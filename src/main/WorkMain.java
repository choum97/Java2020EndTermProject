package main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import db.DAO;
import sub.Login;

public class WorkMain extends JFrame {
	DAO dao = new DAO();
	private JPanel contentPane;
	private JTextField txtDay;

	private Vector v; // ���̺� ������
	private Vector cols;
	DefaultTableModel model; // ���̺� �� ��
	private JScrollPane jscp1, jscp2;
	private JTable jtable, jtable2;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WorkMain frame = new WorkMain(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void jTableRefresh() {
		DefaultTableModel model = new DefaultTableModel(dao.showAllTable(), dao.getColimn());
		jtable.setModel(model);
	}

	public WorkMain(String userId) {

		v = dao.showAllTable();
		cols = dao.getColimn();
		model = new DefaultTableModel(v, cols);

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
				JOptionPane.showMessageDialog(null, "�α׾ƿ� �Ǿ����ϴ�.");
				log.setVisible(true);
				dispose();
			}
		});

		btnLogOut.setBounds(1033, 20, 95, 23);
		contentPane.add(btnLogOut);

		JLabel lbluserName = new JLabel("\uAE40\uC694\uD55C\uB2D8");
		lbluserName.setBounds(964, 24, 57, 15);
		lbluserName.setText(userId);
		contentPane.add(lbluserName);

		JLabel lblNewLabel_1 = new JLabel("\uC0AC\uC6A9\uC790 :");
		lblNewLabel_1.setBounds(906, 24, 57, 15);
		contentPane.add(lblNewLabel_1);

		JComboBox coboxSearchCondition = new JComboBox();
		coboxSearchCondition.setModel(new DefaultComboBoxModel(new String[] { "\uC774\uB984\uC73C\uB85C \uAC80\uC0C9",
				"\uC804\uCCB4 \uAC80\uC0C9", "\uB3C4\uB85C\uBA85\uC8FC\uC18C\uB85C \uAC80\uC0C9",
				"\uC9C0\uBC88\uC8FC\uC18C\uB85C \uAC80\uC0C9" }));
		coboxSearchCondition.setBounds(37, 21, 109, 23);
		contentPane.add(coboxSearchCondition);

		JTextArea txtSearch = new JTextArea();
		txtSearch.setBounds(161, 20, 378, 24);
		contentPane.add(txtSearch);

		JButton btnNewContents = new JButton("\uC2E0\uADDC");
		btnNewContents.addActionListener(new ActionListener() { // �ű�
			public void actionPerformed(ActionEvent e) {
				NewContent nContent = new NewContent();
				nContent.setVisible(true);
			}
		});
		btnNewContents.setBounds(841, 400, 63, 23);
		contentPane.add(btnNewContents);

		JButton btnDeleteContents = new JButton("\uC0AD\uC81C");
		btnDeleteContents.addActionListener(new ActionListener() { // ����
			public void actionPerformed(ActionEvent e) {
				int row = jtable.getSelectedRow();
				if (row < 0)
					return;
				int cNum = (Integer) jtable.getValueAt(row, 0);

				dao.mainDel(cNum);
				jTableRefresh();
			}
		});
		btnDeleteContents.setBounds(916, 400, 63, 23);
		contentPane.add(btnDeleteContents);

		JButton btnInputContent = new JButton("\uC785\uB825");
		btnInputContent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnInputContent.setBounds(790, 86, 69, 23);
		contentPane.add(btnInputContent);

		JButton btnExit = new JButton("\uC885\uB8CC");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(1065, 400, 63, 23);
		contentPane.add(btnExit);

		JButton btnSearch = new JButton("\uAC80\uC0C9");
		btnSearch.addActionListener(new ActionListener() { // �˻�
			public void actionPerformed(ActionEvent e) {
				String fieldName = coboxSearchCondition.getSelectedItem().toString();
				if (fieldName.trim().equals("��ü �˻�")) {// ��ü�˻�
					dao.seachWord(model, null, txtSearch.getText(), 1);
					txtSearch.requestFocus();
				}
				if (txtSearch.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "�˻��� �ܾ �Է����ּ���");
					txtSearch.requestFocus();
				}
				if (fieldName.trim().equals("�̸����� �˻�")) {// �˻�� �Է��������
					String sch = "cName";
					dao.seachWord(model, sch, txtSearch.getText(), 1); // ���̺�, �˻�����, �˻��� �ܾ�, ���� ���� ���� ��(���ο���)
				}
				if (fieldName.trim().equals("���θ��ּҷ� �˻�")) {
					String sch = "cRoadName";
					dao.seachWord(model, sch, txtSearch.getText(), 1);
				}
				if (fieldName.trim().equals("�����ּҷ� �˻�")) {
					String sch = "cBranchName";
					dao.seachWord(model, sch, txtSearch.getText(), 1);
				}
			}
		});
		btnSearch.setBounds(551, 20, 63, 23);
		contentPane.add(btnSearch);

		JButton btnChangeContents = new JButton("\uC218\uC815");
		btnChangeContents.addActionListener(new ActionListener() { // ����
			public void actionPerformed(ActionEvent e) {

				int row = jtable.getSelectedRow();
				if (row < 0)
					return;
				int num = (int) jtable.getValueAt(row, 0);
				String name = (String) jtable.getValueAt(row, 1);
				String roadName = (String) jtable.getValueAt(row, 2);
				String branchName = (String) jtable.getValueAt(row, 3);
				String postal = (String) jtable.getValueAt(row, 4);
				String division = (String) jtable.getValueAt(row, 5);
				String phone = (String) jtable.getValueAt(row, 6);
				String cleanname = (String) jtable.getValueAt(row, 7);
				String cleanday = (String) jtable.getValueAt(row, 8);

				ChangeContent chagecontent = new ChangeContent(num, name, roadName, branchName, postal, division, phone,
						cleanname, cleanday);
				chagecontent.setVisible(true);
			}
		});
		btnChangeContents.setBounds(990, 400, 63, 23);
		contentPane.add(btnChangeContents);

		JLabel lblRoadNameAddress = new JLabel("\uB9C8\uD3EC\uAD6C \uC6D4\uB4DC\uCEF5\uB85C 120 1\uCE35");
		lblRoadNameAddress.setBounds(196, 90, 164, 15);
		contentPane.add(lblRoadNameAddress);

		JLabel lblDisinfectionTarget = new JLabel("7\uBC88\uAC00 \uD53C\uC790 \uC11C\uAD50\uB9DD\uC6D0\uC810");
		lblDisinfectionTarget.setBounds(47, 90, 152, 15);
		contentPane.add(lblDisinfectionTarget);

		JComboBox coboxMonth = new JComboBox();
		coboxMonth.setModel(new DefaultComboBoxModel(new String[] { "1\uC6D4", "2\uC6D4", "3\uC6D4", "4\uC6D4",
				"5\uC6D4", "6\uC6D4", "7\uC6D4", "8\uC6D4", "9\uC6D4", "10\uC6D4", "11\uC6D4", "12\uC6D4" }));
		coboxMonth.setBounds(552, 86, 85, 23);
		contentPane.add(coboxMonth);

		txtDay = new JTextField();
		txtDay.setText("22");
		txtDay.setBounds(671, 88, 69, 21);
		contentPane.add(txtDay);
		txtDay.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("\uC77C");
		lblNewLabel_3.setBounds(752, 94, 26, 15);
		contentPane.add(lblNewLabel_3);

		JLabel lblBranchAddress = new JLabel("\uB9C8\uD3EC\uAD6C \uC6D4\uB4DC\uCEF5\uB85C 120 1\uCE35");
		lblBranchAddress.setBounds(372, 90, 152, 15);
		contentPane.add(lblBranchAddress);

		JLabel lblNewLabel_4 = new JLabel("\uC774\uB984");
		lblNewLabel_4.setBounds(37, 65, 57, 23);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_4_1 = new JLabel("\uC9C0\uBC88 \uC8FC\uC18C");
		lblNewLabel_4_1.setBounds(362, 65, 85, 23);
		contentPane.add(lblNewLabel_4_1);

		JLabel lblNewLabel_4_2 = new JLabel("\uB3C4\uB85C\uBA85 \uC8FC\uC18C");
		lblNewLabel_4_2.setBounds(187, 65, 95, 23);
		contentPane.add(lblNewLabel_4_2);

		JButton btnBackContents = new JButton("\uC0AD\uC81C\uAE30\uB85D"); // ��������
		btnBackContents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WorkBackUpContent backupContent = new WorkBackUpContent();
				backupContent.setVisible(true);
			}
		});
		btnBackContents.setBounds(1033, 53, 95, 23);
		contentPane.add(btnBackContents);

		JButton btnSetManage = new JButton("\uAD00\uB9AC\uC124\uC815"); // ��������
		btnSetManage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SetManage sManage = new SetManage();
				sManage.setVisible(true);
			}
		});
		btnSetManage.setBounds(1033, 86, 95, 23);
		contentPane.add(btnSetManage);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(37, 119, 1086, 263);
		contentPane.add(tabbedPane);

		jtable = new JTable(model); // ���̺� DB��
		jscp1 = new JScrollPane(jtable); // ��ũ�ѹ�
		
		jtable2 = new JTable(model); // ���̺� DB��
		jscp2 = new JScrollPane(jtable); // ��ũ�ѹ�

		JScrollPane jScrollPane = new JScrollPane();

		// tabbedPane.addTab("1", null, jScrollPane, null);
		tabbedPane.add("��ü", jscp1); // �Ǻκ� �߰�
		tabbedPane.addTab("�������", null, jScrollPane, null);
		
		JButton btnRefresh = new JButton("\uC0C8\uB85C\uACE0\uCE68"); // ���ΰ�ħ
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jTableRefresh();
			}
		});
		btnRefresh.setBounds(720, 400, 109, 23);
		contentPane.add(btnRefresh);

//		if (userId == null) {
//			JOptionPane.showMessageDialog(null, "�������� ���� ������Դϴ�.");
//			System.exit(0);
//		} 

	}
}