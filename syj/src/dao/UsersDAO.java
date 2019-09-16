package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DBConnectionMgr;
import vo.User;


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
	
	public boolean insertUser(User user) {
		
		boolean result = false;
		sql = "INSERT INTO users(id, pw, salt, addr, phone, gender, both, email, location_no, credential_file) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			
			con = pool.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPw());
			pstmt.setString(3, user.getSalt());
			pstmt.setString(4, user.getAddr());
			pstmt.setString(5, user.getPhone());
			pstmt.setString(6, Character.toString(user.getGender()));
			pstmt.setDate(7, user.getBoth());
			pstmt.setString(8, user.getEmail());
			pstmt.setInt(9, user.getLocation().getNo());
			pstmt.setString(10, user.getCredentialFile());
			
			result = pstmt.executeUpdate() != 0;
			
		}
		catch (Exception e) { e.printStackTrace(); }
		finally { pool.freeConnection(con, pstmt, rs); }
		
		return result;
		
	} //insertUser();
	
} //class UsersDAO;
