package servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class queryHotWordCateListByLvl extends HttpServlet {

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
		response.setContentType("application/json;charset=utf-8");//指定返回的格式为JSON格式
		PrintWriter out = response.getWriter();
		String catId=request.getParameter("catId");
		String catIdParent=request.getParameter("catIdParent");
    	String json=getHotWords(catId,catIdParent);
		out.println(json);
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
	
	public static String getHotWords(String catId,String catIdParent) {
		String api="https://mms.pinduoduo.com/sydney/api/hotWord/queryHotWord";
		String key=queryGoodsRank.getkey();
		Document doc=null;
		Connection connection=Jsoup.connect(api);
		String postdata=null;
		if(catId==null) {
			postdata = "{\"sort\":\"heat\",\"asc\":false,\"pageSize\":100000,\"pageNumber\":1,\"spanDays\":1,\"query\":\"\",\"categoryIdOne\":18637,\"categoryIdTwo\":"+catIdParent+",\"categoryIdThree\":"+catId+",\"crawlerInfo\":\""+key+"\"}";
		}else {
			postdata = "{\"sort\":\"heat\",\"asc\":false,\"pageSize\":100000,\"pageNumber\":1,\"spanDays\":1,\"query\":\"\",\"categoryIdOne\":18637,\"categoryIdTwo\":"+catIdParent+",\"categoryIdThree\":"+catId+",\"crawlerInfo\":\""+key+"\"}";
		}
		JsonObject data=new JsonParser().parse(postdata).getAsJsonObject();
//		System.out.println(token);
		connection=connection.header("anti-content",key);
//		System.out.println(data);
		connection=connection.requestBody(data.toString());
		connection=connection.header("Referer","https://mms.pinduoduo.com/exp/tools/dataAnalysis");
		connection=connection.header("Origin","https://mms.pinduoduo.com");
		connection=connection.header("Content-Type", "application/json; charset=utf-8");
		connection=connection.header("Cookie", queryGoodsRank.getcookie("pdd"));
		try {
			doc = connection.userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:74.0) Gecko/20100101 Firefox/74.0").timeout(50000).ignoreContentType(true).post();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String json=doc.body().text();
		return json;
	}
}
