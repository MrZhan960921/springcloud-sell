package com.zcq.service.impl;

import com.zcq.model.po.UserInfo;
import com.zcq.repository.UserInfoRepository;
import com.zcq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author Maybeeeee
 * @date 2019-09-18 00:26
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public UserInfo findByOpenid(String openid) {
        return userInfoRepository.findByOpenid(openid);
    }
}
