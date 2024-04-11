package com.example.mamazonAPI.Model.DTO;

import com.example.mamazonAPI.Model.Entity.Panier;

public class LoginDTO {
    private String email;
    private String password;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
