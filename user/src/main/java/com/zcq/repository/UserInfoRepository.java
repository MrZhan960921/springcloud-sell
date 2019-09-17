package com.zcq.repository;

import com.zcq.model.po.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Maybeeeee
 * @date 2019-09-18 00:23
 */
public interface UserInfoRepository extends JpaRepository<UserInfo, String> {

    UserInfo findByOpenid(String openid);
}
