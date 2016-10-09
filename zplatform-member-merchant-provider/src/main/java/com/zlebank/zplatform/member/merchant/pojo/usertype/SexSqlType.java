/* 
 * SexSqlType.java  
 * 
 * version TODO
 *
 * 2015年9月9日 
 * 
 * Copyright (c) 2015,zlebank.All rights reserved.
 * 
 */
package com.zlebank.zplatform.member.merchant.pojo.usertype;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;

import com.zlebank.zplatform.member.commons.enums.BaseEnumSqlType;
import com.zlebank.zplatform.member.individual.bean.enums.SexType;

/**
 * Class Description
 *
 * @author Luxiaoshuai
 * @version
 * @date 2015年9月9日 下午9:38:30
 * @since
 */
public class SexSqlType extends BaseEnumSqlType<SexType> {
    @Override
    public Object nullSafeGet(ResultSet rs,
            String[] names,
            SessionImplementor arg2,
            Object owner) throws HibernateException, SQLException {
        return SexType.fromValue(rs.getInt(names[0]));
    }

    @Override
    public void nullSafeSet(PreparedStatement st,
            Object value,
            int index,
            SessionImplementor arg2) throws HibernateException, SQLException {
        SexType status = value != null ? (SexType) value : SexType.UNKNOW;
        st.setInt(index, status.getCode());
    }
}