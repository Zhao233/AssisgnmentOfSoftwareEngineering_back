package com.example.demo.authentication;

import com.example.demo.domain.User.UserInfo;
import com.example.demo.service.UserService;
import com.example.demo.util.JwtUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component("myLoginSuccessHandler")
public class MyLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler { //自定义的
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException, ServletException {
        logger.info("登录成功！");

        //登录成功后设置JWT
        String token = JwtUtils.generateToken(authentication);

        /* 获取已登录用户的信息，与token对应，并保存至redis中 */
        String username = httpServletRequest.getParameter("username");
        UserInfo userInfo = userService.getUserInfoByName(username);
        saveUserInfoToRedis(userInfo, token);

        httpServletResponse.addHeader("Authorization", token);
        //要做的工作就是将Authentication以json的形式返回给前端。 需要工具类ObjectMapper，Spring已自动注入。
        //设置返回类型
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        Map<String, Object> tokenInfo = new HashMap<String, Object>();
        tokenInfo.put("token",token);
        tokenInfo.put("status",200);
        //将token信息写入
        httpServletResponse.getWriter().write(objectMapper.writeValueAsString(tokenInfo));
    }

    public void saveUserInfoToRedis(UserInfo userInfo, String token) throws JsonProcessingException {
        String userInfo_json = objectMapper.writeValueAsString(userInfo);

        redisTemplate.opsForValue().set(token, userInfo_json);

        System.out.println(redisTemplate.opsForValue().get(token));
    }
}