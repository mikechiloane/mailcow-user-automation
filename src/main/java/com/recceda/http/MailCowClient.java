package com.recceda.http;

import lombok.Getter;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

import static com.recceda.constants.Constants.API_KEY_HEADER;

public class MailCowClient {

    private static MailCowClient instance;
    private final String apiKey;
    @Getter
    private final String domain;
    private final String baseUrl;
    @Getter
    private HttpClient client;

    private MailCowClient() {
        String apiKey = System.getenv("MAIL_API_KEY");
        String baseUrl = System.getenv("MAIL_BASE_URL");
        String domain = System.getenv("MAIL_DOMAIN");
        if (apiKey == null || baseUrl == null || domain == null)
            throw new IllegalStateException("Api key or base url missing");
        this.apiKey = apiKey;
        this.baseUrl = baseUrl;
        this.domain = domain;
        this.client = HttpClient.newHttpClient();
    }

    public static synchronized MailCowClient getInstance() {
        if (instance == null) {
            instance = new MailCowClient();
        }
        return instance;
    }

    public HttpRequest.Builder requestBuilder(String path) {
        return HttpRequest.newBuilder()
                .uri(URI.create(this.baseUrl+path))
                .header(API_KEY_HEADER, apiKey);
    }

    public <T> CompletableFuture<HttpResponse<T>> send(HttpRequest request, HttpResponse.BodyHandler<T> bodyHandler) {
        return client.sendAsync(request, bodyHandler);
    }

}
