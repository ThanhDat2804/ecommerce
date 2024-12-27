package com.example.userservice.service;

import com.example.userservice.constant.AppConstant;
import com.example.userservice.model.dto.request.EmailDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class EmailService {
    private final WebClient.Builder webClientBuilder;

    @Autowired
    public EmailService(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }
    public String sendEmail(EmailDetails emailDetails) {
        // Use block() to wait until completion and get the result value
        return webClientBuilder.baseUrl(AppConstant.DiscoveredDomainsApi.API_GATEWAY_HOST).build()
                .post()
                .uri("/api/email/sendEmail")
                .bodyValue(emailDetails)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
