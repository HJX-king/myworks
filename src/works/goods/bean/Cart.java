package works.goods.bean;

import java.util.Arrays;

public class Cart {
	private long id;
	private long user_id;
	private long goods_id;
	private int num;
	private long create_time;
	
	private String g_name;
	private double price;
	private String type_name;
	private String inco;
	//这个放的是good_id还是购物车id
	private long[] ids;

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

	public long getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(long goods_id) {
		this.goods_id = goods_id;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public long getCreate_time() {
		return create_time;
	}

	public void setCreate_time(long create_time) {
		this.create_time = create_time;
	}

	public String getG_name() {
		return g_name;
	}

	public void setG_name(String g_name) {
		this.g_name = g_name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getType_name() {
		return type_name;
	}

	public void setType_name(String type_name) {
		this.type_name = type_name;
	}

	public String getInco() {
		return inco;
	}

	public void setInco(String inco) {
		this.inco = inco;
	}

	public long[] getIds() {
		return ids;
	}

	public void setIds(long[] ids) {
		this.ids = ids;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{\"id\":\"");
		builder.append(id);
		builder.append("\", \"user_id\":\"");
		builder.append(user_id);
		builder.append("\", \"goods_id\":\"");
		builder.append(goods_id);
		builder.append("\", \"num\":\"");
		builder.append(num);
		builder.append("\", \"create_time\":\"");
		builder.append(create_time);
		builder.append("\", \"g_name\":\"");
		builder.append(g_name);
		builder.append("\", \"price\":\"");
		builder.append(price);
		builder.append("\", \"type_name\":\"");
		builder.append(type_name);
		builder.append("\", \"inco\":\"");
		builder.append(inco);
		builder.append("\", \"ids\":\"");
		builder.append(Arrays.toString(ids));
		builder.append("\"}");
		return builder.toString();
	}

	
}
