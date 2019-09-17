package com.zcq.model.po;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Maybeeeee
 * @date 2019-09-18 00:21
 */
@Data
@Entity
public class UserInfo {

    @Id
    private String id;

    private String username;

    private String password;

    private String openid;

    private Integer role;
}
