package cu.entumovil.payment.enzona.controller;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import cu.entumovil.payment.enzona.model.PrincipalDetails;

@RestController
@RequestMapping("/enzona")
@CrossOrigin
public class ProfileRestController {
	/*private final RestTemplate restTemplate = new RestTemplate();
	private final OAuth2AuthorizedClientService oAuth2AuthorizedClientService = null;

	@GetMapping("/")
	public PrincipalDetails profile(OAuth2AuthenticationToken token) {
		OAuth2AuthorizedClient client = this.oAuth2AuthorizedClientService.loadAuthorizedClient(token.getAuthorizedClientRegistrationId(),token.getName());
		String uri = client.getClientRegistration().getProviderDetails().getUserInfoEndpoint().getUri();
		ResponseEntity<PrincipalDetails> responseEntity = this.restTemplate.exchange(uri, HttpMethod.GET, null, PrincipalDetails.class);
		return responseEntity.getBody();
	}

	@PostMapping("/login")
	public static RestTemplate restTemplate(OAuth2AuthorizedClientService clientService) {

		return new RestTemplateBuilder().interceptors((ClientHttpRequestInterceptor) (httpRequest, bytes, execution) -> {
			//Token de autorizacion
			OAuth2AuthenticationToken token = OAuth2AuthenticationToken.class.cast(SecurityContextHolder.getContext().getAuthentication());			

			OAuth2AuthorizedClient client = clientService.loadAuthorizedClient(token.getAuthorizedClientRegistrationId(),token.getName());
			httpRequest.getHeaders().add(HttpHeaders.AUTHORIZATION, "Bearer " + client.getAccessToken().getTokenValue());

			return execution.execute(httpRequest, bytes);
		})
				.build();
	}




	/*
	@GetMapping("/user")
	Profile all() {
		return this.loginService.getProfile();
	}

	@PostMapping("/loginID")
	public TokenResponse createPaymentLink(@RequestBody TokenRequest loginCorreo) throws UnirestException{
		//TokenRequest tokenRequest1 = new TokenRequest("17dff03d0dd9bf02f56ea78af59cc321", "723a252b0192af61569733b034a98f8e");
		return this.loginService.loginCorreo(loginCorreo);
	}
	 */
}
