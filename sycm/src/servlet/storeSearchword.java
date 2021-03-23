package servlet;

import java.io.IOException;
import java.io.PrintWriter;
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

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import entity.cate;
import service.service;
import service.service_make;
import utils.random;

public class storeSearchword extends HttpServlet {

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
		String rangestr = request.getParameter("range");
		Integer range = 0;
		if(rangestr == null) {
			range = 1;
		}else {
			Pattern pattern = Pattern.compile("^[1-9]\\d*$");
			Matcher isNum = pattern.matcher(rangestr);
			if(isNum.matches()==false) {
				range = 1;
			}else {
				range = Integer.parseInt(rangestr);
			}
		}
		PrintWriter out = response.getWriter();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(new Date());
		gc.add(5, -range);
		String date = sf.format(gc.getTime());
		SimpleDateFormat sf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		GregorianCalendar gc1 = new GregorianCalendar();
		gc1.setTime(new Date());
		gc1.add(5, 0);
		String crawl_time = sf1.format(gc1.getTime());
		String type = request.getParameter("type");
		if(type == null||(!type.equals("1")&&!type.equals("2"))) {
			type = "1";
		}
		List<cate> list = null;
		if(type.equals("1")) {
			list = service.searchAllCateInfo();
		}else {
			list = service_make.searchAllCateInfo();
		}
		int flag = 0;
		for (int i = 0; i < list.size(); i++) {
			cate cate = list.get(i);
			Integer catId = cate.getCat_id();
			Integer parentId = cate.getCat_parent();
			if (parentId.equals(-1)) {
				if(type.equals("1")) {
					parentId = 1801;
				}else {
					parentId = 50010788;
				}
			}
			String json = searchWord.api(date, catId, parentId);
			JsonElement obj = new JsonParser().parse(json).getAsJsonObject().get("data");
			if (obj != null) {
				JsonArray hotList = obj.getAsJsonObject().get("hotList").getAsJsonArray();
				JsonArray soarList = obj.getAsJsonObject().get("soarList").getAsJsonArray();
				for (JsonElement jsonElement : hotList) {
					JsonObject data = jsonElement.getAsJsonObject();
					String se_ipv_uv_hits = null;
					String click_hits = null;
					String click_rate = null;
					Integer hot_search_rank = null;
					Integer order_num = null;
					String p4p_ref_price = null;
					String pay_rate = null;
					String search_word = null;
					String tm_click_rate = null;
					
					if (data.get("clickHits") != null) {
						click_hits = data.get("clickHits").getAsString();
					}
					if (data.get("clickRate") != null) {
						click_rate = data.get("clickRate").getAsString();
					}
					if (data.get("hotSearchRank") != null) {
						hot_search_rank = data.get("hotSearchRank").getAsInt();
					}
					if (data.get("orderNum") != null) {
						order_num = data.get("orderNum").getAsInt();
					}
					if (data.get("p4pRefPrice") != null) {
						p4p_ref_price = data.get("p4pRefPrice").getAsString();
					}
					if (data.get("payRate") != null) {
						pay_rate = data.get("payRate").getAsString();
					}
					if (data.get("searchWord") != null) {
						search_word = data.get("searchWord").getAsString();
					}
					if (data.get("tmClickRate") != null) {
						tm_click_rate = data.get("tmClickRate").getAsString();
					}
					if (data.get("seIpvUvHits") != null) {
						se_ipv_uv_hits = data.get("seIpvUvHits").getAsString();
					}
					int num = 0;
					if(type.equals("1")) {
						num = service.fillSearchwordHot(catId, click_hits, click_rate, hot_search_rank, order_num, p4p_ref_price,
							pay_rate, se_ipv_uv_hits, search_word, tm_click_rate, date, crawl_time);
					}else {
						num = service_make.fillSearchwordHot(catId, click_hits, click_rate, hot_search_rank, order_num, p4p_ref_price,
								pay_rate, se_ipv_uv_hits, search_word, tm_click_rate, date, crawl_time);
					}
					if (num != 1) {
						System.out.println(catId + " : " + "hotList" + "error");
					}
				}
				for (JsonElement jsonElement : soarList) {
					JsonObject data = jsonElement.getAsJsonObject();
					String se_ipv_uv_hits = null;
					String click_hits = null;
					String click_rate = null;
					Integer soar_rank = null;
					Integer order_num = null;
					String p4p_ref_price = null;
					String pay_rate = null;
					String search_word = null;
					String se_rise_rate = null;
					
					if (data.get("clickHits") != null) {
						click_hits = data.get("clickHits").getAsString();
					}
					if (data.get("clickRate") != null) {
						click_rate = data.get("clickRate").getAsString();
					}
					if (data.get("soarRank") != null) {
						soar_rank = data.get("soarRank").getAsInt();
					}
					if (data.get("orderNum") != null) {
						order_num = data.get("orderNum").getAsInt();
					}
					if (data.get("p4pRefPrice") != null) {
						p4p_ref_price = data.get("p4pRefPrice").getAsString();
					}
					if (data.get("payRate") != null) {
						pay_rate = data.get("payRate").getAsString();
					}
					if (data.get("searchWord") != null) {
						search_word = data.get("searchWord").getAsString();
					}
					if (data.get("seRiseRate") != null) {
						se_rise_rate = data.get("seRiseRate").getAsString();
					}
					if (data.get("seIpvUvHits") != null) {
						se_ipv_uv_hits = data.get("seIpvUvHits").getAsString();
					}
					int num = 0;
					if(type.equals("1")) {
						num = service.fillSearchwordSoar(catId, click_hits, click_rate, soar_rank, order_num,
							p4p_ref_price, pay_rate, se_ipv_uv_hits, search_word, se_rise_rate, date, crawl_time);
					}else {
						num = service_make.fillSearchwordSoar(catId, click_hits, click_rate, soar_rank, order_num,
								p4p_ref_price, pay_rate, se_ipv_uv_hits, search_word, se_rise_rate, date, crawl_time);
					}
					if (num != 1) {
						System.out.println(catId + " : " + "soarList" + "error");
					}
				}
//				System.out.println(json);
				if (!(flag == 0)) {
					json = "," + json;
				}
				;
				if(flag == 0){
					out.print("{\"status\":200,\"success\":true,\"message\":\"\\u72b6\\u6001\\u6b63\\u5e38\",\"updateTime\":\""+date+"\",\"result\":[");
				}
				out.print(json);
			} else {
				out.print("{\"status\":200,\"success\":true,\"message\":\"\\u72b6\\u6001\\u5f02\\u5e38\",\"updateTime\":\""+date+"\",\"result\":[");
				out.print(json);
				break;
			}
			flag++;
			if (i < list.size() - 1) {
				try {
					Integer time = random.getDelay();
					Thread.currentThread();
					Thread.sleep(time);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("执行存储完毕");
			}
		}
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

}
