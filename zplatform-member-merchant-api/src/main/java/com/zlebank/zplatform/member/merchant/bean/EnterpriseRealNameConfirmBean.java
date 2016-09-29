/* 
 * EnterpriseRealNameConfirmBean.java  
 * 
 * version TODO
 *
 * 2016年8月22日 
 * 
 * Copyright (c) 2016,zlebank.All rights reserved.
 * 
 */
package com.zlebank.zplatform.member.merchant.bean;

import java.io.Serializable;

/**
 * Class Description
 *
 * @author guojia
 * @version
 * @date 2016年8月22日 下午4:45:29
 * @since 
 */
public class EnterpriseRealNameConfirmBean implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 963619977072561028L;
	private String tn;//受理订单号
	private String memberId;//企业会员号
	private String coopInsti;//合作机构
	private String smsCode;//短信验证码
	private String payPWD;//支付密码-明文
	private String txnamt;//打款金额
	/**
	 * @return the tn
	 */
	public String getTn() {
		return tn;
	}
	/**
	 * @param tn the tn to set
	 */
	public void setTn(String tn) {
		this.tn = tn;
	}
	/**
	 * @return the memberId
	 */
	public String getMemberId() {
		return memberId;
	}
	/**
	 * @param memberId the memberId to set
	 */
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	/**
	 * @return the smsCode
	 */
	public String getSmsCode() {
		return smsCode;
	}
	/**
	 * @param smsCode the smsCode to set
	 */
	public void setSmsCode(String smsCode) {
		this.smsCode = smsCode;
	}
	/**
	 * @return the payPWD
	 */
	public String getPayPWD() {
		return payPWD;
	}
	/**
	 * @param payPWD the payPWD to set
	 */
	public void setPayPWD(String payPWD) {
		this.payPWD = payPWD;
	}
	/**
	 * @return the txnamt
	 */
	public String getTxnamt() {
		return txnamt;
	}
	/**
	 * @param txnamt the txnamt to set
	 */
	public void setTxnamt(String txnamt) {
		this.txnamt = txnamt;
	}
	/**
	 * @return the coopInsti
	 */
	public String getCoopInsti() {
		return coopInsti;
	}
	/**
	 * @param coopInsti the coopInsti to set
	 */
	public void setCoopInsti(String coopInsti) {
		this.coopInsti = coopInsti;
	}
	
	
}
