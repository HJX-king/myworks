package works.user.web;



import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import works.user.bean.Address;
import works.user.bean.Users;
import works.user.service.AddressService;
import works.utils.ResponseMsg;

@Controller
@RequestMapping("/address/")
public class AddressContrller {
	private AddressService addressService = new AddressService();

	@ResponseBody
	@RequestMapping("updateDefault")
	public ResponseMsg updateDefault(Address address, HttpSession session) {
		Users user = (Users) session.getAttribute("login");
		ResponseMsg msg = new ResponseMsg();
		if (user != null) {
			address.setUser_id(user.getId());
			boolean flg = addressService.updateIsdefaultByAddressIdAndUserId(address);
			if (flg) {
				msg.setCode(1);
			} else {
				msg.setCode(-1);
			}
		} else {
			msg.setCode(3);
		}
		return msg;
	}
	
	@ResponseBody
	@RequestMapping("addaddress")
	public ResponseMsg addaddress(Address address, HttpSession session) {
		Users user = (Users) session.getAttribute("login");
		
		ResponseMsg msg = new ResponseMsg();
		if (user != null) {
			address.setUser_id(user.getId());
			boolean flg=addressService.saveAddress(address);
			if(flg) {
				msg.setCode(1);
			}else {
				msg.setCode(-1);
				msg.setMessage("对不起,添加失败");
			}
		}else {
			msg.setCode(3);
		}
		return msg;
	}
	@ResponseBody
	@RequestMapping("deleteById")
	public ResponseMsg deleteById(Address address, HttpSession session) {
		Users user = (Users) session.getAttribute("login");
		ResponseMsg msg = new ResponseMsg();
		if (user != null) {
			address.setUser_id(user.getId());
			boolean flg=addressService.deteleByAddressIdAndUserId(address);
			if(flg) {
				msg.setCode(1);
			}else {
				msg.setCode(-1);
				msg.setMessage("对不起,删除失败");
			}
		} else {
			msg.setCode(3);
		}
		return msg;
	}
	@ResponseBody
	@RequestMapping("updateAddressById")
	public ResponseMsg updateAddressById(Address address, HttpSession session) {
		Users user = (Users) session.getAttribute("login");
		ResponseMsg msg = new ResponseMsg();
		if (user != null) {
			address.setUser_id(user.getId());
			boolean flg=addressService.updateByAddressIdAndUserId(address);
			if(flg) {
				msg.setCode(1);
			}else {
				msg.setCode(-1);
				msg.setMessage("对不起,修改失败");
			}
		} else {
			msg.setCode(3);
		}
		return msg;
	}

}
