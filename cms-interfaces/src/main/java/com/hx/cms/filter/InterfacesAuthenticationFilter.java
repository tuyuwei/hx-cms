package com.hx.cms.filter;

import com.hx.cms.service.UserLoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
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

    @Resource
    private UserLoginService userLoginService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        log.info("before doFilterInternal.");
        userLoginService.login(null);
        filterChain.doFilter(request, response);
    }
}
