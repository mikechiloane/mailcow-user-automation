package com.recceda.http.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CreateMailRequest {
    private String localPart;
    private String domain;
    private String name;
    private String quota;
    private String password;
    private String getPassword2;
    private String active;
    private String forcePwUpdate;
    private String tlsEnforceIn;
    private String getTlsEnforceOut;

}
