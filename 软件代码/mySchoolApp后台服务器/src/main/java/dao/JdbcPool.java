package dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.sql.DataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;


public class JdbcPool {
	
	public static DataSource source;
	
	static{
           Properties properties=new Properties();
		   InputStream is=JdbcPool.class.getClassLoader().getResourceAsStream("jdbc.properties");
		   try {
			  properties.load(is);
			  source=DruidDataSourceFactory.createDataSource(properties);
			  } catch (Exception e) {
			 e.printStackTrace();
		   }
	    }
	
	public static Connection getConnection() throws SQLException
	{
		Connection con;
			con = source.getConnection();
		return con;
	}
	
	
	
	//关闭连接
		public static void closeSoucre(Connection con,Statement statem)
		{
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
				}
			if(statem!=null)
				try {
					statem.close();
				} catch (SQLException e) {
				}
			
			
		}
	
	
	public static void closeSoucre(Connection con,Statement statem,ResultSet rs)
	{
		if(con!=null)
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if(statem!=null)
			try {
				 statem.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if(rs!=null)
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}
	
	
	public static void myRollback(Connection con)
	{
		try {
			con.rollback();}
		catch (SQLException e1) {}
	finally{
		if(con!=null)
			try {
				con.close();
			} catch (SQLException e) {
			}
	       }	
	}
	
	
	

}
