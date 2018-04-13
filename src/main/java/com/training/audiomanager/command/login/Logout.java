package com.training.audiomanager.command.login;

import com.training.audiomanager.command.Command;
import com.training.audiomanager.util.constants.PageConstants;

import javax.servlet.http.HttpServletRequest;

public class Logout implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        return PageConstants.INDEX_REDIRECT;
    }
}
