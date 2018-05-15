package com.alekseysamoylov.learn.security.service;


import com.alekseysamoylov.learn.security.entity.User;

public interface UserContext {


    User getCurrentUser();


    void setCurrentUser(final User user);

}
