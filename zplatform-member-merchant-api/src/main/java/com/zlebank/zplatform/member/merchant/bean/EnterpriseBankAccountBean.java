/* 
 * EnterpriseBankAccountBean.java  
 * 
 * version TODO
 *
 * 2016年8月23日 
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
 * @date 2016年8月23日 下午4:12:07
 * @since 
 */
public class EnterpriseBankAccountBean implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3290652638964553700L;
	
	private String memberId;//企业会员号
	private String coopinsti;//合作机构
	private String accNum;//银行账号
	private String accName;//银行账户名称
	private String bankNode;//开户行号
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
	 * @return the coopinsti
	 */
	public String getCoopinsti() {
		return coopinsti;
	}
	/**
	 * @param coopinsti the coopinsti to set
	 */
	public void setCoopinsti(String coopinsti) {
		this.coopinsti = coopinsti;
	}
	/**
	 * @return the accNum
	 */
	public String getAccNum() {
		return accNum;
	}
	/**
	 * @param accNum the accNum to set
	 */
	public void setAccNum(String accNum) {
		this.accNum = accNum;
	}
	/**
	 * @return the accName
	 */
	public String getAccName() {
		return accName;
	}
	/**
	 * @param accName the accName to set
	 */
	public void setAccName(String accName) {
		this.accName = accName;
	}
	/**
	 * @return the bankNode
	 */
	public String getBankNode() {
		return bankNode;
	}
	/**
	 * @param bankNode the bankNode to set
	 */
	public void setBankNode(String bankNode) {
		this.bankNode = bankNode;
	}
}
