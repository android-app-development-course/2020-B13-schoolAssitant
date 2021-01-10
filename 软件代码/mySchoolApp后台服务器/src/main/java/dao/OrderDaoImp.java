package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import org.junit.jupiter.api.Test;

import com.alibaba.fastjson.JSON;

import bean.Book_list;
import bean.Order_list;
import service.UserServiceImp;

public class OrderDaoImp extends BaseDao<Order_list> implements OrderDao{
	
	@Test
	public void mytest() {
		
		
		UserServiceImp use=new UserServiceImp();
		Order_list order=new Order_list(3,"20182131106",2,"200000");
		boolean a=use.OrderBook(order);
		System.out.println(a);
		
		
		Connection con;
		
		try {
		con = JdbcPool.getConnection();
		/*
		Order_list a=new Order_list(1,"20182131106",1,new Date(System.currentTimeMillis()));
		Order_list b=new Order_list(2,"20182131106",1,new Date(System.currentTimeMillis()));
		Order_list c=new Order_list(3,"20182131106",1,new Date(System.currentTimeMillis()));
		Order_list d=new Order_list(4,"20182131106",1,new Date(System.currentTimeMillis()));
		Order_list e=new Order_list(5,"20182131106",1,new Date(System.currentTimeMillis()));
		Order_list f=new Order_list(6,"20182131106",1,new Date(System.currentTimeMillis()));
		insert(con, a);
		insert(con, b);
		insert(con, c);
		insert(con, d);
		insert(con, e);
		insert(con, f);
		*/
		
		String orderStr="{order_id:2,order_user_account:'1',order_book_id:1,order_date:'2020-12-11'}";
		Order_list getOrder=JSON.parseObject(orderStr,Order_list.class);
		insert(con,getOrder);
		System.out.println(getOrder);
		
		List<Order_list> list= queryAll(con);
		System.out.println("----------------所有---------------");
		for (Order_list book_order_list : list) {
			System.out.println(book_order_list);
		}
		/*
		List<Order_list> list2= querySome(con,2,3);
		System.out.println("----------------部分---------------");
		for (Order_list book_order_list : list2) {
			System.out.println(book_order_list);
		}
		
		deleteById(con, 2);
		deleteById(con, 3);
		
		System.out.println("----------------所有---------------");
		for (Order_list book_order_list : list) {
			System.out.println(book_order_list);
		}*/
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	

	@Override
	public boolean insert(Connection con, Order_list order) {
		try {
			int id=getorderId(con);
			id=id+1;
			String sql="insert into order_list(order_id,order_user_account,order_book_id,order_date) values(?,?,?,?)";
			Object[]args=new Object[4];
			args[0]=id;
			args[1]=order.getOrder_user_account();
			args[2]=order.getOrder_book_id();
			args[3]=order.getOrder_date();
			Updata(con,sql,args);
			return true;
		} catch (SQLException e) {
			return false;
		}
		
	}

	@Override
	public boolean deleteById(Connection con, int id) {
		try {
			String sql="delete from order_list where order_id=?";
			Updata(con,sql,id);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	@Override
	public List<Order_list> queryAll(Connection con) {
		String sql="select * from order_list";
		List<Order_list> list;
		try {
			list = Select(con, sql);
			return list;
		} catch (SQLException e) {
			return null;
		}
	}

	@Override
	public List<Order_list> queryById(Connection con, int id) {
	
		String sql="select * from order_list where order_id=?";
		List<Order_list> list;
		try {
			list = Select(con, sql,id);
			return list;
		} catch (SQLException e) {
			return null;
		}
	}

	@Override
	public List<Order_list> querySome(Connection con, int start, int end) {
		
		String sql="select * from order_list limit ?,?";
		List<Order_list> list;
		try {
			list = Select(con, sql,start,end);
			return list;
		} catch (SQLException e) {
			return null;
		}
	}



	@Override
	public List<Order_list> queryByUserAccount(Connection con, String account) {
		String sql="select * from order_list where order_user_account=?";
		List<Order_list> list;
		try {
			list = Select(con, sql,account);
			return list;
		} catch (SQLException e) {
			return null;
		}
	}

	
	
	
	public int getorderId(Connection con) {
		 try {
			 String sql="select * from order_list order by order_id DESC limit 1";
				int num;
				List<Order_list> list=Select(con,sql);
				if(list!=null&&list.size()>0)
				{
					Order_list t=list.get(0);
					num=t.getOrder_id();
				}else num=0;
				return num;
			} catch (Exception e) {
				e.printStackTrace();
				return 0;
			}
	}



	@Override
	public boolean queryOrder(Connection con, String account, String book_id) {
		String sql="select * from order_list where order_user_account=? and order_book_id=?";
		System.out.println(sql);
		try {
			List<Order_list> list;
			list = Select(con, sql,account,book_id);
			if(list.size()==0||list==null)
				return true;
			else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}


}
