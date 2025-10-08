package com.recceda.http.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;

import java.net.http.HttpResponse;


public class ResponseMapper {

    private final  static ObjectMapper objectMapper = new ObjectMapper()
            .setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);

    public static <T> T toObject(String response, Class<T> type) throws JsonProcessingException {
        return objectMapper.readValue(response, type);
    }
    public static <T> T toObject(HttpResponse<String> response, TypeReference<T> typeRef) throws JsonProcessingException {
        return objectMapper.readValue(response.body(), typeRef);
    }
}
