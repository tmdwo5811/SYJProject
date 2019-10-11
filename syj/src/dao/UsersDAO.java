package dao;

import java.sql.Connection;
import java.sql.Date;
//import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DBConnectionMgr;
import vo.Location;
import vo._Login;
import vo.User;
import vo.UserSub;

public class UsersDAO {

	private DBConnectionMgr pool;

	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private String sql;

	public UsersDAO() {

		try {
			pool = DBConnectionMgr.getInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}

	} // UsersDAO();

	public boolean insertUser(User user, _Login _login, UserSub userSub) {

		boolean result = false;

		try {

			con = pool.getConnection();
			sql = "INSERT INTO users (gender,both,location_no) VALUES (?,?,?)";
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, user.getGender());
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
