package sub.process;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

	public static DAO getInstance() { // ����� ��ȯ ���ֱ�
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
			if (con != null) {
				con.close();
				// System.out.println("DB���� ����");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void newContent() {

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
				String cName = rs.getString("cName");
				String cRoadName = rs.getString("cRoadName");
				String cBranchName = rs.getString("cBranchName");
				String cPostal = rs.getString("cPostal");
				String cDivision = rs.getString("cDivision");
				String cPhone = rs.getString("cPhone");
				String cCleanName = rs.getString("cCleanName");
				String cCleanDay = rs.getString("cCleanDay");

				Vector row = new Vector();
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

// ���ο��� ������ư���� flag�� 0���� ����� DB ���� ��������
	public Vector showBackupData() {
		Vector data = new Vector();
		openCon();

		try {
			String sql = "SELECT * FROM disinfection_target_list WHERE flag = 0";
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				String cName = rs.getString("cName");
				String cRoadName = rs.getString("cRoadName");
				String cBranchName = rs.getString("cBranchName");
				String cPostal = rs.getString("cPostal");
				String cDivision = rs.getString("cDivision");
				String cPhone = rs.getString("cPhone");
				String cCleanName = rs.getString("cCleanName");
				String cCleanDay = rs.getString("cCleanDay");

				Vector row = new Vector();
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

// ���系������ ���� - DB���� ������ ����
	public void delete(String cName) {
		try {
			openCon();
			String query4 = "DELETE FROM disinfection_target_list WHERE cName = ?";
			psmt = con.prepareStatement(query4);
			psmt.setString(1, cName);
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

// ������������ �ٽ� ���ο� ���̺�� ���������ֱ�
	public void mainReturn(String cName) {
		try {
			openCon();
			String query3 = "UPDATE disinfection_target_list SET flag = 1  WHERE cName = ?";
			psmt = con.prepareStatement(query3);
			psmt.setString(1, cName);
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
	public void mainDel(String cName) {
		try {
			openCon();
			String query3 = "UPDATE disinfection_target_list SET flag = 0  WHERE cName = ?";
			psmt = con.prepareStatement(query3);
			psmt.setString(1, cName);
			int excuteQuery = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeCon();
		}
	}
	


///////////////////////////////////////////////////////////////////
// ȸ������
	public void insertData(String userName, String userId, String userPw, String userEmail) {
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
