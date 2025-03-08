package com.thyonix.service;

import com.thyonix.entity.User;

public interface UserService {
    void login(String username, String password);
    void register(User user);
}
