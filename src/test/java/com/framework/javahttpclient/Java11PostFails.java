package com.framework.javahttpclient;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static java.net.http.HttpClient.newBuilder;
import static org.junit.jupiter.api.Assertions.*;

public class Java11PostFails {

    private static final String BASE_URL = "https://api.github.com/";

    @Test
    void postWithOutAuthorizationFails() throws IOException, InterruptedException {
        //Arrange - Create Client
        HttpClient httpClient = newBuilder().build();

        //Arrange - create request
        HttpRequest post = HttpRequest.newBuilder(URI.create(BASE_URL + "user/repos"))
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();

        // Act - sent request
        HttpResponse<Void> response = httpClient.send(post, HttpResponse.BodyHandlers.discarding());
        int actualCode = response.statusCode();

        // Assert
        assertEquals(401, actualCode);


    }

}
