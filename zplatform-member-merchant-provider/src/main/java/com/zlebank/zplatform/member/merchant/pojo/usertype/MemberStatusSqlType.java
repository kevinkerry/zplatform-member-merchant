package com.zlebank.zplatform.member.merchant.pojo.usertype;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;

import com.zlebank.zplatform.member.commons.enums.BaseEnumSqlType;
import com.zlebank.zplatform.member.individual.bean.enums.MemberStatusType;

public class MemberStatusSqlType   extends BaseEnumSqlType<MemberStatusType>{
    @Override
    public Object nullSafeGet(ResultSet rs, String[] names, SessionImplementor arg2,Object owner)
            throws HibernateException, SQLException {
        return MemberStatusType.fromValue(rs.getString(names[0]));
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index,SessionImplementor arg2)
            throws HibernateException, SQLException {
    	MemberStatusType status = value!=null?(MemberStatusType)value:MemberStatusType.UNKNOW;
        st.setString(index, status.getCode());
    }
}
