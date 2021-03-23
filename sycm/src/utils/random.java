package utils;

import java.math.BigDecimal;
import java.util.Random;

public class random {
	public static Integer getDelay() {
		Random rand = new Random();
		Integer res = rand.nextInt(5000);
		if(res<1000) {
			res += 1000;
		}
		double tm = new BigDecimal((float)res/1000).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		System.out.println("请求间隔时间为:"+String.format("%.2f", tm)+"s");
		return res;
	}
}
