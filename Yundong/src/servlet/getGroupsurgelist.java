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

import entity.goods;

public class getGroupsurgelist extends HttpServlet {

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
		List<goods> list = service.service.searchGroupsurgelist(catID, dateRange);
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
			goods groupsurgelist = list.get(i);
			String date = groupsurgelist.getupdate_date();
			Integer visitorNum = groupsurgelist.getvisitor_num();
			String goodsName = groupsurgelist.getgoods_name();
			Integer orderNum = groupsurgelist.getorder_num();
			String incrPercent = groupsurgelist.getincr_percent();
			JsonObject obj = new JsonObject();
			obj.addProperty("visitorNum", visitorNum);
			obj.addProperty("orderNum", orderNum);
			obj.addProperty("incrPercent", incrPercent);
			obj.addProperty("goodsName", goodsName);
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
