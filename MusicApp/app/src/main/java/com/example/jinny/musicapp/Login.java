package com.example.jinny.musicapp;

public class Login {
    public class LoginRequest {
        public String username;
        public String password;

        public LoginRequest(String username, String password) {
            this.username = username;
            this.password = password;
        }
    }

    public class LoginResponse {
        public boolean success;
    }
} 