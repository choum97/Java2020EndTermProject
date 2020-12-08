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

	public static DAO getInstance() { // 결과값 반환 해주기
		return instance;
	}

// DB에 연결하기
	public void openCon() {
		try {
			Class.forName(driver);
			// System.out.println("JDBC 드라이버 로드 성공");
			con = DriverManager.getConnection(url, uid, pwd);
			// System.out.println("DB 접속 성공");
		} catch (ClassNotFoundException e1) {
			System.out.println("드라이버 로드 실패");
		} catch (SQLException e2) {
			System.out.println("접속 실패");
		}

	}

// DB 연결 끊기
	public void closeCon() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (con != null) {
				con.close();
				// System.out.println("DB연결 해제");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void newContent() {

	}

// 소독대상 DB 값 가져오기 (flag가 1인 값들)
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

// 테이블 상단에 표시할 열
	public Vector getColimn() {
		Vector col = new Vector();
		col.add("이름");
		col.add("도로명");
		col.add("지번");
		col.add("우편번호");
		col.add("구분");
		col.add("연락처");
		col.add("소독업체명");
		col.add("소독날짜");

		return col;
	}

// 메인에서 삭제버튼으로 flag가 0으로 변경된 DB 값들 가져오기
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

// 삭재내역에서 삭제 - DB에서 데이터 삭제
	public void delete(String cName) {
		try {
			openCon();
			String query4 = "DELETE FROM disinfection_target_list WHERE cName = ?";
			psmt = con.prepareStatement(query4);
			psmt.setString(1, cName);
			int excuteQuery = psmt.executeUpdate();
			if (excuteQuery != 1)
				JOptionPane.showMessageDialog(null, "삭제 실패");
			else {
				JOptionPane.showMessageDialog(null, "삭제 성공");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeCon();
		}
	}

// 삭제내역에서 다시 메인에 테이블로 복원시켜주기
	public void mainReturn(String cName) {
		try {
			openCon();
			String query3 = "UPDATE disinfection_target_list SET flag = 1  WHERE cName = ?";
			psmt = con.prepareStatement(query3);
			psmt.setString(1, cName);
			int excuteQuery = psmt.executeUpdate();

			if (excuteQuery != 1)
				JOptionPane.showMessageDialog(null, "복구 실패");
			else {
				JOptionPane.showMessageDialog(null, "복구 성공");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeCon();
		}
	}

// 메인 테이블에서 안 보이게하기 - DB값 삭제 X
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
			int excuteQuery = psmt.executeUpdate();// 성공하면 1반환
			if (excuteQuery != 1)
				JOptionPane.showMessageDialog(null, "가입 실패");
			else {
				JOptionPane.showMessageDialog(null, "가입 성공");
			}
			closeCon();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

// 로그인	
	public int login(String userID, String userPW) {
		openCon();// 1. DB 연결
		try {
			psmt = con.prepareStatement("select userPW from member where userID = ?"); // id검색
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
		} finally {
			closeCon();
		}
		return -1; // 로그인 실패
	}

// 비밀번호 찾기
	public String findUserPassword(String userName, String userID, String userEmail) {
		openCon();
		try {
			psmt = con.prepareStatement("select userPW from member where userName = '" + userName + "' and userID = '"
					+ userID + "' and userEmail = '" + userEmail + "'");
			rs = psmt.executeQuery();
			while (rs.next()) {
				// System.out.println(rs.getString(1));
				return rs.getString(1); // sql 결과값 넘기기
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
