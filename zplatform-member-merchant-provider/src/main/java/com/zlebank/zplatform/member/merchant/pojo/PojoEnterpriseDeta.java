/* 
 * PojoEnterpriseDeta.java  
 * 
 * version v1.3
 *
 * 2016年2月24日 
 * 
 * Copyright (c) 2016,zlebank.All rights reserved.
 * 
 */
package com.zlebank.zplatform.member.merchant.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.zlebank.zplatform.member.merchant.bean.enums.CardType;

/**
 * 企业会员
 *
 * @author Luxiaoshuai
 * @version
 * @date 2016年2月24日 下午3:39:26
 * @since 
 */
@Entity
@PrimaryKeyJoinColumn(name="ENTERPRISE_ID") 
@Table(name="T_ENTERPRISE_DETA")
public class PojoEnterpriseDeta extends PojoMember{
    /**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6099736990878032685L;
	/**会员号**/
    private String enterpriseMemberId;
    /** 企业名称 **/
    private String enterpriseName;
    /**合作机构id**/
    private Long coopInstiId;
    /**所属行业**/
    private String mcc;
    /**所属行业子类别**/
    private String mccList;
    /**企业所属机构**/
    private Long enterpriseInsti;
    /**企业所属省**/
    private Long province;
    /**企业所属市**/
    private Long city;
    /**企业所属县**/
    private Long street;
    /**企业行政地区代码（由商户所属县得到）**/
    private String zoneCode;
    /**企业邮编**/
    private String postCode;
    /**企业地址**/
    private String address;
    /**企业邮箱**/
    private String email;
    /**企业网址**/
    private String website;
    /**企业证件类型**/
    private CardType cardType;
    /**税务登记证号**/
    private String taxNo;
    /**营业执照号**/
    private String licenceNo;
    /**组织机构代码证**/
    private String orgCode;
    /**法人**/
    private String corporation;
    /**法人证件号码**/
    private String corpNo;
    /**法人身份证正面路径**/
    private String corpFile;
    /**法人身份证背面路径**/
    private String corpFileOpp;
    /**税务登记证文件路径**/
    private String taxFile;
    /**营业执照文件路径**/
    private String licenceFile;
    /**组织机构文件路径**/
    private String orgCodeFile;
    /**联系人**/
    private String contact;
    /**联系人电话**/
    private String contPhone;
    /**联系人职位**/
    private String contTitle;
    /**联系人邮箱**/
    private String contEmail;
    /**联系人地址**/
    private String contAddress;
    /**联系人邮编**/
    private String contPost;
    /**客户来源**/
    private String custFrom;
    /**客户经理**/
    private String custMgr;
    /**客户经理部门**/
    private String custMgrDept;
    /**是否授权人办理1-是0-否**/
    private Long isDelegation;
    /**委托人**/
    private String signatory;
    /**委托人身份证**/
    private String signCertNo;
    /**委托人证件照正面路径**/
    private String signCertFile;
    /**委托人证件照背面路径**/
    private String signCertFileOpp;
    /**状态**/
    private String enterpriseStatus;
    /**初次业务时间**/
    private Date firstTime;
    /**写入人**/
    private Long inUser;
    /**写入时间**/
    private Date enterInTime;
    /**初审人**/
    private Long stexaUser;
    /**初审时间**/
    private Date stexaTime;
    /**初审意见**/
    private String stexaOpt;
    /**复核人**/
    private Long cvlexaUser;
    /**复核时间**/
    private Date cvlexaTime;
    /**复核意见**/
    private String cvlexaOpt;
    /**备注**/
    private String notes;
    /**备注**/
    private String remarks;
    /**企业联系手机号**/
    private String cellPhoneNo;

    @Column(name = "MEMBER_ID")
    public String getEnterpriseMemberId() {
        return enterpriseMemberId;
    }
    public void setEnterpriseMemberId(String enterpriseMemberId) {
        this.enterpriseMemberId = enterpriseMemberId;
    }

    @Column(name = "COOP_INSTI_ID")
    public Long getCoopInstiId() {
        return coopInstiId;
    }
    public void setCoopInstiId(Long coopInstiId) {
        this.coopInstiId = coopInstiId;
    }
    @Column(name = "MCC")
    public String getMcc() {
        return mcc;
    }
    public void setMcc(String mcc) {
        this.mcc = mcc;
    }
    @Column(name = "MCC_LIST")
    public String getMccList() {
        return mccList;
    }
    public void setMccList(String mccList) {
        this.mccList = mccList;
    }
    @Column(name = "ENTERPRISE_INSTI")
    public Long getEnterpriseInsti() {
        return enterpriseInsti;
    }
    public void setEnterpriseInsti(Long enterpriseInsti) {
        this.enterpriseInsti = enterpriseInsti;
    }
    
