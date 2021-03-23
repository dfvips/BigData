package servlet;

import static org.hamcrest.CoreMatchers.nullValue;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import entity.collectgoods;
import mybatis.Mapper;
import mybatis.MybatisReader;

public class executedDetailStore extends HttpServlet {

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
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(new Date());
		gc.add(5, 0);
		out.print("{\"status\":200,\"success\":true,\"message\":\"\\u72b6\\u6001\\u6b63\\u5e38\",\"result\":[");
		String update_time = sf.format(gc.getTime());
		SqlSession sqlSession = MybatisReader.getSession();
		List<collectgoods> collectgoods = sqlSession.getMapper(Mapper.class).getCollectGoods();
		sqlSession.commit();
		System.out.println(collectgoods.size());
		try {
			//for (int i = 0; i < collectgoods.size(); i++) {
			for (int i = 0; i < collectgoods.size(); i++) {
//				try{
//	             Thread.currentThread();
//	             Thread.sleep(2000);
//	            }catch(InterruptedException ie){
//	                ie.printStackTrace();
//	            }
				String goodName = collectgoods.get(i).getGoods_name();
				Integer id = collectgoods.get(i).getHot_rise_id();
				String json = detail.gethtmlapi(goodName);
				JsonObject obj = new JsonParser().parse(json).getAsJsonObject();
				JsonObject data = obj.get("data").getAsJsonObject();
				JsonObject good = data.get("goods").getAsJsonObject();
				JsonObject mall = data.get("mall").getAsJsonObject();
				JsonObject oakData = data.get("oakData").getAsJsonObject();
				String upTime = good.get("upTime").toString().replace("\"", "");
				String minGroupPrice = good.get("minGroupPrice").toString().replace("\"", "");
				String minNormalPrice = good.get("minNormalPrice").toString().replace("\"", "");
				String icon = null;
				try {
					icon = good.get("icon").getAsJsonObject().get("url").toString().replace("\"", "");
				}catch (Exception e) {
					// TODO: handle exception
					icon = null;
				}
				String sideSalesTip = good.get("sideSalesTip").toString().replace("\"", "").replace("已拼", "").replaceAll("总售", "").replaceAll("累计", "")
						.replace("件", "").replaceAll("：", "").replaceAll(":", "").replaceAll(" ", "");
				String salesTip = mall.get("salesTip").toString().replace("\"", "").replace("已拼", "").replace("件", "")
						.replaceAll("：", "").replaceAll(":", "").replaceAll(" ", "").replaceAll("总售", "").replaceAll("累计", "");
				String goodsNum = mall.get("goodsNum").toString();
				String reviewNum = oakData.get("review").getAsJsonObject().get("reviewNum").toString();
				String activityStartTime = null;
				String activityEndTime = null;
				JsonObject activityCollection = oakData.get("activityCollection").getAsJsonObject();
				JsonObject activity = null;
				if (!(activityCollection.get("activity") == null)) {
					activity = activityCollection.get("activity").getAsJsonObject();
					activityStartTime = activity.get("activityStartTime").toString();
					activityStartTime = parsedate(activityStartTime);
					activityEndTime = activity.get("activityEndTime").toString();
					activityEndTime = parsedate(activityEndTime);
				}
				sqlSession.getMapper(Mapper.class).updateHotCollect(upTime, id);
				sqlSession.commit();
				int nummm = sqlSession.getMapper(Mapper.class).queryHotNum("%"+update_time.substring(0, 10)+"%", id);
				if(nummm==0) {
					sqlSession.getMapper(Mapper.class).storeHotTrend(update_time, sideSalesTip, reviewNum, salesTip, goodsNum, id.toString(), minNormalPrice, minGroupPrice, activityStartTime, activityEndTime, icon);
					sqlSession.commit();
				}
				String res = "";
				if (!(i == 0)) {
					res += ",";
				}
				res += "{\"update_time\":\"" + update_time + "\",\"goodName\":\"" + goodName + "\",\"timestamp\":"
						+ new Date().getTime() + "}";
				out.print(res);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		sqlSession.close();
		out.print("],\"timestamp\":" + new Date().getTime() + ",\"description\":\"Powered By DreamFly.\"}");
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

	public static String parsedate(String time) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sf.format(new Date(Integer.parseInt(time) * 1000L));
	}
}
