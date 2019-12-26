package works.goods.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import works.goods.Dao.CartMapper;
import works.goods.Dao.OrderGoodsMappingMapper;
import works.goods.Dao.OrderMapper;
import works.goods.bean.Cart;
import works.goods.bean.Order;
import works.goods.bean.OrderGoodsMapping;
import works.utils.SqlUtils2;

public class OrderService {
//	private OrderDao orderDao = new OrderDao();
//	private CartDao cartDao = new CartDao(); 
//	private OrderGoodsMappingDao mappingDao = new OrderGoodsMappingDao();
	
	public long saveOrder(Order order) {
		CartMapper cartMapper =SqlUtils2.getMapper(CartMapper.class);
		OrderMapper orderMapper =SqlUtils2.getMapper(OrderMapper.class);
		OrderGoodsMappingMapper orderGoodsMapping =SqlUtils2.getMapper(OrderGoodsMappingMapper.class);
		//客户端点击去支付时, 会将购物车记录的id和收货地址id传递过来, 我们根据这些购物车id 查出对应的商品
		
		long[] cartIds = order.getCartIds(); //多个购物车里的商品,数组里放的是购物车id 
		Cart cart = new Cart(); 
		cart.setIds(cartIds);
		cart.setUser_id(order.getUser_id());
		//根据购物车记录的id查询出对应的商品
		//购物车id-->goods_id-->商品
		List<Cart> carts = cartMapper.getGoodsByCartId(cart);//购物车里要支付的数据
		
		//计算订单中的商品总价格
		double sum = 0;
		
		for (Cart cart2 : carts) {//购物车里要支付的数据和一些商品信息
			sum += cart2.getPrice()*cart2.getNum();
		}
		//订单总价
		order.setPrice(sum);
		order.setCreate_time(System.currentTimeMillis());
		//保存订单, 并获取订单的id
		 orderMapper.saveOrder(order);
		 long id =order.getId();
		
		//保存订单和商品的映射关系
		List<OrderGoodsMapping> list = new ArrayList<OrderGoodsMapping>();
		for (Cart cart2 : carts) {
			OrderGoodsMapping goodsMapping = new OrderGoodsMapping();
			goodsMapping.setOrder_id(id);
			goodsMapping.setGoods_id(cart2.getGoods_id());
			goodsMapping.setPrice(cart2.getPrice());
			goodsMapping.setNum(cart2.getNum());
			goodsMapping.setInco(cart2.getInco());
			goodsMapping.setG_name(cart2.getG_name());
			list.add(goodsMapping);
		}
		//插入多条数据,用批处理
		orderGoodsMapping.saveMapping(list);
		//提交订单后,删除购物车里的对应数据
		cartMapper.deleteByIds(cart);
		SqlUtils2.release();
		return id ;
	}
	/**
	   * 更新订单支付状态
	 * @param order
	 * @return
	 */
	public boolean updateOrderStatus(Order order) {
		OrderMapper orderMapper =SqlUtils2.getMapper(OrderMapper.class);
		int num = orderMapper.updateOrderStatus(order);
		SqlUtils2.release();
		return num >0;
	}
	
	//获取所有订单及其对应的商品,(用于在订单页展示)
	public List<Order> getList(Order order){
		OrderMapper orderMapper =SqlUtils2.getMapper(OrderMapper.class);
		OrderGoodsMappingMapper orderGoodsMapping =SqlUtils2.getMapper(OrderGoodsMappingMapper.class);

		//获取多个订单并分页
		List<Order> list = orderMapper.getList(order);
		//有多少个订单就有多少个订单id
		long[] orderIds = new long[list.size()];
		//获取所有订单的id,存进数组
		for (int i = 0; i < list.size(); i++) {
			Order order2 = list.get(i);
			orderIds[i] = order2.getId();
		}
		//根据(order_id)订单编号获取映射表里的对应的数据
		//获取所有订单及其对应的商品id
		List<OrderGoodsMapping> mappings = orderGoodsMapping.getListByOrderIds(orderIds);
		
		/*
		 * for (OrderGoodsMapping orderGoodsMapping : mappings) { long orderId =
		 * orderGoodsMapping.getGoods_id();
		 * 
		 * for (Order order2 : list) { if(order2.getId()==orderId) {
		 * order2.getMappings().add(orderGoodsMapping); break; } } }
		 */
		
		HashMap<Long, Order> map = new HashMap<Long, Order>();
		//order_id为键,order为值,存入map集合
		for (Order order2 : list) {
			map.put(order2.getId(), order2);
		}
		//根据映射的对应关系,
		for (OrderGoodsMapping orderGoods : mappings) {
			long orderId = orderGoods.getOrder_id();
			//通过id,获得order
			Order order2 = map.get(orderId);
			//把order_id所对应的映射表数据写入,根据里面的goods_id可以查询到对应的商品
			order2.getMappings().add(orderGoods);
		}
		SqlUtils2.release();
		return list;
	}
	/**
	 * 获取总数
	 * @param order
	 * @return
	 */
	public int getCount(Order order) {
		OrderMapper orderMapper =SqlUtils2.getMapper(OrderMapper.class);
		int num=orderMapper.getCount(order);
		return num;
	}
	
}
