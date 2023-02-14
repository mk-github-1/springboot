package com.example.userinterface.loginuser;

import java.util.List;

public record LoginUser(String email, String name, String password, List<String> roleList) {
}
