package com.training.audiomanager.util;

import com.training.audiomanager.util.constants.ValidationConstants;

import javax.servlet.http.HttpServletRequest;

//TODO refactor
public class InputUtil {

    private boolean valid = true;

    public String inputStringValue(HttpServletRequest request, String param, String regex){
        String value = request.getParameter(param);
        if (!ValidationUtil.isValid(value, regex)) {
            valid = validationFailed(request, param, ValidationConstants.INCORRECT_INPUT);
        }
        return value;
    }

    public String inputStringValue(HttpServletRequest request, String param, String regex, String message){
        String value = request.getParameter(param);
        if (!ValidationUtil.isValid(value, regex)) {
            valid = validationFailed(request, param, message);
        }
        return value;
    }

    public Long inputLongValue(HttpServletRequest request, String param){
        Long value = 0L;
        try {
            value = Long.valueOf(request.getParameter(param));
        } catch (NumberFormatException e){
            valid = validationFailed(request, param, ValidationConstants.INCORRECT_INPUT);
        }
        return value;
    }

    public int inputIntValue(HttpServletRequest request, String param){
        int value = 0;
        try {
            value = Integer.valueOf(request.getParameter(param));
        } catch (NumberFormatException e){
            valid = validationFailed(request, param, ValidationConstants.INCORRECT_INPUT);
        }
        return value;
    }

    private boolean validationFailed(HttpServletRequest request, String attributeName, String message) {
        request.getSession().setAttribute(attributeName, message);
        return false;
    }

    public boolean isValid() {
        return valid;
    }
}
