package com.hackathon.youngandrich.user.model.request;

import com.hackathon.youngandrich.user.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserCreateRequest {

    @NotNull
    @Email
    @Size(max=45)
    private String email;

    @NotNull
    private String password;

    @NotNull
    @Size(max=20)
    private String userName;

    @NotNull
    @Size(max=11)
    private String phoneNumber;

    public User toUser() {
        User user = new User();

        user.setUserName(getUserName());
        user.setPhoneNumber(getPhoneNumber());
        user.setEmail(getEmail());
        user.setPassword(getPassword());

        return user;
    }
}
