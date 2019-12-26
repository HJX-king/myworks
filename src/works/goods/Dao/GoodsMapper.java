package works.goods.Dao;

import java.util.List;

import works.goods.bean.Goods;

public interface GoodsMapper {
	//获取所有商品及其详情
	List<Goods> getList(Goods goods);
	
	//根据条件查询数据的总量
	int getCount(Goods goods);
	//根据分类的id查询本条记录
	Goods getById(long id);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}




