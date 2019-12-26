package works.goods.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import works.goods.bean.OrderGoodsMapping;

public interface OrderGoodsMappingMapper {
	//在映射表存储多个数据
	 // 一个订单对应多个商品
	int saveMapping(List<OrderGoodsMapping> list);
	//根据order_id订单编号获取映射表里的对应的数据
		//把数据展示在订单页
	List<OrderGoodsMapping> getListByOrderIds(@Param("orderIds")long[] orderIds);
}
