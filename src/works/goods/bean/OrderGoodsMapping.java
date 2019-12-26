package works.goods.bean;

public class OrderGoodsMapping {
	private long order_id;
	private long goods_id;
	private int num;
	private double price;
	private String inco;
	private String g_name;
	public long getOrder_id() {
		return order_id;
	}
	public void setOrder_id(long order_id) {
		this.order_id = order_id;
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getInco() {
		return inco;
	}
	public void setInco(String inco) {
		this.inco = inco;
	}
	public String getG_name() {
		return g_name;
	}
	public void setG_name(String g_name) {
		this.g_name = g_name;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{\"order_id\":\"");
		builder.append(order_id);
		builder.append("\", \"goods_id\":\"");
		builder.append(goods_id);
		builder.append("\", \"num\":\"");
		builder.append(num);
		builder.append("\", \"price\":\"");
		builder.append(price);
		builder.append("\", \"inco\":\"");
		builder.append(inco);
		builder.append("\", \"g_name\":\"");
		builder.append(g_name);
		builder.append("\"}");
		return builder.toString();
	}

}
