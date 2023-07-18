package cu.entumovil.payment.enzona.controller;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import cu.entumovil.payment.enzona.model.PrincipalDetails;


@RestController
public class ProfileRestController {
	private final RestTemplate restTemplate;
	private final OAuth2AuthorizedClientService oAuth2AuthorizedClientService;

	public ProfileRestController(RestTemplate restTemplate, OAuth2AuthorizedClientService clientService) {
		this.restTemplate = restTemplate;
		this.oAuth2AuthorizedClientService = clientService;
	}

	@GetMapping("/")
	public PrincipalDetails profile(OAuth2AuthenticationToken token) {
		OAuth2AuthorizedClient client = this.oAuth2AuthorizedClientService.loadAuthorizedClient(token.getAuthorizedClientRegistrationId(),token.getName());
		
		String uri = client.getClientRegistration().getProviderDetails().getUserInfoEndpoint().getUri();

		ResponseEntity<PrincipalDetails> responseEntity = this.restTemplate.exchange(uri, HttpMethod.GET, null, PrincipalDetails.class);
		return responseEntity.getBody();
	}
}
