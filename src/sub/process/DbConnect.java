package sub.process;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class DbConnect {
	Connection con = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;

	static String driver = "org.mariadb.jdbc.Driver";
	static String url = "jdbc:mariadb://localhost:3307/test";
	static String uid = "root";
	static String pwd = "1234";
	private String query = null;

	private static DbConnect instance = new DbConnect();

	public static DbConnect getInstance() {
		return instance;
	}

// DB�� �����ϱ�
	public void openCon() {
		try {
			Class.forName(driver);
			// System.out.println("JDBC ����̹� �ε� ����");
			con = DriverManager.getConnection(url, uid, pwd);
			System.out.println("DB ���� ����");
		} catch (ClassNotFoundException e1) {
			System.out.println("����̹� �ε� ����");
		} catch (SQLException e2) {
			System.out.println("���� ����");
		}

	}

// DB ���� ����
	public void closeCon() {
		try {
			if (con != null) {
				con.close();
				System.out.println("DB���� ����");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

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
			int excuteQuery = psmt.executeUpdate();
			if (excuteQuery != 1)
				JOptionPane.showMessageDialog(null, "���� ����");
			else {
				JOptionPane.showMessageDialog(null, "���� ����");
			}
			psmt.close();
			closeCon();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

// �α���	
	public int login(String userID, String userPW) {
		openCon();// 1. DB ����
		try {
			psmt = con.prepareStatement("select userPW from member where userID = ?");
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
		}finally {
			closeCon();
		}
		return -1; // �α��� ����
	}

	
// ��й�ȣ ã��
	public String findUserPassword(String userName, String userID, String userEmail) {
		openCon();
		try {
			psmt = con.prepareStatement("select userPW from member where userName = '"+ userName + "' and userID = '"+userID+"' and userEmail = '"+userEmail+"'");
			rs = psmt.executeQuery();
			while (rs.next()) {
				//System.out.println(rs.getString(1));
				return rs.getString(1); // sql ����� �ѱ��
			}
		} catch (SQLException e) {}
		finally {
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
