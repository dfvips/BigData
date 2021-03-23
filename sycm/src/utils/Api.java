package utils;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import chpher.DecodeUtil;

public class Api {

	@SuppressWarnings("deprecation")
	public static String get(String api, String referer, String sycm_referer) {
		Document doc = null;
		Connection connection = Jsoup.connect(api);
		String json = "";
		String traceId = getTraceId.traceId();
		System.out.println(traceId);
		connection = connection.header("referer", referer);
		connection = connection.header("eagleeye-traceid", traceId);
		connection = connection.header("p3p",
				"CP='CURa ADMa DEVa PSAo PSDo OUR BUS UNI PUR INT DEM STA PRE COM NAV OTC NOI DSP COR'");
		connection = connection.header("s", "STATUS_NORMAL");
		connection = connection.header("Content-Type", "application/json;charset=UTF-8");
		connection = connection.header("cookie", getCookie.getcookie("cookie"));
		connection = connection.header("transit-id", DecodeUtil.getTransitId());
		if (api.contains("h5api")||api.contains("h5")) {
			connection = connection.header("user-agent",
					"Mozilla/5.0 (iPhone; CPU iPhone OS 13_2_3 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/13.0.3 Mobile/15E148 Safari/604.1");
		} else {
			connection = connection.header("user-agent",
					"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.89 Safari/537.36");
			connection = connection.header("sycm-referer", sycm_referer);
		}
		try {
			doc = connection.timeout(500000000).ignoreContentType(true).get();
			json = doc.text();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (!api.contains("h5api")&&!api.contains("h5")) {
			json = json.replaceAll("\\\\\"", "\\\"");
		}
//		System.out.println(json);
		if (JSON.isValidObject(json) == true) {
			System.out.println(json);
			JSONObject obj = JSONObject.parseObject(json);
			if (obj != null ||(obj != null && !api.contains("sycm.taobao.com"))) {
				if(obj.getString("data") != null) {
					String encryptData = null;
					encryptData = obj.getString("data").toString();
					String data = DecodeUtil.decodeData(encryptData);
					Object dataobj = JSON.parse(data);
					obj.put("data", dataobj);
					System.out.println(obj.toString());
					return obj.toString();
				}else {
					if(obj.getString("message") != null&&obj.getString("message").toString().contains("异常")) {
						try {
							Integer time = random.getDelay();
							Thread.currentThread();
							Thread.sleep(time);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						String res = get(api, referer, sycm_referer);
						System.out.println(res);
						return res;
					}else {
						return obj.toString();
					}
				}			
//			} else if (obj != null && !obj.getString("message").equals("操作成功")) {
//				String res = get(api, referer, sycm_referer);
//				System.out.println(res);
//				return res;
			} else {
				String res = get(api, referer, sycm_referer);
				System.out.println(res);
				return res;
			}
		} else {
			return "{}";
		}
	}

}
