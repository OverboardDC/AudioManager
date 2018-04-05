package com.training.audiomanager.util;

public class ValidationUtil {

    public static final String INCORRECT_INPUT = "The input is incorrect";

    public static boolean isValid(String field, String regex){
        return field.matches(regex);
    }
}
