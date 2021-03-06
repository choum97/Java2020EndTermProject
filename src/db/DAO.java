package db;

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
			if (con != null)
				con.close();
			// System.out.println("DB연결 해제");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// manageShow()에서 사용할 time_set 테이블에 설정된 시간 값을 가져오는 것
	public String manageTimeGet(String num) {
		openCon();
		try {
			String query = "SELECT startDay FROM time_set WHERE tNum = ?";
			psmt = con.prepareStatement(query);
			psmt.setString(1, num);
			rs = psmt.executeQuery();
			while (rs.next()) {
				// System.out.println(rs.getString(1));
				return rs.getString(1); // sql 결과값 넘기기
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		closeCon();
		return null;
	}

	// 설정된 관리명단 값들
	public Vector manageShow() {
		Vector data = new Vector();
		openCon();

		try {
			String sql1 = "select * from disinfection_target_list where flag = 1 AND cDivision = '휴게음식점' AND cCleanDay Not between '"
					+ manageTimeGet("1") + "' and '" + toDay() + "'";
			String sql2 = "select * from disinfection_target_list where flag = 1 AND cDivision = '일반음식점' AND cCleanDay Not between '"
					+ manageTimeGet("2") + "' and '" + toDay() + "'";
			String sql3 = "select * from disinfection_target_list where flag = 1 AND cDivision = '상가' AND cCleanDay Not between '"
					+ manageTimeGet("3") + "' and '" + toDay() + "'";
			String sql4 = "select * from disinfection_target_list where flag = 1 AND cDivision = '오피스텔' AND cCleanDay Not between '"
					+ manageTimeGet("4") + "' and '" + toDay() + "'";
			String sql5 = "select * from disinfection_target_list where flag = 1 AND cDivision = '백화점' AND cCleanDay Not between '"
					+ manageTimeGet("5") + "' and '" + toDay() + "'";
			String sql6 = "select * from disinfection_target_list where flag = 1 AND cDivision = '대형마트' AND cCleanDay Not between '"
					+ manageTimeGet("6") + "' and '" + toDay() + "'";
			String sql7 = "select * from disinfection_target_list where flag = 1 AND cDivision = '죵교집회장' AND cCleanDay Not between '"
					+ manageTimeGet("7") + "' and '" + toDay() + "'";
			String sql8 = "select * from disinfection_target_list where flag = 1 AND cDivision = '문화집회시설' AND cCleanDay Not between '"
					+ manageTimeGet("8") + "' and '" + toDay() + "'";
			String sql9 = "select * from disinfection_target_list where flag = 1 AND cDivision = '아파트' AND cCleanDay Not between '"
					+ manageTimeGet("9") + "' and '" + toDay() + "'";
			String sql10 = "select * from disinfection_target_list where flag = 1 AND cDivision = '학교' AND cCleanDay Not between '"
					+ manageTimeGet("10") + "' and '" + toDay() + "'";
			String sql11 = "select * from disinfection_target_list where flag = 1 AND cDivision = '지하철' AND cCleanDay Not between '"
					+ manageTimeGet("11") + "' and '" + toDay() + "'";
			String sql12 = "select * from disinfection_target_list where flag = 1 AND cDivision = '식품접객업' AND cCleanDay Not between '"
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
			rs.first();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
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

	// 테이블 상단에 표시할 열
	public Vector getColimn() {
		Vector col = new Vector();
		col.add("고유번호");
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

	// 삭재내역에서 삭제 - DB에서 데이터 삭제
	public void delete(int cNum) {
		try {
			openCon();
			String query4 = "DELETE FROM disinfection_target_list WHERE cNum = ?";
			psmt = con.prepareStatement(query4);
			psmt.setInt(1, cNum);
			int excuteQuery = psmt.executeUpdate();
			if (excuteQuery != 1)
				JOptionPane.showMessageDialog(null, "삭제 실패");
			else {
				JOptionPane.showMessageDialog(null, "삭제 성공");
			}
			closeCon();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 삭제내역에서 다시 메인에 테이블로 복원시켜주기
	public void mainReturn(int cNum) {
		try {
			openCon();
			String query3 = "UPDATE disinfection_target_list SET flag = 1  WHERE cNum = ?";
			psmt = con.prepareStatement(query3);
			psmt.setInt(1, cNum);
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

	// 소독실적 명단에 추가
	static int resultData;

	public int insertData(DataDTO ddto) {
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

			if (ddto.getcCleanDay().trim().equals("")) {

			}

			int excuteQuery = psmt.executeUpdate();// 성공하면 1반환
			resultData = excuteQuery;

		} catch (Exception e) {
			e.printStackTrace();
		}
		closeCon();
		return resultData;
	}

	// 소독 실적 명단 데이터 수정
	public int chagetData(DataDTO ddto) {
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

			int excuteQuery = psmt.executeUpdate();// 성공하면 1반환
			resultData = excuteQuery;
			closeCon();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultData;
	}

	// 메인에서 실적입력
	public int mainInsertData(String cleanDay, int num) {
		openCon();
		try {
			String query2 = "UPDATE disinfection_target_list SET cCleanDay = ? WHERE cNum = ?";
			psmt = con.prepareStatement(query2);

			psmt.setString(1, cleanDay);
			psmt.setInt(2, num);

			int excuteQuery = psmt.executeUpdate();// 성공하면 1반환
			resultData = excuteQuery;

		} catch (Exception e) {
			e.printStackTrace();
		}
		closeCon();
		return resultData;
	}

	// 검색- 테이블값, 검색조건, 검색할 단어, 삭제 여부(메인에서)
	public void searchWord(DefaultTableModel dt, String seachLimit, String seachWord, int flagNum) {
		openCon();
		try {
			for (int i = 0; i < dt.getRowCount();) {
				dt.removeRow(0);
			}
			if (seachLimit == null) { // 전체 검색
				String sql2 = "SELECT * FROM disinfection_target_list WHERE flag = '" + flagNum + "' AND (cName LIKE '%"
						+ seachWord.trim() + "%' OR cRoadName LIKE '%" + seachWord.trim() + "%' OR cBranchName LIKE '%"
						+ seachWord.trim() + "%')";
				psmt = con.prepareStatement(sql2);
			} else { // 다른 검색들
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

	// 새로고침
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

	// time_set에 저장되어 있는 날짜값을 SetManage에 날짜를 txt값에 넣어주기 위해서 사용
	public String timeShow(String num) {
		try {
			openCon();
			String query = "SELECT startDay FROM time_set where tNum = '" + num + "'";
			psmt = con.prepareStatement(query);
			rs = psmt.executeQuery();
			while (rs.next()) {
				// System.out.println(rs.getString(1));
				return rs.getString(1); // sql 결과값 넘기기
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		closeCon();
		return null;
	}

	// time_set 테이블에 시간 설정
	public void timeSet(int tNum, String sDay) {
		openCon();
		try {
			String query = "UPDATE time_set SET startDay = ? WHERE tNum = ?";
			psmt = con.prepareStatement(query);
			psmt.setString(1, sDay);
			psmt.setInt(2, tNum);
			int excuteQuery = psmt.executeUpdate();// 성공하면 1반환
			if (excuteQuery != 1) {
				JOptionPane.showMessageDialog(null, "설정 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		closeCon();
	}

	// 오늘 날짜 구하기
	public String toDay() {
		SimpleDateFormat dateFormat;
		dateFormat = new SimpleDateFormat("yyyyMMdd");
		Calendar cal = Calendar.getInstance();

		cal.setTime(new Date(System.currentTimeMillis()));
		String endDate = dateFormat.format(cal.getTime()); // 오늘

		cal.add(Calendar.MONTH, 1);
		return endDate;
	}

	// 기간으로 검색
	public String timeSearch(DefaultTableModel dt, String startDay, String endDay) {
		try {
			openCon();
			String sql = "select * from disinfection_target_list where flag = 1 AND cCleanDay between '" + startDay
					+ "' and '" + endDay + "'";
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			for (int i = 0; i < dt.getRowCount();) {
				dt.removeRow(0);
			}
			while (rs.next()) {
				Object data[] = { rs.getInt("cNum"), rs.getString("cName"), rs.getString("cRoadName"),
						rs.getString("cBranchName"), rs.getString("cPostal"), rs.getString("cDivision"),
						rs.getString("cPhone"), rs.getString("cCleanName"), rs.getString("cCleanDay") };
				dt.addRow(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		closeCon();
		return null;
	}

	////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////
	// 회원가입
	public void insertMember(MemberDTO mdto) {
		try {
			openCon();
			String query1 = "insert into member value(?,?,?,?)";
			psmt = con.prepareStatement(query1);
			psmt.setString(1, mdto.getuName());
			psmt.setString(2, mdto.getuID());
			psmt.setString(3, mdto.getuPW());
			psmt.setString(4, mdto.getuEmail());
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
