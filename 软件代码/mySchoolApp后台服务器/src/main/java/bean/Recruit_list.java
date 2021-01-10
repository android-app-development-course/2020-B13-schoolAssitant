package bean;
import java.util.Arrays;

public class Recruit_list {
	//招募表
	private Integer recruit_id;
	private String recruit_title;
	private String recruit_user;
	private String recruit_user_account;
	private String recruit_information;
	private String recruit_date;
	
	public Recruit_list() {
		super();
	}
	


	public Recruit_list(Integer recruit_id, String recruit_title, String recruit_userString,
			String recruit_user_account, String recruit_information, String recruit_date, byte[] recruit_picture1,
			byte[] recruit_picture2, byte[] recruit_picture3) {
		super();
		this.recruit_id = recruit_id;
		this.recruit_title = recruit_title;
		this.recruit_user = recruit_userString;
		this.recruit_user_account = recruit_user_account;
		this.recruit_information = recruit_information;
		this.recruit_date = recruit_date;
	}




	public int getRecruit_id() {
		return recruit_id;
	}
	public void setRecruit_id(int recruit_id) {
		this.recruit_id = recruit_id;
	}
	public String getRecruit_user_account() {
		return recruit_user_account;
	}
	public void setRecruit_user_account(String recruit_user_account) {
		this.recruit_user_account = recruit_user_account;
	}
	public String getRecruit_information() {
		return recruit_information;
	}
	public void setRecruit_information(String recruit_information) {
		this.recruit_information = recruit_information;
	}
	public String getRecruit_date() {
		return recruit_date;
	}

	public void setRecruit_date(String recruit_date) {
		this.recruit_date = recruit_date;
	}
	
	public String getRecruit_title() {
		return recruit_title;
	}

	public void setRecruit_title(String recruit_title) {
		this.recruit_title = recruit_title;
	}

	public String getRecruit_user() {
		return recruit_user;
	}

	public void setRecruit_user(String recruit_user) {
		this.recruit_user = recruit_user;
	}

	public void setRecruit_id(Integer recruit_id) {
		this.recruit_id = recruit_id;
	}

	@Override
	public String toString() {
		return "Recruit_list [recruit_id=" + recruit_id + ", recruit_title=" + recruit_title + ", recruit_user_account="
				+ recruit_user_account + ", recruit_information=" + recruit_information + ", recruit_date="
				+ recruit_date+"]";
	}
	
	
	
}

