package db;

import java.io.ObjectInputStream.GetField;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DAO {
	Connection con = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;

	static String driver = "org.mariadb.jdbc.Driver";
	static String url = "jdbc:mariadb://localhost:3307/test";
	static String uid = "root";
	static String pwd = "1234";
	private String query = null;

	private static DAO instance = new DAO();

	public static DAO getInstance() {
		return instance;
	}

	// DB�� �����ϱ�
	public void openCon() {
		try {
			Class.forName(driver);
			// System.out.println("JDBC ����̹� �ε� ����");
			con = DriverManager.getConnection(url, uid, pwd);
			// System.out.println("DB ���� ����");
		} catch (ClassNotFoundException e1) {
			System.out.println("����̹� �ε� ����");
		} catch (SQLException e2) {
			System.out.println("���� ����");
		}

	}

	// DB ���� ����
	public void closeCon() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (con != null)
				con.close();
			// System.out.println("DB���� ����");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// manageShow()���� ����� time_set ���̺� ������ �ð� ���� �������� ��
	public String manageTimeGet(String num) {
		openCon();
		try {
			String query = "SELECT startDay FROM time_set WHERE tNum = ?";
			psmt = con.prepareStatement(query);
			psmt.setString(1, num);
			rs = psmt.executeQuery();
			while (rs.next()) {
				// System.out.println(rs.getString(1));
				return rs.getString(1); // sql ����� �ѱ��
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		closeCon();
		return null;
	}

	// ������ ������� ����
	public Vector manageShow() {
		Vector data = new Vector();
		openCon();

		try {
			String sql1 = "select * from disinfection_target_list where flag = 1 AND cDivision = '�ް�������' AND cCleanDay Not between '"
					+ manageTimeGet("1") + "' and '" + toDay() + "'";
			String sql2 = "select * from disinfection_target_list where flag = 1 AND cDivision = '�Ϲ�������' AND cCleanDay Not between '"
					+ manageTimeGet("2") + "' and '" + toDay() + "'";
			String sql3 = "select * from disinfection_target_list where flag = 1 AND cDivision = '��' AND cCleanDay Not between '"
					+ manageTimeGet("3") + "' and '" + toDay() + "'";
			String sql4 = "select * from disinfection_target_list where flag = 1 AND cDivision = '���ǽ���' AND cCleanDay Not between '"
					+ manageTimeGet("4") + "' and '" + toDay() + "'";
			String sql5 = "select * from disinfection_target_list where flag = 1 AND cDivision = '��ȭ��' AND cCleanDay Not between '"
					+ manageTimeGet("5") + "' and '" + toDay() + "'";
			String sql6 = "select * from disinfection_target_list where flag = 1 AND cDivision = '������Ʈ' AND cCleanDay Not between '"
					+ manageTimeGet("6") + "' and '" + toDay() + "'";
			String sql7 = "select * from disinfection_target_list where flag = 1 AND cDivision = '�ձ���ȸ��' AND cCleanDay Not between '"
					+ manageTimeGet("7") + "' and '" + toDay() + "'";
			String sql8 = "select * from disinfection_target_list where flag = 1 AND cDivision = '��ȭ��ȸ�ü�' AND cCleanDay Not between '"
					+ manageTimeGet("8") + "' and '" + toDay() + "'";
			String sql9 = "select * from disinfection_target_list where flag = 1 AND cDivision = '����Ʈ' AND cCleanDay Not between '"
					+ manageTimeGet("9") + "' and '" + toDay() + "'";
			String sql10 = "select * from disinfection_target_list where flag = 1 AND cDivision = '�б�' AND cCleanDay Not between '"
					+ manageTimeGet("10") + "' and '" + toDay() + "'";
			String sql11 = "select * from disinfection_target_list where flag = 1 AND cDivision = '����ö' AND cCleanDay Not between '"
					+ manageTimeGet("11") + "' and '" + toDay() + "'";
			String sql12 = "select * from disinfection_target_list where flag = 1 AND cDivision = '��ǰ������' AND cCleanDay Not between '"
					+ manageTimeGet("12") + "' and '" + toDay() + "'";
			psmt = con.prepareStatement(sql1);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Integer cNum = rs.getInt("cNum");
				String cName = rs.getString("cName");
				String cRoadName = rs.getString("cRoadName");
				String cBranchName = rs.getString("cBranchName");
				String cPostal = rs.getString("cPostal");
				String cDivision = rs.getString("cDivision");
				String cPhone = rs.getString("cPhone");
				String cCleanName = rs.getString("cCleanName");
				String cCleanDay = rs.getString("cCleanDay");

				Vector row = new Vector();
				row.add(cNum);
				row.add(cName);
				row.add(cRoadName);
				row.add(cBranchName);
				row.add(cPostal);
				row.add(cDivision);
				row.add(cPhone);
				row.add(cCleanName);
				row.add(cCleanDay);
				data.add(row);
			}

			rs.first();
			psmt = con.prepareStatement(sql2);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Integer cNum = rs.getInt("cNum");
				String cName = rs.getString("cName");
				String cRoadName = rs.getString("cRoadName");
				String cBranchName = rs.getString("cBranchName");
				String cPostal = rs.getString("cPostal");
				String cDivision = rs.getString("cDivision");
				String cPhone = rs.getString("cPhone");
				String cCleanName = rs.getString("cCleanName");
				String cCleanDay = rs.getString("cCleanDay");

				Vector row = new Vector();
				row.add(cNum);
				row.add(cName);
				row.add(cRoadName);
				row.add(cBranchName);
				row.add(cPostal);
				row.add(cDivision);
				row.add(cPhone);
				row.add(cCleanName);
				row.add(cCleanDay);
				data.add(row);
			}
			rs.first();
			psmt = con.prepareStatement(sql3);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Integer cNum = rs.getInt("cNum");
				String cName = rs.getString("cName");
				String cRoadName = rs.getString("cRoadName");
				String cBranchName = rs.getString("cBranchName");
				String cPostal = rs.getString("cPostal");
				String cDivision = rs.getString("cDivision");
				String cPhone = rs.getString("cPhone");
				String cCleanName = rs.getString("cCleanName");
				String cCleanDay = rs.getString("cCleanDay");

				Vector row = new Vector();
				row.add(cNum);
				row.add(cName);
				row.add(cRoadName);
				row.add(cBranchName);
				row.add(cPostal);
				row.add(cDivision);
				row.add(cPhone);
				row.add(cCleanName);
				row.add(cCleanDay);
				data.add(row);
			}
			rs.first();
			psmt = con.prepareStatement(sql4);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Integer cNum = rs.getInt("cNum");
				String cName = rs.getString("cName");
				String cRoadName = rs.getString("cRoadName");
				String cBranchName = rs.getString("cBranchName");
				String cPostal = rs.getString("cPostal");
				String cDivision = rs.getString("cDivision");
				String cPhone = rs.getString("cPhone");
				String cCleanName = rs.getString("cCleanName");
				String cCleanDay = rs.getString("cCleanDay");

				Vector row = new Vector();
				row.add(cNum);
				row.add(cName);
				row.add(cRoadName);
				row.add(cBranchName);
				row.add(cPostal);
				row.add(cDivision);
				row.add(cPhone);
				row.add(cCleanName);
				row.add(cCleanDay);
				data.add(row);
			}
			rs.first();
			psmt = con.prepareStatement(sql5);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Integer cNum = rs.getInt("cNum");
				String cName = rs.getString("cName");
				String cRoadName = rs.getString("cRoadName");
				String cBranchName = rs.getString("cBranchName");
				String cPostal = rs.getString("cPostal");
				String cDivision = rs.getString("cDivision");
				String cPhone = rs.getString("cPhone");
				String cCleanName = rs.getString("cCleanName");
				String cCleanDay = rs.getString("cCleanDay");

				Vector row = new Vector();
				row.add(cNum);
				row.add(cName);
				row.add(cRoadName);
				row.add(cBranchName);
				row.add(cPostal);
				row.add(cDivision);
				row.add(cPhone);
				row.add(cCleanName);
				row.add(cCleanDay);
				data.add(row);
			}

			rs.first();
			psmt = con.prepareStatement(sql6);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Integer cNum = rs.getInt("cNum");
				String cName = rs.getString("cName");
				String cRoadName = rs.getString("cRoadName");
				String cBranchName = rs.getString("cBranchName");
				String cPostal = rs.getString("cPostal");
				String cDivision = rs.getString("cDivision");
				String cPhone = rs.getString("cPhone");
				String cCleanName = rs.getString("cCleanName");
				String cCleanDay = rs.getString("cCleanDay");

				Vector row = new Vector();
				row.add(cNum);
				row.add(cName);
				row.add(cRoadName);
				row.add(cBranchName);
				row.add(cPostal);
				row.add(cDivision);
				row.add(cPhone);
				row.add(cCleanName);
				row.add(cCleanDay);
				data.add(row);
			}
			rs.first();
			psmt = con.prepareStatement(sql7);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Integer cNum = rs.getInt("cNum");
				String cName = rs.getString("cName");
				String cRoadName = rs.getString("cRoadName");
				String cBranchName = rs.getString("cBranchName");
				String cPostal = rs.getString("cPostal");
				String cDivision = rs.getString("cDivision");
				String cPhone = rs.getString("cPhone");
				String cCleanName = rs.getString("cCleanName");
				String cCleanDay = rs.getString("cCleanDay");

				Vector row = new Vector();
				row.add(cNum);
				row.add(cName);
				row.add(cRoadName);
				row.add(cBranchName);
				row.add(cPostal);
				row.add(cDivision);
				row.add(cPhone);
				row.add(cCleanName);
				row.add(cCleanDay);
				data.add(row);
			}
			rs.first();
			psmt = con.prepareStatement(sql8);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Integer cNum = rs.getInt("cNum");
				String cName = rs.getString("cName");
				String cRoadName = rs.getString("cRoadName");
				String cBranchName = rs.getString("cBranchName");
				String cPostal = rs.getString("cPostal");
				String cDivision = rs.getString("cDivision");
				String cPhone = rs.getString("cPhone");
				String cCleanName = rs.getString("cCleanName");
				String cCleanDay = rs.getString("cCleanDay");

				Vector row = new Vector();
				row.add(cNum);
				row.add(cName);
				row.add(cRoadName);
				row.add(cBranchName);
				row.add(cPostal);
				row.add(cDivision);
				row.add(cPhone);
				row.add(cCleanName);
				row.add(cCleanDay);
				data.add(row);
			}
			rs.first();
			psmt = con.prepareStatement(sql9);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Integer cNum = rs.getInt("cNum");
				String cName = rs.getString("cName");
				String cRoadName = rs.getString("cRoadName");
				String cBranchName = rs.getString("cBranchName");
				String cPostal = rs.getString("cPostal");
				String cDivision = rs.getString("cDivision");
				String cPhone = rs.getString("cPhone");
				String cCleanName = rs.getString("cCleanName");
				String cCleanDay = rs.getString("cCleanDay");

				Vector row = new Vector();
				row.add(cNum);
				row.add(cName);
				row.add(cRoadName);
				row.add(cBranchName);
				row.add(cPostal);
				row.add(cDivision);
				row.add(cPhone);
				row.add(cCleanName);
				row.add(cCleanDay);
				data.add(row);
			}
			rs.first();
			psmt = con.prepareStatement(sql10);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Integer cNum = rs.getInt("cNum");
				String cName = rs.getString("cName");
				String cRoadName = rs.getString("cRoadName");
				String cBranchName = rs.getString("cBranchName");
				String cPostal = rs.getString("cPostal");
				String cDivision = rs.getString("cDivision");
				String cPhone = rs.getString("cPhone");
				String cCleanName = rs.getString("cCleanName");
				String cCleanDay = rs.getString("cCleanDay");

				Vector row = new Vector();
				row.add(cNum);
				row.add(cName);
				row.add(cRoadName);
				row.add(cBranchName);
				row.add(cPostal);
				row.add(cDivision);
				row.add(cPhone);
				row.add(cCleanName);
				row.add(cCleanDay);
				data.add(row);
			}
			rs.first();
			psmt = con.prepareStatement(sql11);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Integer cNum = rs.getInt("cNum");
				String cName = rs.getString("cName");
				String cRoadName = rs.getString("cRoadName");
				String cBranchName = rs.getString("cBranchName");
				String cPostal = rs.getString("cPostal");
				String cDivision = rs.getString("cDivision");
				String cPhone = rs.getString("cPhone");
				String cCleanName = rs.getString("cCleanName");
				String cCleanDay = rs.getString("cCleanDay");

				Vector row = new Vector();
				row.add(cNum);
				row.add(cName);
				row.add(cRoadName);
				row.add(cBranchName);
				row.add(cPostal);
				row.add(cDivision);
				row.add(cPhone);
				row.add(cCleanName);
				row.add(cCleanDay);
				data.add(row);
			}
			rs.first();
			psmt = con.prepareStatement(sql12);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Integer cNum = rs.getInt("cNum");
				String cName = rs.getString("cName");
				String cRoadName = rs.getString("cRoadName");
				String cBranchName = rs.getString("cBranchName");
				String cPostal = rs.getString("cPostal");
				String cDivision = rs.getString("cDivision");
				String cPhone = rs.getString("cPhone");
				String cCleanName = rs.getString("cCleanName");
				String cCleanDay = rs.getString("cCleanDay");

				Vector row = new Vector();
				row.add(cNum);
				row.add(cName);
				row.add(cRoadName);
				row.add(cBranchName);
				row.add(cPostal);
				row.add(cDivision);
				row.add(cPhone);
				row.add(cCleanName);
				row.add(cCleanDay);
				data.add(row);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}

	// �ҵ���� DB �� �������� (flag�� 1�� ����)
	public Vector showAllTable() {
		Vector data = new Vector();
		openCon();

		try {
			String sql = "SELECT * FROM disinfection_target_list WHERE flag = 1";
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Integer cNum = rs.getInt("cNum");
				String cName = rs.getString("cName");
				String cRoadName = rs.getString("cRoadName");
				String cBranchName = rs.getString("cBranchName");
				String cPostal = rs.getString("cPostal");
				String cDivision = rs.getString("cDivision");
				String cPhone = rs.getString("cPhone");
				String cCleanName = rs.getString("cCleanName");
				String cCleanDay = rs.getString("cCleanDay");

				Vector row = new Vector();
				row.add(cNum);
				row.add(cName);
				row.add(cRoadName);
				row.add(cBranchName);
				row.add(cPostal);
				row.add(cDivision);
				row.add(cPhone);
				row.add(cCleanName);
				row.add(cCleanDay);

				data.add(row);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}

	// ���̺� ��ܿ� ǥ���� ��
	public Vector getColimn() {
		Vector col = new Vector();
		col.add("������ȣ");
		col.add("�̸�");
		col.add("���θ�");
		col.add("����");
		col.add("�����ȣ");
		col.add("����");
		col.add("����ó");
		col.add("�ҵ���ü��");
		col.add("�ҵ���¥");

		return col;
	}
	
	// ���â ���̺�

// ���ο��� ������ư���� flag�� 0���� ����� DB ���� ��������
	public Vector showBackupData() {
		Vector data = new Vector();
		try {
			openCon();
			String sql = "SELECT * FROM disinfection_target_list WHERE flag = 0";
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				int cNum = rs.getInt("cNum");
				String cName = rs.getString("cName");
				String cRoadName = rs.getString("cRoadName");
				String cBranchName = rs.getString("cBranchName");
				String cPostal = rs.getString("cPostal");
				String cDivision = rs.getString("cDivision");
				String cPhone = rs.getString("cPhone");
				String cCleanName = rs.getString("cCleanName");
				String cCleanDay = rs.getString("cCleanDay");

				Vector row = new Vector();
				row.add(cNum);
				row.add(cName);
				row.add(cRoadName);
				row.add(cBranchName);
				row.add(cPostal);
				row.add(cDivision);
				row.add(cPhone);
				row.add(cCleanName);
				row.add(cCleanDay);

				data.add(row);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeCon();
		return data;
	}
	

// ���系������ ���� - DB���� ������ ����
	public void delete(int cNum) {
		try {
			openCon();
			String query4 = "DELETE FROM disinfection_target_list WHERE cNum = ?";
			psmt = con.prepareStatement(query4);
			psmt.setInt(1, cNum);
			int excuteQuery = psmt.executeUpdate();
			if (excuteQuery != 1)
				JOptionPane.showMessageDialog(null, "���� ����");
			else {
				JOptionPane.showMessageDialog(null, "���� ����");
			}
			closeCon();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// ���â���� �������� ����

// ������������ �ٽ� ���ο� ���̺�� ���������ֱ�
	public void mainReturn(int cNum) {
		try {
			openCon();
			String query3 = "UPDATE disinfection_target_list SET flag = 1  WHERE cNum = ?";
			psmt = con.prepareStatement(query3);
			psmt.setInt(1, cNum);
			int excuteQuery = psmt.executeUpdate();

			if (excuteQuery != 1)
				JOptionPane.showMessageDialog(null, "���� ����");
			else {
				JOptionPane.showMessageDialog(null, "���� ����");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeCon();
		}
	}
	
	

	// ���� ���̺��� �� ���̰��ϱ� - DB�� ���� X
	public void mainDel(int cNum) {
		try {
			openCon();
			String query3 = "UPDATE disinfection_target_list SET flag = 0  WHERE cNum = ?";
			psmt = con.prepareStatement(query3);
			psmt.setInt(1, cNum);
			int excuteQuery = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeCon();
		}
	}

	// �ҵ� ���� ��ܿ� ������ �߰�
	static int resultData;
	public int insertData(dataDTO ddto) {
		openCon();
		try {
			String query1 = "insert into disinfection_target_list(cName, cRoadName,cBranchName,cPostal,cDivision,cPhone,cCleanName,cCleanDay,flag) value(?,?,?,?,?,?,?,?,?)";
			psmt = con.prepareStatement(query1);
			psmt.setString(1, ddto.getcName());
			psmt.setString(2, ddto.getcRoadName());
			psmt.setString(3, ddto.getcBranchName());
			psmt.setString(4, ddto.getcPostal());
			psmt.setString(5, ddto.getcDivision());
			psmt.setString(6, ddto.getcPhone());
			psmt.setString(7, ddto.getcCleanName());
			psmt.setString(8, ddto.getcCleanDay());
			psmt.setInt(9, 1);

			int excuteQuery = psmt.executeUpdate();// �����ϸ� 1��ȯ
			resultData = excuteQuery;

		} catch (Exception e) {
			e.printStackTrace();
		}
		closeCon();
		return resultData;
	}

	// �ҵ� ���� ��� ������ ����
	public int chagetData(dataDTO ddto) {
		try {
			openCon();

			String query1 = "UPDATE disinfection_target_list SET cName = ?, cRoadName=?,cBranchName=?,cPostal=?,cDivision=?,cPhone=?,cCleanName=?,cCleanDay=?,flag=? WHERE cNum = ?";
			psmt = con.prepareStatement(query1);
			psmt.setString(1, ddto.getcName());
			psmt.setString(2, ddto.getcRoadName());
			psmt.setString(3, ddto.getcBranchName());
			psmt.setString(4, ddto.getcPostal());
			psmt.setString(5, ddto.getcDivision());
			psmt.setString(6, ddto.getcPhone());
			psmt.setString(7, ddto.getcCleanName());
			psmt.setString(8, ddto.getcCleanDay());
			psmt.setInt(9, ddto.getFlag());
			psmt.setInt(10, ddto.getcNum());

			int excuteQuery = psmt.executeUpdate();// �����ϸ� 1��ȯ
			resultData = excuteQuery;
			closeCon();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultData;
	}
	
	// �ҵ� ���� ��ܿ� ������ �߰�
	public int mainInsertData(int i, String cleanDay) {
		openCon();
		try {
			String query1 = "UPDATE disinfection_target_list SET cCleanDay=? WHERE cNum = ?";
			psmt = con.prepareStatement(query1);
//			psmt.setString(1, ddto.getcName());
//			psmt.setString(2, ddto.getcRoadName());
//			psmt.setString(3, ddto.getcBranchName());
//			psmt.setString(4, ddto.getcPostal());
//			psmt.setString(5, ddto.getcDivision());
//			psmt.setString(6, ddto.getcPhone());
//			psmt.setString(7, ddto.getcCleanName());
//			psmt.setString(8, ddto.getcCleanDay());
//			psmt.setInt(9, ddto.getFlag());
//			psmt.setInt(10, ddto.getcNum());

			psmt.setString(1, cleanDay);

			psmt.setInt(2, i);
			
			int excuteQuery = psmt.executeUpdate();// �����ϸ� 1��ȯ
			resultData = excuteQuery;

		} catch (Exception e) {
			e.printStackTrace();
		}
		closeCon();
		return resultData;
	}

	// �˻�- ���̺�, �˻�����, �˻��� �ܾ�, ���� ����(���ο���)
	public void seachWord(DefaultTableModel dt, String seachLimit, String seachWord, int flagNum) {
		openCon();
		try {
			for (int i = 0; i < dt.getRowCount();) {
				dt.removeRow(0);
			}
			if (seachLimit == null) { // ��ü �˻�
				String sql2 = "SELECT * FROM disinfection_target_list WHERE flag = '" + flagNum + "' AND (cName LIKE '%"
						+ seachWord.trim() + "%' OR cRoadName LIKE '%" + seachWord.trim() + "%' OR cBranchName LIKE '%"
						+ seachWord.trim() + "%')";
				psmt = con.prepareStatement(sql2);
			} else { // �ٸ� �˻���
				String sql = "SELECT * FROM disinfection_target_list WHERE flag = '" + flagNum + "' AND "
						+ seachLimit.trim() + " LIKE '%" + seachWord.trim() + "%'";
				psmt = con.prepareStatement(sql);
			}
			rs = psmt.executeQuery();

			while (rs.next()) {
				Object data[] = { rs.getInt("cNum"), rs.getString("cName"), rs.getString("cRoadName"),
						rs.getString("cBranchName"), rs.getString("cPostal"), rs.getString("cDivision"),
						rs.getString("cPhone"), rs.getString("cCleanName"), rs.getString("cCleanDay") };
				dt.addRow(data);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeCon();
	}

	// ���ΰ�ħ
	public void reset(DefaultTableModel dt, int flagNum) {
		openCon();
		try {
			for (int i = 0; i < dt.getRowCount();) {
				dt.removeRow(0);
			}
			String sql = "SELECT * FROM disinfection_target_list WHERE flag = '" + flagNum + "'";
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				Object data[] = { rs.getInt("cNum"), rs.getString("cName"), rs.getString("cRoadName"),
						rs.getString("cBranchName"), rs.getString("cPostal"), rs.getString("cDivision"),
						rs.getString("cPhone"), rs.getString("cCleanName"), rs.getString("cCleanDay") };
				dt.addRow(data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeCon();
	}

	//time_set�� ����Ǿ� �ִ� ��¥���� SetManage�� ��¥�� txt���� �־��ֱ� ���ؼ� ���
	public String timeShow(String num) {
		try {
			openCon();
			String query = "SELECT startDay FROM time_set where tNum = '" + num + "'";
			psmt = con.prepareStatement(query);
			rs = psmt.executeQuery();
			while (rs.next()) {
				// System.out.println(rs.getString(1));
				return rs.getString(1); // sql ����� �ѱ��
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		closeCon();
		return null;
	}

	// time_set ���̺� �ð� ����
	public void timeSet(int tNum, String sDay) {
		openCon();
		try {
			String query = "UPDATE time_set SET startDay = ? WHERE tNum = ?";
			psmt = con.prepareStatement(query);
			psmt.setString(1, sDay);
			psmt.setInt(2, tNum);
			int excuteQuery = psmt.executeUpdate();// �����ϸ� 1��ȯ
			if (excuteQuery != 1) {
				JOptionPane.showMessageDialog(null, "���� ����");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		closeCon();
	}

	// ���� ��¥ ���ϱ�
	public String toDay() {
		SimpleDateFormat dateFormat;
		dateFormat = new SimpleDateFormat("yyyyMMdd");
		Calendar cal = Calendar.getInstance();

		cal.setTime(new Date(System.currentTimeMillis()));
		String endDate = dateFormat.format(cal.getTime()); // ����

		cal.add(Calendar.MONTH, 1);
		return endDate;
	}

	////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////
	// ȸ������
	public void insertMember(String userName, String userId, String userPw, String userEmail) {
		try {
			openCon();
			String query1 = "insert into member value(?,?,?,?)";
			psmt = con.prepareStatement(query1);
			psmt.setString(1, userName);
			psmt.setString(2, userId);
			psmt.setString(3, userPw);
			psmt.setString(4, userEmail);
			// psmt.executeUpdate();
			int excuteQuery = psmt.executeUpdate();// �����ϸ� 1��ȯ
			if (excuteQuery != 1)
				JOptionPane.showMessageDialog(null, "���� ����");
			else {
				JOptionPane.showMessageDialog(null, "���� ����");
			}
			closeCon();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// �α���	
	public int login(String userID, String userPW) {
		openCon();// 1. DB ����
		try {
			psmt = con.prepareStatement("select userPW from member where userID = ?"); // id�˻�
			psmt.setString(1, userID);
			rs = psmt.executeQuery();
			if (rs.next()) {
				if (rs.getString(1).equals(userPW)) {
					return 1;// �α��� ����
				} else
					return 0; // ��й�ȣ ����ġ
			} else
				return -1;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeCon();
		}
		return -1; // �α��� ����
	}

	// ��й�ȣ ã��
	public String findUserPassword(String userName, String userID, String userEmail) {
		openCon();
		try {
			psmt = con.prepareStatement("select userPW from member where userName = '" + userName + "' and userID = '"
					+ userID + "' and userEmail = '" + userEmail + "'");
			rs = psmt.executeQuery();
			while (rs.next()) {
				// System.out.println(rs.getString(1));
				return rs.getString(1); // sql ����� �ѱ��
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeCon();
		}

		return null;
	}

	// ID �ߺ�Ȯ��
	public int idCheck(String userId) {
		String getOk = null;
		try {
			openCon();
			psmt = con.prepareStatement("select userID from member where userID=?");
			psmt.setString(1, userId);
			rs = psmt.executeQuery();
			while (rs.next()) {
				getOk = rs.getString("userID");
				if (getOk.equals(userId))
					return 0; // ���̵� �ߺ�
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeCon();
		}
		return 1; // ��밡��
	}
}
