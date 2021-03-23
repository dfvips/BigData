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
	        Properties prop = new Properties();// 创建Properties类
	        prop.load(myReader);// 用Properties类对象加载文件
	        cookie=prop.getProperty(value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// 读取property文件
		return cookie;
	}
    public static String getWebPath(String fileName) {
        // file:/D:/JavaWeb/.metadata/.me_tcat/webapps/TestBeanUtils/WEB-INF/classes/
        String path = Thread.currentThread().getContextClassLoader().getResource("").toString();
        // 去掉返回路径中各种不需要的东西
        path = path.replace('/', '\\'); // 将/换成\
        path = path.replace("file:", ""); // 去掉file:
        // path = path.replace("classes\\", ""); // 去掉class\
        path = path.substring(1); // 去掉第一个\,如 \D:\JavaWeb...
 
        // 如果有文件名，则在路径上加入文件名
        if(fileName!=null) {
            if (fileName.isEmpty() == false) {
                path += fileName;
            }
        }
        return path.replace("%20", " ").replace("\\classes", "");
    }
}
