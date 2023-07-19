package cu.entumovil.payment.enzona.service;

import java.util.Properties;

import com.nimbusds.jose.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.nimbusds.oauth2.sdk.token.Token;

@Service
public class LoginService {
	
	private RestTemplate http;
	private String baseUrl;
	static String tokenResponse;
	
	@Autowired
	public LoginService(
			@Autowired Environment environment
			) {
		this.baseUrl = environment.getProperty("enzona.url-production");
		this.http = new RestTemplate();
	}
	
	public LoginService(){
	}

	/**
	 * @description OAuth 2.0 client credentials flow
	 * @return TokenResponse
	 */
	public Token generarTokenAcceso() {
		String consumerKey = "17dff03d0dd9bf02f56ea78af59cc321";
		String consumerSecret = "723a252b0192af61569733b034a98f8e";
		String url = baseUrl;
		
		Base64 codToBase64 = Base64.encode((consumerKey +":"+ consumerSecret).getBytes());
		String authHeader = "Authorization: Basic " + new String(codToBase64.toString());
		
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("content-type", "application/json");

		
		ResponseEntity<Token> response = this.http.postForEntity(url, authHeader, Token.class);
		
		tokenResponse = response.getBody().toString(); 
		System.out.println("token: " + tokenResponse);
		
		return response.getBody();
	}

	/**
	 * @description get profile data
	 * @return Profile
	 
	public Profile getProfile() {
		String url = this.baseUrl + "/api/users/profile";
		String authHeader = "Basic " + new String(tokenResponse);
		System.out.println("----token: " + authHeader);

		HttpHeaders headers = new HttpHeaders();
		headers.set("content-type", "application/json");
		headers.set("Authorization", authHeader);

		HttpEntity request = new HttpEntity(headers);
		ResponseEntity<Profile> response = this.http.exchange(url, HttpMethod.GET, request, Profile.class);
		return response.getBody();
	}*/

	
	/**
	 * @description OAuth 2.0 client credentials flow
	 * @return TokenResponse
	 * @throws UnirestException 
	
	public TokenResponse loginCorreo(TokenRequest tokenRequest) throws UnirestException {
		String email = tokenRequest.email;
		String password =  tokenRequest.password;
		
		String url = this.baseUrl + "/api/access/login";
		
		HttpResponse<String> response = Unirest.post(url)
				  .header("Content-Type", "application/json")
				  .header("Accept", "application/json")
				  .body(new Gson().toJson(new TokenRequestCorreo(email, password)))
				  .asString();
		
		TokenResponse conv = new Gson().fromJson(response.getBody(), TokenResponse.class);
		System.out.println(" --- token: " + conv.getAccess_token());
		
		tokenResponse = conv.token; 
		
		return conv;
	} */
}
