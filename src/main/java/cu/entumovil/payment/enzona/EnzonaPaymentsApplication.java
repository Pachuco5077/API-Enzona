package cu.entumovil.payment.enzona;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class EnzonaPaymentsApplication {

	@Bean
	RestTemplate restTemplate(OAuth2AuthorizedClientService clientService) {
		
		///// PRUEBAS ////
		return new RestTemplateBuilder().interceptors((ClientHttpRequestInterceptor) (httpRequest, bytes, execution) -> {
			
			
			//Token de autorizacion
			OAuth2AuthenticationToken token = OAuth2AuthenticationToken.class.cast(SecurityContextHolder.getContext().getAuthentication());			

			System.out.println("- - - Este es el token: " + token.getCredentials());
			
			//Cliente autorizado con el token
			OAuth2AuthorizedClient client = clientService.loadAuthorizedClient(token.getAuthorizedClientRegistrationId(),token.getName());
			httpRequest.getHeaders().add(HttpHeaders.AUTHORIZATION, "Bearer " + client.getAccessToken().getTokenValue());

			return execution.execute(httpRequest, bytes);
		})
				.build();
	}

	public static void main(String[] args) {
		
		
		SpringApplication.run(EnzonaPaymentsApplication.class, args);
	}
}

