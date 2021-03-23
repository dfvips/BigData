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

public class getHotwordRank extends HttpServlet {

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
		Integer catID=0;
		Integer dataRange=50;
		Integer type=0;
		Integer day=1;
		if(request.getParameter("catId")!=null) {
			catID=Integer.parseInt(request.getParameter("catId"));
		}
		if(request.getParameter("dataRange")!=null) {
			dataRange=Integer.parseInt(request.getParameter("dataRange"));
		}
		if(request.getParameter("type")!=null) {
			type=Integer.parseInt(request.getParameter("type"));
		}
		if(request.getParameter("day")!=null) {
			day=Integer.parseInt(request.getParameter("day"));
		}
		List<hotwords> list = service.service.getHotwordRank(day,catID,dataRange,type);
		JsonObject res=new JsonObject();
		res.addProperty("success", true);
		res.addProperty("errorCode", 0);
		res.add("errorMsg", null);
		JsonArray result=new JsonArray();
		for (int i = 0; i < list.size(); i++) {
			hotwords hotwords = list.get(i);
			String date = hotwords.getupdate_date();
			Integer pv = hotwords.getPv();
			Integer clickNum = hotwords.getclick_num();
			String ctr = hotwords.getCtr();
			String cvr = hotwords.getCvr();
			Integer competeValue = hotwords.getcompete_value();
			String imprAvgBid = hotwords.getimpr_avg_bid();
			String word = hotwords.getWord();
			Integer catId = hotwords.getcat_id();
			String catName = hotwords.getcat_name();
			JsonObject obj = new JsonObject();
			obj.addProperty("pv", pv);
			obj.addProperty("ctr", ctr);
			obj.addProperty("cvr", cvr);
			obj.addProperty("competeValue", competeValue);
			obj.addProperty("imprAvgBid", imprAvgBid);
			obj.addProperty("clickNum", clickNum);
			obj.addProperty("word", word);
			obj.addProperty("date", date);
			obj.addProperty("catId", catId);
			obj.addProperty("catName", catName);
			result.add(obj);
		}
		res.add("result", result);
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
