package service;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import bean.Book_list;
import bean.Recruit_list;
import bean.User_list;
import dao.BookDaoImp;
import dao.JdbcPool;
import dao.RecruitDaoImp;
import dao.UserDaoImp;

public class PageServiceImp implements PageService{
	
	Connection con=null;
	BookDaoImp bookDao;
	RecruitDaoImp recruitDao;
	UserDaoImp userLogin;

	public PageServiceImp() {
		bookDao=new BookDaoImp();
		recruitDao=new RecruitDaoImp();
		userLogin=new UserDaoImp();
	}
	
	@Override
	public List<Book_list> getBook() {
		try {
			con=JdbcPool.getConnection();
			List<Book_list> list=bookDao.queryAll(con);
			con.close();
			return list;
		} catch (SQLException e) {
			return null;
		}
	}

	@Override
	public List<Recruit_list> getRecruit() {
		try {
			con=JdbcPool.getConnection();
			List<Recruit_list> list=recruitDao.queryAll(con);
			con.close();
			return list;
		} catch (SQLException e) {
			return null;
		}
	}

	@Override
	public boolean login(String account, String password) {
		try {
			con=JdbcPool.getConnection();
			User_list user=userLogin.queryUser(con, account, password);
			if(user==null)
				return false;
			else 
				return true;
		} catch (SQLException e) {
			return false;
		}
	}

	@Override
	public List<Book_list> getBook2() {
		try {
			con=JdbcPool.getConnection();
			List<Book_list> list=bookDao.queryAll2(con);
			con.close();
			return list;
		} catch (SQLException e) {
			return null;
		}
	}

	

}
