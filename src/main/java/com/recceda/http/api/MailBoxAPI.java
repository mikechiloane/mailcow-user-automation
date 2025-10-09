package com.recceda.http.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.recceda.elements.User;
import com.recceda.http.MailCowClient;
import com.recceda.http.mapper.RequestMapper;
import com.recceda.http.mapper.ResponseMapper;
import com.recceda.http.request.CreateMailRequest;
import com.recceda.http.response.CreateMailResponse;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.ExecutionException;

import static com.recceda.constants.Constants.MAILBOX_ENDPOINT;
import static com.recceda.constants.Constants.SUCCESS;

public class MailBoxAPI {

    private final MailCowClient mailCowClient = MailCowClient.getInstance();

    public User createEmailForUser(User user) throws JsonProcessingException, ExecutionException, InterruptedException {
        CreateMailRequest createMailRequest = defaultCreateMailRequest(user.getUsername(), user.getPassword());
        HttpRequest request = mailCowClient.requestBuilder(MAILBOX_ENDPOINT)
                .POST(HttpRequest.BodyPublishers.ofString(RequestMapper.toJson(createMailRequest)))
                .build();
        HttpResponse<String> response = mailCowClient.send(request, HttpResponse.BodyHandlers.ofString()).get();
        CreateMailResponse[] createMailResponse = ResponseMapper.toObject(response.body(), CreateMailResponse[].class);
        if (response.statusCode() != 200 || !createMailResponse[0].getType().equals(SUCCESS))
            throw new RuntimeException("Failed to create account");
        return user;
    }


    private CreateMailRequest defaultCreateMailRequest(String username, String password) {
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
