package utils;

import com.google.gson.JsonObject;

public class unicode {
	public static String toUnicode(String str) {  
        String result = "";  
        for (int i = 0; i < str.length(); i++) {  
            int chr1 = (char) str.charAt(i);  
            if (chr1 >= 19968 && chr1 <= 171941) {// ºº×Ö·¶Î§ \u4e00-\u9fa5 (ÖÐÎÄ)  
                result += "\\u" + Integer.toHexString(chr1);  
            } else {  
                result += str.charAt(i);  
            }  
        }  
        return result;  
    }  
	public static String handtxt(JsonObject s) {
		String str= s.toString().replaceAll("\\\\u", "\\u");
		return str;
	}
}
