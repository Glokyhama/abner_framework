package com.abner.dao.core;

import com.abner.entity.core.po.UserAuth;

public interface UserAuthDao {

    UserAuth getUserAuthByUid(String uid);
    UserAuth getUserAuthByToken(String uid);
    UserAuth getUserAuthByIdentifier(String identifier);
}
