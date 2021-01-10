package bean;

import java.sql.Blob;

public class Book_list {
	//发布书的列表
	private int book_id;
	private String book_user_account;
	private String book_name;
	private String book_type;
	private String book_information;
	private int book_price;
	private String  book_date;
	private int book_state;
	
	public Book_list() {
		super();
	}

	
	public Book_list(int book_id, String book_user_account, String book_name, String book_type, String book_information,
			String book_date, int book_price,int book_state,Blob picture) {
		super();
		this.book_id = book_id;
		this.book_user_account = book_user_account;
		this.book_name = book_name;
		this.book_type = book_type;
		this.book_information = book_information;
		this.book_date = book_date;
		this.book_price = book_price;
		this.book_state=book_state;
	}



	public Book_list(int book_id, String book_user_account, String book_name, String book_type, String book_information,
			int book_price, String book_date, int book_state) {
		super();
		this.book_id = book_id;
		this.book_user_account = book_user_account;
		this.book_name = book_name;
		this.book_type = book_type;
		this.book_information = book_information;
		this.book_price = book_price;
		this.book_date = book_date;
		this.book_state = book_state;
	}


	@Override
	public String toString() {
		return "Book_list [book_id=" + book_id + ", book_user_account=" + book_user_account + ", book_name=" + book_name
				+ ", book_type=" + book_type + ", book_information=" + book_information + ", book_date=" + book_date
				+ ", book_price=" + book_price + "]";
	}

	
	public int getBook_state() {
		return book_state;
	}


	public void setBook_state(int book_state) {
		this.book_state = book_state;
	}

	
	public int  getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public String getBook_user_account() {
		return book_user_account;
	}

	public void setBook_user_account(String book_user_account) {
		this.book_user_account = book_user_account;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getBook_type() {
		return book_type;
	}

	public void setBook_type(String book_type) {
		this.book_type = book_type;
	}

	public String getBook_information() {
		return book_information;
	}

	public void setBook_information(String book_information) {
		this.book_information = book_information;
	}

	public String getBook_date() {
		return book_date;
	}

	public void setBook_date(String book_date) {
		this.book_date = book_date;
	}

	public int getBook_price() {
		return book_price;
	}

	public void setBook_price(int book_price) {
		this.book_price = book_price;
	}
	
}
