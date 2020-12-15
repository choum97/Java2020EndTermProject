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
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import db.DAO;
import db.DataDTO;
import sub.Login;

public class WorkMain extends JFrame {
	DAO dao = new DAO();
	DataDTO ddto = new DataDTO();
	private JPanel contentPane;
	private JTextField txtDay;

	static DefaultTableModel model, model2; // ���̺�, model�� ��ü ,model2�� �������
	private JScrollPane jscp1, jscp2;
	private JTable jtable, jtable2;
	private JTextField txtStartDay;
	private JTextField txtEndDay;

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

	public void jTable2Refresh() {
		DefaultTableModel model2 = new DefaultTableModel(dao.manageShow(), dao.getColimn());
		jtable2.setModel(model2);

	}

	public WorkMain(String userId) {

		model = new DefaultTableModel(dao.showAllTable(), dao.getColimn());
		model2 = new DefaultTableModel(dao.manageShow(), dao.getColimn());

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1156, 501);
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
		btnNewContents.addActionListener(new ActionListener() { // �űԻ���
			public void actionPerformed(ActionEvent e) {
				NewContent nContent = new NewContent();
				nContent.setVisible(true);
			}
		});
		btnNewContents.setBounds(841, 429, 63, 23);
		contentPane.add(btnNewContents);

		JButton btnDeleteContents = new JButton("\uC0AD\uC81C");
		btnDeleteContents.addActionListener(new ActionListener() { // ���� ���̺��� ����
			public void actionPerformed(ActionEvent e) {
				int row = jtable.getSelectedRow();
				if (row < 0)
					return;
				int cNum = (Integer) jtable.getValueAt(row, 0);

				dao.mainDel(cNum);
				dao.reset(model, 1);
			}
		});
		btnDeleteContents.setBounds(916, 429, 63, 23);
		contentPane.add(btnDeleteContents);

