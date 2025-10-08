package com.recceda.http.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class CreateMailRequest {
    private String localPart;
    private String domain;
    private String name;
    private String quota;
    private String password;
    private String password2;
    private String active;
    private String forcePwUpdate;
    private String tlsEnforceIn;
    private String tlsEnforceOut;
}
