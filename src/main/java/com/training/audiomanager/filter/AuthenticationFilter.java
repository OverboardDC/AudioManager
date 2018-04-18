package com.training.audiomanager.filter;

import com.training.audiomanager.entity.User;
import com.training.audiomanager.util.LoginUtil;
import com.training.audiomanager.util.constants.AttributeConstants;
import com.training.audiomanager.util.constants.GlobalConstants;
import com.training.audiomanager.util.constants.PageConstants;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(value = GlobalConstants.APP_ROOT_CATALOG + "*")
public class AuthenticationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String url = request.getRequestURI().replaceAll(".*" + GlobalConstants.APP_ROOT_CATALOG, "");
        if(url.contains(GlobalConstants.ADMIN_URL_PATTERN)) {
            User user = (User) request.getSession().getAttribute(AttributeConstants.USER);
            if (!LoginUtil.isAdmin(user)) {
                response.sendRedirect(PageConstants.LOGIN_PAGE_REDIRECT);
                return;
            }
        }
        filterChain.doFilter(request, servletResponse);
    }


    @Override
    public void destroy() {
    }
}
