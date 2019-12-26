package works.user.bean;

public class UserInfo {
	private long id;
	private long userId;
	private String nickName;
	private String inco;
	private String cellphone;
	private String qq;
	private String email;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getInco() {
		return inco;
	}
	public void setInco(String inco) {
		this.inco = inco;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{\"id\":\"");
		builder.append(id);
		builder.append("\", \"userId\":\"");
		builder.append(userId);
		builder.append("\", \"nickName\":\"");
		builder.append(nickName);
		builder.append("\", \"inco\":\"");
		builder.append(inco);
		builder.append("\", \"cellphone\":\"");
		builder.append(cellphone);
		builder.append("\", \"qq\":\"");
		builder.append(qq);
		builder.append("\", \"email\":\"");
		builder.append(email);
		builder.append("\"}");
		return builder.toString();
	}
	

}
