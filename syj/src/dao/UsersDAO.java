package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DBConnectionMgr;
import vo.Location;
import vo.Login;
import vo.User;
import vo.UserSub;


public class UsersDAO {
	
	private DBConnectionMgr pool;
	
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private String sql;
	
	public UsersDAO() {
		
		try { pool = DBConnectionMgr.getInstance(); }
		catch (Exception e) { e.printStackTrace(); }
		
	} //UsersDAO();
	
	public boolean insertUser(User user, Login login, UserSub userSub) {
		
		boolean result = false;
		
		/***
		 * user, login, userSub 입력방식
		 * 입력은 다른곳에서 한뒤에 매개변수로 넘겨줘야합니다.
		 */
		
		user = new User();
		user.setGender('M');
		user.setBoth(Date.valueOf("1999-12-06"));
		user.setLocation(new Location());
		user.getLocation().setNo(4);
		
		login = new Login();
		login.setId("haseongjong99");
		login.setPasswordWithEncrypt("이 메서드로 비번을 설정하면 login객체에 암호화되서 저장됨");
		
		userSub = new UserSub();
		userSub.setAddr("미추홀구 숭의동 296-38 참좋은家 501호");
		userSub.setPhone("+82 10-4942-7332");
		userSub.setEmail("haseongjong99@gmail.com");
		
		try {
			
			sql = "아침에 버즈를 들고오는걸 깜빡했다";
			sql = "INSERT INTO users (gender, `both`, location_no) VALUES (?, ?, ?)";
			
			con = pool.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, Character.toString(user.getGender()));
			pstmt.setDate(2, user.getBoth());
			pstmt.setInt(3, user.getLocation().getNo());
			
			if(pstmt.executeUpdate() == 0) return false;
			pstmt.close();
			
			sql = "INSERT INTO login (user_no, id, pw, salt) VALUES (LAST_INSERT_ID(), ?, ?, ?)";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, login.getId());
			pstmt.setString(2, login.getPw());
			pstmt.setString(3, login.getSalt());
			
			if(pstmt.executeUpdate() == 0) return false;
			pstmt.close();
			
			sql = "INSERT INTO users_sub (user_no, addr, phone, email) VALUES (LAST_INSERT_ID(), ?, ?, ?)";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, userSub.getAddr());
			pstmt.setString(2, userSub.getPhone());
			pstmt.setString(3, userSub.getEmail());
			
			result = pstmt.executeUpdate() != 0;
			
		}
		catch (Exception e) { e.printStackTrace(); }
		finally { pool.freeConnection(con, pstmt); }
		
		return result;
		
	} //insertUser();
	
	public List<User> selectUser() {
		
		List<User> result = new ArrayList<>();
		
		try {
			con = pool.getConnection();
			pstmt = con.prepareStatement("SELECT no, gender, `both`, location_no `location.no`, credential FROM users");
			rs = pstmt.executeQuery();
			if(rs.next()) {
				
				System.out.println(new User().setByResultSet(rs));
				
			}
		}
		catch (Exception e) { e.printStackTrace(); }
		finally { pool.freeConnection(con, pstmt, rs); }
		
		return result;
		
	} //selectUser();
	
} //class UsersDAO;
