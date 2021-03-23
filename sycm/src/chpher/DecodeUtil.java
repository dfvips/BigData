package chpher;

public class DecodeUtil {
	private final static String key = "w28Cz694s63kBYk4";
	private final static String iv = "4kYBk36s496zC82w";

	public static String getTransitId() {
		String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCJ50kaClQ5XTQfzkHAW9Ehi+iXQKUwVWg1R0SC3uYIlVmneu6AfVPEj6ovMmHa2ucq0qCUlMK+ACUPejzMZbcRAMtDAM+o0XYujcGxJpcc6jHhZGO0QSRK37+i47RbCxcdsUZUB5AS0BAIQOTfRW8XUrrGzmZWtiypu/97lKVpeQIDAQAB";
		String transitId = null;
		try {
			transitId = RSAEncrypt.encrypt(key, publicKey);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return transitId;
	}

	public static String decodeData(String data) {
		String decodeData = AESEncrypt.decrypt(data, key, iv);
		return decodeData;
	}
}
