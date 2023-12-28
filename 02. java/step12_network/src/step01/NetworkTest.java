package step01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

public class NetworkTest {

	public static void main(String[] args) {
		
		// IP
//		InetAddress local;
//		try {
//			local = InetAddress.getLocalHost();
//			System.out.println(local.getHostAddress());
//			System.out.println(local.getAddress());
//			System.out.println(local.getHostName());
//			
//			
//			
//			// 외부
//			
//			InetAddress remote = InetAddress.getByName("naver.com");
//			System.out.println(remote);
//			
//			InetAddress[] remoteAll = InetAddress.getAllByName("naver.com");
//			for (InetAddress v : remoteAll) {
//				System.out.println(v);
//			}
//		
//		
//		
//		
//		
//		
//		
//		} catch (UnknownHostException e) {
//			e.printStackTrace();
//		}
		
		
		//URL
		// https://www.naver.com/index.html
		try {
			URL naverURL = new URL("https://www.naver.com/index.html");
//			System.out.println(naverURL.getPath());
			
			BufferedReader br = new BufferedReader(new InputStreamReader(naverURL.openStream()));
			String data = "";
			while((data = br.readLine()) != null) {
				System.out.println(data);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
