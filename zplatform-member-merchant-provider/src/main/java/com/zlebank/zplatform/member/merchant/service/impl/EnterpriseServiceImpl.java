/* 
 * CoopInstiMKServiceImpl.java  
 * 
 * version TODO
 *
 * 2016年1月25日 
 * 
 * Copyright (c) 2016,zlebank.All rights reserved.
 * 
 */
package com.zlebank.zplatform.member.merchant.service.impl;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zlebank.zplatform.member.commons.utils.BeanCopyUtil;
import com.zlebank.zplatform.member.commons.utils.Md5;
import com.zlebank.zplatform.member.commons.utils.StringUtil;
import com.zlebank.zplatform.member.coopinsti.bean.CoopInsti;
import com.zlebank.zplatform.member.coopinsti.service.CoopInstiService;
import com.zlebank.zplatform.member.exception.CreateMemberFailedException;
import com.zlebank.zplatform.member.exception.DataCheckFailedException;
import com.zlebank.zplatform.member.exception.InvalidMemberDataException;
import com.zlebank.zplatform.member.exception.PrimaykeyGeneratedException;
import com.zlebank.zplatform.member.individual.bean.MemberApplyBean;
import com.zlebank.zplatform.member.individual.bean.MemberBean;
import com.zlebank.zplatform.member.individual.bean.QuickpayCustBean;
import com.zlebank.zplatform.member.individual.bean.enums.MemberStatusType;
import com.zlebank.zplatform.member.individual.bean.enums.MemberType;
import com.zlebank.zplatform.member.individual.bean.enums.RealNameLvType;
import com.zlebank.zplatform.member.individual.service.MemberApplyService;
import com.zlebank.zplatform.member.individual.service.MemberBankCardService;
import com.zlebank.zplatform.member.individual.service.MemberInfoService;
import com.zlebank.zplatform.member.individual.service.MemberOperationService;
import com.zlebank.zplatform.member.individual.service.PrimayKeyService;
import com.zlebank.zplatform.member.merchant.bean.EnterpriseBankAccountBean;
import com.zlebank.zplatform.member.merchant.bean.EnterpriseBean;
import com.zlebank.zplatform.member.merchant.bean.EnterpriseRealNameBean;
import com.zlebank.zplatform.member.merchant.bean.EnterpriseRealNameConfirmBean;
import com.zlebank.zplatform.member.merchant.dao.BankInfoDAO;
import com.zlebank.zplatform.member.merchant.dao.EnterpriseDAO;
import com.zlebank.zplatform.member.merchant.dao.EnterpriseDetaApplyDAO;
import com.zlebank.zplatform.member.merchant.dao.ProvinceDAO;
import com.zlebank.zplatform.member.merchant.pojo.PojoBankInfo;
import com.zlebank.zplatform.member.merchant.pojo.PojoEnterpriseDeta;
import com.zlebank.zplatform.member.merchant.pojo.PojoEnterpriseDetaApply;
import com.zlebank.zplatform.member.merchant.pojo.PojoEnterpriseRealnameApply;
import com.zlebank.zplatform.member.merchant.pojo.PojoMember;
import com.zlebank.zplatform.member.merchant.pojo.PojoProvince;
import com.zlebank.zplatform.member.merchant.service.EnterpriseRealnameApplyService;
import com.zlebank.zplatform.member.merchant.service.EnterpriseService;

/**
 * 合作机构密钥服务类
 *
 * @author Luxiaoshuai
 * @version
 * @date 2016年1月25日 上午10:08:24
 * @since 
 */
@Service
public class EnterpriseServiceImpl implements EnterpriseService {
    private static final Log log = LogFactory.getLog(EnterpriseServiceImpl.class);
    @Autowired
    private EnterpriseDAO enterpriseDAO;
    @Autowired
    private EnterpriseDetaApplyDAO enterpriseDetaApplyDAO;
    @Autowired
    //private MemberApplyDAO memberApplyDAO;
    private MemberApplyService memberApplyService;
    @Autowired
    private PrimayKeyService primayService;
    @Autowired
    private CoopInstiService coopInstiService;
    @Autowired
    private ProvinceDAO provinceDAO;
    @Autowired
    private MemberInfoService memberService;
    
    
    @Autowired
    private EnterpriseRealnameApplyService enterpriseRealnameApplyService;
    @Autowired
    private BankInfoDAO bankInfoDAO;
   /* @Autowired
    private MemberDAO memberDAO;*/
    @Autowired
    private MemberBankCardService memberBankCardService;
    @Autowired
    private MemberOperationService memberOperationService;
    
