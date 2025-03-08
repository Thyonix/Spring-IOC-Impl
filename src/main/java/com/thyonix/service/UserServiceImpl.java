package com.thyonix.service;

import com.thyonix.BeanFactory;
import com.thyonix.dao.UserDao;
import com.thyonix.entity.User;

public class UserServiceImpl implements UserService{
    private UserDao userDao = (UserDao) BeanFactory.getBean("userDao", UserDao.class);

    @Override
    public void login(String username, String password) {
        userDao.queryUserByUsernameAndPassword(username, password);
    }

    @Override
    public void register(User user) {
        userDao.save(user);
    }
    
}
