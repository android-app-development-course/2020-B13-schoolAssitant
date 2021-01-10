package dao;

import java.sql.Connection;
import java.util.List;

import bean.Book_list;

public interface BookDao {
	public boolean insert(Connection con,Book_list stu);
	public boolean delete(Connection con,int id);
	public int getbookId(Connection con);
	public boolean changeState(Connection con,int state,int id);
	public List<Book_list> queryByType(Connection con,String type);
	public List<Book_list> queryAll(Connection con);
	public List<Book_list> queryAll2(Connection con);
	public List<Book_list> queryUserBook(Connection con,String account);
	public Book_list queryBookById(Connection con,int id);
	public List<Book_list> queryByName(Connection con,String name);
}
