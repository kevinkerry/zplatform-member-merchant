/* 
 * MerchDAO.java  
 * 
 * version TODO
 *
 * 2015年9月11日 
 * 
 * Copyright (c) 2015,zlebank.All rights reserved.
 * 
 */
package com.zlebank.zplatform.member.merchant.dao;

import com.zlebank.zplatform.member.commons.dao.BaseDAO;
import com.zlebank.zplatform.member.merchant.pojo.PojoMerchDeta;

/**
 * Class Description
 *
 * @author yangpeng
 * @version
 * @date 2015年9月11日 上午10:11:32
 * @since
 */
public interface MerchDAO extends BaseDAO<PojoMerchDeta> {
	/**
	 * 根据父级ID得到父级商户
	 * 
	 * @param merchId
	 * @return
	 */
	public PojoMerchDeta getParentMerch(String memberId);

	/**
	 * 通过税务登记号得到商户
	 * 
	 * @param taxno
	 * @return PojoMerchDeta
	 */
	@Deprecated
	public PojoMerchDeta getMerchByTaxno(String taxno);

	/**
	 * 通过营业执照得到商户
	 * 
	 * @param licenceNo
	 * @return
	 */
	@Deprecated
	public PojoMerchDeta getMerchByLicenceNo(String licenceNo);

	/**
	 * 通过email得到商户
	 * 
	 * @param email
	 * @return
	 */
	@Deprecated
	public PojoMerchDeta getMerchByEmail(String email);

	/**
	 * 通过电话号码得到商户
	 * 
	 * @param phone
	 * @return
	 */
	@Deprecated
	public PojoMerchDeta getMerchByPhone(String phone);

	/**
	 * 根据memberId得到商户
	 * 
	 * @param memberId
	 * @return
	 */
	public PojoMerchDeta getMerchBymemberId(String memberId);
}
