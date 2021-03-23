package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.getCookie;

public class addCookie extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");// 指定返回的格式为JSON格式
		PrintWriter out = response.getWriter();
		String s = getCookie.getcookie("cookie");
		String cookies [] = s.split(";");
		String time = String.valueOf(new Date().getTime()+(8640000*30)).substring(0,10);
		int num = 1;
		String json = "[";
		for (int i = 0; i < cookies.length; i++) {
			String all [] = cookies[i].split("=");
			String key = all[0].replaceAll(" ", "");
			String value = all[1].replaceAll(" ", "");
			json += "{\"domain\":\".taobao.com\",\"expirationDate\":"+time+".296547,\"hostOnly\":false,\"httpOnly\":false,\"name\":\""+key+"\",\"path\":\"/\",\"sameSite\":\"no_restriction\",\"secure\":true,\"session\":false,\"storeId\":\"0\",\"value\":\""+value+"\",\"id\":"+num+"},";
			num++;
			json += "{\"domain\":\"sycm.taobao.com\",\"expirationDate\":"+time+".296547,\"hostOnly\":false,\"httpOnly\":false,\"name\":\""+key+"\",\"path\":\"/\",\"sameSite\":\"no_restriction\",\"secure\":true,\"session\":false,\"storeId\":\"0\",\"value\":\""+value+"\",\"id\":"+num+"},"; 
			num++;
//			Cookie cookie =new Cookie(key,value);//实例化一个Cookie对象
//			cookie.setMaxAge(7*24*60*60);         //设置Cookie生命周期(有效时间);单位:秒
//			response.addCookie(cookie);       //添加Cookie到会话
		}
		json = json.substring(0, json.length()-1);
		json = json + "]";
		out.print(json);
		out.flush();
		out.close();
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
