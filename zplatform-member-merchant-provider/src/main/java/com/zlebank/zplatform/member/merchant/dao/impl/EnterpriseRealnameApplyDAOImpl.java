/* 
 * EnterpriseRealnameApplyDAOImpl.java  
 * 
 * version TODO
 *
 * 2016年8月22日 
 * 
 * Copyright (c) 2016,zlebank.All rights reserved.
 * 
 */
package com.zlebank.zplatform.member.merchant.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.zlebank.zplatform.member.commons.dao.impl.HibernateBaseDAOImpl;
import com.zlebank.zplatform.member.commons.utils.StringUtil;
import com.zlebank.zplatform.member.merchant.bean.EnterpriseRealNameQueryBean;
import com.zlebank.zplatform.member.merchant.dao.EnterpriseRealnameApplyDAO;
import com.zlebank.zplatform.member.merchant.pojo.PojoEnterpriseRealnameApply;

/**
 * Class Description
 *
 * @author guojia
 * @version
 * @date 2016年8月22日 上午10:42:22
 * @since
 */
@Repository("enterpriseRealnameApplyDAO")
public class EnterpriseRealnameApplyDAOImpl extends
		HibernateBaseDAOImpl<PojoEnterpriseRealnameApply> implements
		EnterpriseRealnameApplyDAO {
	/**
	 *
	 * @param tn
	 * @return
	 */
	@Override
	public PojoEnterpriseRealnameApply getDetaByTN(String tn) {
		Criteria crite = this.getSession().createCriteria(
				PojoEnterpriseRealnameApply.class);
		crite.add(Restrictions.eq("tn", tn));
		PojoEnterpriseRealnameApply apply = (PojoEnterpriseRealnameApply) crite
				.uniqueResult();
		return apply;

	}

	/**
	 *
	 * @param tid
	 * @return
	 */
	@Override
	public PojoEnterpriseRealnameApply getById(Long tid) {
		Criteria crite = this.getSession().createCriteria(
				PojoEnterpriseRealnameApply.class);
		crite.add(Restrictions.eq("tid", tid));
		PojoEnterpriseRealnameApply apply = (PojoEnterpriseRealnameApply) crite
				.uniqueResult();
		return apply;
	}

    /**
     *
     * @param example
     * @return 
     */
    @Override
    public long count(EnterpriseRealNameQueryBean example) {
        Criteria crite=buildCrite(example);
        return crite.list().size();
    }

    private Criteria buildCrite(EnterpriseRealNameQueryBean example){
        Criteria crite=this.getSession().createCriteria(PojoEnterpriseRealnameApply.class);
        if (StringUtil.isNotEmpty(example.getStatus())) {
            crite.add(Restrictions.eq("status", example.getStatus()));
        }
        if (StringUtil.isNotEmpty(example.getMemberId())) {
            crite.add(Restrictions.eq("memberId", example.getMemberId()));
        }
        if (StringUtil.isNotEmpty(example.getEnterpriseName())) {
            crite.add(Restrictions.eq("enterpriseName", example.getEnterpriseName()));
        }
        return crite;
    }
    /**
     *
     * @param offset
     * @param pageSize
     * @param example
     * @return 
     */
    @SuppressWarnings("unchecked")
	@Override
    public List<PojoEnterpriseRealnameApply> getItem(int offset,
            int pageSize,
            EnterpriseRealNameQueryBean example) {
        Criteria crite=buildCrite(example);
        crite.setFirstResult(offset);
        crite.setMaxResults(pageSize);
        return crite.list();
    }
}
