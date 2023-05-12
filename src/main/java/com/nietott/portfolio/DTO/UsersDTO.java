package com.nietott.portfolio.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UsersDTO {
    private long userId;
    private String name;
    private String email;
    private String password;
    private String phone;
    private String gitUsername;
    private String linkedinUsername;
    private int dni;
    private String surname;
    private String imageUrl;
    private String bannerUrl;
}
