/* 
 * EnterpriseRealNameBean.java  
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
 * 企业实名认证bean
 *
 * @author guojia
 * @version
 * @date 2016年8月22日 上午9:28:10
 * @since
 */
public class EnterpriseRealNameBean  implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 2957897255631015514L;

	/** 原始订单信息 **/
	private String txnType;// 交易类型
	private String txnSubType;// 交易子类
	private String bizType;// 产品类型
	private String channelType;// 渠道类型
	private String memberId;// 企业会员ID
	private String enterpriseName;// 企业名称
	private String licenceNo;// 工商营业执照号
	private String corporation;// 法人姓名
	private String contactsTelNo;// 联系人电话
	private String frontURL;// 前台通知地址
	private String coopInsti;//合作机构

	/** 企业实名认证信息 **/
	private String orgCode;// 组织机构代码
	private String taxNo;// 企业税务登记号
	private String corpNo;// 法人代表身份证号
	private String contact;// 企业联系人姓名
	private String accNum;// 银行账号
	private String accName;// 银行账户名
	private String bankNode;// 银行账户开户网点(开户行号)
	
	private String tn;
	
	private long tid;
	private Long txnamt;
	private String status;
	private String bankName;
	/**
     * @return the tid
     */
    public long getTid() {
        return tid;
    }
    /**
     * @param tid the tid to set
     */
    public void setTid(long tid) {
        this.tid = tid;
    }
    /**
	 * @return the txnType
	 */
	public String getTxnType() {
		return txnType;
	}
	/**
	 * @param txnType the txnType to set
	 */
	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}
	/**
	 * @return the txnSubType
	 */
	public String getTxnSubType() {
		return txnSubType;
	}
	/**
	 * @param txnSubType the txnSubType to set
	 */
	public void setTxnSubType(String txnSubType) {
		this.txnSubType = txnSubType;
	}
	/**
	 * @return the bizType
	 */
	public String getBizType() {
		return bizType;
	}
	/**
	 * @param bizType the bizType to set
	 */
	public void setBizType(String bizType) {
		this.bizType = bizType;
	}
	/**
	 * @return the channelType
	 */
	public String getChannelType() {
		return channelType;
	}
	/**
	 * @param channelType the channelType to set
	 */
	public void setChannelType(String channelType) {
		this.channelType = channelType;
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
	 * @return the enterpriseName
	 */
	public String getEnterpriseName() {
		return enterpriseName;
	}
	/**
	 * @param enterpriseName the enterpriseName to set
	 */
	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}
	/**
	 * @return the licenceNo
	 */
	public String getLicenceNo() {
		return licenceNo;
	}
	/**
	 * @param licenceNo the licenceNo to set
	 */
	public void setLicenceNo(String licenceNo) {
		this.licenceNo = licenceNo;
	}
	/**
	 * @return the corporation
	 */
	public String getCorporation() {
		return corporation;
	}
	/**
	 * @param corporation the corporation to set
	 */
	public void setCorporation(String corporation) {
		this.corporation = corporation;
	}
	/**
	 * @return the contactsTelNo
	 */
	public String getContactsTelNo() {
		return contactsTelNo;
	}
	/**
	 * @param contactsTelNo the contactsTelNo to set
	 */
	public void setContactsTelNo(String contactsTelNo) {
		this.contactsTelNo = contactsTelNo;
	}
	/**
	 * @return the frontURL
	 */
	public String getFrontURL() {
		return frontURL;
	}
	/**
	 * @param frontURL the frontURL to set
	 */
	public void setFrontURL(String frontURL) {
		this.frontURL = frontURL;
	}
	/**
	 * @return the orgCode
	 */
	public String getOrgCode() {
		return orgCode;
	}
	/**
	 * @param orgCode the orgCode to set
	 */
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	/**
	 * @return the taxNo
	 */
	public String getTaxNo() {
		return taxNo;
	}
	/**
	 * @param taxNo the taxNo to set
	 */
	public void setTaxNo(String taxNo) {
		this.taxNo = taxNo;
	}
	/**
	 * @return the corpNo
	 */
	public String getCorpNo() {
		return corpNo;
	}
	/**
	 * @param corpNo the corpNo to set
	 */
	public void setCorpNo(String corpNo) {
		this.corpNo = corpNo;
	}
	/**
	 * @return the contact
	 */
	public String getContact() {
		return contact;
	}
	/**
	 * @param contact the contact to set
	 */
	public void setContact(String contact) {
		this.contact = contact;
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
	 * @return the txnamt
	 */
	public Long getTxnamt() {
		return txnamt;
	}
	/**
	 * @param txnamt the txnamt to set
	 */
	public void setTxnamt(Long txnamt) {
		this.txnamt = txnamt;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the bankName
	 */
	public String getBankName() {
		return bankName;
	}
	/**
	 * @param bankName the bankName to set
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	
	
}
