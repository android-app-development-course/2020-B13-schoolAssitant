package dao;

import java.sql.Connection;
import java.util.List;

import bean.Recruit_list;

public interface RecruitDao {
	public boolean insert(Connection con,Recruit_list recruit);
	public boolean deleteById(Connection con,int id);
	public int getRecruitId(Connection con);
	public List<Recruit_list> queryAll(Connection con);
	public List<Recruit_list> querySome(Connection con,int start,int end);
	public List<Recruit_list> queryMyRecruit(Connection con,String account);
}

