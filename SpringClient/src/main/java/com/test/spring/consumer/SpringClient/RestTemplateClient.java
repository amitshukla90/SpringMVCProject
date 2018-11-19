package com.test.spring.consumer.SpringClient;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Base64;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestTemplateClient {
	
	public static void main(String[] arges) throws URISyntaxException {
	 RestTemplate  restTemplate = new RestTemplate();
	 String userAndPass = "amit"+":"+"test";
	 String encodedPass = Base64.getEncoder().encodeToString(userAndPass.getBytes());
	 HttpHeaders headers = new HttpHeaders();
	 headers.add("Authorization", "Basic "+encodedPass);
	 
	URI url = new URI("http://localhost:8080/hello");
	HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
	ResponseEntity<String> response = restTemplate.exchange(url , HttpMethod.GET, requestEntity , String.class);
	 System.out.println(response.getBody());
	}

}
