/* 
 * EnterpriseDAOImpl.java  
 * 
 * version TODO
 *
 * 2016年3月21日 
 * 
 * Copyright (c) 2016,zlebank.All rights reserved.
 * 
 */
package com.zlebank.zplatform.member.merchant.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.zlebank.zplatform.member.commons.dao.impl.HibernateBaseDAOImpl;
import com.zlebank.zplatform.member.merchant.dao.EnterpriseDAO;
import com.zlebank.zplatform.member.merchant.pojo.PojoEnterpriseDeta;

/**
 * 企业DAO实现类
 *
 * @author Luxiaoshuai
 * @version
 * @date 2016年3月21日 下午2:14:37
 * @since 
 */
@Repository
public class EnterpriseDAOImpl extends HibernateBaseDAOImpl<PojoEnterpriseDeta> implements EnterpriseDAO{

    /**
     * 根据memberId得到企业
     * @param memberId
     * @return 企业信息
     */
    @Override
    public PojoEnterpriseDeta getEnterpriseByMemberId(String memberId) {
        Criteria crite = this.getSession().createCriteria(PojoEnterpriseDeta.class);
        crite.add(Restrictions.eq("memberId", memberId));
        PojoEnterpriseDeta member = (PojoEnterpriseDeta) crite.uniqueResult();
        return member;
    }
}
