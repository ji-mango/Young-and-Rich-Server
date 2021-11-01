package com.hackathon.youngandrich;

import com.hackathon.youngandrich.config.MyBatisConfig;
import com.hackathon.youngandrich.user.mapper.UserMapper;
import com.hackathon.youngandrich.user.model.entity.User;
import com.hackathon.youngandrich.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

@SpringJUnitConfig(RepositoryTest.Config.class)
@Transactional
@Slf4j
public class RepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Configuration
    @Import(MyBatisConfig.class)
    static class Config {
        @Bean
        public UserRepository userRepository(UserMapper userMapper) {
            return new UserRepository(userMapper);
        }
    }

    public User testUser() {
        User user = new User();
        user.setUserEmail("a@naver.com");
        user.setUserIdx(1);
        return user;
    }


    @Test
    public void test() {
        User actualUser = userRepository.test();
        User testUser = testUser();
        // test -> 내 db
        // mockUser -> 예측 값
        System.out.println(actualUser);
        Assertions.assertEquals(actualUser.getUserIdx(), testUser.getUserIdx());
        Assertions.assertEquals(actualUser.getUserEmail(), testUser.getUserEmail());

    }

}
