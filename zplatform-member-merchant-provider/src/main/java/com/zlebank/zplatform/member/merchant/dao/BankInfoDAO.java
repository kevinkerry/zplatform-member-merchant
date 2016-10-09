/* 
 * BankInfoDAO.java  
 * 
 * version TODO
 *
 * 2015年9月18日 
 * 
 * Copyright (c) 2015,zlebank.All rights reserved.
 * 
 */
package com.zlebank.zplatform.member.merchant.dao;

import java.util.List;

import com.zlebank.zplatform.member.commons.dao.BaseDAO;
import com.zlebank.zplatform.member.merchant.pojo.PojoBankInfo;

/**
 * Class Description
 *
 * @author Luxiaoshuai
 * @version
 * @date 2015年9月18日 下午3:48:31
 * @since 
 */
public interface BankInfoDAO extends BaseDAO<PojoBankInfo> {
        /**
         * 通过银行代码得到银行信息
         * @param code
         * @return PojoBankInfo
         */
    public PojoBankInfo getByBankNode(String bankCode);
    /**
     * 通过银行支行名称得到银行信息
     * @param code
     * @return List<PojoBankInfo>
     */
    public List<PojoBankInfo> getByBankName(String bankName, int size);
    /**
     * 通过银行支行名称得到银行信息条数
     * @param code
     * @return int
     */
    public long getByBankNameCount(String bankName) ;
}
