package utils;

import java.io.UnsupportedEncodingException;

public class URLEncoder {
	public static String encode(String word) {
		try {
			word = java.net.URLEncoder.encode(word,"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return word;
	}
}
