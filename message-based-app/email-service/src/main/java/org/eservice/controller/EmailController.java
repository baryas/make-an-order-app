package org.eservice.controller;

import org.eservice.dto.EmailRequest;
import org.eservice.dto.Order;
import org.eservice.service.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    // http://localhost:8083/api/email/send?recipientEmail=email_here@gmail.com

    @PostMapping("/send")
    public ResponseEntity<String> sendConfirmationEmail
            (@RequestParam String recipientEmail,@RequestBody Order order){
        emailService.sendOrderConfirmationEmail(recipientEmail, order);
        return ResponseEntity.ok("email sent");
    }

    //http:localhost:8083/api/email/sendemail

    @PostMapping("/sendemail")
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest emailRequest) {
        // Extract data from the emailRequest object (recipient, subject, text)
        String to = emailRequest.getRecipient();
        String subject = emailRequest.getSubject();
        String text = emailRequest.getText();

        // Send the email
        emailService.sendConfirmationEmail(to, subject, text);

        return ResponseEntity.ok("Email sent successfully");
    }

}
