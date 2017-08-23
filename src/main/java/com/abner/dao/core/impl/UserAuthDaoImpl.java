package com.abner.dao.core.impl;

import com.abner.dao.core.UserAuthDao;
import com.abner.entity.core.po.UserAuth;
import org.springframework.stereotype.Repository;

@Repository
public class UserAuthDaoImpl extends BaseDaoImpl implements UserAuthDao {

    @Override
    public UserAuth getUserAuthByuid(String uid) {
        return null;
    }

    @Override
    public UserAuth getUserAuthByToken(String uid) {
        return null;
    }
}
