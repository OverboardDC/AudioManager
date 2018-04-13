package com.training.audiomanager.util;

import com.training.audiomanager.entity.User;

public class LoginUtil {

    public static boolean isAdmin(User user){
        return user != null && user.isAdmin();
    }
}
