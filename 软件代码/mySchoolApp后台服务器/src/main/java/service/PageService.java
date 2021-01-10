package service;

import java.util.List;

import bean.Book_list;
import bean.Recruit_list;

public interface PageService {

	public List<Book_list> getBook();
	public List<Recruit_list> getRecruit();
	public boolean login(String account, String password);
	public List<Book_list> getBook2();
}