    private MemberInfoService memberInfoService;
    
    private final static String MERCHPARATYPE="MERCHBIN";// 企业会员
    private final static String MEMBER_IDSEQUENCES = "seq_t_merch_deta_memberid";// 会员号生成用序列
    /**
     * 根据memberId得到企业信息
     * @param memberId 
     * @return 企业信息
     */
    @Override
    @Transactional(propagation=Propagation.REQUIRED,rollbackFor=Throwable.class)
    public EnterpriseBean getEnterpriseByMemberId(String memberId) {
        PojoEnterpriseDeta pojo = enterpriseDAO.getEnterpriseByMemberId(memberId);
        if(pojo==null){
        	return null;
        }
        EnterpriseBean bean = BeanCopyUtil.copyBean(EnterpriseBean.class, pojo);
        return bean;
    }

	/**
	 *
	 * @param enterpriseDeta
	 * @throws CreateMemberFailedException 
	 * @throws InvalidMemberDataException 
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Throwable.class)
	public String registerApply(EnterpriseBean enterpriseDeta) throws CreateMemberFailedException, InvalidMemberDataException {
		String memberId = null;
		checkData(enterpriseDeta);
		try {
			memberId = primayService.getNexId(MERCHPARATYPE, MEMBER_IDSEQUENCES);
		} catch (PrimaykeyGeneratedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (StringUtil.isEmpty(memberId)) {
		    throw new CreateMemberFailedException("生成会员号时发生错误");
		}
		//合作机构代码 to 合作机构id
		CoopInsti coopInsti = coopInstiService.getInstiByInstiCode(enterpriseDeta.getCoopInstiCode());
		try {
			//通过手机号查询是否绑定过会员
			MemberBean member = memberService.getMemberByPhoneAndCoopInsti(enterpriseDeta.getCellPhoneNo(), coopInsti.getId());//getMemberByphone(enterpriseDeta.getCellPhoneNo());
			if(member!=null){
				 throw new CreateMemberFailedException("企业手机号已被注册");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error(e);
			throw new CreateMemberFailedException("企业注册失败");
		}
		
		MemberApplyBean bean = new MemberApplyBean();
		bean.setMemberId(memberId);// 会员ID
		setMemberComm(bean, enterpriseDeta); // T_member 属性设定
		
		PojoEnterpriseDetaApply enterpriseDetaApply = BeanCopyUtil.copyBean(PojoEnterpriseDetaApply.class, enterpriseDeta);
		enterpriseDetaApply.setMemberId(memberId);
		//主营业务 to MCC 大类MCC 和 小类mcc一致
		enterpriseDetaApply.setMcc(enterpriseDeta.getPrimaryBusiness().getMcc());
		enterpriseDetaApply.setMccList(enterpriseDeta.getPrimaryBusiness().getMcc());
		
		enterpriseDetaApply.setCoopInstiId(coopInsti.getId());
		enterpriseDetaApply.setInTime(new Date());
		//行政地区代码
		PojoProvince pojoProvince = provinceDAO.get(enterpriseDetaApply.getProvince());
		if(pojoProvince!=null){
			enterpriseDetaApply.setZoneCode(pojoProvince.getProvinceCode());
		}else {
			throw new CreateMemberFailedException("省份代码错误");
		}
		enterpriseDetaApply.setStatus("10");
		enterpriseDetaApply.setInUser(0L);
		bean.setInstiCode(coopInsti.getId());
		bean=memberInfoService.saveMemberApply(bean);
		enterpriseDetaApply.setSelfId(bean.getSelfId());
		enterpriseDetaApply.setEnterpriseId(bean.getMemId());
		enterpriseDetaApplyDAO.saveEntity(enterpriseDetaApply);
		return memberId;
	}
	
	/**
     * 设置会员共通属性
     * @param pojo
     * @param bean
     * @param memberType 
     */
    private void setMemberComm(MemberApplyBean pojo, EnterpriseBean bean) {
        pojo.setInstiCode(bean.getCoopInstiId());// 合作机构
        pojo.setMemberName(bean.getEnterpriseName());// 会员昵称
        pojo.setLoginName(bean.getEmail());// 登录名
        pojo.setPwd(Md5.getInstance().md5s("123456"));// 登录密码
        pojo.setRealnameLv(RealNameLvType.LV1.getCode());// 实名等级，01-未实名，02-姓名+身份证,03-银行卡校验,04-证件审核
        pojo.setPhone(bean.getCellPhoneNo());// 手机
        pojo.setEmail(bean.getEmail());// 邮箱
        pojo.setMemberType(MemberType.ENTERPRISE.getCode());// 会员类型，01-个人，02-企业
        pojo.setStatus(MemberStatusType.CHECKING.getCode());// 会员状态，00-正常，02-冻结，99-注销
        pojo.setRegisterIdent("03");// 注册认证，01-手机认证，02-邮箱认证，03-Both
        Date current = new Date();
        pojo.setInTime(current);// 会员注册时间
        //pojo.setUpTime(current);// 修改时间
    }
	
