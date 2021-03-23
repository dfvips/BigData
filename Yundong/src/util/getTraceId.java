package util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class getTraceId {
	public static String traceId() {
		DateFormat dateFormat = new SimpleDateFormat("SSS");
		String orderNo = new Date().getTime()+dateFormat.format(new Date());
		Random random = new Random();
		orderNo = orderNo + random.nextInt(9);
		return getstart()+random(6)+orderNo+"d"+getend()+random(3);
	}
	public static String random(int length) {
		Random random = new Random();
		String val = "";
		for (int i = 0; i < length; i++) {
			String charOrNum = random.nextInt(9) % 3==0 ? "char" : "num";
			if ("char".equalsIgnoreCase(charOrNum)) {
				int choice = 97;
				val += (char) (choice + random.nextInt(5));
			} else if ("num".equalsIgnoreCase(charOrNum)) {
				val += String.valueOf(random.nextInt(10));
			}
		}
		return val;
	}
	
	public static String randomNum(int length) {
		Random random = new Random();
		String val = "";
		for (int i = 0; i < length; i++) {
			val += String.valueOf(random.nextInt(10));
		}
		return val;
	}
	
	public static String getstart() {
		Random random = new Random();
		String val = random.nextInt(100) > 3 ? "0b" : "21";
		return val;
	}
	public static String getend() {
		Random random = new Random();
		String val = random.nextInt(100) > 20 ? "0" : "1";
		return val;
	}
	public static String toJson(String result) {
		int start = result.indexOf("(");
        int end = result.lastIndexOf(")");
        String res = result.substring(start+1, end);
        return res;
	}
}
