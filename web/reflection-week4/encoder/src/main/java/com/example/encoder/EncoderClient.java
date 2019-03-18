package com.example.encoder;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
@RequiredArgsConstructor
public class EncoderClient {
   private final RestTemplate restTemplate;
    @Value("${polo.server.url}")
    private String url;

    public String getMessage(String message) {
        return restTemplate.postForObject(url, message, String.class);
    }
}
