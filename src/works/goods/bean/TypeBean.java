package works.goods.bean;

public class TypeBean {
	private long id ;
	private long user_id;
	private String type_name="";
	private String content="";
	private long create_time;
	
	
	private String real_name;


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


	public String getType_name() {
		return type_name;
	}


	public void setType_name(String type_name) {
		this.type_name = type_name;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public long getCreate_time() {
		return create_time;
	}


	public void setCreate_time(long create_time) {
		this.create_time = create_time;
	}


	public String getReal_name() {
		return real_name;
	}


	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{\"id\":\"");
		builder.append(id);
		builder.append("\", \"user_id\":\"");
		builder.append(user_id);
		builder.append("\", \"type_name\":\"");
		builder.append(type_name);
		builder.append("\", \"content\":\"");
		builder.append(content);
		builder.append("\", \"create_time\":\"");
		builder.append(create_time);
		builder.append("\", \"real_name\":\"");
		builder.append(real_name);
		builder.append("\"}");
		return builder.toString();
	}
	

}
