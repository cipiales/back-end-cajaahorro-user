package ec.com.giocompany.cajaahorro.user.config;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;

public class NoCacheFilter implements Filter {
    private boolean noCache = true;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletResponse res = (HttpServletResponse) response;
        if (noCache) {
            res.setHeader("Cache-Control", "no-store, no-cache, must-revalidate, post-check=0, pre-check=0");
            res.setHeader("Pragma", "no-cache");
            res.setDateHeader("Expires", 0);
        }
        chain.doFilter(request, response);
    }
}