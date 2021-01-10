package dao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import org.junit.jupiter.api.Test;

import bean.Book_list;
import bean.Recruit_list;

public class RecruitDaoImp extends BaseDao<Recruit_list> implements RecruitDao{
	
	@Test
	public void mytest()
	{
		Connection con;
		try {
		con = JdbcPool.getConnection();/*
		Recruit_list a=new Recruit_list(1,"20182131106","广告",new Date(System.currentTimeMillis()),null,null,null);
		Recruit_list b=new Recruit_list(2,"20182131106","竞赛招募",new Date(System.currentTimeMillis()),null,null,null);
		Recruit_list c=new Recruit_list(3,"20182131106","科研项目招募",new Date(System.currentTimeMillis()),null,null,null);
		Recruit_list d=new Recruit_list(4,"20182131106","啦啦队招募",new Date(System.currentTimeMillis()),null,null,null);
		
		insert(con, a);
		insert(con, b);
		insert(con, c);
		insert(con, d);
		*/
		
		List<Recruit_list> list=queryAll(con);
		System.out.println("----------------所有---------------");
		for (Recruit_list recruit_list : list) {
			System.out.println(recruit_list);
		}
		List<Recruit_list> list2= querySome(con,2,3);
		System.out.println("----------------部分---------------");
		for (Recruit_list recruit_list : list2) {
			System.out.println(recruit_list);
		}
		
		deleteById(con, 2);
		deleteById(con, 3);
		
		System.out.println("----------------所有---------------");
		List<Recruit_list> list3=queryAll(con);
		for (Recruit_list recruit_list : list3) {
			System.out.println(recruit_list);
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	
	

	@Override
	public boolean insert(Connection con, Recruit_list recruit) {
		try {
			int id=getRecruitId(con)+1;
			String sql="insert into recruit_list(recruit_title,recruit_user,recruit_user_account,recruit_information,recruit_date,recruit_id) values(?,?,?,?,?,?)";
			Object[]args=new Object[6];
			args[0]=recruit.getRecruit_title();
			args[1]=recruit.getRecruit_user();
			args[2]=recruit.getRecruit_user_account();
			args[3]=recruit.getRecruit_information();
			args[4]=recruit.getRecruit_date();
			args[5]=id;
			Updata(con,sql,args);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	@Override
	public boolean deleteById(Connection con, int id) {
		try {
			String sql="delete from recruit_list where recruit_id=?";
			Updata(con,sql,id);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	@Override
	public List<Recruit_list> queryAll(Connection con) {
		
		String sql="select * from recruit_list order by recruit_id desc";
		List<Recruit_list> list;
		try {
			list = Select(con, sql);
			return list;
		} catch (SQLException e) {
			return null;
		}
	}

	@Override
	public List<Recruit_list> querySome(Connection con, int start, int end) {
		
		String sql="select * from recruit_list limit ?,?";
		List<Recruit_list> list;
		try {
			list = Select(con, sql,start,end);
			return list;
		} catch (SQLException e) {
			return null;
		}
	}



	@Override
	public List<Recruit_list> queryMyRecruit(Connection con, String account) {
		String sql="select * from recruit_list where recruit_user_account=?";
		List<Recruit_list> list;
		try {
			list = Select(con, sql,account);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}



	@Override
	public int getRecruitId(Connection con) {
		try {
			String sql="select * from recruit_list order by recruit_id DESC limit 1";
				int num;
				List<Recruit_list> list=Select(con,sql);
				if(list!=null)
				{
					Recruit_list t=list.get(0);
					num=t.getRecruit_id();
				}else num=0;
			return num;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

}
