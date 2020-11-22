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

// DB에 연결하기
	public void openCon() {
		try {
			Class.forName(driver);
			// System.out.println("JDBC 드라이버 로드 성공");
			con = DriverManager.getConnection(url, uid, pwd);
			System.out.println("DB 접속 성공");
		} catch (ClassNotFoundException e1) {
			System.out.println("드라이버 로드 실패");
		} catch (SQLException e2) {
			System.out.println("접속 실패");
		}

	}

// DB 연결 끊기
	public void closeCon() {
		try {
			if (con != null) {
				con.close();
				System.out.println("DB연결 해제");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

// 회원가입
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
				JOptionPane.showMessageDialog(null, "가입 실패");
			else {
				JOptionPane.showMessageDialog(null, "가입 성공");
			}
			psmt.close();
			closeCon();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

// 로그인	
	public int login(String userID, String userPW) {
		openCon();// 1. DB 연결
		try {
			psmt = con.prepareStatement("select userPW from member where userID = ?");
			psmt.setString(1, userID);
			rs = psmt.executeQuery();
			if (rs.next()) {
				if (rs.getString(1).equals(userPW)) {
					return 1;// 로그인 성공
				} else
					return 0; // 비밀번호 불일치
			} else
				return -1;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeCon();
		}
		return -1; // 로그인 실패
	}

	
// 비밀번호 찾기
	public String findUserPassword(String userName, String userID, String userEmail) {
		openCon();
		try {
			psmt = con.prepareStatement("select userPW from member where userName = '"+ userName + "' and userID = '"+userID+"' and userEmail = '"+userEmail+"'");
			rs = psmt.executeQuery();
			while (rs.next()) {
				//System.out.println(rs.getString(1));
				return rs.getString(1); // sql 결과값 넘기기
			}
		} catch (SQLException e) {}
		finally {
			closeCon();
		}
		
		return null;
	}
// ID 중복확인
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
					return 0; // 아이디 중복
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeCon();
		}
		return 1; // 사용가능
	}
}
