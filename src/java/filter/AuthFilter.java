package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig)
            throws ServletException {
    }

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req =
                (HttpServletRequest) request;

        HttpServletResponse res =
                (HttpServletResponse) response;

        Object currentUserObj = req.getSession().getAttribute("currentUser");
        String user = currentUserObj == null ? null : currentUserObj.toString();

        String uri = req.getRequestURI();

        if (uri.contains("login.jsp")
                || uri.contains("login.do")
                || uri.contains("/login")) {

            chain.doFilter(request, response);
            return;
        }

                // allow static resources
                if (uri.contains("/css/") || uri.contains("/js/") || uri.contains("/images/")) {
                        chain.doFilter(request, response);
                        return;
                }

                if (uri.contains("/jsp/") && user == null) {
                        res.sendRedirect(req.getContextPath() + "/jsp/login.jsp");
                        return;
                }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}