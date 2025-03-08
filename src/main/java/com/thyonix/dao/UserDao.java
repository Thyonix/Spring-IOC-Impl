package com.thyonix.dao;

import com.thyonix.entity.User;

public interface UserDao {
    void save(User user);
    void queryUserByUsernameAndPassword(String username, String password);
}
