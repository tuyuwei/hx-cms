package com.hx.cms.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登陆认证filter
 *
 * @author: tywei
 * @create: 2022-04-13 6:37 下午
 **/
@Slf4j
@Component
@WebFilter
public class InterfacesAuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        log.info("before doFilterInternal.");
        filterChain.doFilter(request, response);
    }
}
