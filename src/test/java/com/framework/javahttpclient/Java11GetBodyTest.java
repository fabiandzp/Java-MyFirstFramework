package com.framework.javahttpclient;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static java.net.http.HttpClient.newBuilder;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Java11GetBodyTest {

    private static final String BASE_URL = "https://api.github.com/";

    @Test
    void postWithOutAuthorizationFails() throws IOException, InterruptedException {
        //Arrange - Create Client
        HttpClient httpClient = newBuilder().build();

        //Arrange - create request
        HttpRequest get = HttpRequest.newBuilder(URI.create(BASE_URL + "users/fabiandzp"))
                .GET()
                .setHeader("User-Agent", "Java 11 Http bot")
                .build();

        // Act - sent request
        HttpResponse<String> response = httpClient.send(get, HttpResponse.BodyHandlers.ofString());
        String body = response.body();

        // Assert
        assertTrue(body.contains("\"login\":\"fabiandzp\""));


    }

}
