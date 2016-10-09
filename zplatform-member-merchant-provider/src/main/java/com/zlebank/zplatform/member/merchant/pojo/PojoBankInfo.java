/* 
 * PojoBankInfo.java  
 * 
 * version TODO
 *
 * 2015年9月18日 
 * 
 * Copyright (c) 2015,zlebank.All rights reserved.
 * 
 */
package com.zlebank.zplatform.member.merchant.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Class Description
 *
 * @author Luxiaoshuai
 * @version
 * @date 2015年9月18日 下午3:47:11
 * @since 
 */
@Entity
@Table(name="T_BANK_INFO")
public class PojoBankInfo implements Serializable{
    /**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4500274727130352574L;
	/**节点号码**/
    private String bankNode;
    /**清算行号**/
    private String bankCode;
    /**城市代码**/
    private String bankCity;
    /**银行名称**/
    private String bankName;
    /**银行简称**/
    private String bankSname;
    /**地址**/
    private String bankAddress;
    /**状态**/
    private String status;
    /**主银行缩写代码**/
    private String mainBankScode;
    /**主银行银行名称**/
    private String mainBankSname;
    /**级别**/
    private String bankLevel;
    /**父级节点号码**/
    private String parentNode;
    /**备注1**/
    private String notes;
    /**备注2**/
    private String remarks;
    @Column(name = "BANK_NODE")
    @Id
    public String getBankNode() {
        return bankNode;
    }
    public void setBankNode(String bankNode) {
        this.bankNode = bankNode;
    }
    @Column(name = "BANK_CODE")
    public String getBankCode() {
        return bankCode;
    }
    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }
    @Column(name = "BANK_CITY")
    public String getBankCity() {
        return bankCity;
    }
    public void setBankCity(String bankCity) {
        this.bankCity = bankCity;
    }
    @Column(name = "BANK_NAME")
    public String getBankName() {
        return bankName;
    }
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
    @Column(name = "BANK_SNAME")
    public String getBankSname() {
        return bankSname;
    }
    public void setBankSname(String bankSname) {
        this.bankSname = bankSname;
    }
    @Column(name = "BANK_ADDRESS")
    public String getBankAddress() {
        return bankAddress;
    }
    public void setBankAddress(String bankAddress) {
        this.bankAddress = bankAddress;
    }
    @Column(name = "STATUS")
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    @Column(name = "MAIN_BANK_SCODE")
    public String getMainBankScode() {
        return mainBankScode;
    }
    public void setMainBankScode(String mainBankScode) {
        this.mainBankScode = mainBankScode;
    }
    @Column(name = "MAIN_BANK_SNAME")
    public String getMainBankSname() {
        return mainBankSname;
    }
    public void setMainBankSname(String mainBankSname) {
        this.mainBankSname = mainBankSname;
    }
    @Column(name = "BANK_LEVEL")
    public String getBankLevel() {
        return bankLevel;
    }
    public void setBankLevel(String bankLevel) {
        this.bankLevel = bankLevel;
    }
    @Column(name = "PARENT_NODE")
    public String getParentNode() {
        return parentNode;
    }
    public void setParentNode(String parentNode) {
        this.parentNode = parentNode;
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

}
