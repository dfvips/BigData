package test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.imageio.ImageIO;

import org.junit.jupiter.api.Test;
import org.opencv.core.Core;

import chpher.AesKit;
import chpher.DecodeUtil;
import service.service;
import utils.FingerPrint;
import utils.PhotoDigest;
import utils.SimilarityUtil;
import utils.getCookie;
import utils.getTraceId;
import utils.random;
import com.hankcs.hanlp.tokenizer.NLPTokenizer;

class Test01 {

	@Test
	void test() {
//		String content = "FD382D6C108357AFCB0FD641A5D8EF40E1C9AC7FE85504C034DB05536682EA08303C354DF7190D146E37634316A6D78E9801BFB11852C9AF16AF7C09411CBC9F0305C0A44520356BFC43B832B2B9D623AAEF450D56770B6C398E9F332B39463636DCDE46087F922E2506738830EDF6B6BE44CAF70C356B52ADB7E9B140F1480936E0E03FA93E652B944B9B88FDC8A27A495C01B7B20D63BE4E206BB8305745EC1AC22B9418F922C915B6A0A31BBC0E64F6D283FF86D6F6EEE8FFE0867B5B698F1E172369F0AA166C3B769B5227E5A71404D35B5B578DC58897E824CBEBBEB393A4D0E8085423F2E1093F6462B545A6B3FC289499EFD80DF041E1E047E7AB9CDF45915A771D6BB44231D23DA2F31B8E815D8AA51C027B57565F86C546DB33BF1D5BF99EF501CA3519AE81E5107C9BEC76C6DA297F64EFEFDA9384651B186891C7FE848EF7921015812D871BF1C6F21C1B710FA7FDC7FA8B12DFA6710A3EDD88FACCA13DF596D586592A6167C425C81DF4C25E739700CF0AE620C9ACB88044EC70EC6244CFFDB79EB8375E49A0A76A3639765ADCC12F3BECE583A04466ED848F00CB84F83CFE929F03A496D4A03DCBE2FA63E3B973B006A4A8DBDC58249DDF47D3F5F250E8BBDECDF986825D438DF8B970002AFCD17701CCFBFDD4B3E264691C66A54A27A2F93CD6ED2B1F9FE1B4EE4F06DBD1BCF188EE208EDC2C51BE7F049241";
//		String key = "w28Cz694s63kBYk4";
//		String iv = "4kYBk36s496zC82w";
//		String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCJ50kaClQ5XTQfzkHAW9Ehi+iXQKUwVWg1R0SC3uYIlVmneu6AfVPEj6ovMmHa2ucq0qCUlMK+ACUPejzMZbcRAMtDAM+o0XYujcGxJpcc6jHhZGO0QSRK37+i47RbCxcdsUZUB5AS0BAIQOTfRW8XUrrGzmZWtiypu/97lKVpeQIDAQAB";
//		//String privateKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAMXXKUENB9fwG4HrJ4J0VDerAsUYRgcx8yOkt+s2gmsiLCiSXvM6xSfppN0OY0+JdALw9kI5X8GYtEk/hqU+ZxNsTRSoLo0+WNNRz4weqVsBnALAwgdPIgqX+n+3j4crYm81M4hyZU/JGYKf1UiKiU9fOylFU/PrzBYZP5RaDQElAgMBAAECgYEAs7vkM7/11zzAkMglDcRHWoeXLZ3+yLydSk1z9VGBLHlQKs/HSSukP71o1Jckq/aRGbb10nYzQztK1pzK40aM9qRT39A2lOadg49CzM5Xp3jRqZ9LIQA44ufmXRY1HpSQ7Ol1inuPxe6ddhWk22ZPUR/1/BbEf2G4T1YB9n1gtSECQQDmC041iWIYHPZf/V6Pcpk7MXdvFhUR8OQARrP3EF8V2gtFj8mvbMNNtplu3A5MrTwk7MWo8v9SXiJKVLDc3dwdAkEA3Cmrom9Hprc87G15bm5U1fRpi4ipX/A5hVMBXv7qIHKSVjqEz00krmIp/vffdzFwhYHt7vBo/K9m90GNId7aqQJBAN9EHbXMDo6EnYHwMHRcrudKTTZdYjm1aDP0avngw8g7hTEQKpi9oJeuHx//J0m34GWd/wDIRpE0l2c45yaVlOkCQG7P4n19eRjmfZmaeFYm3jhaLo12mZmaNblvT+9aaskuIY2ZIqOcdmv3KKAWbrl1fucTwIhVJOKZ/j9RFRIJMxECQDNAfAH+dr2MZBOJC64OGHQPIRnvyH2cHmCY1sH3Lkcog6156MVckDCZp/ozOun/pbtdTUj61iZQ2f79+c8phd8=";
//		String res = AESEncrypt.decrypt(content, key, iv);
//		System.out.println(res);
//		//String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCgWtxaILwPbhqaOsWMpUzDGWVatzEhxXvCv2kddWAF04wBi6aY9A0uP9RiaRXULckPogh4QnOM70gshSt4bArzWpkxGVF1zxk77zQc4pHHxSt25fPJ2yL2UTeqpa4jEVQ2L0/Rkvy/Jbo9rCDxoEa2s8aN1FjWfcSwmJQ11398hwIDAQAB";
//		//String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAKBa3FogvA9uGpo6xYylTMMZZVq3MSHFe8K/aR11YAXTjAGLppj0DS4/1GJpFdQtyQ+iCHhCc4zvSCyFK3hsCvNamTEZUXXPGTvvNBzikcfFK3bl88nbIvZRN6qlriMRVDYvT9GS/L8luj2sIPGgRrazxo3UWNZ9xLCYlDXXf3yHAgMBAAECgYBj/YRd5v+dl4ibF37L3t9o4NMkqArJBj3QCE9hgSlpOKqa5Bv0UGpPppmm6+QitJIlX2JsqvMmtKaKrFeY9bY1X2SEhq45sV96EqCcRONwU7x1EM7UCSOr7P5kllztoTe/0gWw0IhThFn69EXQ3lWVCVEve2QgwcKuAzZYaVrIYQJBAN1OeEug0jLX58dITo7quccJlQ8/b9FS1K7gIZcEp84MCpEz6ti6GjtTMVExTxwWfSJXD5cJLsO/FAzZBjwFlSkCQQC5fkQD9bhl6SE51TxuvdY7fkbWasCmJgwBXtrT5IeQrQhpyr9Pi7le74QKclCqQqvP6j6tciiPfYaO/IaYqYovAkASQUzPAD8WjpTB7Yb9ZwNYFcRD87mnjKuamUZsDKhC6N9eRugSZJeRWTVyOx0JdhlwYboZfVpsLzDaNnS7MsKxAkBd24b83fONFXZrdfsbKdFhzxZ23hNWvr+qXd2qA+OYkAVGyoEc9d05LUaJpqgsTonzLVrDlpTxbhmM9jgAvSCfAkEApAoN0oSnvXE1Xq6+CyIX7CjFbv44X6fcwAfxK9/+DyRZgiUXNBizApRNkYGsMNaLsc4ce7K5Q0LKPdH0E55xWw==";
////		String str = Long.toString(new Date().getTime()).substring(0, 10);
//		String str = "w28Cz694s63kBYk4";
////		String te = "L6DIHneGx4I5/GvZEn3R+3gweooeGF4FOgvMWVNRAQmGd8I9eyPGPKhWR+CdiPTEdDc3qYJ1Pwvst7kFFcoBZ4vSR/dem418bKnihGCA/fF+XJalO1PyuukCLbgm74MtiWuGlJPrwFhkLyhntq2kR+uThPOfdp/i3Nm0H6+PdsE=";
//		String te = null;
//		try {
//			te = RSAEncrypt.encrypt(str, publicKey);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("RSA加密后："+te);
////		String org = null;
////		try {
////			org = RSAEncrypt.decrypt(te, publicKey);
////		} catch (Exception e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////		System.out.println("RSA解密后："+org);
//	}
//		System.out.println(DecodeUtil.decodeData(content));
//		System.out.println(DecodeUtil.getTransitId());
//		System.out.println(getCookie.getcookie("cookie"));
//		System.out.println(getTraceId.traceId());
//		for (int i = 0; i < 50; i++) {
////			System.out.println(random.getDelay());
//			System.out.println(getTraceId.traceId());
//		}
//		int num = service.fillHotrank(123, "1cds", "sdc", "603262759308", "dsc", "dsc", "dcscs", "csdcs", "cdscsdc", "cdscs", "csdcsdcdsa", "603262759308", 12, 10, "csdcs", "dcscs", "2020-09-09", "2020-09-09 10:11:11");
//		System.out.println(num);
//		double f1 = new BigDecimal((float)2540/1000).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
//		System.out.println(f1);
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(new Date());
		gc.add(5, -36);
		System.out.println(sf.format(gc.getTime()));
		System.out.println(getTraceId.randomNum(12));
//		System.err.println(getTraceId.traceId());
//		System.out.println(SimilarityUtil.getSimilarity("网红NOVO眼影闪粉哑光珠光色彩笔记本九色眼影盘ins超火平价防水 ", "李佳琪推荐九色眼影盘网红同款珠光闪粉防水大地色眼影初学者学生"));
//		System.out.println(SimilarityUtil.getSimilarity("网红NOVO眼影闪粉哑光珠光色彩笔记本九色眼影盘ins超火平价防水 ", "【新品爆闪】正品网红透明九色眼影盘ins超火珠光闪粉学生平价女"));
//		System.out.println(SimilarityUtil.getSimilarity("网红NOVO眼影闪粉哑光珠光色彩笔记本九色眼影盘ins超火平价防水 ", "九色眼影盘ins超火闪粉珠光防水亮片便携平价小众学生网红款眼影"));
//		System.out.println(SimilarityUtil.getSimilarity("网红NOVO眼影闪粉哑光珠光色彩笔记本九色眼影盘ins超火平价防水 ", "奶茶晶石猫眼指甲油胶2020年新款流行色百变冰沙宽猫眼美甲店专用"));
//		System.out.println(SimilarityUtil.getSimilarity("正品网红透明九色眼影盘ins超火珠光闪粉学生平价女 ", "九色眼影盘闪粉珠光亮片防水ins超火平价学生小众初学者网红款."));
//		System.out.println(SimilarityUtil.getSimilarity("九色眼影盘ins超火闪粉珠光防水亮片便携平价小众学生网红款眼影 ", "九色眼影盘闪粉珠光亮片防水ins超火平价学生小众初学者网红款."));
//		System.out.println(SimilarityUtil.getSimilarity("九色眼影盘ins超火闪粉珠光防水亮片便携平价小众学生网红款眼影 ", "自然色半透明指甲油免烤快干不可剥裸透果冻色持久不可撕拉学生"));
//		System.out.println(SimilarityUtil.getSimilarity("初学者彩妆全套4-11件组合学生化妆品眼妆套装防水眉笔眼线笔眼影 ", "九色眼影盘闪粉珠光亮片防水ins超火平价学生小众初学者网红款."));
//		String base = "C:\\Users\\梦丶随心飞\\Desktop\\";
//		System.out.println(SimilarityUtil.imgsimilar(base+"aaa.jpg", base+"bbb.jpg"));
//		System.out.println(SimilarityUtil.imgsimilar(base+"ccc.jpg", base+"bbb.jpg"));
//		System.out.println(SimilarityUtil.imgsimilar(base+"aaa.jpg", base+"fff.jpeg"));
//		System.out.println(SimilarityUtil.imgsimilar(base+"fff.jpeg", base+"ggg.jpg"));
//		System.out.println(SimilarityUtil.imgsimilar(base+"bbb.jpg", base+"ggg.jpg"));
//		System.out.println(SimilarityUtil.imgsimilar(base+"aaa.jpg", base+"ggg.jpg"));
//		System.out.println(SimilarityUtil.imgsimilar(base+"aaa.jpg", base+"ccc.jpg"));
//		System.out.println(SimilarityUtil.imgsimilar(base+"bbb.jpg", base+"bbb.jpg"));
//		System.out.println(SimilarityUtil.imgsimilar(base+"aaa.jpg", base+"aaa.jpg"));
//		System.out.println(SimilarityUtil.imgsimilar(base+"ccc.jpg", base+"ccc.jpg"));
//		System.out.println(SimilarityUtil.imgsimilar(base+"fff.jpeg", base+"fff.jpeg"));
///		System.out.println(SimilarityUtil.imgsimilar(SimilarityUtil.readImage("https://www.baidu.com"), SimilarityUtil.readImage("https://www.baidu.com")));
//		System.out.println(getCookie.getWebPath(null));
		String taobaoname="uoTOFOjvM7TS6Mj/BLFr4WZmex/kGYB6jvD3sfXqwu8=";
		String taobaopwd="ywDJziJNjn4hcENz0QZ10Q==";
		try {
			System.out.println(AesKit.detrypt2(taobaoname));
			System.out.println(AesKit.detrypt2(taobaopwd));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
