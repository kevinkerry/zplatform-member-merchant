/* 
 * 
 * MerchDAOImpl.java  
 * version TODO
 *
 * 2015年9月11日 
 * 
 * Copyright (c) 2015,zlebank.All rights reserved.
 * 
 */
package com.zlebank.zplatform.member.merchant.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.zlebank.zplatform.member.commons.dao.impl.HibernateBaseDAOImpl;
import com.zlebank.zplatform.member.merchant.dao.MerchDAO;
import com.zlebank.zplatform.member.merchant.pojo.PojoMerchDeta;
import com.zlebank.zplatform.member.merchant.pojo.usertype.MerchStatusType;

/**
 * Class Description
 *
 * @author yangpeng
 * @version
 * @date 2015年9月11日 上午10:13:08
 * @since
 */
@Repository
public class MerchDAOImpl extends HibernateBaseDAOImpl<PojoMerchDeta> implements
		MerchDAO {

	/**
	 *
	 * @param memberId
	 * @return
	 */
	@Override
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
	public PojoMerchDeta getParentMerch(String memberId) {
		// Criteria crite=this.getSession().createCriteria(PojoMerchDeta.class);
		// return (PojoMerchDeta)crite .add(Restrictions.eq("dateMemberid",
		// memberId)).uniqueResult();

		PojoMerchDeta pojoMerchDeta = (PojoMerchDeta) getSession()
				.createCriteria(PojoMerchDeta.class)
				.add(Restrictions.eq("memberId", memberId))
				.add(Restrictions.eq("merchStatus", MerchStatusType.NORMAL))
				.uniqueResult();
		if (pojoMerchDeta != null)
			getSession().evict(pojoMerchDeta);
		return pojoMerchDeta;

	}

	/**
	 *
	 * @param taxno
	 * @return
	 */
	@Override
	@Deprecated
	public PojoMerchDeta getMerchByTaxno(String taxno) {
		Criteria crite = this.getSession().createCriteria(PojoMerchDeta.class);
		crite.add(Restrictions.eq("taxno", taxno));
		crite.add(Restrictions.eq("merchStatus", MerchStatusType.NORMAL));
		@SuppressWarnings("unchecked")
		List<PojoMerchDeta> pojos = crite.list();
		return pojos.size() > 0 ? (PojoMerchDeta) pojos.get(0) : null;
	}

	/**
	 *
	 * @param licenceNo
	 * @return
	 */
	@Override
	@Deprecated
	public PojoMerchDeta getMerchByLicenceNo(String licenceNo) {
		Criteria crite = this.getSession().createCriteria(PojoMerchDeta.class);
		crite.add(Restrictions.eq("licenceno", licenceNo));
		crite.add(Restrictions.eq("merchStatus", MerchStatusType.NORMAL));
		@SuppressWarnings("unchecked")
		List<PojoMerchDeta> pojos = crite.list();
		return pojos.size() > 0 ? (PojoMerchDeta) pojos.get(0) : null;
	}

	/**
	 *
	 * @param email
	 * @return
	 */
	@Override
	@Deprecated
	public PojoMerchDeta getMerchByEmail(String email) {
		Criteria crite = this.getSession().createCriteria(PojoMerchDeta.class);
		crite.add(Restrictions.eq("email", email));
		crite.add(Restrictions.eq("merchStatus", MerchStatusType.NORMAL));
		@SuppressWarnings("unchecked")
		List<PojoMerchDeta> pojos = crite.list();
		return pojos.size() > 0 ? (PojoMerchDeta) pojos.get(0) : null;
	}

	/**
	 *
	 * @param phone
	 * @return
	 */
	@Override
	@Deprecated
	public PojoMerchDeta getMerchByPhone(String phone) {
		Criteria crite = this.getSession().createCriteria(PojoMerchDeta.class);
		PojoMerchDeta merch = (PojoMerchDeta) crite
				.add(Restrictions.eq("contphone", phone))
				.add(Restrictions.eq("merchStatus", MerchStatusType.NORMAL))
				.uniqueResult();
		return merch;
	}

	/**
	 *
	 * @param memberId
	 * @return
	 */
	@Override
	public PojoMerchDeta getMerchBymemberId(String memberId) {
		PojoMerchDeta pojoMerchDeta = (PojoMerchDeta) getSession()
				.createCriteria(PojoMerchDeta.class)
				.add(Restrictions.eq("memberId", memberId))
				.add(Restrictions.eq("merchStatus", MerchStatusType.NORMAL))
				.uniqueResult();
		if (pojoMerchDeta != null)
			getSession().evict(pojoMerchDeta);
		return pojoMerchDeta;
	}
}
