package works.goods.Dao;

import java.util.List;

import works.goods.bean.Order;

public interface OrderMapper {
	// 提交订单,写入数据库,返回提交的订单编号
	int saveOrder(Order order);

	// 更新订单的支付状态,根据订单id 和user_id
	int updateOrderStatus(Order order);

	// 获取订单并分页
	List<Order> getList(Order order);

	// 获取所有的订单数量
	int getCount(Order order);

}
