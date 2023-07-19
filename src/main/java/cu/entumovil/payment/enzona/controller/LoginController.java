package cu.entumovil.payment.enzona.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.nimbusds.oauth2.sdk.token.Token;

import cu.entumovil.payment.enzona.service.LoginService;

@RestController
@RequestMapping("/enzona")
@CrossOrigin
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping("/generarToken")
	public Token generarToken() throws UnirestException{
		return this.loginService.generarTokenAcceso();
	}
	
	/*
	@GetMapping("/user")
	Profile all() {
		return this.loginService.getProfile();
	}
	*/
	/*
	@PostMapping("/loginID")
	public TokenResponse createPaymentLink(@RequestBody TokenRequest loginCorreo) throws UnirestException{
		//TokenRequest tokenRequest1 = new TokenRequest("17dff03d0dd9bf02f56ea78af59cc321", "723a252b0192af61569733b034a98f8e");
		return this.loginService.loginCorreo(loginCorreo);
	}
	*/
}
