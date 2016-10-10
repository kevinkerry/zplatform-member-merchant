/* 
 * MerchMKServiceImpl.java  
 * 
 * version 1.0
 *
 * 2015年9月17日 
 * 
 * Copyright (c) 2015,zlebank.All rights reserved.
 * 
 */
package com.zlebank.zplatform.member.merchant.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zlebank.zplatform.member.commons.utils.BeanCopyUtil;
import com.zlebank.zplatform.member.commons.utils.RSAUtils;
import com.zlebank.zplatform.member.merchant.bean.MerchMK;
import com.zlebank.zplatform.member.merchant.dao.MerchMKDAO;
import com.zlebank.zplatform.member.merchant.pojo.PojoMerchMK;
import com.zlebank.zplatform.member.merchant.service.MerchMKService;

/**
 * Class Description
 *
 * @author yangying
 * @version
 * @date 2015年9月17日 上午9:42:03
 * @since
 */
@Service("merchMKService")
public class MerchMKServiceImpl implements MerchMKService {
    private final static Log log = LogFactory.getLog(MerchMKService.class);
    @Autowired
    private MerchMKDAO merchMKDAOImpl;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public MerchMK get(String memberId) {
        PojoMerchMK pojoMerchMK = merchMKDAOImpl.get(memberId);
        MerchMK merchMK = null;
        if (pojoMerchMK != null) {
            merchMK = BeanCopyUtil.copyBean(MerchMK.class, pojoMerchMK);
        }

        return merchMK;
    }

    /**
     * 根据memberId进行验签【使用商户公钥】
     * @param memberId 会员号【T_MERCH_MK】
     * @param signedData 被加签的数据
     * @param originData 原数据
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean verify(String memberId, String signedData, String originData) {
        MerchMK merchMK = get(memberId);
        if (merchMK == null) {
            log.error("校验加签数据错误，此商户的秘钥对不存在。");
            return false;
        }

        if (log.isDebugEnabled()) {
            log.info("原数据=" + originData + ", 被加签的数据=" + signedData);
        }
        boolean isOK = false;

        try { 
            isOK = RSAUtils.verify(originData.getBytes("UTF-8"), merchMK.getMemberPubKey().trim(), signedData);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        if (!isOK) 
            return false;
        return true;
    }
    /**
     * 根据memberId进行加签【使用平台私钥】
     * @param memberId 会员号【T_MERCH_MK】
     * @param originData 原数据
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public String sign(String memberId, String originData) {
        MerchMK merchMK = get(memberId);
        if (merchMK == null) {
            log.error("校验加签数据错误，此商户的秘钥对不存在。");
            return null;
        }
        if (log.isDebugEnabled()) {
            log.info("原数据= " + originData);
        }
        try {
            return RSAUtils.sign(originData.getBytes(), merchMK.getLocalPriKey().trim());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor=Throwable.class)
    public void updateMerchMK(MerchMK merchMK){
    	PojoMerchMK pojoMerchMK = null;
    	if (merchMK != null) {
    		pojoMerchMK = BeanCopyUtil.copyBean(PojoMerchMK.class, merchMK);
        }
    	merchMKDAOImpl.update(pojoMerchMK);
    	
    }
}
