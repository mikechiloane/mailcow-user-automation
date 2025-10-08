package com.recceda.http;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

import static com.recceda.Constants.API_KEY_HEADER;

public class MailCowClient {

    private final String apiKey;
    private HttpClient client;

    public MailCowClient(final String baseUrl, final String apiKey){
        this.apiKey = apiKey;
    }


    public HttpRequest.Builder requestBuilder(String path){
        return HttpRequest.newBuilder()
                .uri(URI.create(path))
                .header(API_KEY_HEADER, apiKey);
    }
}
