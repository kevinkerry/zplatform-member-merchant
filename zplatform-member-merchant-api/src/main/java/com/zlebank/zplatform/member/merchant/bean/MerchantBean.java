/* 
 * Merchant.java  
 * 
 * version TODO
 *
 * 2015年9月11日 
 * 
 * Copyright (c) 2015,zlebank.All rights reserved.
 * 
 */
package com.zlebank.zplatform.member.merchant.bean;

import java.io.Serializable;
import java.util.Date;

import com.zlebank.zplatform.member.merchant.bean.enums.CardType;
import com.zlebank.zplatform.member.merchant.bean.enums.IndustryType;
import com.zlebank.zplatform.member.merchant.bean.enums.MerchType;

/**
 * Class Description
 *
 * @author yangpeng
 * @version
 * @date 2015年9月11日 上午9:44:22
 * @since 
 */
public class MerchantBean implements Serializable{
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 3572436993137918257L;
    /**商户名称**/
    private String merchname;
    /**商户简称**/
    private String alias;
    /**商户英文名称**/
    private String engname;
    /**商户所属机构**/
    private Long merchinsti;
    /**商户所属省**/
    private Long province;
    /**商户所属市**/
    private Long city;
    /**商户所属县**/
    private Long street;
    /**商户地址**/
    private String address;
    /**税务登记证号**/
    private String taxno;
    /**营业执照号**/
    private String licenceno;
    /**组织机构代码证**/
    private String orgcode;
    /**商户网址**/
    private String website;
    /**商户类型:0代理商1普通商户**/
    private MerchType merchtype;
    /**所属行业:0餐饮1酒店连锁2其他3大型商场连锁4娱乐5金融6物流**/
    private IndustryType trade;
    /**法人**/
    private String corporation;
    /**法人身份证号码**/
    private String corpno;
    /**联系人**/
    private String contact;
    /**联系人电话**/
    private String contphone;
    /**联系人职位**/
    private String conttitle;
    /**联系人邮箱**/
    private String contemail;
    /**客户来源**/
    private String custfrom;
    /**客户经理**/
    private String custmgr;
    /**客户经理部门**/
    private String custmgrdept;
    /**签约人**/
    private String signatory;
    /**签约人电话**/
    private String signphone;
    /**清算周期**/
    private Long setlcycle;
    /**结算行号**/
    private String bankcode;
    /**开户行号**/
    private String banknode;
    /**开户账号**/
    private String accnum;
    /**开户名**/
    private String accname;
    /**服务费**/
    private Money charge;
    /**保证金**/
    private Money deposit;
    /**合约开始日期**/
    private Date agreemtStart;
    /**合约终止日期**/
    private Date agreemtEnd;
    /**开户行所属省**/
    private Long bnkProvince;
    /**开户行所属市**/
    private Long bnkCity;
    /**开户行所属县**/
    private Long bnkStreet;
    /**邮编**/
    private String postcode;
    /**邮箱**/
    private String email;
    /**身份证文件目录**/
    private String corpfile;
    /**税务登记证文件目录**/
    private String taxfile;
    /**营业执照文件目录**/
    private String licencefile;
    /**组织机构文件目录**/
    private String orgcodefile;
    /**备注**/
    private String notes;
    /**备注**/
    private String remarks;
    /**上级商户**/
    private String parent;
    /**证件类型**/
    private CardType cardtype;
    /**联系人地址**/
    private String contaddress;
    /**联系人邮编**/
    private String contpost;
   
