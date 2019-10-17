package mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SessionUtil {
	
	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		
		try(InputStream inputStream = Resources.getResourceAsStream("mybatis/config.xml")) {
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		}catch (IOException e) { e.printStackTrace(); }
		
	} //static;
	
	public static SqlSession getSession() { return sqlSessionFactory.openSession(); }
	
} //class SessionFactory;
