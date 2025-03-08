package com.thyonix.dao;

import com.thyonix.entity.User;

public class UserDaoImpl implements UserDao{

    @Override
    public void save(User user) {
        System.out.println("save user:" + user);
    }

    @Override
    public void queryUserByUsernameAndPassword(String username, String password) {
        System.out.println("username:" + username + ", password:" + password);
    }
    
}
