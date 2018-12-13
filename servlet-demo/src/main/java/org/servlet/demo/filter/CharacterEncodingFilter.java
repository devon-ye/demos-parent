package org.servlet.demo.filter;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * spring impl
 */
public class CharacterEncodingFilter implements Filter {

    private String encoding;
    private boolean forceEncoding;


    public void setForceEncoding(boolean forceEncoding) {
        this.forceEncoding = forceEncoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        if (encoding != null && (servletRequest.getCharacterEncoding() == null || this.forceEncoding)) {
            httpServletRequest.setCharacterEncoding(this.encoding);
            if (this.forceEncoding) {
                httpServletResponse.setCharacterEncoding(this.encoding);
            }

        }
    }

    @Override
    public void destroy() {

    }
}
