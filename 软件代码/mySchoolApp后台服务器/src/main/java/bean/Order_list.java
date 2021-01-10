package bean;

public class Order_list {
	//总订单
	private int order_id;
	private String order_user_account;
	private int order_book_id;
	private String order_date;
	
	public Order_list() {
		super();
	}
	
	public Order_list(String order_user_account, int order_book_id, String order_date) {
		super();
		this.order_user_account = order_user_account;
		this.order_book_id = order_book_id;
		this.order_date = order_date;
	}

	public Order_list(int order_id, String order_user_account, int order_book_id, String order_date) {
		super();
		this.order_id = order_id;
		this.order_user_account = order_user_account;
		this.order_book_id = order_book_id;
		this.order_date = order_date;
	}
	
	
	
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public String getOrder_user_account() {
		return order_user_account;
	}
	public void setOrder_user_account(String order_user_account) {
		this.order_user_account = order_user_account;
	}
	public int getOrder_book_id() {
		return order_book_id;
	}
	public void setOrder_book_id(int order_book_id) {
		this.order_book_id = order_book_id;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}

	@Override
	public String toString() {
		return "Order_list [order_id=" + order_id + ", order_user_account=" + order_user_account + ", order_book_id="
				+ order_book_id + ", order_date=" + order_date + "]";
	}
	
	
}
