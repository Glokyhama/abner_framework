package com.abner.dao.core;

import com.abner.entity.core.po.UserAuth;

public interface UserAuthDao {

    UserAuth getUserAuthByuid(String uid);
    UserAuth getUserAuthByToken(String uid);
}
