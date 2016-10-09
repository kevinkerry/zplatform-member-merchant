/* 
 * EnterpriseRealnameApplyDAO.java  
 * 
 * version TODO
 *
 * 2016年8月22日 
 * 
 * Copyright (c) 2016,zlebank.All rights reserved.
 * 
 */
package com.zlebank.zplatform.member.merchant.dao;

import java.util.List;

import com.zlebank.zplatform.member.commons.dao.BaseDAO;
import com.zlebank.zplatform.member.merchant.bean.EnterpriseRealNameQueryBean;
import com.zlebank.zplatform.member.merchant.pojo.PojoEnterpriseRealnameApply;

/**
 * Class Description
 *
 * @author guojia
 * @version
 * @date 2016年8月22日 上午10:41:55
 * @since 
 */
public interface EnterpriseRealnameApplyDAO extends BaseDAO<PojoEnterpriseRealnameApply>{

	/**
	 * 通过tn获取实名认证审核信息
	 * @param tn
	 * @return
	 */
	public PojoEnterpriseRealnameApply getDetaByTN(String tn);
	
	/**
	 * 通过主键获取实名认证审核信息
	 * @param tid
	 * @return
	 */
	public PojoEnterpriseRealnameApply getById(Long tid);

    /**
     * @param example
     */
    public long count(EnterpriseRealNameQueryBean example);

    /**
     * @param offset
     * @param pageSize
     * @param example
     */
    public List<PojoEnterpriseRealnameApply> getItem(int offset,
            int pageSize,
            EnterpriseRealNameQueryBean example);
}
