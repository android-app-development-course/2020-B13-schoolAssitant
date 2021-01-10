package service;

import java.util.List;
import java.util.Map;

import bean.Picture_list;

public interface PictureService {
	
	public byte[] getPicture(String url,String name);
	public boolean SavePicture(String url,String name,byte[] bytes);
	public boolean delPicture(String url,String name);
	public List<Picture_list> getAllBookPicture(String url);
	public List<Picture_list> getAllRecruitPicture(String url);

}
