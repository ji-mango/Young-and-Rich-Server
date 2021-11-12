package com.hackathon.youngandrich.user.controller;

import com.hackathon.youngandrich.common.response.ResponseMessage;
import com.hackathon.youngandrich.user.model.entity.User;
import com.hackathon.youngandrich.user.model.request.UserCreateRequest;
import com.hackathon.youngandrich.user.model.request.UserEmailRequest;
import com.hackathon.youngandrich.user.model.request.UserLoginRequest;
import com.hackathon.youngandrich.user.model.request.UserPhoneRequest;
import com.hackathon.youngandrich.user.model.response.UserCreateResponse;
import com.hackathon.youngandrich.user.model.response.UserPhoneResponse;
import com.hackathon.youngandrich.user.service.UserService;
import lombok.RequiredArgsConstructor;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

import com.hackathon.youngandrich.config.PhoneConfig;

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
    public ResponseMessage<Boolean> checkUserEmail(@RequestBody @Valid UserEmailRequest userEmailRequest) {
        String email = userEmailRequest.getEmail();
        Boolean result = userService.checkUserEmail(email);

        return new ResponseMessage<>(result);
    }

    @PostMapping("/users/phone")
    public ResponseMessage<UserPhoneResponse> verifiedPhone(@RequestBody @Valid UserPhoneRequest userPhoneRequest) {
        String phoneNumber = userPhoneRequest.getPhoneNumber();
        PhoneConfig phoneConfig = new PhoneConfig();

        String code = phoneConfig.getCode();
        UserPhoneResponse userPhoneResponse = new UserPhoneResponse();
        userPhoneResponse.setCode(code);

        String hostNameUrl = phoneConfig.getHostNameUrl();
        String requestUrl = phoneConfig.getRequestUrl();
        String requestUrlType = phoneConfig.getRequestUrlType();
        String accessKey = phoneConfig.getAccessKey();
        String secretKey = phoneConfig.getSecretKey();
        String serviceId = phoneConfig.getServiceId();
        String method = "POST";
        String timestamp = Long.toString(System.currentTimeMillis());
        requestUrl += serviceId + requestUrlType;
        String apiUrl = hostNameUrl + requestUrl;

        JSONObject bodyJson = new JSONObject();
        JSONObject toJson = new JSONObject();
        JSONArray toArr = new JSONArray();

        toJson.put("to", phoneNumber);
        toArr.add(toJson);

        bodyJson.put("type", "SMS");
        bodyJson.put("contentType", "COMM");
        bodyJson.put("countryCode", "82");
        bodyJson.put("from", phoneConfig.getFrom());
        bodyJson.put("content", "[Young&Rich] "+ code);
        bodyJson.put("messages", toArr);

        String body = bodyJson.toJSONString();

        System.out.println(body);

        try {
            URL url = new URL(apiUrl);

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setUseCaches(false);
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("x-ncp-apigw-timestamp", timestamp);
            con.setRequestProperty("x-ncp-iam-access-key", accessKey);
            con.setRequestProperty("x-ncp-apigw-signature-v2", phoneConfig.makeSignature(requestUrl, timestamp, method, accessKey, secretKey));
            con.setRequestMethod(method);
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.write(body.getBytes());
            wr.flush();
            wr.close();
            int responseCode = con.getResponseCode();
            BufferedReader br;
            System.out.println("responseCode" + " " + responseCode);
            if (responseCode == 202) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else { // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            System.out.println(response.toString());
            return new ResponseMessage<>(userPhoneResponse);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseMessage<>("인증요청 실패");
        }
    }

@PostMapping("/users/sign-up")
public ResponseMessage<UserCreateResponse> signUp(@RequestBody @Valid UserCreateRequest userCreateRequest) {
        User user=userCreateRequest.toUser();
        userService.signUp(user);

        return new ResponseMessage<>(UserCreateResponse.from(user));
        }
}
