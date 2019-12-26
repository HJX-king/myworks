package works.user.bean;

public class Address {
	private long id;
	private long user_id;
	private String r_name;
	private String cellphone;
	private String address;
	private int isdefault ;
	private long creat_time;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public String getR_name() {
		return r_name;
	}
	public void setR_name(String r_name) {
		this.r_name = r_name;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getIsdefault() {
		return isdefault;
	}
	public void setIsdefault(int isdefault) {
		this.isdefault = isdefault;
	}
	public long getCreat_time() {
		return creat_time;
	}
	public void setCreat_time(long creat_time) {
		this.creat_time = creat_time;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{\"id\":\"");
		builder.append(id);
		builder.append("\", \"user_id\":\"");
		builder.append(user_id);
		builder.append("\", \"r_name\":\"");
		builder.append(r_name);
		builder.append("\", \"cellphone\":\"");
		builder.append(cellphone);
		builder.append("\", \"address\":\"");
		builder.append(address);
		builder.append("\", \"isdefault\":\"");
		builder.append(isdefault);
		builder.append("\", \"creat_time\":\"");
		builder.append(creat_time);
		builder.append("\"}");
		return builder.toString();
	}
	
	

}
