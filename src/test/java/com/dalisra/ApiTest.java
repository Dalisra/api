package com.dalisra;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@MicronautTest
class ApiTest{

    @Inject
    @Client("/")
    HttpClient client;

    @Inject
    EmbeddedApplication<?> application;

    @Test
    void testItWorks(){
        Assertions.assertTrue(application.isRunning());
    }

    @Test
    void testPostWorks(){
        HttpRequest request = HttpRequest.POST("/", "");
        String body = client.toBlocking().retrieve(request);

        Assertions.assertEquals("ok", body);
    }

    @Test
    void testGetWorks(){
        HttpRequest request = HttpRequest.GET("/");
        String body = client.toBlocking().retrieve(request);
        Assertions.assertEquals("wazap", body);
    }

}
