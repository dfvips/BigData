package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class detail extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String UAs [] = {"Mozilla/5.0 (Linux; U; Android 8.1.0; zh-cn; BLA-AL00 Build/HUAWEIBLA-AL00) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/57.0.2987.132 MQQBrowser/8.9 Mobile Safari/537.36","Mozilla/5.0 (Linux; Android 8.1; PAR-AL00 Build/HUAWEIPAR-AL00; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/57.0.2987.132 MQQBrowser/6.2 TBS/044304 Mobile Safari/537.36 MicroMessenger/6.7.3.1360(0x26070333) NetType/WIFI Language/zh_CN Process/tools","Mozilla/5.0 (Linux; Android 8.1.0; ALP-AL00 Build/HUAWEIALP-AL00; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/63.0.3239.83 Mobile Safari/537.36 T7/10.13 baiduboxapp/10.13.0.11 (Baidu; P1 8.1.0)","Mozilla/5.0 (Linux; Android 8.1; EML-AL00 Build/HUAWEIEML-AL00; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/53.0.2785.143 Crosswalk/24.53.595.0 XWEB/358 MMWEBSDK/23 Mobile Safari/537.36 MicroMessenger/6.7.2.1340(0x2607023A) NetType/4G Language/zh_CN","Mozilla/5.0 (Linux; U; Android 8.0.0; zh-CN; MHA-AL00 Build/HUAWEIMHA-AL00) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/57.0.2987.108 UCBrowser/12.1.4.994 Mobile Safari/537.36","Mozilla/5.0 (Linux; Android 8.0; MHA-AL00 Build/HUAWEIMHA-AL00; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/57.0.2987.132 MQQBrowser/6.2 TBS/044304 Mobile Safari/537.36 MicroMessenger/6.7.3.1360(0x26070333) NetType/NON_NETWORK Language/zh_CN Process/tools","Mozilla/5.0 (Linux; U; Android 8.0.0; zh-CN; MHA-AL00 Build/HUAWEIMHA-AL00) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/40.0.2214.89 UCBrowser/11.6.4.950 UWS/2.11.1.50 Mobile Safari/537.36 AliApp(DingTalk/4.5.8) com.alibaba.android.rimet/10380049 Channel/227200 language/zh-CN","Mozilla/5.0 (Linux; U; Android 8.1.0; zh-CN; EML-AL00 Build/HUAWEIEML-AL00) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/57.0.2987.108 UCBrowser/11.9.4.974 UWS/2.13.1.48 Mobile Safari/537.36 AliApp(DingTalk/4.5.11) com.alibaba.android.rimet/10487439 Channel/227200 language/zh-CN","Mozilla/5.0 (Linux; U; Android 8.1.0; zh-CN; EML-TL00 Build/HUAWEIEML-TL00) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/57.0.2987.108 UCBrowser/11.9.4.974 UWS/2.14.0.13 Mobile Safari/537.36 AliApp(TB/7.10.4) UCBS/2.11.1.1 TTID/227200@taobao_android_7.10.4 WindVane/8.3.0 1080X2244","Mozilla/5.0 (Linux; U; Android 4.1.2; zh-cn; HUAWEI MT1-U06 Build/HuaweiMT1-U06) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30 baiduboxapp/042_2.7.3_diordna_8021_027/IEWAUH_61_2.1.4_60U-1TM+IEWAUH/7300001a/91E050E40679F078E51FD06CD5BF0A43%7C544176010472968/1","Mozilla/5.0 (Linux; Android 8.0; MHA-AL00 Build/HUAWEIMHA-AL00; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/57.0.2987.132 MQQBrowser/6.2 TBS/044304 Mobile Safari/537.36 MicroMessenger/6.7.3.1360(0x26070333) NetType/4G Language/zh_CN Process/tools","Mozilla/5.0 (iPhone; CPU iPhone OS 12_0 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Mobile/16A366 MicroMessenger/6.7.3(0x16070321) NetType/WIFI Language/zh_CN","Mozilla/5.0 (iPhone; CPU iPhone OS 12_0 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Mobile/16A366 MicroMessenger/6.7.3(0x16070321) NetType/WIFI Language/zh_HK","Mozilla/5.0 (iPhone; CPU iPhone OS 11_2 like Mac OS X) AppleWebKit/604.3.5 (KHTML, like Gecko) Version/11.0 MQQBrowser/8.8.2 Mobile/15B87 Safari/604.1 MttCustomUA/2 QBWebViewType/1 WKType/1","Mozilla/5.0 (iPhone 6s; CPU iPhone OS 11_4_1 like Mac OS X) AppleWebKit/604.3.5 (KHTML, like Gecko) Version/11.0 MQQBrowser/8.3.0 Mobile/15B87 Safari/604.1 MttCustomUA/2 QBWebViewType/1 WKType/1","Mozilla/5.0 (iPhone; CPU iPhone OS 10_1 like Mac OS X) AppleWebKit/602.2.14 (KHTML, like Gecko) Version/10.0 MQQBrowser/8.8.2 Mobile/14B72c Safari/602.1 MttCustomUA/2 QBWebViewType/1 WKType/1","Mozilla/5.0 (iPhone; CPU iPhone OS 11_0_2 like Mac OS X) AppleWebKit/604.1.38 (KHTML, like Gecko) Mobile/15A421 wxwork/2.5.8 MicroMessenger/6.3.22 Language/zh","Mozilla/5.0 (iPhone; CPU iPhone OS 11_4_1 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Mobile/15G77 wxwork/2.5.1 MicroMessenger/6.3.22 Language/zh","Mozilla/5.0 (iPhone; CPU iPhone OS 10_1_1 like Mac OS X) AppleWebKit/602.2.14 (KHTML, like Gecko) Version/10.0 MQQBrowser/8.8.2 Mobile/14B100 Safari/602.1 MttCustomUA/2 QBWebViewType/1 WKType/1","Mozilla/5.0 (Linux; Android 6.0.1; OPPO A57 Build/MMB29M; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/48.0.2564.116 Mobile Safari/537.36 T7/9.1 baidubrowser/7.18.21.0 (Baidu; P1 6.0.1)","Mozilla/5.0 (Linux; Android 6.0.1; OPPO A57 Build/MMB29M; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/63.0.3239.83 Mobile Safari/537.36 T7/10.13 baiduboxapp/10.13.0.10 (Baidu; P1 6.0.1)","Mozilla/5.0 (Linux; U; Android 8.1.0; zh-CN; vivo Y85 Build/OPM1.171019.011) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/57.0.2987.108 UCBrowser/11.9.6.976 Mobile Safari/537.36","Mozilla/5.0 (Linux; Android 5.1.1; OPPO R9 Plustm A Build/LMY47V; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/63.0.3239.83 Mobile Safari/537.36 T7/10.12 baiduboxapp/10.12.0.12 (Baidu; P1 5.1.1)","Mozilla/5.0 (Linux; Android 7.1.1; OPPO R11 Build/NMF26X; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/63.0.3239.83 Mobile Safari/537.36 T7/10.13 baiduboxapp/10.13.0.11 (Baidu; P1 7.1.1)","Mozilla/5.0 (Linux; Android 5.1.1; vivo X6S A Build/LMY47V; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/57.0.2987.132 MQQBrowser/6.2 TBS/044207 Mobile Safari/537.36 MicroMessenger/6.7.3.1340(0x26070332) NetType/4G Language/zh_CN Process/tools","Mozilla/5.0 (Linux; Android 8.1.0; PACM00 Build/O11019; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/63.0.3239.83 Mobile Safari/537.36 T7/10.13 baiduboxapp/10.13.0.11 (Baidu; P1 8.1.0)","Mozilla/5.0 (Linux; Android 7.1.1; vivo X20A Build/NMF26X; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/57.0.2987.132 MQQBrowser/6.2 TBS/044304 Mobile Safari/537.36 MicroMessenger/6.7.2.1340(0x2607023A) NetType/WIFI Language/zh_CN","Mozilla/5.0 (Linux; Android 8.1.0; vivo Y71A Build/OPM1.171019.011; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/63.0.3239.83 Mobile Safari/537.36 T7/10.13 baiduboxapp/10.13.0.11 (Baidu; P1 8.1.0)","Mozilla/5.0 (Linux; U; Android 8.0.0; zh-cn; Mi Note 2 Build/OPR1.170623.032) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/61.0.3163.128 Mobile Safari/537.36 XiaoMi/MiuiBrowser/10.1.1","Mozilla/5.0 (Linux; U; Android 7.0; zh-cn; MI 5s Build/NRD90M) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/61.0.3163.128 Mobile Safari/537.36 XiaoMi/MiuiBrowser/10.2.2","Mozilla/5.0 (Linux; Android 8.0.0; MI 6 Build/OPR1.170623.027; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/63.0.3239.83 Mobile Safari/537.36 T7/10.13 baiduboxapp/10.13.0.11 (Baidu; P1 8.0.0)","Mozilla/5.0 (Linux; U; Android 8.0.0; zh-CN; MI 5 Build/OPR1.170623.032) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/57.0.2987.108 UCBrowser/11.8.9.969 Mobile Safari/537.36","Mozilla/5.0 (Linux; Android 8.0.0; MI 6 Build/OPR1.170623.027) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/62.0.3202.84 Mobile Safari/537.36 Maxthon/3235","Mozilla/5.0 (Linux; U; Android 8.1.0; zh-cn; Mi Note 3 Build/OPM1.171019.019) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/61.0.3163.128 Mobile Safari/537.36 XiaoMi/MiuiBrowser/10.0.2","Mozilla/5.0 (Linux; U; Android 5.1.1; zh-CN; SM-J3109 Build/LMY47X) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/57.0.2987.108 UCBrowser/11.8.0.960 UWS/2.12.1.18 Mobile Safari/537.36 AliApp(TB/7.5.4) UCBS/2.11.1.1 WindVane/8.3.0 720X1280","Mozilla/5.0 (Linux; Android 8.0.0; SM-G9650 Build/R16NW; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/63.0.3239.83 Mobile Safari/537.36 T7/10.13 baiduboxapp/10.13.0.11 (Baidu; P1 8.0.0)","Mozilla/5.0 (Linux; Android 8.0.0; SM-N9500 Build/R16NW; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/63.0.3239.83 Mobile Safari/537.36 T7/10.13 baiduboxapp/10.13.0.11 (Baidu; P1 8.0.0)"}; 
	
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
		String goodId=request.getParameter("goodId");
		String goodName=request.getParameter("goodName");
		if(goodId!=null) {
			String json = gethtml(goodId);
			out.println(json);
		}else {
			if (goodName==null) {
				goodName="绿茶冰肌深层清洁去黑头泥膜收缩毛孔涂抹式面膜男女美白补水控油";
			}
			if (goodName!=null) {
				String json = gethtmlapi(goodName);
				out.println(json);
			}
		}
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

	public static String api(String goodName) {
		String key=queryGoodsRank.getkey();
    	String api="http://yangkeduo.com/proxy/api/search?pdduid=8055413520578&item_ver=lzqq&source=index&search_met=history&track_data=refer_page_id,10002_1598429378667_deihh0wmaz%3Brefer_search_met_pos,0&list_id=hN8qZx9Cbo&sort=default&filter=&q="+encodeUrl(goodName)+"&page=1&size=50&anti_content="+key;
		Document doc=null;
		Connection connection=Jsoup.connect(api);
		String json = "";
		Long goodId = null;
		connection=connection.header("Referer","https://mobile.yangkeduo.com/search_result.html?search_key="+encodeUrl(goodName));
		connection=connection.header("Origin","http://mobile.yangkeduo.com/");
		connection=connection.header("Content-Type", "application/json;charset=UTF-8");
		connection=connection.header("Cookie", queryGoodsRank.getcookie("pddcookie"));
		connection=connection.header("accesstoken", queryGoodsRank.getcookie("accesstoken"));
		connection=connection.header("verifyauthtoken",queryGoodsRank.getcookie("verifyauthtoken"));
		try {
			doc = connection.userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:74.0) Gecko/20100101 Firefox/74.0").timeout(50000).ignoreContentType(true).get();
			json = doc.text();
			JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
			JsonArray item = jsonObject.get("items").getAsJsonArray();
			for (int i = 0; i < item.size(); i++) {
				JsonObject goods_model = item.get(i).getAsJsonObject().get("item_data").getAsJsonObject().get("goods_model").getAsJsonObject();
				String goods_name = goods_model.get("goods_name").toString().replaceAll("\"", "");
				String short_name = goods_model.get("short_name").toString().replaceAll("\"", "");
				Long goods_id = goods_model.get("goods_id").getAsLong();
				if(goods_name.contains(goodName)||short_name.contains(goodName)) {
					goodId = goods_id;
					break;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block

		}
		if(goodId!=null) {
			json = gethtml(goodId.toString());
		}
		return json;
	}
	
	public static String gethtml(String goodId) {
    	String api="http://mobile.yangkeduo.com/goods.html?goods_id="+goodId;
        String UA = UA();
		Document doc=null;
		Connection connection=Jsoup.connect(api);
		connection=connection.header("Referer","http://mobile.yangkeduo.com/");
		connection=connection.header("Origin","http://mobile.yangkeduo.com/");
		connection=connection.header("Content-Type", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
//		connection=connection.header("Cookie", queryGoodsRank.getcookie("pddcookie"));
		connection=connection.header("Cookie", "api_uid=CiWX0F9wd1d/CQBjNW36Ag==; _nano_fp=XpEoXpPxlpUql0danT_9gn4KKrkmMFf2smr_cOZa; ua="+encodeUrl(UA)+"; webp=1; pdd_vds=gaSLgIVtqQMGWLHigOztSGHIKnJmVIpNFoFQZOVakbHmzmXnWbvoziStFnzm");
		try {
			doc = connection.userAgent(UA).timeout(50000).ignoreContentType(true).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Elements elScripts = doc.getElementsByTag("script");  
        String str="{}";
        for (int i = 0; i < elScripts.size(); i++) {
            Element element = elScripts.get(i).selectFirst("script");
            if (element != null) {
                str = element.data();
                if(str.contains("window.rawData")) {
                    str=str.replace("window.rawData=", "").replace(";", "");
                    try {
						JsonObject json = new JsonParser().parse(str).getAsJsonObject();
						JsonObject data = json.get("store").getAsJsonObject().get("initDataObj").getAsJsonObject();
						JsonObject goods = data.get("goods").getAsJsonObject();
						JsonArray viewImageData = goods.get("viewImageData").getAsJsonArray();
						JsonArray detailGallery = goods.get("detailGallery").getAsJsonArray();
						long time = 0;
						Date d = new Date();
						SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
						for (int j = 0; j < viewImageData.size(); j++) {
							String ssString = viewImageData.get(j).toString();
							ssString=getSubUtilSimple(ssString,"\\d{4}-\\d{2}-\\d{2}");
//							ssString=getSubUtilSimple(ssString,"(?<=(images/)|(-img/)).*(?=/)");
							if(time==0) {
								time = d.getTime();
							}
							if(ssString.equals("")||ssString=="") {
								continue;
							}else {
								try {
									d = sf.parse(ssString);
									if(d.getTime()<time) {
										time = d.getTime();
									}
								} catch (ParseException e) {
									e.printStackTrace();
								}
							}
						}
						for (int j = 0; j < detailGallery.size(); j++) {
							String ssString = detailGallery.get(j).toString();
							ssString=getSubUtilSimple(ssString,"\\d{4}-\\d{2}-\\d{2}");
//							ssString=getSubUtilSimple(ssString,"(?<=(images/)|(-img/)).*(?=/)");
							if(time==0) {
								time = d.getTime();
							}
							if(ssString.equals("")||ssString=="") {
								continue;
							}else {
								try {
									d = sf.parse(ssString);
									if(d.getTime()<time) {
										time = d.getTime();
									}
								} catch (ParseException e) {
									e.printStackTrace();
								}
							}
						}
						String upTime = sf.format(new Date(time)); // 时间戳转换日期
						goods.addProperty("upTime", upTime);
						data.add("goods", goods);
						json = new JsonObject();
						json.addProperty("status", "success");
						json.addProperty("code", 200);
						json.add("data", data);
						json.addProperty("timestamp", new Date().getTime());
						json.addProperty("description", "Powered By DreamFly.");
						str = json.toString();
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
                	break;
                }
            }
		}
		return str;
	}
	
	public static String gethtmlapi(String goodName) {
    	String api="http://mobile.yangkeduo.com/search_result.html?search_key="+goodName;
        String res = "";
        String UA = UA();
		Document doc=null;
		Connection connection=Jsoup.connect(api);
		connection=connection.header("Referer","http://mobile.yangkeduo.com/");
		connection=connection.header("Origin","http://mobile.yangkeduo.com/");
		connection=connection.header("Content-Type", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		connection=connection.header("Cookie",queryGoodsRank.getcookie("pddcookie"));
		try {
			doc = connection.userAgent(UA).timeout(50000).ignoreContentType(true).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(doc.html());
		System.out.println(doc.body().text());
		Elements elScripts = doc.getElementsByTag("script");  
        String str="";
        for (int i = 0; i < elScripts.size(); i++) {
            Element element = elScripts.get(i).selectFirst("script");
            if (element != null) {
                str = element.data();
                if(str.contains("window.rawData")) {
                    str=str.replace("window.rawData=", "").replace(";", "");
                    try {
						JsonObject json = new JsonParser().parse(str).getAsJsonObject();
						JsonObject data = json.get("store").getAsJsonObject().get("data").getAsJsonObject().get("ssrListData").getAsJsonObject();
						JsonArray list = data.get("list").getAsJsonArray();
						for (int j = 0; j < list.size(); j++) {
							JsonObject obj = list.get(j).getAsJsonObject();
							String goodsName = obj.get("goodsName").toString();
							String goodsID = obj.get("goodsID").toString();
							if (goodsName.contains(goodName)) {
								if(goodsID!=null) {
									res = gethtml(goodsID);
									break;
								}
							}
						}
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
//						return gethtmlapi(goodName);
					}
                	break;
                }
            }
		}
		return res;
	}
	
	public static String getSubUtilSimple(String soap,String rgex){  
        Pattern pattern = Pattern.compile(rgex);
        Matcher m = pattern.matcher(soap);  
        while(m.find()){  
            return m.group(0);  
        }  
        return "";  
    }
	
	public static String encodeUrl(String string) {
		try {
			string = URLEncoder.encode(string,"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return string;
	}
	public static String UA() {
		Random random = new Random();
		String UA=UAs[random.nextInt(37)];
		return UA;
	}
}

