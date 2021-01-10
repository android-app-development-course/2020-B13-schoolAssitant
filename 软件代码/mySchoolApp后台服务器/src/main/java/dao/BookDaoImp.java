package dao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import org.junit.jupiter.api.Test;
import bean.Book_list;

public class BookDaoImp extends BaseDao<Book_list> implements BookDao{

	@Test
	public void buy()
	{
		Connection con;
		try {
		   
		con = JdbcPool.getConnection();
		/*
		Book_list a=new Book_list(1,"20182131106","java从入门到放弃","编程","这本书适合初学者",new Date(System.currentTimeMillis()),50,null,null,null);
		Book_list b=new Book_list(2,"20182131107","C#从入门到放弃","编程","这本书适合初学者",new Date(System.currentTimeMillis()),50,null,null,null);
		Book_list c=new Book_list(3,"20182131108","C从入门到放弃","数学","这本书适合初学者",new Date(System.currentTimeMillis()),50,null,null,null);
		Book_list d=new Book_list(4,"20182131109","C++从入门到放弃","文学","这本书适合初学者",new Date(System.currentTimeMillis()),50,null,null,null);
		Book_list e=new Book_list(5,"20182131110","PHP从入门到放弃","编程","这本书适合初学者",new Date(System.currentTimeMillis()),50,null,null,null);
		Book_list f=new Book_list(6,"20182131110","PHP从入门到放弃","语文","这本书适合初学者",new Date(System.currentTimeMillis()),50,null,null,null);
		insert(con,a);
		insert(con,b);
		insert(con,c);
		insert(con,d);
		insert(con,e);
		insert(con,f);
		
		
		Statement s=con.createStatement();
		ResultSet t=s.executeQuery("select * from book_list");
		while(t.next())
			System.out.println(new Date(t.getString(6)));
		
		*/
		System.out.println("-------------------所有书---------------------------------");
		List<Book_list> list=queryAll(con);
		for (Book_list book_list : list) {
			System.out.println(book_list);
		}
		System.out.println("-------------------编程类---------------------------------");
		List<Book_list> list1=queryByType(con,"编程");
		for (Book_list book_list : list1) {
			System.out.println(book_list);
		}
		System.out.println("--------------------PHP从入门到放弃--------------------------------");
		List<Book_list> list2=queryByName(con,"PHP从入门到放弃");
		for (Book_list book_list : list2) {
			System.out.println(book_list);
		}
		System.out.println("-------------------所有书---------------------------------");
		List<Book_list> list3=queryAll(con);
		for (Book_list book_list : list3) {
			System.out.println(book_list);
		}
		}catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	
	
	@Override
	public boolean insert(Connection con, Book_list book) {
		try {
			int id=getbookId(con)+1;
			String sql="insert into book_list(book_user_account,book_name,book_type,book_information,book_price,book_date,book_id) values(?,?,?,?,?,?,?)";
			Object[] arg=new Object[7];
			arg[0]=book.getBook_user_account();
			arg[1]=book.getBook_name();
			arg[2]=book.getBook_type();
			arg[3]=book.getBook_information();
			arg[4]=book.getBook_price();
			arg[5]=book.getBook_date();
			arg[6]=id;
			Updata(con,sql,arg);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Connection con, int id) {
		try {
			String sql="delete from book_list where book_id=?";
			Updata(con,sql,id);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	
	}

	@Override
	public List<Book_list> queryByType(Connection con,String type){
		String sql="select * from book_list where book_type=? order by book_id desc";
		List<Book_list> list;
		try {
			list = Select(con, sql,type);
			return list;
		} catch (SQLException e) {
			return null;
		}
	}

	@Override
	public List<Book_list> queryAll(Connection con) {
		String sql="select * from book_list order by book_id desc";
		List<Book_list> list;
		try {
			list = Select(con, sql);
			return list;
		} catch (SQLException e) {
			return null;
		}
	}

	@Override
	public List<Book_list> queryByName(Connection con,  String name) {
	
		String sql="select * from book_list where book_name=? order by book_id desc";
		List<Book_list> list;
		try {
			list = Select(con, sql,name);
			return list;
		} catch (SQLException e) {
			return null;
		}
	}
	
	@Override
	public boolean changeState(Connection con,int state,int id) {
		try {
			String sql="update book_list set book_state=? where book_id=?";
			Updata(con,sql,state,id);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}



	@Override
	public List<Book_list> queryAll2(Connection con) {
		String sql="select * from book_list where book_state=0 order by book_id desc";
		List<Book_list> list;
		try {
			list = Select(con, sql);
			return list;
		} catch (SQLException e) {
			return null;
		}
	}



	@Override
	public int getbookId(Connection con) {
		 try {
			 String sql="select * from book_list order by book_id DESC limit 1";
				int num;
				List<Book_list> list=Select(con,sql);
				if(list!=null&&list.size()>0)
				{
					Book_list t=list.get(0);
					num=t.getBook_id();
				}else num=0;
				return num;
			} catch (Exception e) {
				e.printStackTrace();
				return 0;
			}
	}



	@Override
	public List<Book_list> queryUserBook(Connection con, String account) {
		String sql="select * from book_list where book_user_account=?";
		List<Book_list> list;
		try {
			list = Select(con, sql,account);
			return list;
		} catch (SQLException e) {
			return null;
		}
	}



	@Override
	public Book_list queryBookById(Connection con, int id) {
		String sql="select * from book_list where book_id=?";
		Book_list list;
		try {
			list = getInstance(con, sql,id);
			return list;
		} catch (SQLException e) {
			return null;
		}
	}

	
}
