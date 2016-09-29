/* 
 * MenchService.java  
 * 
 * version TODO
 *
 * 2015年9月11日 
 * 
 * Copyright (c) 2015,zlebank.All rights reserved.
 * 
 */
package com.zlebank.zplatform.member.merchant.service;

import com.zlebank.zplatform.member.merchant.bean.EnterpriseBankAccountBean;
import com.zlebank.zplatform.member.merchant.bean.EnterpriseBean;
import com.zlebank.zplatform.member.merchant.bean.EnterpriseRealNameBean;
import com.zlebank.zplatform.member.merchant.bean.EnterpriseRealNameConfirmBean;
import com.zlebank.zplatform.member.merchant.exception.CreateMemberFailedException;
import com.zlebank.zplatform.member.merchant.exception.DataCheckFailedException;
import com.zlebank.zplatform.member.merchant.exception.InvalidMemberDataException;

/**
 * 
 * 企业服务类
 *
 * @author Luxiaoshuai
 * @version
 * @date 2016年3月21日 下午2:06:21
 * @since
 */
public interface EnterpriseService { 

    
    /**
     * 根据memberId得到企业信息
     * @param memberId
     * @return
     */
   public EnterpriseBean getEnterpriseByMemberId(String memberId); 
   
   /**
    * 企业注册申请
    * @param enterpriseDeta
    */
   public String registerApply(EnterpriseBean enterpriseDeta) throws CreateMemberFailedException,InvalidMemberDataException;
   
   /**
    * 创建企业实名认证bean并提交实名认证申请
    * @param enterpriseRealNameBean
    */
   public void realNameApply(EnterpriseRealNameBean enterpriseRealNameBean) throws InvalidMemberDataException;
   
   
   
   /**
    * 企业实名认证确认
    * @param enterpriseRealNameConfirmBean
    * @throws InvalidMemberDataException
    */
   public void realNameConfirm(EnterpriseRealNameConfirmBean enterpriseRealNameConfirmBean) throws InvalidMemberDataException, DataCheckFailedException;
   
   /**
    * 企业会员绑定银行卡
    * @param enterpriseBankAccountBean
    */
   public void bindingBankAccount(EnterpriseBankAccountBean enterpriseBankAccountBean)throws InvalidMemberDataException;
   
   /**
    * 完成绑定银行账户
    * @param tid
    */
   public void bindingBankAccountFinish(Long tid);
}
