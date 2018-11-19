package com.test.spring.consumer.SpringClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
			URL url = new URL("http://localhost:8080/hello");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			String userAndPass = "amit"+":"+"test";
			String encodedPass = Base64.getEncoder().encodeToString(userAndPass.getBytes());
			connection.setRequestProperty("Authorization", "Basic "+encodedPass);
			if(connection.getResponseCode() != 200) {
				System.out.println("Error while calling");
				System.out.println(connection.getResponseCode());
				InputStreamReader reader = new InputStreamReader(connection.getErrorStream());
				BufferedReader br = new BufferedReader(reader);
				String line;
				while((line = br.readLine())!= null) {
					System.out.println(line);
				}
				
			}
			InputStreamReader reader = new InputStreamReader(connection.getInputStream());
			BufferedReader br = new BufferedReader(reader);
			String line;
			while((line = br.readLine())!= null) {
				System.out.println(line);
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
    }
}
