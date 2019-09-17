package com.zcq.service;

import com.zcq.model.po.UserInfo;

/**
 * @author Maybeeeee
 * @date 2019-09-18 00:25
 */
public interface UserService {

    /**
     * 通过openid查询用户
     * @param openid
     * @return
     */
    UserInfo findByOpenid(String openid);
}
