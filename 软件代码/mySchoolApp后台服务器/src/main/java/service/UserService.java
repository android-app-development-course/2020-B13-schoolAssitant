package service;
import java.util.List;
import bean.Book_list;
import bean.Order_list;
import bean.Recruit_list;
import bean.User_list;

public interface UserService {
	
	//登录
	public boolean login(String account,String password);
	
	//获得指定用户
	public User_list getUser(String account);
	
	//注册
	public boolean register(User_list user);
	
	//修改信息
	public boolean ModifyInformation(User_list user);
	//出售书籍
	public int SellBook(Book_list book);
	//删除发布的课本
	public boolean DelBook(int id);
	
	//删除招募信息
	public boolean DelRecruit(int id);
	
	//订书
	public boolean OrderBook(Order_list order);
	//删除订单
	public boolean DelOrder(int id);
	//所有招募信息
		public List<Recruit_list> getRecruit();
	//发布招募信息
	public int Recruitment(Recruit_list recruit);
	//我的招募信息
	public List<Recruit_list> getMyRecruit(String account);
	//我出售的课本
	public List<Book_list> getMyBook(String account);
	//我的订单
	public List<Order_list> MyOrder(String account);
	//按类型查询书本
	public List<Book_list> QueryBookByType(String type);
	//按名字查询课本
	public List<Book_list> QueryBookByName(String name);
	
	public byte[] getUserPicture();
	public Book_list getOneBook(int id);
	
}
