package com.hackathon.youngandrich.user.controller;

import com.hackathon.youngandrich.common.response.ResponseMessage;
import com.hackathon.youngandrich.user.model.entity.User;
import com.hackathon.youngandrich.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Validated
public class UserController {
    private final UserService userService;

    @GetMapping("/test")
    public ResponseMessage<User> test() {
        return new ResponseMessage<>(userService.test());
    }
}
