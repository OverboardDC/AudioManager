package com.training.audiomanager.util.constants;

public interface RegexConstants {

    String NAME_REGEX  = "[0-9A-Za-z\\s]{1,24}+";
    String NUMBER_REGEX = "[0-9]{1,8}+";

    String USERNAME_REGEX = "[0-9A-Za-z]{4,20}+";
    String PASSWORD_REGEX = "[0-9A-Za-z]{5,20}+";
}
