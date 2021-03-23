package servlet;//搜索关键词趋势

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.Api;
import utils.URLEncoder;
import utils.getCookie;

public class propertyTrend extends HttpServlet {

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
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");   
		GregorianCalendar gc=new GregorianCalendar(); 
		gc.setTime(new Date()); 
		gc.add(5,-1);
		String word = request.getParameter("word");
		if(word==null) {
			word="面膜";
		}
		String date = sf.format(gc.getTime());
		String json = api(date, word);
		System.out.println(json);
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
	
	public static String api(String date,String word) {
		String api = "https://sycm.taobao.com/mc/searchword/propertyTrend.json?dateType=day&dateRange="+date+"%7C"+date+"&indexCode=&device=0&keyword="+URLEncoder.encode(word)+"&diffKeyword=&_="+new Date().getTime()+"&token="+getCookie.getcookie("token");
		String referer = "https://sycm.taobao.com/mc/mq/search_analyze?activeKey=overview&dateRange="+date+"%7C"+date+"&dateType=day&device=0&keyword="+URLEncoder.encode(word)+"&spm=a21ag.11815257.LeftMenu.d588.291550a5WJUSvN";
		String sycm_referer = "/mc/mq/search_analyze";
		return Api.get(api, referer, sycm_referer);
	}

}
