package com.hackathon.youngandrich;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.hackathon.youngandrich.common.advice.ControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@ExtendWith(MockitoExtension.class)
@Slf4j
@Disabled
public class ControllerTest {
    private final ObjectMapper objectMapper = new ObjectMapper();

    protected MockMvc getMockMvc(Object... controllers) {
        return MockMvcBuilders.standaloneSetup(controllers)
                              .setControllerAdvice(new ControllerAdvice())
                              .build();
    }

    protected String toJson(Object o) {
        try {
            return objectMapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            log.error("Failed to build json string: {}", o, e);
        }
        return null;
    }
}
