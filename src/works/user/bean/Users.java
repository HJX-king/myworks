package works.user.bean;

public class Users {
	private long id;
	private String userName;
	private String password;
	
	
	private String nickName;
	private String inco;
	
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
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "{\"id\":\"" + id + "\", \"userName\":\"" + userName + "\", \"password\":\"" + password
				+ "\", \"nickName\":\"" + nickName + "\", \"inco\":\"" + inco + "\"}";
	}
	
	

}
