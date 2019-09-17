package com.zcq.controller;

import com.zcq.enums.ResultEnum;
import com.zcq.enums.RoleEnum;
import com.zcq.model.po.UserInfo;
import com.zcq.model.vo.ResultVO;
import com.zcq.service.UserService;
import com.zcq.utils.CookieUtil;
import com.zcq.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Maybeeeee
 * @date 2019-09-18 00:28
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

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
    public ResultVO seller(@RequestParam("openid") String openid, HttpServletResponse response) {
        return null;
    }
}
