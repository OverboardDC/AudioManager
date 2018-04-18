package com.training.audiomanager.util;

import com.training.audiomanager.util.constants.ValidationConstants;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class InputUtil {

    private boolean valid = true;

    public String inputStringValue(HttpServletRequest request, String param, String regex) {
        String value = request.getParameter(param);
        if (!ValidationUtil.isValid(value, regex)) {
            valid = validationFailed(request, param, ValidationConstants.INCORRECT_INPUT);
        }
        return value;
    }

    public String inputStringValue(HttpServletRequest request, String param, String regex, String message) {
        String value = request.getParameter(param);
        if (!ValidationUtil.isValid(value, regex)) {
            valid = validationFailed(request, param, message);
        }
        return value;
    }

    public Long inputLongValue(HttpServletRequest request, String param, String regex) {
        Optional<String> value = Optional.of(request.getParameter(param));
        if(!value.isPresent() || !ValidationUtil.isValid(value.get(), regex)){
            valid = validationFailed(request, param, ValidationConstants.INCORRECT_INPUT);
            return 0L;
        }
        return Long.parseLong(value.get());
    }

    public int inputIntValue(HttpServletRequest request, String param, String regex) {
        Optional<String> value = Optional.of(request.getParameter(param));
        if(!value.isPresent() || !ValidationUtil.isValid(value.get(), regex)){
            valid = validationFailed(request, param, ValidationConstants.INCORRECT_INPUT);
            return 0;
        }
        return Integer.parseInt(value.get());
    }

    private boolean validationFailed(HttpServletRequest request, String attributeName, String message) {
        request.getSession().setAttribute(attributeName, message);
        return false;
    }

    public boolean isValidationFailed() {
        return !valid;
    }
}
