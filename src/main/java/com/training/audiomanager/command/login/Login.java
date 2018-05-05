package com.training.audiomanager.command.login;

import com.training.audiomanager.command.Command;
import com.training.audiomanager.entity.User;
import com.training.audiomanager.service.UserService;
import com.training.audiomanager.util.constants.AttributeConstants;
import com.training.audiomanager.util.constants.PageConstants;
import com.training.audiomanager.util.constants.ParameterConstants;
import com.training.audiomanager.util.constants.ValidationConstants;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class Login implements Command {

    private UserService userService;

    public Login(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String username = request.getParameter(ParameterConstants.USERNAME);
        String password = request.getParameter(ParameterConstants.PASSWORD);
        Optional<User> user = Optional.ofNullable(userService.login(username, password));
        if(!user.isPresent()){
            request.getSession().setAttribute(AttributeConstants.LOGIN_ERROR, ValidationConstants.LOGIN_FAILED);
            return PageConstants.LOGIN_PAGE_REDIRECT;
        }

        request.getSession().setAttribute(AttributeConstants.USER, user.get());
        return PageConstants.INDEX_REDIRECT;
    }
}
