package works.user.service;

import java.util.List;

import works.user.bean.Address;

import works.user.dao.AddressMapper;
import works.utils.SqlUtils2;

public class AddressService {
	
	//查
	public List<Address> getAddressByUserId(long userId){
		AddressMapper addressMapper=SqlUtils2.getMapper(AddressMapper.class);
		List<Address> list =addressMapper.getAddressByUserId(userId);
		SqlUtils2.release();
		return list;
	}
	//增
	public boolean saveAddress(Address address) {
		AddressMapper addressMapper=SqlUtils2.getMapper(AddressMapper.class);
		address.setCreat_time(System.currentTimeMillis());
		List<Address> list=addressMapper.getAddressByUserId(address.getUser_id());
		if(list.size()<=0) {
			address.setIsdefault(1);
		}
		int num=addressMapper.saveAddress(address);
		SqlUtils2.release();
		return num>0;
	}
	//删除
	public boolean deteleByAddressIdAndUserId(Address address) {
		AddressMapper addressMapper=SqlUtils2.getMapper(AddressMapper.class);
		int num=addressMapper.deteleByAddressIdAndUserId(address);
		SqlUtils2.release();
		return num>0;
	}
	//修改地址详情
	public boolean updateByAddressIdAndUserId(Address address) {
		AddressMapper addressMapper=SqlUtils2.getMapper(AddressMapper.class);
		int num=addressMapper.updateByAddressIdAndUserId(address);
		SqlUtils2.release();
		return num>0;
	}
	//修改是否是默认地址
	public boolean updateIsdefaultByAddressIdAndUserId(Address address) {
		AddressMapper addressMapper=SqlUtils2.getMapper(AddressMapper.class);
		int num=addressMapper.updateIsdefaultByAddressIdAndUserId(address);
		if(num>0) {
			int num1=addressMapper.updateIsdefaultByAddressIdAndUserId2(address);
			if(num1>0) {
				return true;
			}else {
				return false;
			}
		}else {
			
			return false;
		}
	}

}
