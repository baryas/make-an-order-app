package com.message.app.controller;

import com.message.app.dto.Order;
import com.message.app.publisher.JsonPublisher;
import com.message.app.publisher.RabbitmqPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/v1")
public class MessageController {

    private final RabbitmqPublisher rabbitmqPublisher;

    private final JsonPublisher jsonPublisher;

    private final RestTemplate restTemplate;

    public MessageController(RabbitmqPublisher rabbitmqPublisher,
                             JsonPublisher jsonPublisher,
                             RestTemplate restTemplate) {
        this.rabbitmqPublisher = rabbitmqPublisher;
        this.jsonPublisher = jsonPublisher;
        this.restTemplate = restTemplate;
    }

    //localhost:8080/api/v1/publish

    @GetMapping("/publish")
    public ResponseEntity<String>
    sendMessgae(@RequestParam("message") String message) {
        rabbitmqPublisher.sendMessage(message);
        return ResponseEntity.ok()
                .body("Message sent to Rabbitmq = " + message);
    }

    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessage(@RequestBody Order order) {
        jsonPublisher.sendJsonMessage(order);

        // Send email confirmation request to email-service

        String emailServiceUrl =
                "http://localhost:8083/api/email/send?recipientEmail=yash2baranwal@gmail.com";;
        ResponseEntity<String> response =
                restTemplate.postForEntity(emailServiceUrl,order,String.class);

        return ResponseEntity.ok("order and mail request has been sent");
    }


}
