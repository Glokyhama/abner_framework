package com.abner.dao.core.impl;

import com.abner.dao.core.UserAuthDao;
import com.abner.dao.impl.BaseDaoImpl;
import com.abner.entity.core.po.UserAuth;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserAuthDaoImpl extends BaseDaoImpl implements UserAuthDao {


    @Override
    public UserAuth getUserAuthByUid(String uid) {
        return null;
    }

    @Override
    public UserAuth getUserAuthByToken(String uid) {
        return null;
    }

    @Override
    public UserAuth getUserAuthByIdentifier(String identifier) {
        Map<String, Object> params = new HashMap<>();
        params.put("identifier", identifier);
        return sqlSessionTemplate.selectOne("UserAuth.getUserAuthByIdentifier", params);
    }
}
