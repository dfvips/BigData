package utils;

import java.io.FileReader;
import java.io.Reader;
import java.util.Properties;

public class getCookie {
	public static String getcookie(String value) {
		String fileName="cookie.properties";
		String filePath = getWebPath(fileName);
		Reader myReader;
		String cookie="";
		try {
			myReader = new FileReader(filePath);
	        Properties prop = new Properties();// ����Properties��
	        prop.load(myReader);// ��Properties���������ļ�
	        cookie=prop.getProperty(value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// ��ȡproperty�ļ�
		return cookie;
	}
    public static String getWebPath(String fileName) {
        // file:/D:/JavaWeb/.metadata/.me_tcat/webapps/TestBeanUtils/WEB-INF/classes/
        String path = Thread.currentThread().getContextClassLoader().getResource("").toString();
        // ȥ������·���и��ֲ���Ҫ�Ķ���
        path = path.replace('/', '\\'); // ��/����\
        path = path.replace("file:", ""); // ȥ��file:
        // path = path.replace("classes\\", ""); // ȥ��class\
        path = path.substring(1); // ȥ����һ��\,�� \D:\JavaWeb...
 
        // ������ļ���������·���ϼ����ļ���
        if(fileName!=null) {
            if (fileName.isEmpty() == false) {
                path += fileName;
            }
        }
        return path.replace("%20", " ").replace("\\classes", "");
    }
}
