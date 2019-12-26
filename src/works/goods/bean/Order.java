package works.goods.bean;

import java.util.ArrayList;
import java.util.List;

import works.utils.Page;

public class Order extends Page{
	private long id;
	private long user_id;
	private double price;
	private long address_id;
	private int status;
	private long create_time;
	
	//接收多个购物车里的商品id
	private long[] cartIds;
	//放一个订单里的多个商品
	private List<OrderGoodsMapping> mappings = new ArrayList<OrderGoodsMapping>();
	public List<OrderGoodsMapping> getMappings() {
		return mappings;
	}
	public void setMappings(List<OrderGoodsMapping> mappings) {
		this.mappings = mappings;
	}
	public long[] getCartIds() {
		return cartIds;
	}
	public void setCartIds(long[] cartIds) {
		this.cartIds = cartIds;
	}
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public long getAddress_id() {
		return address_id;
	}
	public void setAddress_id(long address_id) {
		this.address_id = address_id;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public long getCreate_time() {
		return create_time;
	}
	public void setCreate_time(long create_time) {
		this.create_time = create_time;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{\"id\":\"");
		builder.append(id);
		builder.append("\", \"user_id\":\"");
		builder.append(user_id);
		builder.append("\", \"price\":\"");
		builder.append(price);
		builder.append("\", \"address_id\":\"");
		builder.append(address_id);
		builder.append("\", \"status\":\"");
		builder.append(status);
		builder.append("\", \"create_time\":\"");
		builder.append(create_time);
		builder.append("\"}");
		return builder.toString();
	}

}
