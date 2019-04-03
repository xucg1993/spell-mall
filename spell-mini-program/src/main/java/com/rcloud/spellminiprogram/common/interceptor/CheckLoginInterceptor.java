package com.rcloud.spellminiprogram.common.interceptor;

import com.rcloud.spellcommon.common.exception.CheckLoginException;
import com.rcloud.spellminiprogram.common.annotation.CheckLogin;
import com.rcloud.spellutils.utils.StringRedisUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 验证登录拦截器
 *
 * @author xuchenguang
 * @since 2019.01.01
 */
public class CheckLoginInterceptor implements HandlerInterceptor {

    private String TOKEN_NAME = "X-MiniProGram-Token";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;

        Method method = handlerMethod.getMethod();

        CheckLogin checkLogin = method.getAnnotation(CheckLogin.class);

        if (checkLogin != null) {
            String token = request.getHeader(TOKEN_NAME);
            String userId = StringRedisUtils.get(token);
            if (StringUtils.isBlank(userId)) {
                throw new CheckLoginException("登录异常，请重新登录");
            }
            return true;
        }

        return true;
    }
}