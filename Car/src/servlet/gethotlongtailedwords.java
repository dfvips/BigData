package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import entity.hotwords;

public class gethotlongtailedwords extends HttpServlet {

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
		Integer catID=18637;
		Integer dateRange=1;
		if(request.getParameter("catId")!=null) {
			catID=Integer.parseInt(request.getParameter("catId"));
		}
		if(request.getParameter("dateRange")!=null) {
			dateRange=Integer.parseInt(request.getParameter("dateRange"));
		}
		List<hotwords> list = service.service.searchHotlongtailedwords(catID, dateRange);
		JsonObject res=new JsonObject();
		res.addProperty("success", true);
		res.addProperty("errorCode", 0);
		res.add("errorMsg", null);
		Integer catId=null;
		String catName="";
		if(list.size()>0) {
			catId = list.get(0).getcat_id();
			catName = list.get(0).getcat_name();
		}
		JsonArray result=new JsonArray();
		for (int i = 0; i < list.size(); i++) {
			hotwords hotlongtailedwords = list.get(i);
			String date = hotlongtailedwords.getupdate_date();
			Integer pv = hotlongtailedwords.getPv();
			Integer clickNum = hotlongtailedwords.getclick_num();
			String ctr = hotlongtailedwords.getCtr();
			String cvr = hotlongtailedwords.getCvr();
			Integer competeValue = hotlongtailedwords.getcompete_value();
			String imprAvgBidString = hotlongtailedwords.getimpr_avg_bid();
			String word = hotlongtailedwords.getWord();
			JsonObject obj = new JsonObject();
			obj.addProperty("pv", pv);
			obj.addProperty("ctr", ctr);
			obj.addProperty("cvr", cvr);
			obj.addProperty("competeValue", competeValue);
			obj.addProperty("imprAvgBidString", imprAvgBidString);
			obj.addProperty("clickNum", clickNum);
			obj.addProperty("word", word);
			obj.addProperty("date", date);
			result.add(obj);
		}
		res.add("result", result);
		res.addProperty("catId", catId);
		res.addProperty("catName", catName);
		res.addProperty("timestamp", new Date().getTime());
		res.addProperty("description", "Powered By DreamFly.");
		out.print(res.toString());
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
