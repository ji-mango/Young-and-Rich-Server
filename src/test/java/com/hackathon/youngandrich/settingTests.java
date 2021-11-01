package com.hackathon.youngandrich;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

import com.hackathon.youngandrich.config.MyBatisConfig;

@SpringJUnitConfig(MyBatisConfig.class)
@Transactional
public class settingTests {
    @Value("${db.driverClassName}")
    private String driverClassName;
    @Value("${db.url}")
    private String url;
    @Value("${db.username}")
    private String username;
    @Value("${db.password}")
    private String password;
    @Value("${emptyProperty}")
    private String emptyProperty;

    @Test
    void readPropertiesTest() {
        assertEquals("${emptyProperty}", emptyProperty);
        assertNotEquals("${db.driverClassName}", driverClassName);
        assertNotEquals("${db.url}", url);
        assertNotEquals("${db.username}", username);
        assertNotEquals("${db.password}", password);
    }
}
