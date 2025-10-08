package com.recceda.http.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.recceda.http.MailCowClient;
import com.recceda.http.mapper.RequestMapper;
import com.recceda.http.request.CreateMailRequest;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static com.recceda.Constants.MAILBOX_ENDPOINT;

public class MailBox {

    private final MailCowClient  mailCowClient = MailCowClient.getInstance();
    public String createEmailForUser(String username, String password) throws JsonProcessingException {
        HttpRequest request = mailCowClient.requestBuilder(MAILBOX_ENDPOINT)
                .POST(HttpRequest.BodyPublishers.ofString(RequestMapper.toJson(defaultCreateMailRequest(username, password))))
                .build();

        HttpResponse<String>
    }


    private CreateMailRequest defaultCreateMailRequest(String username, String password){
        return CreateMailRequest.builder()
                .domain(mailCowClient.getDomain())
                .active("1")
                .name(username)
                .quota("500")
                .localPart(username)
                .forcePwUpdate("0")
                .password(password)
                .password2(password)
                .tlsEnforceOut("0")
                .tlsEnforceIn("0")
                .build();
    }
}