	private void checkData(EnterpriseBean enterpriseDeta) throws InvalidMemberDataException{
		//企业名称
		if(StringUtil.isEmpty(enterpriseDeta.getEnterpriseName())){
			throw new InvalidMemberDataException("企业名称不能为空");
		}
		//所属省份编码
		if(enterpriseDeta.getProvince()==0){
			throw new InvalidMemberDataException("所属省份编码不能为空");
		}
		//所属市编码
		if(enterpriseDeta.getCity()==0){
			throw new InvalidMemberDataException("所属市编码不能为空");
		}
		//所属市辖区/县编码
		if(enterpriseDeta.getStreet()==0){
			throw new InvalidMemberDataException("所属市辖区县编码不能为空");
		}
		//税务登记号
		if(StringUtil.isEmpty(enterpriseDeta.getTaxNo())){
			throw new InvalidMemberDataException("税务登记号不能为空");
		}
		
		//工商营业执照号
		if(StringUtil.isEmpty(enterpriseDeta.getLicenceNo())){
			throw new InvalidMemberDataException("工商营业执照号不能为空");
		}
		//组织机构代码
		if(StringUtil.isEmpty(enterpriseDeta.getOrgCode())){
			throw new InvalidMemberDataException("工商营业执照号不能为空");
		}
		//邮政编码
		if(StringUtil.isEmpty(enterpriseDeta.getPostCode())){
			throw new InvalidMemberDataException("工商营业执照号不能为空");
		}
		
		//法人姓名
		if(StringUtil.isEmpty(enterpriseDeta.getCorporation())){
			throw new InvalidMemberDataException("法人姓名不能为空");
		}
		//法人证件编号
		if(StringUtil.isEmpty(enterpriseDeta.getCorpNo())){
			throw new InvalidMemberDataException("法人证件编号不能为空");
		}
		//联系人姓名
		if(StringUtil.isEmpty(enterpriseDeta.getContact())){
			throw new InvalidMemberDataException("法人证件编号不能为空");
		}
		//联系人电话
		if(StringUtil.isEmpty(enterpriseDeta.getContPhone())){
			throw new InvalidMemberDataException("联系人电话不能为空");
		}
		//联系人地址
		if(StringUtil.isEmpty(enterpriseDeta.getContAddress())){
			throw new InvalidMemberDataException("联系人地址不能为空");
		}
		//联系人邮编
		if(StringUtil.isEmpty(enterpriseDeta.getContPost())){
			throw new InvalidMemberDataException("联系人邮编不能为空");
		}
		//联系人电子邮箱
		if(StringUtil.isEmpty(enterpriseDeta.getContEmail())){
			throw new InvalidMemberDataException("联系人邮编不能为空");
		}
		
		if(StringUtil.isEmpty(enterpriseDeta.getCellPhoneNo())){
			throw new InvalidMemberDataException("企业电话不能为空");
		}
		
		if(StringUtil.isEmpty(enterpriseDeta.getEmail())){
			throw new InvalidMemberDataException("企业邮箱不能为空");
		}
		
	}

