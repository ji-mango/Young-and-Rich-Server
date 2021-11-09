package com.hackathon.youngandrich.user.model.request;

import com.hackathon.youngandrich.user.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserLoginRequest {
    @NotBlank
    @Size(max = 45)
    @Email
    private String email;

    @NotBlank
    private String password;

    public User toUser() {
        User user = new User();
        user.setEmail(getEmail());
        user.setPassword(getPassword());

        return user;
    }
}
