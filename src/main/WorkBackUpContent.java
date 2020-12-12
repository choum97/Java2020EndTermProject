package main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import db.DAO;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;

public class WorkBackUpContent extends JFrame {
	DAO dao = new DAO();
	private JPanel contentPane;
	private JButton btnNewButton;

	private Vector v;
	private Vector cols;
	DefaultTableModel model;
	private JScrollPane jscp1;
	private JTable jtable;

	private JButton btnDelete;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WorkBackUpContent frame = new WorkBackUpContent();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void jTableRefresh() {
		DefaultTableModel model = new DefaultTableModel(dao.showBackupData(), dao.getColimn());
		jtable.setModel(model);
	}

	public WorkBackUpContent() {
		v = dao.showBackupData(); // ���̺� DB
		cols = dao.getColimn();
		model = new DefaultTableModel(v, cols);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1115, 281);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnNewButton = new JButton("\uC885\uB8CC");
		btnNewButton.addActionListener(new ActionListener() { // �����ư
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		btnNewButton.setBounds(990, 203, 97, 23);
		contentPane.add(btnNewButton);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 41, 1086, 152);
		contentPane.add(tabbedPane);

		jtable = new JTable(model); // ���̺� DB��
		jscp1 = new JScrollPane(jtable); // ��ũ�ѹ�

		JScrollPane jScrollPane = new JScrollPane();
		tabbedPane.add("��������", jscp1); // �Ǻκ� �߰�

		JButton btnRestore = new JButton("\uBCF5\uAD6C"); // ������ư
		btnRestore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = jtable.getSelectedRow();
				if (row < 0)
					return;
				int cNum = (int) jtable.getValueAt(row, 0);
				model.removeRow(row);
				dao.mainReturn(cNum);

			}
		});
		btnRestore.setBounds(881, 203, 97, 23);
		contentPane.add(btnRestore);

		btnDelete = new JButton("\uC0AD\uC81C");
		btnDelete.addActionListener(new ActionListener() { // ������ư
			public void actionPerformed(ActionEvent e) {
				int row = jtable.getSelectedRow();
				if (row < 0)
					return;
				int cNum = (int) jtable.getValueAt(row, 0);
				model.removeRow(row); // ���̺��� ����
				dao.delete(cNum); // DB���� ����
			}
		});
		btnDelete.setBounds(772, 203, 97, 23);
		contentPane.add(btnDelete);

		JComboBox coboxSearchCondition = new JComboBox();
		coboxSearchCondition.setModel(new DefaultComboBoxModel(new String[] {"\uC774\uB984\uC73C\uB85C \uAC80\uC0C9", "\uC804\uCCB4 \uAC80\uC0C9", "\uB3C4\uB85C\uBA85\uC8FC\uC18C\uB85C \uAC80\uC0C9", "\uC9C0\uBC88\uC8FC\uC18C\uB85C \uAC80\uC0C9"}));
		coboxSearchCondition.setBounds(12, 11, 109, 23);
		contentPane.add(coboxSearchCondition);

		JTextArea txtSearch = new JTextArea();
		txtSearch.setBounds(136, 10, 378, 24);
		contentPane.add(txtSearch);

		JButton btnSearch = new JButton("\uAC80\uC0C9");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fieldName = coboxSearchCondition.getSelectedItem().toString();

				if (fieldName.trim().equals("��ü �˻�")) {// ��ü�˻�
					dao.seachWord(model, null, txtSearch.getText(), 0);
					txtSearch.requestFocus();
				}
				if (txtSearch.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "�˻��� �ܾ �Է����ּ���");
					txtSearch.requestFocus();
				}
				if (fieldName.trim().equals("�̸����� �˻�")) {// �˻�� �Է��������
					String sch = "cName";
					dao.seachWord(model, sch, txtSearch.getText(), 0); // ���̺�, �˻�����, �˻��� �ܾ�, ���� �� ��(���ο���)
				}
				if (fieldName.trim().equals("���θ��ּҷ� �˻�")) {
					String sch = "cRoadName";
					dao.seachWord(model, sch, txtSearch.getText(), 0);
				}
				if (fieldName.trim().equals("�����ּҷ� �˻�")) {
					String sch = "cBranchName";
					dao.seachWord(model, sch, txtSearch.getText(), 0);
				}
			}
		});
		btnSearch.setBounds(526, 10, 63, 23);
		contentPane.add(btnSearch);

		JButton btnRefresh = new JButton("\uAC80\uC0C9 \uCD08\uAE30\uD654");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jTableRefresh();
			}
		});
		btnRefresh.setBounds(592, 11, 116, 23);
		contentPane.add(btnRefresh);
	}
}
