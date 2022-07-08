package com.security;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class ConvertTokenToMap {
    public static Object getFieldFromAuthentificationDetails(String field) {
        String[] chunks = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().
                getHeaders("Authorization").nextElement().split("\\.");
        Base64.Decoder decoder = Base64.getUrlDecoder();
        String token = new String(decoder.decode(chunks[1]), StandardCharsets.UTF_8);
        ObjectMapper mappers = new ObjectMapper();
        Map<String, Object> tokenMap = new HashMap<String, Object>();
        try {
            tokenMap = mappers.readValue(token,
                    new TypeReference<Map<String, Object>>() {
                    });
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return tokenMap.get(field);
    }
}
