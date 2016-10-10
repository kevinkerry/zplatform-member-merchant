/* 
 * PojoMerchDeta.java  
 * 
 * version TODO
 *
 * 2015年9月7日 
 * 
 * Copyright (c) 2015,zlebank.All rights reserved.
 * 
 */
package com.zlebank.zplatform.member.merchant.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import com.zlebank.zplatform.member.merchant.pojo.usertype.MerchStatusType;

/**
 * Class Description
 *
 * @author Luxiaoshuai
 * @version
 * @date 2015年9月7日 下午4:37:54 
 * @since 
 */
@Entity
@Table(name="T_MERCH_DETA")
public class PojoMerchDeta implements Serializable{
  
    /**主键**/
    private Long merchId;
    /**会员外键**/
    private Long memId;
    /**会员号**/
    private String memberId;
    /**上级商户**/
    private String parent;
    /**清算周期**/
    private Long setlCycle;
    /**清算类型**/
    private String setlType;
    /**结算行号**/
    private String bankCode;
    /**开户行号**/
    private String bankNode;
    /**开户账号**/
    private String accNum;
    /**开户名**/
    private String accName;
    /**服务费**/
    private Money charge;
    /**保证金**/
    private Money deposit;
    /**合约开始日期**/
    private Date agreemtStart;
    /**合约终止日期**/
    private Date agreemtEnd;
    /**产品代码**/
    private String prdtVer;
    /**扣率版本**/
    private String feeVer;
    /**分润版本**/
    private String spiltVer;
    /**风控版本**/
    private String riskVer;
    /**路由版本**/
    private String routVer;
    /**状态**/
    private MerchStatusType merchStatus;
    /**写入人**/
    private Long inUser;
    /**写入时间**/
    private Date inTime;
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
    private String activeStatus;
 
    @GenericGenerator(name = "id_gen", strategy = "enhanced-table", parameters = {
            @Parameter(name = "table_name", value = "T_C_PRIMAY_KEY"),
            @Parameter(name = "value_column_name", value = "NEXT_ID"),
            @Parameter(name = "segment_column_name", value = "KEY_NAME"),
            @Parameter(name = "segment_value", value = "MERCH_DETA_ID"),
            @Parameter(name = "increment_size", value = "1"),
            @Parameter(name = "optimizer", value = "pooled-lo") })
    @Id
    @GeneratedValue(generator = "id_gen")
    @Column(name = "MERCH_ID")
    public Long getMerchId() {
        return merchId;
    }
    public void setMerchId(Long merchId) {
        this.merchId = merchId;
    }
    @Column(name = "MEM_ID")
    public Long getMemId() {
        return memId;
    }
    public void setMemId(Long memId) {
        this.memId = memId;
    }
    
    @Column(name = "MEMBER_ID")
    public String getMemberId() {
        return memberId;
    }
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    @Column(name = "SETL_CYCLE")
    public Long getSetlCycle() {
        return setlCycle;
    }
    public void setSetlCycle(Long setlCycle) {
        this.setlCycle = setlCycle;
    }
    @Column(name = "SETL_TYPE")
    public String getSetlType() {
        return setlType;
    }
    public void setSetlType(String setlType) {
        this.setlType = setlType;
    }
    @Column(name = "BANK_CODE")
    public String getBankCode() {
        return bankCode;
    }
    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }
    @Column(name = "BANK_NODE")
    public String getBankNode() {
        return bankNode;
    }
    public void setBankNode(String bankNode) {
        this.bankNode = bankNode;
    }
    @Column(name = "ACC_NUM")
    public String getAccNum() {
        return accNum;
    }
    public void setAccNum(String accNum) {
        this.accNum = accNum;
    }
    @Column(name = "ACC_NAME")
    public String getAccName() {
        return accName;
    }
    public void setAccName(String accName) {
        this.accName = accName;
    }

    @Embedded
    @AttributeOverrides({@AttributeOverride(name="amount",column=@Column(name="CHARGE"))}) 
    public Money getCharge() {
        return charge;
    }
    @Embedded
    @AttributeOverrides({@AttributeOverride(name="amount",column=@Column(name="DEPOSIT"))}) 
    public Money getDeposit() {
        return deposit;
    }
    @Type(type = "com.zlebank.zplatform.member.merchant.pojo.usertype.MerchStatusSqlType")
    @Column(name = "STATUS")
    public MerchStatusType getMerchStatus() {
        return merchStatus;
    }
    @Column(name = "PARENT")
    public String getParent() {
        return parent;
    }
    public void setCharge(Money charge) {
        this.charge = charge;
    }
    public void setDeposit(Money deposit) {
        this.deposit = deposit;
    }

    public void setMerchStatus(MerchStatusType merchStatus) {
        this.merchStatus = merchStatus;
    }
    public void setParent(String parent) {
        this.parent = parent;
    }
    @Column(name = "AGREEMT_START")
    public Date getAgreemtStart() {
        return agreemtStart;
    }
    public void setAgreemtStart(Date agreemtStart) {
        this.agreemtStart = agreemtStart;
    }
    @Column(name = "AGREEMT_END")
    public Date getAgreemtEnd() {
        return agreemtEnd;
    }
    public void setAgreemtEnd(Date agreemtEnd) {
        this.agreemtEnd = agreemtEnd;
    }
    @Column(name = "PRDT_VER")
    public String getPrdtVer() {
        return prdtVer;
    }
    public void setPrdtVer(String prdtVer) {
        this.prdtVer = prdtVer;
    }
    @Column(name = "FEE_VER")
    public String getFeeVer() {
        return feeVer;
    }
    public void setFeeVer(String feeVer) {
        this.feeVer = feeVer;
    }
    @Column(name = "SPILT_VER")
    public String getSpiltVer() {
        return spiltVer;
    }
    public void setSpiltVer(String spiltVer) {
        this.spiltVer = spiltVer;
    }
    @Column(name = "RISK_VER")
    public String getRiskVer() {
        return riskVer;
    }
    public void setRiskVer(String riskVer) {
        this.riskVer = riskVer;
    }
    @Column(name = "ROUT_VER")
    public String getRoutVer() {
        return routVer;
    }
    public void setRoutVer(String routVer) {
        this.routVer = routVer;
    }
    @Column(name = "IN_USER")
    public Long getInUser() {
        return inUser;
    }
    public void setInUser(Long inUser) {
        this.inUser = inUser;
    }
    @Column(name = "IN_TIME")
    public Date getInTime() {
        return inTime;
    }
    public void setInTime(Date inTime) {
        this.inTime = inTime;
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
    @Column(name = "ACTIVATE_STATUS")
    public String getActiveStatus() {
        return activeStatus;
    }
    public void setActiveStatus(String activeStatus) {
        this.activeStatus = activeStatus;
    }

}
