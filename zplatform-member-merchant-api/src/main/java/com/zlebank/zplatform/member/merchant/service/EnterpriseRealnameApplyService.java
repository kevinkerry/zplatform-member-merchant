/* 
 * EnterpriseRealnameApplyService.java  
 * 
 * version TODO
 *
 * 2016年8月22日 
 * 
 * Copyright (c) 2016,zlebank.All rights reserved.
 * 
 */
package com.zlebank.zplatform.member.merchant.service;

import com.zlebank.zplatform.member.merchant.bean.EnterpriseRealNameBean;
import com.zlebank.zplatform.member.merchant.bean.EnterpriseRealNameQueryBean;
import com.zlebank.zplatform.member.merchant.bean.PagedResult;

/**
 * Class Description
 *
 * @author guojia
 * @version
 * @date 2016年8月22日 上午10:46:34
 * @since 
 */
public interface EnterpriseRealnameApplyService {

	/**
	 * 保存实名认证申请
	 * @param enterpriseRealnameApply
	 */
	public void saveEnterpriseRealnameApply(EnterpriseRealNameBean enterpriseRealnameApply);
	
	/**
	 * 通过
	 * @param tn
	 * @return
	 */
	public EnterpriseRealNameBean getDetaByTN(String tn);
	
	/**
	 * 更新企业实名认证申请状态
	 * @param enterpriseRealnameApply
	 */
	public void updateApplyStatus(EnterpriseRealNameBean enterpriseRealnameApply);
	
	/**
	 * 通过主键获取实名认证数据
	 * @param tid
	 * @return
	 */
	public EnterpriseRealNameBean get(Long tid);
    
	/**
	 * 企业实名认证审核分页查询
	 * @param page
	 * @param pageSize
	 * @param queryBean
	 * @return
	 */
	public PagedResult<EnterpriseRealNameBean> queryPaged(int page,int pageSize,EnterpriseRealNameQueryBean queryBean);
}
