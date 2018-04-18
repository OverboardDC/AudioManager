package com.training.audiomanager.command.login;

import com.training.audiomanager.command.Command;
import com.training.audiomanager.entity.Role;
import com.training.audiomanager.entity.User;
import com.training.audiomanager.entity.builder.RoleBuilder;
import com.training.audiomanager.entity.builder.UserBuilder;
import com.training.audiomanager.service.UserService;
import com.training.audiomanager.util.InputUtil;
import com.training.audiomanager.util.constants.*;

import javax.servlet.http.HttpServletRequest;

public class Registration implements Command {

    private UserService userService;

    public Registration(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {

        InputUtil inputUtil = new InputUtil();
        String username = inputUtil.inputStringValue(request, ParameterConstants.USERNAME,
                RegexConstants.USERNAME_REGEX, ValidationConstants.INVALID_USERNAME);

        String password = inputUtil.inputStringValue(request, ParameterConstants.PASSWORD,
                RegexConstants.PASSWORD_REGEX, ValidationConstants.INVALID_PASSWORD);

        String passwordConfirm = request.getParameter(ParameterConstants.PASSWORD_CONFIRM);

        if(userService.isLoginExists(username)){
            request.getSession().setAttribute(AttributeConstants.REGISTRATION_ERROR, ValidationConstants.USER_EXISTS);
            return PageConstants.REGISTRATION_PAGE_REDIRECT;
        }
        if (!password.equals(passwordConfirm)){
            request.getSession().setAttribute(AttributeConstants.PASSWORD_CONFIRM, ValidationConstants.PASSWORDS_DONT_MATCH);
            return PageConstants.REGISTRATION_PAGE_REDIRECT;
        }
        if(inputUtil.isValidationFailed()){
            return  PageConstants.REGISTRATION_PAGE_REDIRECT;
        }

        Role role = new RoleBuilder().buildId(GlobalConstants.USER_ROLE_ID).buildRole();
        User user = new UserBuilder().buildName(username).buildPassword(password).buildRole(role).buildUser();
        userService.add(user);
        return PageConstants.LOGIN_PAGE_REDIRECT;
    }
}
