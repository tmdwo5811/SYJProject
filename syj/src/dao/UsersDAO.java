package dao;

import java.sql.Connection;

import java.sql.Date;
//import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.co.hucloud.utilities.SHA256Util;
import util.DBConnectionMgr;
import vo.Location;
import vo.Login;
import vo._Login;
import vo.User;
import vo.UserSub;

public class UsersDAO {

	private DBConnectionMgr pool;

	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private String sql;
	private int loNum;

	public int locNum() {
		return loNum;
	}
	public UsersDAO() {

		try {
			pool = DBConnectionMgr.getInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}

	} // UsersDAO();
	public boolean loginCheck(String id, String passwd) {
		// 1.DB 연결
				boolean check = false;
				int loNum;
				_Login lo = new _Login();
				// 2.SQL 처리
				try {
					con = pool.getConnection(); // 만들어진 Connection객체를 반환 시키는것
					System.out.println("con=>" + con);
					sql = "select lo.id,lo.pw,lo.salt,us.location_no from login as lo join users as us on (lo.user_no = us.`no`) where lo.id = ?";
					//select 
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, id);
					rs = pstmt.executeQuery();
//					check = rs.next(); // 데이터가 존재 => true or 없으면 -> false
					if(rs.next()) {
						Login login = new Login();
						login.setPw(rs.getString(2));
						login.setSalt(rs.getString(3));
						check = login.isPassword(passwd);
						Location loc = new Location();
						loc.setNo(rs.getInt(4));
						this.loNum = loc.getNo();
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					// 3.메모리해제
					pool.freeConnection(con, pstmt, rs);
				}
				return check;
	}
	
	public boolean insertUser(User user, _Login _login, UserSub userSub) {

		boolean result = false;

		try {

			con = pool.getConnection();
			sql = "INSERT INTO users (gender,`both`,location_no) VALUES (?,?,?)";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, Character.toString(user.getGender()));
			pstmt.setDate(2, user.getBoth());
			pstmt.setInt(3, user.getLocation().getNo());
			if (pstmt.executeUpdate() == 0) {
				return false;
			} else {
				System.out.println("user테이블 입력 성공");
			}
			pstmt.close();

			sql = "INSERT INTO login (user_no, id, pw, salt) VALUES (LAST_INSERT_ID(), ?, ?, ?)";

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, _login.getId());
			pstmt.setString(2, _login.getPw());
			pstmt.setString(3, _login.getSalt());

			if (pstmt.executeUpdate() == 0) {
				return false;
			} else {
				System.out.println("_login 테이블 입력 성공");
			}
			pstmt.close();

			sql = "INSERT INTO users_sub (user_no, phone, regdate) VALUES (LAST_INSERT_ID(), ?, ?)";

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, userSub.getPhone());
			pstmt.setTimestamp(2, userSub.getRegdate());

			result = pstmt.executeUpdate() != 0;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}

		return result;

	} // insertUser();

	public List<User> selectUser() {

		List<User> result = new ArrayList<>();

		try {
			con = pool.getConnection();
			pstmt = con.prepareStatement("SELECT no, gender, `both`, location_no `location.no`, credential FROM users");
			rs = pstmt.executeQuery();
			if (rs.next()) {

				System.out.println(new User().setByResultSet(rs));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}

		return result;

	} // selectUser();

} // class UsersDAO;
