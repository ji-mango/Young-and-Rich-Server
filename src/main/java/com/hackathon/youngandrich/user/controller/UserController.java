package com.hackathon.youngandrich.user.controller;

import com.hackathon.youngandrich.common.response.ResponseMessage;
import com.hackathon.youngandrich.user.model.entity.User;
import com.hackathon.youngandrich.user.model.request.UserEmailRequest;
import com.hackathon.youngandrich.user.model.request.UserLoginRequest;
import com.hackathon.youngandrich.user.model.response.UserCreateResponse;
import com.hackathon.youngandrich.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
public class UserController {
    private final UserService userService;

    // 로그인 API
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/users/login")
    public ResponseMessage<UserCreateResponse> login(@RequestBody @Valid UserLoginRequest userLoginRequest) {

            User user = userLoginRequest.toUser();
            int result = userService.login(user);

            user.setUserId(result);
            return new ResponseMessage<>(UserCreateResponse.from(user));
    }

    // 회원가입 이메일 중복체크 API
    @PostMapping("/users/email")
    public ResponseMessage<Boolean> login(@RequestBody @Valid UserEmailRequest userEmailRequest) {
        String email = userEmailRequest.getEmail();
        Boolean result = userService.checkUserEmail(email);

        return new ResponseMessage<>(result);
    }
}