		JButton btnExit = new JButton("\uC885\uB8CC");
		btnExit.addActionListener(new ActionListener() { // ����
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(1065, 429, 63, 23);
		contentPane.add(btnExit);

		JButton btnSearch = new JButton("\uAC80\uC0C9");
		btnSearch.addActionListener(new ActionListener() { // �ܾ�� �˻�
			public void actionPerformed(ActionEvent e) {
				String fieldName = coboxSearchCondition.getSelectedItem().toString();
				if (txtSearch.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "�˻��� �ܾ �Է����ּ���");
					txtSearch.requestFocus();
					dao.searchWord(model, null, txtSearch.getText(), 1);
				}
				if (fieldName.trim().equals("��ü �˻�")) {// ��ü�˻�
					dao.searchWord(model, null, txtSearch.getText(), 1);
					// dao.seachWord(model2, null, txtSearch.getText(), 1);
					txtSearch.requestFocus();
				}
				if (fieldName.trim().equals("�̸����� �˻�")) {// �˻�� �Է��������
					String sch = "cName";
					dao.searchWord(model, sch, txtSearch.getText(), 1); // ���̺�, �˻�����, �˻��� �ܾ�, ���� ���� ���� ��(���ο���)
				}
				if (fieldName.trim().equals("���θ��ּҷ� �˻�")) {
					String sch = "cRoadName";
					dao.searchWord(model, sch, txtSearch.getText(), 1);
				}
				if (fieldName.trim().equals("�����ּҷ� �˻�")) {
					String sch = "cBranchName";
					dao.searchWord(model, sch, txtSearch.getText(), 1);
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
		btnChangeContents.setBounds(990, 429, 63, 23);
		contentPane.add(btnChangeContents);

		JLabel lblRoadName = new JLabel("");
		lblRoadName.setBounds(196, 128, 164, 15);
		contentPane.add(lblRoadName);

		JLabel lblName = new JLabel("");
		lblName.setBounds(47, 128, 152, 15);
		contentPane.add(lblName);

		txtDay = new JTextField();
		txtDay.setBounds(556, 122, 164, 21);
		contentPane.add(txtDay);
		txtDay.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("\uB0A0\uC9DC");
		lblNewLabel_3.setBounds(541, 103, 26, 15);
		contentPane.add(lblNewLabel_3);

		JLabel lblBranchName = new JLabel("");
		lblBranchName.setBounds(372, 128, 152, 15);
		contentPane.add(lblBranchName);

		JLabel lblNewLabel_4 = new JLabel("\uC774\uB984");
		lblNewLabel_4.setBounds(37, 103, 57, 23);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_4_1 = new JLabel("\uC9C0\uBC88 \uC8FC\uC18C");
		lblNewLabel_4_1.setBounds(362, 103, 85, 23);
		contentPane.add(lblNewLabel_4_1);

		JLabel lblNewLabel_4_2 = new JLabel("\uB3C4\uB85C\uBA85 \uC8FC\uC18C");
		lblNewLabel_4_2.setBounds(187, 103, 95, 23);
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
		tabbedPane.setBounds(37, 153, 1086, 266);
		contentPane.add(tabbedPane);

		jtable = new JTable(model); // ���̺� DB��
		jscp1 = new JScrollPane(jtable); // ��ũ�ѹ�

		jtable2 = new JTable(model2); // ���̺� DB��
		jscp2 = new JScrollPane(jtable2); // ��ũ�ѹ�

		JScrollPane jScrollPane = new JScrollPane();

		tabbedPane.add("��ü", jscp1); // �Ǻκ� �߰�
		tabbedPane.addTab("�������", jscp2);

		JButton btnRefresh = new JButton("\uC0C8\uB85C\uACE0\uCE68"); // ���ΰ�ħ
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dao.reset(model, 1);
				jTable2Refresh();
			}
		});
		btnRefresh.setBounds(720, 429, 109, 23);
		contentPane.add(btnRefresh);

		JButton btnInputContent = new JButton("\uC785\uB825");
		btnInputContent.addActionListener(new ActionListener() { // �Է�
			public void actionPerformed(ActionEvent e) {
				int row = jtable.getSelectedRow();
				if (row < 0)
					return;

				ddto.setcNum((int) jtable.getValueAt(row, 0));
				String cleanday = txtDay.getText();
				int result = dao.mainInsertData(cleanday, ddto.getcNum());

				if (result != 1) {
					JOptionPane.showMessageDialog(null, "���� ����");
				} else {
					JOptionPane.showMessageDialog(null, "�Է� ����");
					dao.reset(model, 1);
				}

			}
		});
		btnInputContent.setBounds(732, 120, 69, 23);
		contentPane.add(btnInputContent);

		txtStartDay = new JTextField();
		txtStartDay.setBounds(161, 54, 97, 21);
		contentPane.add(txtStartDay);
		txtStartDay.setColumns(10);

		JLabel lblNewLabel_4_3 = new JLabel("~");
		lblNewLabel_4_3.setBounds(280, 53, 33, 23);
		contentPane.add(lblNewLabel_4_3);

		txtEndDay = new JTextField();
		txtEndDay.setColumns(10);
		txtEndDay.setBounds(317, 54, 95, 21);
		contentPane.add(txtEndDay);

		JButton btnSearchDay = new JButton("\uB0A0\uC9DC \uAE30\uAC04\uC73C\uB85C \uAC80\uC0C9");
		btnSearchDay.addActionListener(new ActionListener() { // �Ⱓ���� �˻�
			public void actionPerformed(ActionEvent e) {
				String startDay = txtStartDay.getText();
				String endDay = txtEndDay.getText();
				if (startDay.trim().equals("") && endDay.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "�˻��� �Ⱓ�� �������ּ���.");
				} else {
					dao.timeSearch(model, startDay, endDay);
				}

			}
		});
		btnSearchDay.setBounds(450, 54, 164, 23);
		contentPane.add(btnSearchDay);

		jtable.addMouseListener(new java.awt.event.MouseAdapter() { // ���̺� ���� �Է¹�ư ���� �󺧿� �־��ִ� ��
			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				int row = jtable.getSelectedRow();
				int num = (int) jtable.getValueAt(row, 0);
				String name = (String) jtable.getValueAt(row, 1);
				String roadName = (String) jtable.getValueAt(row, 2);
				String branchName = (String) jtable.getValueAt(row, 3);
				String cleanday = (String) jtable.getValueAt(row, 8);

				ddto.setcNum(num);
				ddto.setcCleanDay(cleanday);

				lblName.setText(name);
				lblRoadName.setText(roadName);
				lblBranchName.setText(branchName);
				txtDay.setText(cleanday);
			}
		});

//		if (userId == null) {
//			JOptionPane.showMessageDialog(null, "�������� ���� ������Դϴ�.");
//			System.exit(0);
//		}

	}
}