package com.ironyard.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by osmanidris on 1/26/17.
 */
@WebFilter(filterName = "LoginFilter", urlPatterns = {"/*"})
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;

        String username = (String)request.getSession().getAttribute("user");
        boolean tryToLogin = request.getRequestURI().equals("/login");
        if(username != null || tryToLogin) {
            chain.doFilter(req, resp);
        } else {
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
