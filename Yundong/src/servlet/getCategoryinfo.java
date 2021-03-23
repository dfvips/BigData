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

import entity.categoryinfo;

public class getCategoryinfo extends HttpServlet {

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
		Integer catId=1;
		if(request.getParameter("catId")!=null) {
			catId=Integer.parseInt(request.getParameter("catId"));
		}
		List<categoryinfo> list = service.service.searchCategoryinfo(catId);
		JsonObject res=new JsonObject();
		res.addProperty("success", true);
		res.addProperty("errorCode", 0);
		res.add("errorMsg", null);
		@SuppressWarnings("unused")
		String catName="";
		System.out.println(list);
		if(list.size()>0) {
			catId = list.get(0).getcat_id();
			catName = list.get(0).getcat_name();
		}
		JsonArray result=new JsonArray();
		for (int i = 0; i < list.size(); i++) {
			categoryinfo categoryinfo = list.get(i);
			Integer catID=categoryinfo.getcat_id();
			String caTName=categoryinfo.getcat_name();
			Integer cat1Id=categoryinfo.getparent_cat_id();
			String cat1Name=categoryinfo.getparent_cat_name();
			JsonObject obj = new JsonObject();
			obj.addProperty("catId", catID);
			obj.addProperty("catName", caTName);
			obj.addProperty("cat1Id", cat1Id);
			obj.addProperty("cat1Name", cat1Name);
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
