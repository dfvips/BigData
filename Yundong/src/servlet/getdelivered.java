package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import entity.goods;

public class getdelivered extends HttpServlet {

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
		String json = getIndustryTrend();
		JsonObject data = new JsonParser().parse(json).getAsJsonObject();
		JsonObject result = data.get("result").getAsJsonObject();
		Integer total = result.get("total").getAsInt();
		JsonArray list = result.get("list").getAsJsonArray();
		for (int i = 0; i < list.size(); i++) {
			JsonObject obj = list.get(i).getAsJsonObject();
			if(i==1) {
				String js=getmsg(obj.get("id").getAsString());
				out.print(js);
			}
			System.out.print(obj.get("id"));
			System.out.print(obj.get("trackingNumber"));
		}
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
	
	public static String getIndustryTrend() {
		String api="https://mms.pinduoduo.com/honolulu/order/delivered";
		String key=queryGoodsRank.getkey();
		Document doc=null;
		Connection connection=Jsoup.connect(api);
		String postdata=null;
		postdata = "{\"timeRange\":[\"2020-08-20T00:00:00.000Z\",\"2020-08-30T17:00:00.00Z\"],\"page\":1,\"pageSize\":100,\"shippingStartTime\":1597852800000,\"shippingEndTime\":1598803199999}";
		JsonObject data=new JsonParser().parse(postdata).getAsJsonObject();
//		System.out.println(token);
		connection=connection.header("anti-content",key);
//		System.out.println(data);
		connection=connection.requestBody(data.toString());
		connection=connection.header("Referer","https://mms.pinduoduo.com/print/delivered-order");
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
	
	public static String getmsg(String id) {
		String api="https://mms.pinduoduo.com/honolulu/order/receiver?id="+id+"&type=3";
		System.out.println(api);
		String key=queryGoodsRank.getkey();
		Document doc=null;
		Connection connection=Jsoup.connect(api);	
		connection=connection.header("anti-content",key);
		connection=connection.header("Referer","https://mms.pinduoduo.com/print/delivered-order");
		connection=connection.header("Origin","https://mms.pinduoduo.com");
		connection=connection.header("Content-Type", "application/json; charset=utf-8");
		connection=connection.header("Cookie", queryGoodsRank.getcookie("pdd"));
		connection=connection.header("verifyauthtoken", "Os0wuLISYVHiQZsuzxsoOQ3918364ff0bc65ead");
		
		try {
			doc = connection.userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:74.0) Gecko/20100101 Firefox/74.0").timeout(50000).ignoreContentType(true).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String json=doc.body().text();
		return json;
	}
	
}
