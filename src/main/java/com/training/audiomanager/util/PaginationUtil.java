package com.training.audiomanager.util;

import com.training.audiomanager.util.constants.ParameterConstants;

import javax.servlet.http.HttpServletRequest;

public class PaginationUtil {

    public static int getPageParameter(HttpServletRequest request){
        int page = 1;
        if(request.getParameter(ParameterConstants.PAGE) != null && !request.getParameter(ParameterConstants.PAGE).equals("")){
            page = Integer.parseInt(request.getParameter(ParameterConstants.PAGE));
        }
        return page;
    }

    public static int calculateMaxPage(int totalCount, int itemsOnPage){
        int limit;
        if(totalCount % itemsOnPage == 0){
            limit = totalCount / itemsOnPage;
        } else {
            limit = (totalCount / itemsOnPage) + 1;
        }
        return limit;
    }
}
