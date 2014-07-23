package book30.ch10._3._1.prototypeScopeUsage.service;

import org.springframework.stereotype.Component;

@Component("emailService")
public class EmailService {
	public void sendEmail(String email, String message) {
		System.out.println("Sending mail to " + email + "... Message: " + message);
	}
}
