package com.example.project1.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Component
public class LoggerInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(LoggerInterceptor.class);

    @Override
    public boolean preHandle(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse, final  Object hdandler)throws Exception{
        logger.info("[doFilter]"+ httpServletRequest.getMethod()+" "+httpServletRequest.getRequestURI());
        return true;
    }


}
