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
import com.zlebank.zplatform.member.merchant.pojo.PojoEnterpriseDeta;

/**
 * 
 * 企业DAO
 *
 * @author Luxiaoshuai
 * @version
 * @date 2016年3月21日 下午2:12:54
 * @since
 */
public interface EnterpriseDAO extends BaseDAO<PojoEnterpriseDeta> {
    
    /**
     * 根据memberId得到企业
     * @param memberId
     * @return 企业
     */
   public  PojoEnterpriseDeta  getEnterpriseByMemberId(String memberId); 
}
