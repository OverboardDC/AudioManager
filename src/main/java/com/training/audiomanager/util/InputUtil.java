package com.training.audiomanager.util;

import javax.servlet.http.HttpServletRequest;

public class InputUtil {

    private boolean valid = true;

    public String inputStringValue(HttpServletRequest request, String param, String regex){
        String value = request.getParameter(param);
        if (!ValidationUtil.isValid(value, regex)) {
            valid = validationFailed(request, param);
        }
        return value;
    }

    public Long inputLongValue(HttpServletRequest request, String param){
        Long value = 0L;
        try {
            value = Long.valueOf(request.getParameter(param));
        } catch (NumberFormatException e){
            valid = validationFailed(request, param);
        }
        return value;
    }

    public int inputIntValue(HttpServletRequest request, String param){
        int value = 0;
        try {
            value = Integer.valueOf(request.getParameter(param));
        } catch (NumberFormatException e){
            valid = validationFailed(request, param);
        }
        return value;
    }

    private boolean validationFailed(HttpServletRequest request, String attributeName) {
        request.getSession().setAttribute(attributeName, ValidationUtil.INCORRECT_INPUT);
        return false;
    }

    public boolean isValid() {
        return valid;
    }
}
