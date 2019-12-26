//package works.user.web;
//
//import java.io.IOException;
//import java.util.Random;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import works.utils.ImgCode;
//
////import works.utils.ImgCode;
//
//@WebServlet("/user/imgcode")
//public class GetImgCode extends HttpServlet {
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		doPost(req, resp);
//	}
//
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		Random random = new Random();
//
//		String code = "";
//		for (int i = 0; i < 4; i++) {
//			int num = random.nextInt(10);
//			code += num;
//		}
//		ImgCode.outputImage(200, 50, resp.getOutputStream(), code);
//
//		req.getSession().setAttribute("ImgCode", code);
//	}
//}
