package com.framework.javahttpclient;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Java11GetHeaderTestRefactored {

    private static final String BASE_URL = "https://api.github.com/";

    static HttpClient httpClient = HttpClient.newBuilder().build();
    static HttpResponse<Void> response;


    @BeforeAll
    static void sendGetBaseEndPoint() throws IOException, InterruptedException {
        HttpRequest get = HttpRequest.newBuilder(URI.create(BASE_URL))
                //.GET()
                .setHeader("User-Agent", "Java 11 Http bot")
                .build();

        response = httpClient.send(get, HttpResponse.BodyHandlers.discarding());
    }

    //Test Not refactored
    @Test
    void getReturns200() throws IOException, InterruptedException {

        // Arrange
        HttpClient httpClient = HttpClient.newBuilder().build();

        HttpRequest get = HttpRequest.newBuilder(URI.create(BASE_URL))
                //.GET()
                .setHeader("User-Agent", "Java 11 Http bot")
                .build();

        // Act
        HttpResponse<Void> response = httpClient.send(get, HttpResponse.BodyHandlers.discarding());
        int actualCode = response.statusCode();
//        String body = response.body().toString();
//        System.out.println(body);

        // Assert
        Assertions.assertEquals(200, actualCode);
    }

    //Multiple headers tests refactored in one
    @ParameterizedTest
    @CsvSource({
            "x-ratelimit-limit,60",
            "content-type,application/json; charset=utf-8",
                "server,GitHub.com",
                "x-frame-options,deny"
    })
    void parametrizedTestForHeaders(String header, String expectedValue) {
        // Act
        String contentType = response.headers().firstValue(header).get();

        // Assert
        Assertions.assertEquals(expectedValue, contentType);
    }

}