    @Column(name = "PROVINCE")
    public Long getProvince() {
        return province;
    }
    public void setProvince(Long province) {
        this.province = province;
    }
    @Column(name = "CITY")
    public Long getCity() {
        return city;
    }
    public void setCity(Long city) {
        this.city = city;
    }
    @Column(name = "STREET")
    public Long getStreet() {
        return street;
    }
    public void setStreet(Long street) {
        this.street = street;
    }
    @Column(name = "ZONE_CODE")
    public String getZoneCode() {
        return zoneCode;
    }
    public void setZoneCode(String zoneCode) {
        this.zoneCode = zoneCode;
    }
    @Column(name = "POST_CODE")
    public String getPostCode() {
        return postCode;
    }
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    @Column(name = "ADDRESS")
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @Column(name = "WEBSITE")
    public String getWebsite() {
        return website;
    }
    public void setWebsite(String website) {
        this.website = website;
    }
    @Column(name = "CARD_TYPE")
    @Type(type = "com.zlebank.zplatform.member.merchant.pojo.usertype.CardSqlType")
    public CardType getCardType() {
        return cardType;
    }
    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    @Column(name = "TAX_NO")
    public String getTaxNo() {
        return taxNo;
    }
    public void setTaxNo(String taxNo) {
        this.taxNo = taxNo;
    }
    @Column(name = "LICENCE_NO")
    public String getLicenceNo() {
        return licenceNo;
    }
    public void setLicenceNo(String licenceNo) {
        this.licenceNo = licenceNo;
    }
    @Column(name = "ORG_CODE")
    public String getOrgCode() {
        return orgCode;
    }
    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    @Column(name = "CORPORATION")
    public String getCorporation() {
        return corporation;
    }
    public void setCorporation(String corporation) {
        this.corporation = corporation;
    }
    @Column(name = "CORP_NO")
    public String getCorpNo() {
        return corpNo;
    }
    public void setCorpNo(String corpNo) {
        this.corpNo = corpNo;
    }
    @Column(name = "CORP_FILE")
    public String getCorpFile() {
        return corpFile;
    }
    public void setCorpFile(String corpFile) {
        this.corpFile = corpFile;
    }
    @Column(name = "CORP_FILE_OPP")
    public String getCorpFileOpp() {
        return corpFileOpp;
    }
    public void setCorpFileOpp(String corpFileOpp) {
        this.corpFileOpp = corpFileOpp;
    }
    @Column(name = "TAX_FILE")
    public String getTaxFile() {
        return taxFile;
    }
    public void setTaxFile(String taxFile) {
        this.taxFile = taxFile;
    }
    @Column(name = "LICENCE_FILE")
    public String getLicenceFile() {
        return licenceFile;
    }
    public void setLicenceFile(String licenceFile) {
        this.licenceFile = licenceFile;
    }
    @Column(name = "ORG_CODE_FILE")
    public String getOrgCodeFile() {
        return orgCodeFile;
    }
    public void setOrgCodeFile(String orgCodeFile) {
        this.orgCodeFile = orgCodeFile;
    }
    @Column(name = "CONTACT")
    public String getContact() {
        return contact;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }
    @Column(name = "CONT_PHONE")
    public String getContPhone() {
        return contPhone;
    }
    public void setContPhone(String contPhone) {
        this.contPhone = contPhone;
    }
    @Column(name = "CONT_TITLE")
    public String getContTitle() {
        return contTitle;
    }
    public void setContTitle(String contTitle) {
        this.contTitle = contTitle;
    }
    @Column(name = "CONT_EMAIL")
    public String getContEmail() {
        return contEmail;
    }
    public void setContEmail(String contEmail) {
        this.contEmail = contEmail;
    }
    @Column(name = "CONT_ADDRESS")
    public String getContAddress() {
        return contAddress;
    }
    public void setContAddress(String contAddress) {
        this.contAddress = contAddress;
    }
    @Column(name = "CONT_POST")
    public String getContPost() {
        return contPost;
    }
    public void setContPost(String contPost) {
        this.contPost = contPost;
    }
    @Column(name = "CUST_FROM")
    public String getCustFrom() {
        return custFrom;
    }
    public void setCustFrom(String custFrom) {
        this.custFrom = custFrom;
    }
    @Column(name = "CUST_MGR")
    public String getCustMgr() {
        return custMgr;
    }
    public void setCustMgr(String custMgr) {
        this.custMgr = custMgr;
    }
    @Column(name = "CUST_MGR_DEPT")
    public String getCustMgrDept() {
        return custMgrDept;
    }
    public void setCustMgrDept(String custMgrDept) {
        this.custMgrDept = custMgrDept;
    }
    @Column(name = "IS_DELEGATION")
    public Long getIsDelegation() {
        return isDelegation;
    }
    public void setIsDelegation(Long isDelegation) {
        this.isDelegation = isDelegation;
    }
    @Column(name = "SIGNATORY")
    public String getSignatory() {
        return signatory;
    }
    public void setSignatory(String signatory) {
        this.signatory = signatory;
    }
    @Column(name = "SIGN_CERT_NO")
    public String getSignCertNo() {
        return signCertNo;
    }
    public void setSignCertNo(String signCertNo) {
        this.signCertNo = signCertNo;
    }
    @Column(name = "SIGN_CERT_FILE")
    public String getSignCertFile() {
        return signCertFile;
    }
    public void setSignCertFile(String signCertFile) {
        this.signCertFile = signCertFile;
    }
    @Column(name = "SIGN_CERT_FILE_OPP")
    public String getSignCertFileOpp() {
        return signCertFileOpp;
    }
    public void setSignCertFileOpp(String signCertFileOpp) {
        this.signCertFileOpp = signCertFileOpp;
    }
    @Column(name = "STATUS")
    public String getEnterpriseStatus() {
        return enterpriseStatus;
    }
    public void setEnterpriseStatus(String enterpriseStatus) {
        this.enterpriseStatus = enterpriseStatus;
    }
    @Column(name = "FIRST_TIME")
    public Date getFirstTime() {
        return firstTime;
    }
    public void setFirstTime(Date firstTime) {
        this.firstTime = firstTime;
    }
    @Column(name = "IN_USER")
    public Long getInUser() {
        return inUser;
    }
    public void setInUser(Long inUser) {
        this.inUser = inUser;
    }
    @Column(name = "IN_TIME")
    public Date getEnterInTime() {
        return enterInTime;
    }
    public void setEnterInTime(Date enterInTime) {
        this.enterInTime = enterInTime;
    }
    @Column(name = "STEXA_USER")
    public Long getStexaUser() {
        return stexaUser;
    }
    public void setStexaUser(Long stexaUser) {
        this.stexaUser = stexaUser;
    }
    @Column(name = "STEXA_TIME")
    public Date getStexaTime() {
        return stexaTime;
    }
    public void setStexaTime(Date stexaTime) {
        this.stexaTime = stexaTime;
    }
    @Column(name = "STEXA_OPT")
    public String getStexaOpt() {
        return stexaOpt;
    }
    public void setStexaOpt(String stexaOpt) {
        this.stexaOpt = stexaOpt;
    }
    @Column(name = "CVLEXA_USER")
    public Long getCvlexaUser() {
        return cvlexaUser;
    }
    public void setCvlexaUser(Long cvlexaUser) {
        this.cvlexaUser = cvlexaUser;
    }
    @Column(name = "CVLEXA_TIME")
    public Date getCvlexaTime() {
        return cvlexaTime;
    }
    public void setCvlexaTime(Date cvlexaTime) {
        this.cvlexaTime = cvlexaTime;
    }
    @Column(name = "CVLEXA_OPT")
    public String getCvlexaOpt() {
        return cvlexaOpt;
    }
    public void setCvlexaOpt(String cvlexaOpt) {
        this.cvlexaOpt = cvlexaOpt;
    }
    @Column(name = "NOTES")
    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
    @Column(name = "REMARKS")
    public String getRemarks() {
        return remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    @Column(name = "ENTERPRISE_NAME")
    public String getEnterpriseName() {
        return enterpriseName;
    }
    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }
	/**
	 * @return the cellPhoneNo
	 */
    @Column(name = "CELL_PHONE_NO")
	public String getCellPhoneNo() {
		return cellPhoneNo;
	}
	/**
	 * @param cellPhoneNo the cellPhoneNo to set
	 */
	public void setCellPhoneNo(String cellPhoneNo) {
		this.cellPhoneNo = cellPhoneNo;
	}
}
