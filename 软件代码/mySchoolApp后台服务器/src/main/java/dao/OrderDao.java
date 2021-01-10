package dao;

import java.sql.Connection;
import java.util.List;

import bean.Order_list;

public interface OrderDao {
	public boolean insert(Connection con,Order_list order);
	public boolean deleteById(Connection con,int id);
	public int getorderId(Connection con);
	public List<Order_list> queryAll(Connection con);
	public List<Order_list> queryById(Connection con,int id);
	public List<Order_list> querySome(Connection con,int start,int end);
	public List<Order_list> queryByUserAccount(Connection con,String account);
	public boolean queryOrder(Connection con,String account,String book_id);
	
	
}