package cu.entumovil.payment.enzona.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mashape.unirest.http.exceptions.UnirestException;

import cu.entumovil.payment.enzona.service.PaymentService;

@RestController
@RequestMapping("/enzona")
@CrossOrigin
public class PaymentController {
	/*@Autowired
	private PaymentService paymentLinkService;
	
	@PostMapping("/paymentintent")
	public PaymentLinkResponse createPaymentLink(@RequestBody PaymentLinkRequest paymentLink) throws UnirestException{
		return this.paymentLinkService.createPaymentLink(paymentLink);
	}
	@PostMapping("/cancelPayment")
	public List getPaymentslink() {
		return this.paymentLinkService.getPaymentslink();
	}
	@PostMapping("/completarPayment")
	public List getPaymentslink() {
		return this.paymentLinkService.getPaymentslink();
	}*/
}
