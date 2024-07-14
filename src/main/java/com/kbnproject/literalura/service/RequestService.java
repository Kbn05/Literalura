package com.kbnproject.literalura.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

@Service
public class RequestService {

    private final HttpClient client;

    public RequestService(){
        this.client = HttpClient.newHttpClient();
    }

    public String requestBook(String title){
        String bookTitle = URLEncoder.encode(title, StandardCharsets.UTF_8);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://gutendex.com/books?search=" + bookTitle))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
//            return ("Error");
        }
    }
}
