package chpher;

import java.io.UnsupportedEncodingException;
import java.security.AlgorithmParameters;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchProviderException;
import java.security.Security;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class AESEncrypt {

    //���ܷ�ʽ
    public static String KEY_ALGORITHM = "AES";
    //������䷽ʽ
    String algorithmStr = "AES/CBC/PKCS7Padding";
    //�����ظ�new���ɶ��BouncyCastleProvider������ΪGC���ղ��ˣ�������ڴ����
    //ֻ�ڵ�һ�ε���decrypt()����ʱ��new ����
    public static boolean initialized = false;

    /**
     * 
     * @param originalContent
     * @param encryptKey
     * @param ivByte
     * @return
     */
    public static byte[] encrypt(byte[] originalContent, byte[] encryptKey, byte[] ivByte) {
        initialize();
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            SecretKeySpec skeySpec = new SecretKeySpec(encryptKey, "AES");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, new IvParameterSpec(ivByte));
            byte[] encrypted = cipher.doFinal(originalContent);
            return encrypted;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * AES����
     * ���ģʽAES/CBC/PKCS7Padding
     * ����ģʽ128
     * @param content
     *            Ŀ������
     * @return
     * @throws Exception 
     * @throws InvalidKeyException 
     * @throws NoSuchProviderException
     */
    public static byte[] decrypt(byte[] content, byte[] aesKey, byte[] ivByte) {
        initialize();
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            Key sKeySpec = new SecretKeySpec(aesKey, "AES");
            cipher.init(Cipher.DECRYPT_MODE, sKeySpec, generateIV(ivByte));// ��ʼ��
            byte[] result = cipher.doFinal(content);
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String decrypt(String content, String key, String iv) {
    	if(content.startsWith("{")||content.startsWith("[")) {
    		return content;
    	}else {
            initialize();
            byte[] aesKey = getBytes(key);
            byte[] aesIv = getBytes(iv);
            byte[] aescontent = hexToByteArray(content);
            try {
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
                Key sKeySpec = new SecretKeySpec(aesKey, "AES");
                cipher.init(Cipher.DECRYPT_MODE, sKeySpec, generateIV(aesIv));// ��ʼ��
                byte[] result = cipher.doFinal(aescontent);
                String res = hexStringToString(bytesToHex(result));
                return res;
            } catch (Exception e) {
            	throw new RuntimeException(e);
            }
    	}
    }
    
    public static byte[] getBytes(String s) {
    	byte[] str = null;
		try {
			str = s.getBytes("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return str;
    }
    
    /**BouncyCastle��Ϊ��ȫ�ṩ����ֹ���Ǽ��ܽ���ʱ����Ϊjdk���õĲ�֧�ָ�ģʽ���б���**/
    public static void initialize() {
        if (initialized)
            return;
        Security.addProvider(new BouncyCastleProvider());
        initialized = true;
    }

    // ����iv
    public static AlgorithmParameters generateIV(byte[] iv) throws Exception {
        AlgorithmParameters params = AlgorithmParameters.getInstance("AES");
        params.init(new IvParameterSpec(iv));
        return params;
    }
    
    public static String bytesToHex(byte[] bytes) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < bytes.length; i++) {
			String hex = Integer.toHexString(bytes[i] & 0xFF);
			if (hex.length() < 2) {
				sb.append(0);
			}
			sb.append(hex);
		}
		return sb.toString();
	}

	public static byte[] hexToByteArray(String inHex) {
		int hexlen = inHex.length();
		byte[] result;
		if (hexlen % 2 == 1) {
			// ����
			hexlen++;
			result = new byte[(hexlen / 2)];
			inHex = "0" + inHex;
		} else {
			// ż��
			result = new byte[(hexlen / 2)];
		}
		int j = 0;
		for (int i = 0; i < hexlen; i += 2) {
			result[j] = hexToByte(inHex.substring(i, i + 2));
			j++;
		}
		return result;
	}

	public static byte hexToByte(String inHex) {
		return (byte) Integer.parseInt(inHex, 16);
	}

	public static String hexStringToString(String s) {
		if (s == null || s.equals("")) {
			return null;
		}
		s = s.replace(" ", "");
		byte[] baKeyword = new byte[s.length() / 2];
		for (int i = 0; i < baKeyword.length; i++) {
			try {
				baKeyword[i] = (byte) (0xff & Integer.parseInt(s.substring(i * 2, i * 2 + 2), 16));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {
			s = new String(baKeyword, "utf-8");
			new String();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return s;
	}
}