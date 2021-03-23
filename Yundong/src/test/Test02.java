package test;

import java.io.IOException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Test02 {
	public static int num = 1;
	public static boolean flag= false;
	public static String code = "HTX3MD5VKFH8H3";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			creatTimer();
		}
		new Timer().schedule(new TimerTask() {
          @Override
          public void run() {
              try {
            	  cancelxhr();
            	  flag = false;
              } catch (Exception e) {
                  e.printStackTrace();
              }
          }
      },0,10000);
	}
	public static String sendxhr() {
		String res = null;
		Random r = new Random();
		int n  = r.nextInt(1000);
		String issue_text = null;
		if (n%2==0) {
			issue_text = "son of a bitch";
		}else {
			issue_text = "不好玩还不给退款？";
		}
		OkHttpClient client = new OkHttpClient().newBuilder()
				  .build();
				@SuppressWarnings("unused")
				MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded; charset=UTF-8");
				RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
				  .addFormDataPart("sessionid", "15f2372d82ae898ba8fa2907")
				  .addFormDataPart("wizard_ajax", "1")
				  .addFormDataPart("help_issue_origin", "112")
				  .addFormDataPart("help_issue", "115")
				  .addFormDataPart("contact_email", "420443292@qq.com")
				  .addFormDataPart("issue_text", issue_text)
				  .addFormDataPart("issue_appid", "218620")
				  .addFormDataPart("issue_transid", "2807394531415329600")
				  .addFormDataPart("issue_line_item", "2807394531415329601")
				  .addFormDataPart("refund_to_wallet", "0")
				  .build();
				Request request = new Request.Builder()
				  .url("https://help.steampowered.com/zh-cn/wizard/AjaxSubmitRefundRequest?sessionid=15f2372d82ae898ba8fa2907&wizard_ajax=1&help_issue_origin=112&help_issue=115&contact_email=420443292@qq.com&issue_text="+issue_text+"&issue_appid=218620&issue_transid=2807394531415329600&issue_line_item=2807394531415329601&refund_to_wallet=0")
				  .method("POST", body)
				  .addHeader("Accept", "*/*")
				  .addHeader("Accept-Encoding", "gzip, deflate, br")
				  .addHeader("Accept-Language", "zh-CN,zh;q=0.9")
				  .addHeader("Connection", "keep-alive")
				  .addHeader("Content-Length", "319")
				  .addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
				  .addHeader("Cookie", "_ga=GA1.2.695612707.1606471380; _gid=GA1.2.1315943329.1606471380; timezoneOffset=28800,0; steamMachineAuth76561199111007686=729BB0316483716E2C2CFE2D22BA6D9665B39B61; steamRememberLogin=76561199111007686%7C%7Ce2a8cafa36579b0ffff22f947fb91d6f; steamLoginSecure=76561199111007686%7C%7C59BE2975FEB9EC6CD65615D5F5E1DABE359D6745; steamHelpHistory=%5B%7B%22time%22%3A1606539225%2C%22url%22%3A%22%5C%2Fzh-cn%5C%2Fwizard%5C%2FHelpWithGameIssue%5C%2F%3Fissueid%3D112%26transid%3D2807394531415329600%26line_item%3D2807394531415329601%22%2C%22referrer%22%3A%22%22%7D%5D; sessionid=15f2372d82ae898ba8fa2907")
				  .addHeader("Referer", "https://help.steampowered.com/zh-cn/wizard/HelpWithGameIssue/?issueid=112&transid=2807394531415329600&line_item=2807394531415329601")
				  .addHeader("Sec-Fetch-Dest", "empty")
				  .addHeader("Sec-Fetch-Mode", "cors")
				  .addHeader("Sec-Fetch-Site", "same-origin")
				  .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.66 Safari/537.36")
				  .addHeader("X-Requested-With", "XMLHttpRequest")
				  .build();
				try {
					Response response = client.newCall(request).execute();
					res = response.body().string().toString();
					System.out.println("Request Times: "+num);
					System.out.println("Status Code: "+response.code());
					System.out.println("Redirect: "+response.isRedirect());
					System.out.println("Success: "+response.isSuccessful());
					System.out.println("Ready: "+response.message());
					System.out.println("Request Headers:\n\t"+request.headers().toString().substring(0, request.headers().toString().length()-1).replaceAll("\n", "\n\t"));
					System.out.println("Response Headers:\n\t"+response.headers().toString().substring(0, response.headers().toString().length()-1).replaceAll("\n", "\n\t"));
					System.out.println("Response:\n\t"+res);
					num++;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return res;
	}
	public static void cancelxhr() {
		OkHttpClient client = new OkHttpClient().newBuilder()
				  .build();
				@SuppressWarnings("unused")
				MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded; charset=UTF-8");
				RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
				  .addFormDataPart("sessionid", "53a58d8387ec098dad9dfe50")
				  .addFormDataPart("wizard_ajax", "1")
				  .addFormDataPart("reference_code", code)
				  .build();
				Request request = new Request.Builder()
				  .url("https://help.steampowered.com/zh-cn/wizard/AjaxCancelHelpRequest/"+code+"?sessionid=53a58d8387ec098dad9dfe50&wizard_ajax=1&reference_code="+code)
				  .method("POST", body)
				  .addHeader("Accept", "*/*")
				  .addHeader("Accept-Encoding", "gzip, deflate, br")
				  .addHeader("Accept-Language", "zh-CN,zh;q=0.9")
				  .addHeader("Content-Length", "78")
				  .addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
				  .addHeader("Cookie", "_ga=GA1.2.695612707.1606471380; _gid=GA1.2.1315943329.1606471380; timezoneOffset=28800,0; steamMachineAuth76561199111007686=729BB0316483716E2C2CFE2D22BA6D9665B39B61; steamRememberLogin=76561199111007686%7C%7Ce2a8cafa36579b0ffff22f947fb91d6f; steamLoginSecure=76561199111007686%7C%7C9E63693F7249E24B1161D1E58A85B11335B212F5; sessionid=53a58d8387ec098dad9dfe50; steamHelpHistory=%5B%7B%22time%22%3A1606628499%2C%22url%22%3A%22%5C%2Fzh-cn%5C%2Fwizard%5C%2FHelpWithGameIssue%5C%2F%3Fissueid%3D112%26transid%3D2807394531415329600%26line_item%3D2807394531415329601%22%2C%22referrer%22%3A%22%22%7D%2C%7B%22time%22%3A1606628510%2C%22url%22%3A%22%5C%2Fzh-cn%5C%2Fwizard%5C%2FHelpWithMyPurchase%3Fline_item%3D2807394531415329601%26transid%3D2807394531415329600%26sessionid%3D53a58d8387ec098dad9dfe50%26wizard_ajax%3D1%22%2C%22referrer%22%3A%22https%3A%5C%2F%5C%2Fhelp.steampowered.com%5C%2Fzh-cn%5C%2Fwizard%5C%2FHelpWithMyPurchase%3Fline_item%3D2807394531415329601%26transid%3D2807394531415329600%22%7D%2C%7B%22time%22%3A1606628518%2C%22url%22%3A%22%5C%2Fzh-cn%5C%2Fwizard%5C%2FHelpWithGameIssue%5C%2F%3Fissueid%3D112%26transid%3D2807394531415329600%26line_item%3D2807394531415329601%26sessionid%3D53a58d8387ec098dad9dfe50%26wizard_ajax%3D1%22%2C%22referrer%22%3A%22https%3A%5C%2F%5C%2Fhelp.steampowered.com%5C%2Fzh-cn%5C%2Fwizard%5C%2FHelpWithGameIssue%5C%2F%3Fissueid%3D112%26transid%3D2807394531415329600%26line_item%3D2807394531415329601%22%7D%5D")
				  .addHeader("Referer", "https://help.steampowered.com/zh-cn/wizard/HelpWithGameIssue/?issueid=112&transid=2807394531415329600&line_item=2807394531415329601")
				  .addHeader("Sec-Fetch-Dest", "empty")
				  .addHeader("Sec-Fetch-Mode", "cors")
				  .addHeader("Sec-Fetch-Site", "same-origin")
				  .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.66 Safari/537.36")
				  .addHeader("X-Requested-With", "XMLHttpRequest")
				  .build();
				try {
					Response response = client.newCall(request).execute();
					System.out.println("Request Times: "+num);
					System.out.println("Status Code: "+response.code());
					System.out.println("Redirect: "+response.isRedirect());
					System.out.println("Success: "+response.isSuccessful());
					System.out.println("Ready: "+response.message());
					System.out.println("Request Headers:\n\t"+request.headers().toString().substring(0, request.headers().toString().length()-1).replaceAll("\n", "\n\t"));
					System.out.println("Response Headers:\n\t"+response.headers().toString().substring(0, response.headers().toString().length()-1).replaceAll("\n", "\n\t"));
					System.out.println("Response:\n\t"+response.body().string());
					num++;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	public static void getCode() {
		OkHttpClient client = new OkHttpClient().newBuilder()
				  .build();
				Request request = new Request.Builder()
				  .url("https://help.steampowered.com/zh-cn/wizard/HelpRequests")
				  .method("GET", null)
				  .addHeader("Accept", "text/html;charset=utf-8")
				  .addHeader("Accept-Language", "zh-CN,zh;q=0.9")
				  .addHeader("Cache-Control", "max-age=0")
				  .addHeader("Cookie", "_ga=GA1.2.695612707.1606471380; _gid=GA1.2.1315943329.1606471380; timezoneOffset=28800,0; steamMachineAuth76561199111007686=729BB0316483716E2C2CFE2D22BA6D9665B39B61; steamRememberLogin=76561199111007686%7C%7Ce2a8cafa36579b0ffff22f947fb91d6f; steamLoginSecure=76561199111007686%7C%7C9E63693F7249E24B1161D1E58A85B11335B212F5; sessionid=53a58d8387ec098dad9dfe50; steamHelpHistory=%5B%7B%22time%22%3A1606628499%2C%22url%22%3A%22%5C%2Fzh-cn%5C%2Fwizard%5C%2FHelpWithGameIssue%5C%2F%3Fissueid%3D112%26transid%3D2807394531415329600%26line_item%3D2807394531415329601%22%2C%22referrer%22%3A%22%22%7D%2C%7B%22time%22%3A1606628510%2C%22url%22%3A%22%5C%2Fzh-cn%5C%2Fwizard%5C%2FHelpWithMyPurchase%3Fline_item%3D2807394531415329601%26transid%3D2807394531415329600%26sessionid%3D53a58d8387ec098dad9dfe50%26wizard_ajax%3D1%22%2C%22referrer%22%3A%22https%3A%5C%2F%5C%2Fhelp.steampowered.com%5C%2Fzh-cn%5C%2Fwizard%5C%2FHelpWithMyPurchase%3Fline_item%3D2807394531415329601%26transid%3D2807394531415329600%22%7D%2C%7B%22time%22%3A1606628518%2C%22url%22%3A%22%5C%2Fzh-cn%5C%2Fwizard%5C%2FHelpWithGameIssue%5C%2F%3Fissueid%3D112%26transid%3D2807394531415329600%26line_item%3D2807394531415329601%26sessionid%3D53a58d8387ec098dad9dfe50%26wizard_ajax%3D1%22%2C%22referrer%22%3A%22https%3A%5C%2F%5C%2Fhelp.steampowered.com%5C%2Fzh-cn%5C%2Fwizard%5C%2FHelpWithGameIssue%5C%2F%3Fissueid%3D112%26transid%3D2807394531415329600%26line_item%3D2807394531415329601%22%7D%2C%7B%22time%22%3A1606629027%2C%22url%22%3A%22%5C%2Fzh-cn%5C%2Fwizard%5C%2FHelpRequest%5C%2FHTX3MD5VKFH8H3%3Fsessionid%3D53a58d8387ec098dad9dfe50%26wizard_ajax%3D1%22%2C%22referrer%22%3A%22https%3A%5C%2F%5C%2Fhelp.steampowered.com%5C%2Fzh-cn%5C%2Fwizard%5C%2FHelpRequest%5C%2FHTX3MD5VKFH8H3%22%7D%2C%7B%22time%22%3A1606629058%2C%22url%22%3A%22%5C%2Fzh-cn%5C%2Fwizard%5C%2FHelpRequest%5C%2FHTX3MD5VKFH8H3%22%2C%22referrer%22%3A%22%22%7D%2C%7B%22time%22%3A1606630119%2C%22url%22%3A%22%5C%2Fzh-cn%5C%2Fwizard%5C%2FHelpRequest%5C%2FHTX3MD5VKFH8H3%22%2C%22referrer%22%3A%22%22%7D%2C%7B%22time%22%3A1606630126%2C%22url%22%3A%22%5C%2Fzh-cn%5C%2Fwizard%5C%2FHelpRequest%5C%2FHTX3MD5VKFH8H3%22%2C%22referrer%22%3A%22%22%7D%2C%7B%22time%22%3A1606630150%2C%22url%22%3A%22%5C%2Fzh-cn%5C%2Fwizard%5C%2FHelpRequest%5C%2F%22%2C%22referrer%22%3A%22%22%7D%2C%7B%22time%22%3A1606630150%2C%22url%22%3A%22%5C%2Fzh-cn%5C%2Fwizard%5C%2FHelpRequests%22%2C%22referrer%22%3A%22%22%7D%5D; steamHelpHistory=%5B%7B%22time%22%3A1606628499%2C%22url%22%3A%22%5C%2Fzh-cn%5C%2Fwizard%5C%2FHelpWithGameIssue%5C%2F%3Fissueid%3D112%26transid%3D2807394531415329600%26line_item%3D2807394531415329601%22%2C%22referrer%22%3A%22%22%7D%2C%7B%22time%22%3A1606628510%2C%22url%22%3A%22%5C%2Fzh-cn%5C%2Fwizard%5C%2FHelpWithMyPurchase%3Fline_item%3D2807394531415329601%26transid%3D2807394531415329600%26sessionid%3D53a58d8387ec098dad9dfe50%26wizard_ajax%3D1%22%2C%22referrer%22%3A%22https%3A%5C%2F%5C%2Fhelp.steampowered.com%5C%2Fzh-cn%5C%2Fwizard%5C%2FHelpWithMyPurchase%3Fline_item%3D2807394531415329601%26transid%3D2807394531415329600%22%7D%2C%7B%22time%22%3A1606628518%2C%22url%22%3A%22%5C%2Fzh-cn%5C%2Fwizard%5C%2FHelpWithGameIssue%5C%2F%3Fissueid%3D112%26transid%3D2807394531415329600%26line_item%3D2807394531415329601%26sessionid%3D53a58d8387ec098dad9dfe50%26wizard_ajax%3D1%22%2C%22referrer%22%3A%22https%3A%5C%2F%5C%2Fhelp.steampowered.com%5C%2Fzh-cn%5C%2Fwizard%5C%2FHelpWithGameIssue%5C%2F%3Fissueid%3D112%26transid%3D2807394531415329600%26line_item%3D2807394531415329601%22%7D%2C%7B%22time%22%3A1606629027%2C%22url%22%3A%22%5C%2Fzh-cn%5C%2Fwizard%5C%2FHelpRequest%5C%2FHTX3MD5VKFH8H3%3Fsessionid%3D53a58d8387ec098dad9dfe50%26wizard_ajax%3D1%22%2C%22referrer%22%3A%22https%3A%5C%2F%5C%2Fhelp.steampowered.com%5C%2Fzh-cn%5C%2Fwizard%5C%2FHelpRequest%5C%2FHTX3MD5VKFH8H3%22%7D%2C%7B%22time%22%3A1606629058%2C%22url%22%3A%22%5C%2Fzh-cn%5C%2Fwizard%5C%2FHelpRequest%5C%2FHTX3MD5VKFH8H3%22%2C%22referrer%22%3A%22%22%7D%2C%7B%22time%22%3A1606630119%2C%22url%22%3A%22%5C%2Fzh-cn%5C%2Fwizard%5C%2FHelpRequest%5C%2FHTX3MD5VKFH8H3%22%2C%22referrer%22%3A%22%22%7D%2C%7B%22time%22%3A1606630126%2C%22url%22%3A%22%5C%2Fzh-cn%5C%2Fwizard%5C%2FHelpRequest%5C%2FHTX3MD5VKFH8H3%22%2C%22referrer%22%3A%22%22%7D%2C%7B%22time%22%3A1606630150%2C%22url%22%3A%22%5C%2Fzh-cn%5C%2Fwizard%5C%2FHelpRequest%5C%2F%22%2C%22referrer%22%3A%22%22%7D%2C%7B%22time%22%3A1606630150%2C%22url%22%3A%22%5C%2Fzh-cn%5C%2Fwizard%5C%2FHelpRequests%22%2C%22referrer%22%3A%22%22%7D%2C%7B%22time%22%3A1606630363%2C%22url%22%3A%22%5C%2Fzh-cn%5C%2Fwizard%5C%2FHelpRequests%22%2C%22referrer%22%3A%22%22%7D%5D")
				  .addHeader("Sec-Fetch-Dest", "document")
				  .addHeader("Sec-Fetch-Mode", "navigate")
				  .addHeader("Sec-Fetch-Site", "none")
				  .addHeader("Sec-Fetch-User", "?1")
				  .addHeader("Upgrade-Insecure-Requests", "1")
				  .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.66 Safari/537.36")
				  .build();
				try {
					Response response = client.newCall(request).execute();
					String res = response.body().string().toString();
					System.out.println("Request Times: "+num);
					System.out.println("Status Code: "+response.code());
					System.out.println("Redirect: "+response.isRedirect());
					System.out.println("Success: "+response.isSuccessful());
					System.out.println("Ready: "+response.message());
					System.out.println("Request Headers:\n\t"+request.headers().toString().substring(0, request.headers().toString().length()-1).replaceAll("\n", "\n\t"));
					System.out.println("Response Headers:\n\t"+response.headers().toString().substring(0, response.headers().toString().length()-1).replaceAll("\n", "\n\t"));
//					System.out.println("Response:\n\t"+res);
					Document html = Jsoup.parse(res);
					String help_request_row = html.getElementsByClass("help_request_row open").attr("href");
					Pattern r = Pattern.compile("[A-Z0-9]{2}-[A-Z0-9\\-]+");
					Matcher m = r.matcher(help_request_row);
				      if (m.find( )) {
				    	  help_request_row = m.group(0).replaceAll("-", "");
				      } 
				    code = help_request_row;
				    System.out.println("Response:\n\t"+code);
				    num++;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	public static void creatTimer() {
		 Timer timer = new Timer();
		 timer.schedule(new TimerTask() {
           @Override
           public void run() {
               try {
               	String json = sendxhr();
               	if (flag==false) {
                   	JsonObject response = new JsonParser().parse(json).getAsJsonObject();
                   	if(response.get("ref")!=null) {
                   		code = response.get("ref").getAsString();
                   	}else {
                   		getCode();
                   	}
                   	flag = true;
				}
               } catch (Exception e) {
                   e.printStackTrace();
               }
           }
       },0,10);
	}
}
