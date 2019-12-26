package works.user.dao;

import java.util.List;

import works.user.bean.Address;

public interface AddressMapper {
	//保存新地址
	int saveAddress(Address address);
	
	//根据地址id和用户id来删除数据
	int deteleByAddressIdAndUserId(Address address);
	//根据地址id和用户id来修改数据
	int updateByAddressIdAndUserId(Address address);
	
	//修改默认收货地址
	int updateIsdefaultByAddressIdAndUserId(Address address);
	int updateIsdefaultByAddressIdAndUserId2(Address address);
	
	//根据用户id查询用户所有的收货地址
	List<Address> getAddressByUserId(long userId);
	
	
	
	
	
	
	
}
