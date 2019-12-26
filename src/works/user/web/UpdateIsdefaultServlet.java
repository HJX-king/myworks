//package works.user.web;
//
//import java.io.IOException;
//import java.lang.reflect.InvocationTargetException;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.commons.beanutils.BeanUtils;
//
//import works.user.bean.Address;
//import works.user.bean.Users;
//import works.user.service.AddressService;
//import works.utils.ResponseMsg;
//@WebServlet("/address/updateDefault")
//public class UpdateIsdefaultServlet extends HttpServlet{
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//	private AddressService addressService=new AddressService();
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		doPost(req, resp);
//	}
//
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		Address address=new Address();
//		Users user=(Users) req.getSession().getAttribute("login");
//		ResponseMsg msg=new ResponseMsg();
//		if(user!=null) {
//			try {
//				BeanUtils.populate(address, req.getParameterMap());
//				address.setUser_id(user.getId());
//				boolean flg=addressService.updateIsdefaultByAddressIdAndUserId(address);
//				if(flg) {
//					msg.setCode(1);
//					
//				}else {
//					msg.setCode(-1);
//					
//					
//				}
//				resp.getOutputStream().write(msg.toString().getBytes());
//			} catch (IllegalAccessException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (InvocationTargetException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		}else {
//			resp.sendRedirect("/mywork/pages/login.jsp");
//			
//		}
//		
//	}
//
//}
