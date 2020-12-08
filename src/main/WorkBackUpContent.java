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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import db.DAO;

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

	public WorkBackUpContent() {
		v = dao.showBackupData();  //���̺� DB
		cols = dao.getColimn();
		model = new DefaultTableModel(v, cols);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1115, 281);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewButton = new JButton("\uC885\uB8CC");
		btnNewButton.addActionListener(new ActionListener() {  // �����ư
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		btnNewButton.setBounds(990, 203, 97, 23);
		contentPane.add(btnNewButton);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 41, 1086, 152);
		contentPane.add(tabbedPane);
		
		
		jtable = new JTable(model); 		//���̺� DB�� 
		jscp1 = new JScrollPane(jtable); //��ũ�ѹ�
		
		JScrollPane jScrollPane = new JScrollPane();
		tabbedPane.add("��������",jscp1);			//�Ǻκ� �߰�
		
		
		JButton btnRestore = new JButton("\uBCF5\uAD6C");  //������ư
		btnRestore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = jtable.getSelectedRow();
				if(row<0) return;
				String cName = (String) jtable.getValueAt(row, 0);
				model.removeRow(row);
				dao.mainReturn(cName);

			}
		});
		btnRestore.setBounds(881, 203, 97, 23);
		contentPane.add(btnRestore);
		
		btnDelete = new JButton("\uC0AD\uC81C");
		btnDelete.addActionListener(new ActionListener() { //������ư
			public void actionPerformed(ActionEvent e) {
				int row = jtable.getSelectedRow();
				if(row<0) return;
				String cName = (String) jtable.getValueAt(row, 0);
				model.removeRow(row); //���̺��� ����
				dao.delete(cName);  // DB���� ����
			}
		});
		btnDelete.setBounds(772, 203, 97, 23);
		contentPane.add(btnDelete);
	}
	
}
