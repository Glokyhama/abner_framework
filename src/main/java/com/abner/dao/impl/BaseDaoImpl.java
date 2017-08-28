package com.abner.dao.impl;

import com.abner.dao.BaseDao;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BaseDaoImpl implements BaseDao {

    @Autowired
    public SqlSessionTemplate sqlSessionTemplate;
}
