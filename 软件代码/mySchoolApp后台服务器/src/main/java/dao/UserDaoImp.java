package dao;
import static org.hamcrest.CoreMatchers.nullValue;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import org.junit.jupiter.api.Test;
import bean.User_list;
import service.MyImage;

import com.alibaba.fastjson.*;

public class UserDaoImp extends BaseDao<User_list> implements UserDao{
	
	@Test
	public void myetest()
	{
		
		Connection con;
		try {
			
			
			
		con = JdbcPool.getConnection();
		/*
		User_list a=new User_list("20182131106","123456","计算机学院","爸爸","1126458841@qq.com");
		User_list b=new User_list("20182131107","123456","计算机学院","爸爸1","1126458841@qq.com");
		User_list c=new User_list("20182131108","123456","计算机学院","爸爸2","1126458841@qq.com");
		User_list d=new User_list("20182131109","123456","计算机学院","爸爸3","1126458841@qq.com");
		User_list e=new User_list("20182131110","123456","计算机学院","爸爸4","1126458841@qq.com");
		
		insert(con,a);
		insert(con,b);
		insert(con,c);
		insert(con,d);
		insert(con,e);
		*/
		
		pPicture(con);
		gPicture(con);
		
		List<User_list> list=queryAll(con);
		System.out.println("----------------所有---------------");
		for (User_list user_list : list) {
			System.out.println(user_list);
		}
		String str=JSON.toJSONString(list);
		System.out.println(str);
		}
		/*
		deleteByAccount(con, "20182131106");
		deleteByAccount(con, "20182131107");
		
		c.setUser_nicheng("梁登光是神");
		c.setUser_password("123456789");
		updataByAccount(con, c);
		
		System.out.println("----------------所有---------------");
		List<User_list> list3=queryAll(con);
		for (User_list user_list : list3) {
			System.out.println(user_list);}
		}*/
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public boolean insert(Connection con,User_list user) {
		try {
			String sql="insert into user_list(user_account,user_password,user_college,user_nicheng,user_email) values(?,?,?,?,?)";
			Object[]args=new Object[5];
			args[0]=user.getUser_account();
			args[1]=user.getUser_password();
			args[2]=user.getUser_college();
			args[3]=user.getUser_nicheng();
			args[4]=user.getUser_email();
			Updata(con,sql,args);
			return true;
		} catch (SQLException e) {
			return false;
		}
		
	}

	@Override
	public boolean deleteByAccount(Connection con,String account) {
		try {
			String sql="delete from user_list where user_account=?";
			Updata(con,sql,account);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	@Override
	public boolean updataByAccount(Connection con,User_list user) {
		try {
			String sql="update user_list set user_password=?,user_college=?,user_nicheng=?,user_email=? where user_account=?";
			Object[] args=new Object[5];
			args[0]=user.getUser_password();
			args[1]=user.getUser_college();
			args[2]=user.getUser_nicheng();
			args[3]=user.getUser_email();
			args[4]=user.getUser_account();
			Updata(con,sql,args);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	@Override
	public User_list queryUserByAccount(Connection con, String account) {
		
		String sql="select * from user_list where user_account=?";
		User_list st;
		try {
			st =  getInstance(con, sql,account);
			return st;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<User_list> queryAll(Connection con) {
		String sql="select * from user_list";
		List<User_list> list;
		try {
			list =Select(con, sql);
			return list;
		} catch (SQLException e) {
			return null;
		}
	}

	@Override
	public User_list queryUser(Connection con, String account, String password) {
		String sql="select * from user_list where user_account=? and user_password=?";
		User_list st;
		try {
			st =  getInstance(con, sql,account, password);
			return st;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void pPicture(Connection con) {
		String sql="update user_list set user_picture=? where user_account=?";
		 MyImage x=new MyImage();
		 byte[] arg=x.image2byte("D://3.jpg");
		 System.out.println(arg);
		try {
			PreparedStatement pre=con.prepareStatement(sql);
			pre.setBytes(1, arg);
			pre.setString(2, "20182131108");
			pre.execute();
			
			System.out.println("------------------>成功");
		} catch (SQLException e) {
			System.out.println("------------------>错误");
			e.printStackTrace();
			
		}
		
	}

	@Override
	public byte[] gPicture(Connection con) {
		String sql="select  user_picture from user_list where user_account=20182131108";
		byte[] list=new byte[1024];
		try {
			Statement statement=con.createStatement();
			ResultSet resultSet=statement.executeQuery(sql);
			if(resultSet.next())
				list=resultSet.getBytes(1);
			System.out.println(list+"---------------------成功");
			System.out.println(list);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	

}
