package bean;

public class User_list {
	private String user_account;
	private String user_password;
	private String user_college;
	private String user_nicheng;
	private String user_email;
	
	public User_list() {
		super();
	}

	public User_list(String user_account, String user_password, String user_college, String user_nicheng,
			String user_email) {
		super();
		this.user_account = user_account;
		this.user_password = user_password;
		this.user_college = user_college;
		this.user_nicheng = user_nicheng;
		this.user_email = user_email;
	}

	public String getUser_account() {
		return user_account;
	}

	public void setUser_account(String user_account) {
		this.user_account = user_account;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getUser_college() {
		return user_college;
	}

	public void setUser_college(String user_college) {
		this.user_college = user_college;
	}

	public String getUser_nicheng() {
		return user_nicheng;
	}

	public void setUser_nicheng(String user_nicheng) {
		this.user_nicheng = user_nicheng;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	@Override
	public String toString() {
		return "User_list [user_account=" + user_account + ", user_password=" + user_password + ", user_college="
				+ user_college + ", user_nicheng=" + user_nicheng + ", user_email=" + user_email + "]";
	}
	
}

