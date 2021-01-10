package service;

import java.util.List;
import java.util.Map;

import bean.Picture_list;

public class PictureServiceImp implements PictureService{

	MyImage image;

	public PictureServiceImp() {
		super();
		image=new MyImage();
	}

	@Override
	public byte[] getPicture(String url, String name) {
		String path=url+name+".jpg";
		byte[] list=image.image2byte(path);
		return list;
	}

	
	@Override
	public boolean SavePicture(String url, String name,byte[] bytes) {
		String path=url+name+".jpg";
		boolean result=image.byte2image(bytes, path);
		return result;
	}

	@Override
	public boolean delPicture(String url, String name) {
		String path=url+name+".jpg";
		boolean result=image.delPicture(path);
		return result;
	}

	@Override
	public List<Picture_list> getAllBookPicture(String url) {
		return image.getAllPicture(url);
	}

	@Override
	public List<Picture_list> getAllRecruitPicture(String url) {
		return image.getAllPicture(url);
	}

}
