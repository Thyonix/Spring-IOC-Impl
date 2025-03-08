package com.thyonix;

import org.junit.Test;

import com.thyonix.entity.User;
import com.thyonix.service.UserService;

public class TestSpring {
    
    private UserService userService = BeanFactory.getBean("userService", UserService.class);

    @Test
    public void Test1(){
        BeanFactory.getBean("userService", UserService.class);
    }

    @Test
    public void Test2(){
        userService.login("Bob", "123");
        userService.register(new User("Beethoven", "321"));
    }
}
