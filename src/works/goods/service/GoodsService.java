package works.goods.service;

import java.util.List;

import works.goods.Dao.GoodsMapper;
import works.goods.bean.Goods;
import works.utils.SqlUtils2;

public class GoodsService {
	
	//查询所有的商品分类信息
	public List<Goods> getList(Goods bean){
		GoodsMapper goodsMapper=SqlUtils2.getMapper(GoodsMapper.class);
		List<Goods> list=goodsMapper.getList(bean);
		SqlUtils2.release();
		return list;
		
	}
	
	//查询商品的总量
	public int getCount(Goods bean) {
		GoodsMapper goodsMapper=SqlUtils2.getMapper(GoodsMapper.class);
		int num=goodsMapper.getCount(bean);
		SqlUtils2.release();
		return num;
	}
	//根据id查询商品详情
	public Goods getById(long id) {
		GoodsMapper goodsMapper=SqlUtils2.getMapper(GoodsMapper.class);
		Goods goods=goodsMapper.getById(id);
		SqlUtils2.release();
		return goods;
	}

}
