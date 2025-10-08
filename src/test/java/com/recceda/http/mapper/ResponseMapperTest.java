package com.recceda.http.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.recceda.http.response.CreateMailResponse;
import junit.framework.TestCase;

public class ResponseMapperTest extends TestCase {

    public void testToObject() throws JsonProcessingException {
        String response = "[\n" +
                "    {\n" +
                "        \"type\": \"success\",\n" +
                "        \"log\": [\n" +
                "            \"ratelimit\",\n" +
                "            \"edit\",\n" +
                "            \"mailbox\",\n" +
                "            {\n" +
                "                \"object\": \"jap@recceda.com\",\n" +
                "                \"rl_frame\": \"s\",\n" +
                "                \"rl_value\": \"\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"msg\": [\n" +
                "            \"rl_saved\",\n" +
                "            \"jap@recceda.com\"\n" +
                "        ]\n" +
                "    },\n" +
                "    {\n" +
                "        \"type\": \"success\",\n" +
                "        \"log\": [\n" +
                "            \"mailbox\",\n" +
                "            \"add\",\n" +
                "            \"mailbox\",\n" +
                "            {\n" +
                "                \"local_part\": \"jap\",\n" +
                "                \"domain\": \"recceda.com\",\n" +
                "                \"name\": \"zola\",\n" +
                "                \"quota\": \"3072\",\n" +
                "                \"password\": \"*\",\n" +
                "                \"password2\": \"*\",\n" +
                "                \"active\": \"1\",\n" +
                "                \"force_pw_update\": \"1\",\n" +
                "                \"tls_enforce_in\": \"1\",\n" +
                "                \"tls_enforce_out\": \"1\"\n" +
                "            },\n" +
                "            null\n" +
                "        ],\n" +
                "        \"msg\": [\n" +
                "            \"mailbox_added\",\n" +
                "            \"jap@recceda.com\"\n" +
                "        ]\n" +
                "    }\n" +
                "]";


        CreateMailResponse[] createMailResponse = ResponseMapper.toObject(response, CreateMailResponse[].class);
        assertEquals(2, createMailResponse.length);
        assertEquals("success",createMailResponse[0].getType());
        assertEquals("success",createMailResponse[1].getType());

    }
}