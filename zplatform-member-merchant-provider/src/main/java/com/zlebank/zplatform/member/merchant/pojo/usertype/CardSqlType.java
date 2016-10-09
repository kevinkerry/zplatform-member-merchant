/* 
 * CardSqlType.java  
 * 
 * version TODO
 *
 * 2015年9月17日 
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
import com.zlebank.zplatform.member.merchant.bean.enums.CardType;

/**
 * Class Description
 *
 * @author Luxiaoshuai
 * @version
 * @date 2015年9月17日 下午4:30:55
 * @since 
 */
public class CardSqlType extends BaseEnumSqlType<CardType>{
    @Override
    public Object nullSafeGet(ResultSet rs, String[] names, SessionImplementor arg2,Object owner)
            throws HibernateException, SQLException {
        return CardType.fromValue(rs.getString(names[0]));
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index,SessionImplementor arg2)
            throws HibernateException, SQLException {
        CardType status = value!=null?(CardType)value:CardType.UNKNOW;
        st.setString(index, status.getCode());
    }
}
