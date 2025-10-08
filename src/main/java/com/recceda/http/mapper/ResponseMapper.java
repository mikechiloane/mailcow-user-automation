package com.recceda.http.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

import java.lang.reflect.Type;

public class ResponseMapper {

    private final  static ObjectMapper objectMapper = new ObjectMapper()
            .setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);

    public static <T> T toObject(String response, Class<T> type) throws JsonProcessingException {
        return objectMapper.readValue(response, type);
    }
}
