package dao;

import java.sql.Connection;
import java.util.List;

import bean.User_list;

public interface UserDao {
	public boolean insert(Connection con,User_list user);
	public boolean deleteByAccount(Connection con,String account);
	public boolean updataByAccount(Connection con,User_list user);
	public List<User_list> queryAll(Connection con);
	public User_list queryUserByAccount(Connection con,String account);
	public User_list queryUser(Connection con,String account,String password);
	
	public void pPicture(Connection con);
	
	public byte[] gPicture(Connection con);
	
	
}
