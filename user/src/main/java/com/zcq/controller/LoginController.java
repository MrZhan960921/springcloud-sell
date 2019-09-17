package com.zcq.controller;


import com.zcq.constant.RedisConstant;
import com.zcq.enums.ResultEnum;
import com.zcq.enums.RoleEnum;
import com.zcq.model.po.UserInfo;
import com.zcq.model.vo.ResultVO;
import com.zcq.service.UserService;
import com.zcq.utils.CookieUtil;
import com.zcq.utils.ResultVOUtil;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author Maybeeeee
 * @date 2019-09-18 00:28
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 买家登录
     *
     * @param openid
     * @param response
     * @return
     */
    @GetMapping("/buyer")
    public ResultVO buyer(@RequestParam("openid") String openid, HttpServletResponse response) {
        //openid和数据库匹配
        UserInfo userInfo = userService.findByOpenid(openid);
        if (userInfo == null) {
            return ResultVOUtil.error(ResultEnum.LOGIN_FAIL);
        }
        //判断角色
        if (RoleEnum.BUYER.getCode() != userInfo.getRole()) {
            return ResultVOUtil.error(ResultEnum.ROLE_ERROR);
        }
        //设置cookie
        CookieUtil.set(response, "openid", openid, 7200);
        return ResultVOUtil.success();
    }

    /**
     * 卖家家登录
     *
     * @param openid
     * @param response
     * @return
     */
    @GetMapping("/seller")
    public ResultVO seller(@RequestParam("openid") String openid, HttpServletRequest request, HttpServletResponse response) {

        //判断是否已登录
        Cookie cookie = CookieUtil.get(request, "token");
        if (cookie != null && !StringUtils.isEmpty(stringRedisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_TEMPLATE, cookie.getValue())))) {
            return ResultVOUtil.success();
        }

        //openid和数据库匹配
        UserInfo userInfo = userService.findByOpenid(openid);
        if (userInfo == null) {
            return ResultVOUtil.error(ResultEnum.LOGIN_FAIL);
        }
        //判断角色
        if (RoleEnum.SELLER.getCode() != userInfo.getRole()) {
            return ResultVOUtil.error(ResultEnum.ROLE_ERROR);
        }
        //redis设置key=uuid,value=xyz
        String token = UUID.randomUUID().toString();
        stringRedisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_TEMPLATE, token),
                openid,
                7200,
                TimeUnit.SECONDS);
        //设置cookie
        CookieUtil.set(response, "token", token, 7200);
        return ResultVOUtil.success();
    }
}
