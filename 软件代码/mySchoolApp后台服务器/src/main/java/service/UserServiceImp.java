package service;
import static org.hamcrest.CoreMatchers.nullValue;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import bean.Book_list;
import bean.Order_list;
import bean.Recruit_list;
import bean.User_list;
import dao.BookDaoImp;
import dao.JdbcPool;
import dao.OrderDaoImp;
import dao.RecruitDaoImp;
import dao.UserDaoImp;

public class UserServiceImp implements UserService{
	Connection con=null;
	UserDaoImp userDao;
	OrderDaoImp orderDao;
	RecruitDaoImp recruitDao;
	BookDaoImp bookDao;
	PictureServiceImp picture;
	
	
	
	public UserServiceImp() {
		userDao=new UserDaoImp();
		orderDao=new OrderDaoImp();
		recruitDao=new RecruitDaoImp();
		bookDao=new BookDaoImp();
		picture=new PictureServiceImp();
	}

	@Override//修改用户信息
	public boolean ModifyInformation(User_list user) {
		try {
			con=JdbcPool.getConnection();
			boolean result=userDao.updataByAccount(con, user);
			con.close();
			return result;
		} catch (SQLException e) {
			return false;
		}
	}

	
	@Override//发布书本，
	public int SellBook(Book_list book) {
		try {
			int num=0;
			con=JdbcPool.getConnection();
			con.setAutoCommit(false);
			boolean result=bookDao.insert(con, book);
			if(result)
			num=bookDao.getbookId(con);
			con.commit();
			con.close();
			return num;
		} catch (Exception e) {
			JdbcPool.myRollback(con);		
			e.printStackTrace();
			return 0;
		}
		
	}
	
	public boolean DelBook(int id) {
		try {
			con=JdbcPool.getConnection();
			con.setAutoCommit(false);
			boolean result1=bookDao.delete(con,id);
			boolean result2=picture.delPicture("D://pictureApp/book/",String.valueOf(id));
			con.commit();
			con.close();
			boolean result=result1&&result2;
			return result;
		} catch (Exception e) {
			JdbcPool.myRollback(con);		
			e.printStackTrace();
			return false;
		}
		
	}
	
	@Override//订书
	public boolean OrderBook(Order_list order) {
		try {
			con=JdbcPool.getConnection();
			boolean t=orderDao.queryOrder(con,order.getOrder_user_account()
					,String.valueOf(order.getOrder_book_id()));
			if(t)
			{
			boolean result=orderDao.insert(con, order);
			con.close();
			return result;}
			else
				return false;
		} catch (SQLException e) {
			JdbcPool.myRollback(con);			
			return false;
		}
	}

	
	@Override//删除订单
	public boolean DelOrder(int id) {
		try {
			con=JdbcPool.getConnection();
			con.setAutoCommit(false);
			boolean result=orderDao.deleteById(con, id);
			boolean result2=bookDao.changeState(con,0, id);
			boolean result3=result&&result2;
			con.commit();
			con.close();
			return result3;
		} catch (SQLException e) {
			JdbcPool.myRollback(con);			
			return false;
		}
	}

	
	@Override//我的订单
	public List<Order_list> MyOrder(String account) {
		try {
			con=JdbcPool.getConnection();
			con.setAutoCommit(false);
			List<Order_list> result=orderDao.queryByUserAccount(con,account);
			con.commit();
			con.close();
			return result;
		} catch (SQLException e) {
			JdbcPool.myRollback(con);			
			return null;
		}
		
	}

	
	@Override//查询课本
	public List<Book_list> QueryBookByType(String type) {
		try {
			con=JdbcPool.getConnection();
			con.setAutoCommit(false);
			List<Book_list> result=bookDao.queryByType(con, type);
			con.commit();
			con.close();
			return result;
		} catch (SQLException e) {
			JdbcPool.myRollback(con);			
			return null;
		}
	}
	
	//按名字查询课本
	public List<Book_list> QueryBookByName(String name)
	{
		try {
			con=JdbcPool.getConnection();
			con.setAutoCommit(false);
			List<Book_list> result=bookDao.queryByName(con, name);
			con.commit();
			con.close();
			return result;
		} catch (SQLException e) {
			JdbcPool.myRollback(con);			
			return null;
		}
	}
	
	@Override//获得所有招募信息
	public List<Recruit_list> getRecruit() {
		try {
			con=JdbcPool.getConnection();
			con.setAutoCommit(false);
			List<Recruit_list> result=recruitDao.queryAll(con);
			con.commit();
			con.close();
			return result;
		} catch (SQLException e) {
			JdbcPool.myRollback(con);			
			return null;
		}
		
	}
	
	@Override//获得我的发布的招募信息
	public List<Recruit_list> getMyRecruit(String account) {
		try {
			con=JdbcPool.getConnection();
			con.setAutoCommit(false);
			List<Recruit_list> result=recruitDao.queryMyRecruit(con, account);
			con.commit();
			con.close();
			return result;
		} catch (SQLException e) {
			JdbcPool.myRollback(con);			
			return null;
		}
	}

	
	@Override//发布招募
	public int Recruitment(Recruit_list recruit) {
		try {
			int num=0;
			con=JdbcPool.getConnection();
			con.setAutoCommit(false);
			boolean result1=recruitDao.insert(con,recruit);
			if(result1)
				num=recruitDao.getRecruitId(con);
			con.commit();
			con.close();
			return num;
		} catch (SQLException e) {
			JdbcPool.myRollback(con);	
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<Book_list> getMyBook(String account) {
		try {
			con=JdbcPool.getConnection();
			con.setAutoCommit(false);
			List<Book_list> result=bookDao.queryUserBook(con,account);
			con.commit();
			con.close();
			return result;
		} catch (SQLException e) {
			JdbcPool.myRollback(con);			
			return null;
		}
	}

	@Override
	public boolean DelRecruit(int id) {
		try {
			boolean result = false;
			con=JdbcPool.getConnection();
			con.setAutoCommit(false);
			boolean result1=recruitDao.deleteById(con, id);
			boolean result2=picture.delPicture("D://pictureApp/recruit/",String.valueOf(id));
			result1=result1&&result2;
			con.commit();
			con.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			JdbcPool.myRollback(con);			
			return false;
		}
	}

	@Override
	public boolean login(String account, String password) {
		try {
			con=JdbcPool.getConnection();
			User_list user=userDao.queryUser(con, account, password);
			if(user==null)
				return false;
			else 
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	//获得指定用户
		public User_list getUser(String account) {
			try {
				con=JdbcPool.getConnection();
				User_list user=userDao.queryUserByAccount(con, account);
				System.out.println(user);
				return user;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
	

	@Override
	public boolean register(User_list user) {
		try {
			con=JdbcPool.getConnection();
			User_list stu=userDao.queryUserByAccount(con, user.getUser_account());
			if(stu==null)
			{
				boolean result=userDao.insert(con, user);
			    return result;
			}
			else {
				return false;
			}
		} catch (SQLException e) {
			return false;
		}
	}

	@Override
	public byte[] getUserPicture(){
		
		return userDao.gPicture(con);
	}

	@Override
	public Book_list getOneBook(int id) {
		try {
			con=JdbcPool.getConnection();
			Book_list list=bookDao.queryBookById(con,id);
			con.close();
			return list;
		} catch (SQLException e) {
			return null;
		}
	}	
}