    /**
     * @param merchname
     * @param alias
     * @param engname
     * @param merchinsti
     * @param province
     * @param city
     * @param street
     * @param address
     * @param taxno
     * @param licenceno
     * @param orgcode
     * @param website
     * @param merchtype
     * @param trade
     * @param corporation
     * @param corpno
     * @param contact
     * @param contphone
     * @param conttitle
     * @param contemail
     * @param custfrom
     * @param custmgr
     * @param custmgrdept
     * @param signatory
     * @param signphone
     * @param setlcycle
     * @param bankcode
     * @param banknode
     * @param accnum
     * @param accname
     * @param charge
     * @param deposit
     * @param agreemtStart
     * @param agreemtEnd
     * @param bnkProvince
     * @param bnkCity
     * @param bnkStreet
     * @param postcode
     * @param email
     * @param corpfile
     * @param taxfile
     * @param licencefile
     * @param orgcodefile
     * @param notes
     * @param remarks
     * @param parent
     */
    public MerchantBean(String merchname, String alias, String engname,
            Long merchinsti, Long province, Long city, Long street,
            String address, String taxno, String licenceno, String orgcode,
            String website, MerchType merchtype, IndustryType trade,
            String corporation, String corpno, String contact,
            String contphone, String conttitle, String contemail,
            String custfrom, String custmgr, String custmgrdept,
            String signatory, String signphone, Long setlcycle,
            String bankcode, String banknode, String accnum, String accname,
            Money charge, Money deposit, Date agreemtStart, Date agreemtEnd,
            Long bnkProvince, Long bnkCity, Long bnkStreet, String postcode,
            String email, String corpfile, String taxfile, String licencefile,
            String orgcodefile, String notes, String remarks, String parent) {
        super();
        this.merchname = merchname;
        this.alias = alias;
        this.engname = engname;
        this.merchinsti = merchinsti;
        this.province = province;
        this.city = city;
        this.street = street;
        this.address = address;
        this.taxno = taxno;
        this.licenceno = licenceno;
        this.orgcode = orgcode;
        this.website = website;
        this.merchtype = merchtype;
        this.trade = trade;
        this.corporation = corporation;
        this.corpno = corpno;
        this.contact = contact;
        this.contphone = contphone;
        this.conttitle = conttitle;
        this.contemail = contemail;
        this.custfrom = custfrom;
        this.custmgr = custmgr;
        this.custmgrdept = custmgrdept;
        this.signatory = signatory;
        this.signphone = signphone;
        this.setlcycle = setlcycle;
        this.bankcode = bankcode;
        this.banknode = banknode;
        this.accnum = accnum;
        this.accname = accname;
        this.charge = charge;
        this.deposit = deposit;
        this.agreemtStart = agreemtStart;
        this.agreemtEnd = agreemtEnd;
        this.bnkProvince = bnkProvince;
        this.bnkCity = bnkCity;
        this.bnkStreet = bnkStreet;
        this.postcode = postcode;
        this.email = email;
        this.corpfile = corpfile;
        this.taxfile = taxfile;
        this.licencefile = licencefile;
        this.orgcodefile = orgcodefile;
        this.notes = notes;
        this.remarks = remarks;
        this.parent = parent;
    }
    /**
     * 
     */
    public MerchantBean() {
        super();
        // TODO Auto-generated constructor stub
    }
    public String getMerchname() {
        return merchname;
    }
    public void setMerchname(String merchname) {
        this.merchname = merchname;
    }
    public String getAlias() {
        return alias;
    }
    public void setAlias(String alias) {
        this.alias = alias;
    }
    public String getEngname() {
        return engname;
    }
    public void setEngname(String engname) {
        this.engname = engname;
    }
    public Long getMerchinsti() {
        return merchinsti;
    }
    public void setMerchinsti(Long merchinsti) {
        this.merchinsti = merchinsti;
    }
    public Long getProvince() {
        return province;
    }
    public void setProvince(Long province) {
        this.province = province;
    }
    public Long getCity() {
        return city;
    }
    public void setCity(Long city) {
        this.city = city;
    }
    public Long getStreet() {
        return street;
    }
    public void setStreet(Long street) {
        this.street = street;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getTaxno() {
        return taxno;
    }
    public void setTaxno(String taxno) {
        this.taxno = taxno;
    }
    public String getLicenceno() {
        return licenceno;
    }
    public void setLicenceno(String licenceno) {
        this.licenceno = licenceno;
    }
    public String getOrgcode() {
        return orgcode;
    }
    public void setOrgcode(String orgcode) {
        this.orgcode = orgcode;
    }
    public String getWebsite() {
        return website;
    }
    public void setWebsite(String website) {
        this.website = website;
    }
    public MerchType getMerchtype() {
        return merchtype;
    }
    public void setMerchtype(MerchType merchtype) {
        this.merchtype = merchtype;
    }
    public IndustryType getTrade() {
        return trade;
    }
    public void setTrade(IndustryType trade) {
        this.trade = trade;
    }
    public String getCorporation() {
        return corporation;
    }
    public void setCorporation(String corporation) {
        this.corporation = corporation;
    }
    public String getCorpno() {
        return corpno;
    }
    public void setCorpno(String corpno) {
        this.corpno = corpno;
    }
    public String getContact() {
        return contact;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }
    public String getContphone() {
        return contphone;
    }
    public void setContphone(String contphone) {
        this.contphone = contphone;
    }
    public String getConttitle() {
        return conttitle;
    }
    public void setConttitle(String conttitle) {
        this.conttitle = conttitle;
    }
    public String getContemail() {
        return contemail;
    }
    public void setContemail(String contemail) {
        this.contemail = contemail;
    }
    public String getCustfrom() {
        return custfrom;
    }
    public void setCustfrom(String custfrom) {
        this.custfrom = custfrom;
    }
    public String getCustmgr() {
        return custmgr;
    }
    public void setCustmgr(String custmgr) {
        this.custmgr = custmgr;
    }
    public String getCustmgrdept() {
        return custmgrdept;
    }
    public void setCustmgrdept(String custmgrdept) {
        this.custmgrdept = custmgrdept;
    }
    public String getSignatory() {
        return signatory;
    }
    public void setSignatory(String signatory) {
        this.signatory = signatory;
    }
    public String getSignphone() {
        return signphone;
    }
    public void setSignphone(String signphone) {
        this.signphone = signphone;
    }
    public Long getSetlcycle() {
        return setlcycle;
    }
    public void setSetlcycle(Long setlcycle) {
        this.setlcycle = setlcycle;
    }
    public String getBankcode() {
        return bankcode;
    }
    public void setBankcode(String bankcode) {
        this.bankcode = bankcode;
    }
    public String getBanknode() {
        return banknode;
    }
    public void setBanknode(String banknode) {
        this.banknode = banknode;
    }
    public String getAccnum() {
        return accnum;
    }
    public void setAccnum(String accnum) {
        this.accnum = accnum;
    }
    public String getAccname() {
        return accname;
    }
    public void setAccname(String accname) {
        this.accname = accname;
    }
    public Money getCharge() {
        return charge;
    }
    public void setCharge(Money charge) {
        this.charge = charge;
    }
    public Money getDeposit() {
        return deposit;
    }
    public void setDeposit(Money deposit) {
        this.deposit = deposit;
    }
    public Date getAgreemtStart() {
        return agreemtStart;
    }
    public void setAgreemtStart(Date agreemtStart) {
        this.agreemtStart = agreemtStart;
    }
    public Date getAgreemtEnd() {
        return agreemtEnd;
    }
    public void setAgreemtEnd(Date agreemtEnd) {
        this.agreemtEnd = agreemtEnd;
    }
    public Long getBnkProvince() {
        return bnkProvince;
    }
    public void setBnkProvince(Long bnkProvince) {
        this.bnkProvince = bnkProvince;
    }
    public Long getBnkCity() {
        return bnkCity;
    }
    public void setBnkCity(Long bnkCity) {
        this.bnkCity = bnkCity;
    }
    public Long getBnkStreet() {
        return bnkStreet;
    }
    public void setBnkStreet(Long bnkStreet) {
        this.bnkStreet = bnkStreet;
    }
    public String getPostcode() {
        return postcode;
    }
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCorpfile() {
        return corpfile;
    }
    public void setCorpfile(String corpfile) {
        this.corpfile = corpfile;
    }
    public String getTaxfile() {
        return taxfile;
    }
    public void setTaxfile(String taxfile) {
        this.taxfile = taxfile;
    }
    public String getLicencefile() {
        return licencefile;
    }
    public void setLicencefile(String licencefile) {
        this.licencefile = licencefile;
    }
    public String getOrgcodefile() {
        return orgcodefile;
    }
    public void setOrgcodefile(String orgcodefile) {
        this.orgcodefile = orgcodefile;
    }
    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
    public String getRemarks() {
        return remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    public String getParent() {
        return parent;
    }
    public void setParent(String parent) {
        this.parent = parent;
    }
    public CardType getCardtype() {
        return cardtype;
    }
    public void setCardtype(CardType cardtype) {
        this.cardtype = cardtype;
    }
    public String getContaddress() {
        return contaddress;
    }
    public void setContaddress(String contaddress) {
        this.contaddress = contaddress;
    }
    public String getContpost() {
        return contpost;
    }
    public void setContpost(String contpost) {
        this.contpost = contpost;
    }

    
    
}
