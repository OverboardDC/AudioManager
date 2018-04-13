package com.training.audiomanager.util;

public class ValidationUtil {

    public static boolean isValid(String field, String regex){
        return field.matches(regex);
    }
}
