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

public class storeHotpurpose extends HttpServlet {

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
			String json = hotpurpose.api(date, catId, parentId);
			JsonElement obj = new JsonParser().parse(json).getAsJsonObject().get("data");
			if (obj != null) {
				JsonArray dataArray = obj.getAsJsonArray();
				for (JsonElement jsonElement : dataArray) {
					JsonObject data = jsonElement.getAsJsonObject();
					JsonObject item = data.get("item").getAsJsonObject();
					JsonObject shop = data.get("shop").getAsJsonObject();
					String item_id = null;
					String pict_url = null;
					String detail_url = null;
					String item_title = null;
					Integer cate_rank_cqc = null;
					String picture_url = null;
					String shop_title = null;
					String shop_url = null;
					String user_id = null;
					Integer cate_rank = null;
					String trade_index = null;
					String clt_hits = null;
					String cart_hits = null;
					if (item.get("itemId") != null) {
						item_id = item.get("itemId").getAsString();
					}
					if (item.get("pictUrl") != null) {
						pict_url = item.get("pictUrl").getAsString();
					}
					if (item.get("detailUrl") != null) {
						detail_url = item.get("detailUrl").getAsString();
					}
					if (item.get("title") != null) {
						item_title = item.get("title").getAsString();
					}
					if (shop.get("pictureUrl") != null) {
						picture_url = shop.get("pictureUrl").getAsString();
					}
					if (shop.get("title") != null) {
						shop_title = shop.get("title").getAsString();
					}
					if (shop.get("shopUrl") != null) {
						shop_url = shop.get("shopUrl").getAsString();
					}
					if (shop.get("userId") != null) {
						user_id = shop.get("userId").getAsString();
					}
					if (data.get("cateRankId") != null) {
						if (data.get("cateRankId").getAsJsonObject().get("value") != null) {
							cate_rank = data.get("cateRankId").getAsJsonObject().get("value").getAsInt();
						}
						if (data.get("cateRankId").getAsJsonObject().get("cycleCqc") != null) {
							cate_rank_cqc = data.get("cateRankId").getAsJsonObject().get("cycleCqc").getAsInt();
						}
					}
					if (data.get("tradeIndex") != null) {
						if (data.get("tradeIndex").getAsJsonObject().get("value") != null) {
							trade_index = data.get("tradeIndex").getAsJsonObject().get("value").getAsString();
						}
					}
					if (data.get("cltHits") != null) {
						if (data.get("cltHits").getAsJsonObject().get("value") != null) {
							clt_hits = data.get("cltHits").getAsJsonObject().get("value").getAsString();
						}
					}
					int num = 0;
					if (data.get("cartHits") != null) {
						if (data.get("cartHits").getAsJsonObject().get("value") != null) {
							cart_hits = data.get("cartHits").getAsJsonObject().get("value").getAsString();
						}
					}
					if(type.equals("1")) {
						num = service.fillHotpurpose(catId, item_id, pict_url, detail_url, item_title, picture_url,
							shop_title, shop_url, user_id, trade_index, cate_rank, cate_rank_cqc, clt_hits, cart_hits,
							date, crawl_time);
					}else {
						num = service_make.fillHotpurpose(catId, item_id, pict_url, detail_url, item_title, picture_url,
								shop_title, shop_url, user_id, trade_index, cate_rank, cate_rank_cqc, clt_hits, cart_hits,
								date, crawl_time);
					}
					if (num != 1) {
						System.out.println(catId + " : " + "error");
					}
				}
//				System.out.println(json);
				if (!(flag == 0)) {
					json = "," + json;
				};
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
			}else {
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
