import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
 
/**
 * @author Crunchify.com
 * 
 */
 
public class JavaTest {
	public static void main(String args[]) throws Exception {
 
		String[] hostList = { "http://http://168.61.20.23:8080/" };
 
		for (int i = 0; i < hostList.length; i++) {
 
			String url = hostList[i];
			getStatus(url);
 
		}
 
		System.out.println("Task completed...");
	}
 
	public static String getStatus(String url) throws IOException {
 
		String result = "";
		int code = 200;
		try {
			URL siteURL = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) siteURL.openConnection();
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(3000);
			connection.connect();
 
			code = connection.getResponseCode();
			if (code == 200) {
				result = "-> Green <-\t" + "Code: " + code;
				;
			} else {
				result = "-> Yellow <-\t" + "Code: " + code;
			}
		} catch (Exception e) {
			result = "-> Red <-\t" + "Wrong domain - Exception: " + e.getMessage();
 
		}
		System.out.println(url + "\t\tStatus:" + result);
		return result;
	}
 
}
