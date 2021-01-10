package bean;

import java.util.Arrays;

public class Picture_list {

	private String name;
	private byte[] data;
	
	
	public Picture_list() {
		super();
	}

	public Picture_list(String name, byte[] data) {
		super();
		this.name = name;
		this.data =data;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Picture_list [name=" + name + ", data=" + Arrays.toString(data) + "]";
	}
	
	
	
	
	
}
