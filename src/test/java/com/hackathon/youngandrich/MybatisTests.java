package com.hackathon.youngandrich;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

import com.hackathon.youngandrich.config.MyBatisConfig;


@SpringJUnitConfig(MyBatisConfig.class)
@Transactional
public class MybatisTests {

}