	/**
	 *
	 * @param enterpriseRealNameBean
	 * @return
	 * @throws InvalidMemberDataException 
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Throwable.class)
	public void realNameApply(EnterpriseRealNameBean enterpriseRealNameBean) throws InvalidMemberDataException {
		MemberBean enterpriseMember = memberService.getMemberByMemberId(enterpriseRealNameBean.getMemberId(),MemberType.ENTERPRISE);
		if(enterpriseMember==null){
			throw new InvalidMemberDataException("企业会员不存在");
		}else{
			RealNameLvType realnameLv = RealNameLvType.fromValue(enterpriseMember.getRealnameLv());
			if(realnameLv!=RealNameLvType.LV1){
				throw new InvalidMemberDataException("企业会员已经实名认证,请不要重复认证");
			}
		}
		PojoEnterpriseRealnameApply enterpriseRealnameApply = BeanCopyUtil.copyBean(PojoEnterpriseRealnameApply.class, enterpriseRealNameBean);
		enterpriseRealnameApply.setInTime(new Date());
		enterpriseRealnameApply.setInUser(0L);
		enterpriseRealnameApply.setStatus("01");
		PojoBankInfo bankInfo = bankInfoDAO.getByBankNode(enterpriseRealnameApply.getBankNode());
		enterpriseRealnameApply.setBankCode(bankInfo.getBankCode());
		enterpriseRealnameApply.setBankName(bankInfo.getMainBankSname());
		enterpriseRealnameApply.setBusiType("01");//01 企业实名认证
		enterpriseRealnameApplyService.saveEnterpriseRealnameApply(BeanCopyUtil.copyBean(EnterpriseRealNameBean.class, enterpriseRealnameApply));
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Throwable.class)
	public void realNameConfirm(EnterpriseRealNameConfirmBean enterpriseRealNameConfirmBean) throws InvalidMemberDataException, DataCheckFailedException{
		//校验充值金额
		EnterpriseRealNameBean enterpriseRealnameApply = enterpriseRealnameApplyService.getDetaByTN(enterpriseRealNameConfirmBean.getTn());
		log.info(enterpriseRealnameApply.getTxnamt());
		log.info(enterpriseRealNameConfirmBean.getTxnamt());
		if(!enterpriseRealnameApply.getTxnamt().toString().equals(enterpriseRealNameConfirmBean.getTxnamt())){//判断打款金额是否相等
			throw new InvalidMemberDataException("打款金额不一致");
		}
		//打款金额一致
		//1.企业实名认证申请状态为00
		enterpriseRealnameApply.setStatus("00");
		enterpriseRealnameApplyService.updateApplyStatus(enterpriseRealnameApply);
		//2.会员实名认证登记，lv3
		MemberBean memberEnterprise = memberService.getMemberByMemberId(enterpriseRealNameConfirmBean.getMemberId(), MemberType.ENTERPRISE);
		memberEnterprise.setRealnameLv(RealNameLvType.LV3.getCode());
		//memberDAO.update(memberEnterprise);
		memberInfoService.updateMemberInfo(memberEnterprise);
		//3.绑定对公账户
		QuickpayCustBean bean = new QuickpayCustBean();
		bean.setAccname(enterpriseRealnameApply.getAccName());
		bean.setCardno(enterpriseRealnameApply.getAccNum());
		bean.setCustomerno(enterpriseRealNameConfirmBean.getCoopInsti());
		bean.setBankcode(enterpriseRealnameApply.getBankNode());
		bean.setIdnum(enterpriseRealnameApply.getLicenceNo());//营业执照
		bean.setIdtype("08");//企业营业执照号
		bean.setPhone(memberEnterprise.getPhone());
		bean.setCardtype("5");//对公账户
		bean.setBankname(enterpriseRealnameApply.getBankName());
		bean.setRelatememberno(enterpriseRealnameApply.getMemberId());
		memberBankCardService.saveQuickPayCust(bean);
		//4重置支付密码
		MemberBean member = new MemberBean();
		member.setPhone(memberEnterprise.getPhone());
		member.setInstiId(memberEnterprise.getInstiId());
		memberOperationService.resetPayPwd(MemberType.ENTERPRISE, member, enterpriseRealNameConfirmBean.getPayPWD(), false);
	}

	/**
	 *
	 * @param enterpriseBankAccountBean
	 * @throws InvalidMemberDataException 
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Throwable.class)
	public void bindingBankAccount(EnterpriseBankAccountBean enterpriseBankAccountBean) throws InvalidMemberDataException {
		// TODO Auto-generated method stub
		
		//获取企业的详细信息
		PojoEnterpriseDeta enterpriseDeta = enterpriseDAO.getEnterpriseByMemberId(enterpriseBankAccountBean.getMemberId());
		if(enterpriseDeta.getRealnameLv()==RealNameLvType.LV1){//未实名认证
			throw new InvalidMemberDataException("企业会员未实名认证");
		}
		PojoEnterpriseRealnameApply enterpriseRealnameApply = new PojoEnterpriseRealnameApply();
		enterpriseRealnameApply.setMemberId(enterpriseBankAccountBean.getMemberId());
		enterpriseRealnameApply.setAccName(enterpriseBankAccountBean.getAccName());
		enterpriseRealnameApply.setAccNum(enterpriseBankAccountBean.getAccNum());
		enterpriseRealnameApply.setEnterpriseName(enterpriseDeta.getEnterpriseName());
		enterpriseRealnameApply.setLicenceNo(enterpriseDeta.getLicenceNo());
		enterpriseRealnameApply.setOrgCode(enterpriseDeta.getOrgCode());
		enterpriseRealnameApply.setTaxNo(enterpriseDeta.getTaxNo());
		enterpriseRealnameApply.setCorporation(enterpriseDeta.getCorporation());
		enterpriseRealnameApply.setCorpNo(enterpriseDeta.getCorpNo());
		enterpriseRealnameApply.setContact(enterpriseDeta.getContact());
		enterpriseRealnameApply.setContactsTelNo(enterpriseDeta.getContPhone());
		enterpriseRealnameApply.setInTime(new Date());
		enterpriseRealnameApply.setInUser(0L);
		enterpriseRealnameApply.setStatus("01");
		PojoBankInfo bankInfo = bankInfoDAO.getByBankNode(enterpriseBankAccountBean.getBankNode());
		enterpriseRealnameApply.setBankNode(enterpriseBankAccountBean.getBankNode());
		enterpriseRealnameApply.setBankCode(bankInfo.getBankCode());
		enterpriseRealnameApply.setBankName(bankInfo.getMainBankSname());
		enterpriseRealnameApply.setBusiType("02");//01 企业绑定银行账户
		enterpriseRealnameApplyService.saveEnterpriseRealnameApply(BeanCopyUtil.copyBean(EnterpriseRealNameBean.class, enterpriseRealnameApply));
	}
	
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Throwable.class)
	public void bindingBankAccountFinish(Long tid){
		EnterpriseRealNameBean enterpriseRealnameApply = enterpriseRealnameApplyService.get(tid);
		//获取企业的详细信息
		PojoEnterpriseDeta enterpriseDeta = enterpriseDAO.getEnterpriseByMemberId(enterpriseRealnameApply.getMemberId());
		QuickpayCustBean bean = new QuickpayCustBean();
		bean.setAccname(enterpriseRealnameApply.getAccName());
		bean.setCardno(enterpriseRealnameApply.getAccNum());
		CoopInsti coopInsti = coopInstiService.getInstiByInstiID(enterpriseDeta.getCoopInstiId());
		bean.setCustomerno(coopInsti.getInstiCode());
		bean.setBankcode(enterpriseRealnameApply.getBankNode());
		bean.setIdnum(enterpriseRealnameApply.getLicenceNo());//营业执照
		bean.setIdtype("08");//企业营业执照号
		bean.setPhone(enterpriseDeta.getPhone());
		bean.setCardtype("5");//对公账户
		bean.setBankname(enterpriseRealnameApply.getBankName());
		bean.setRelatememberno(enterpriseRealnameApply.getMemberId());
		memberBankCardService.saveQuickPayCust(bean);
	}
	
	
	
	
}
