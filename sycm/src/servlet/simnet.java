package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import utils.SimilarityUtil;
import utils.unicode;

public class simnet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request  the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException      if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");// 指定返回的格式为JSON格式
		PrintWriter out = response.getWriter();
		JsonObject json = new JsonObject();
		String type = request.getParameter("type");
		String text = request.getParameter("text");
		String compare = request.getParameter("compare");
		String img = request.getParameter("img");
		String compareImg = request.getParameter("compareImg");
		Float score = null;
		json.addProperty("status", "success");
		json.addProperty("code", 200);
		if(type!=null) {
			if(type.equals("text")) {
				if(text!=null&&compare!=null) {
					json.addProperty("message", "Welcome to use the text similarity judgment api.");
					score = SimilarityUtil.getSimilarity(text,compare);
					JsonObject texts = new JsonObject();
					texts.addProperty("text", unicode.toUnicode(text));
					texts.addProperty("compare", unicode.toUnicode(compare));
					json.add("texts",texts);
					json.addProperty("score",score);
				}else {
					json = failmsg(json,"text and compare cannot be null.");
				}
			}else if(type.equals("img")) {
				if(img!=null&&compareImg!=null) {
					json.addProperty("message", "Welcome to use the image similarity judgment api.");
					score = SimilarityUtil.imgsimilar(SimilarityUtil.readImage(img),SimilarityUtil.readImage(compareImg));
					JsonObject images = new JsonObject();
					images.addProperty("imageUrl", img);
					images.addProperty("compareImgUrl", compareImg);
					json.add("images",images);
					json.addProperty("score",score);
				}else {
					json = failmsg(json,"img and compareImg cannot be null.");
				}
			}else {
				json = failmsg(json,null);
			}
		}else {
			json = failmsg(json,"type cannot be null.");
		}
		json.addProperty("timestamp", new Date().getTime());
		json.addProperty("description", "Powered By DreamFly.");
		out.print(unicode.handtxt(json));
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request  the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException      if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
	
	public static JsonObject failmsg(JsonObject json,String code) {
		json.addProperty("code", 400);
		if(code==null) {
			json.addProperty("message", "check parameter fail.");
		}else {
			json.addProperty("message", code);
		}
		return json;
	}
}
