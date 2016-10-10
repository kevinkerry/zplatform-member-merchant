/* 
 * EnterpriseRealnameApplyServiceImpl.java  
 * 
 * version TODO
 *
 * 2016年8月22日 
 * 
 * Copyright (c) 2016,zlebank.All rights reserved.
 * 
 */
package com.zlebank.zplatform.member.merchant.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zlebank.zplatform.member.commons.utils.BeanCopyUtil;
import com.zlebank.zplatform.member.merchant.bean.DefaultPageResult;
import com.zlebank.zplatform.member.merchant.bean.EnterpriseRealNameBean;
import com.zlebank.zplatform.member.merchant.bean.EnterpriseRealNameQueryBean;
import com.zlebank.zplatform.member.merchant.bean.PagedResult;
import com.zlebank.zplatform.member.merchant.dao.EnterpriseRealnameApplyDAO;
import com.zlebank.zplatform.member.merchant.pojo.PojoEnterpriseRealnameApply;
import com.zlebank.zplatform.member.merchant.service.EnterpriseRealnameApplyService;

/**
 * Class Description
 *
 * @author guojia
 * @version
 * @date 2016年8月22日 上午10:47:00
 * @since 
 */
@Service("enterpriseRealnameApplyService")
public class EnterpriseRealnameApplyServiceImpl implements EnterpriseRealnameApplyService{

	@Autowired
	private EnterpriseRealnameApplyDAO enterpriseRealnameApplyDAO;

	/**
	 *
	 * @param enterpriseRealnameApply
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Throwable.class)
	public void saveEnterpriseRealnameApply(
			EnterpriseRealNameBean enterpriseRealnameApply) {
		//PojoEnterpriseRealnameApply 
		PojoEnterpriseRealnameApply copyBean = BeanCopyUtil.copyBean(PojoEnterpriseRealnameApply.class, enterpriseRealnameApply);
		enterpriseRealnameApplyDAO.saveEntity(copyBean);
	}

	/**
	 *
	 * @param tn
	 * @return
	 */
	@Override
	@Transactional(readOnly=true)
	public EnterpriseRealNameBean getDetaByTN(String tn) {
		PojoEnterpriseRealnameApply enterpriseRealnameApply = enterpriseRealnameApplyDAO.getDetaByTN(tn);
		if(enterpriseRealnameApply!=null){
			return BeanCopyUtil.copyBean(EnterpriseRealNameBean.class, enterpriseRealnameApply);
		}
		return null;
	}

	/**
	 *
	 * @param enterpriseRealnameApply
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Throwable.class)
	public void updateApplyStatus(
			EnterpriseRealNameBean enterpriseRealnameApply) {
		// TODO Auto-generated method stub
		enterpriseRealnameApplyDAO.update(BeanCopyUtil.copyBean(PojoEnterpriseRealnameApply.class,enterpriseRealnameApply));
	}

	/**
	 *
	 * @param tid
	 * @return
	 */
	@Override
	@Transactional(readOnly=true)
	public EnterpriseRealNameBean get(Long tid) {
		PojoEnterpriseRealnameApply enterpriseRealnameApply = enterpriseRealnameApplyDAO.getById(tid);
		if(enterpriseRealnameApply!=null){
			return BeanCopyUtil.copyBean(EnterpriseRealNameBean.class, enterpriseRealnameApply);
		}
		return null;
	}

    /**
     *
     * @param example
     * @return
     */
    private long getTotal(EnterpriseRealNameQueryBean example) {
        return enterpriseRealnameApplyDAO.count(example);
    }

    /**
     *
     * @param offset
     * @param pageSize
     * @param example
     * @return
     */
    private List<EnterpriseRealNameBean> getItem(int offset,
            int pageSize,
            EnterpriseRealNameQueryBean example) {
        List<PojoEnterpriseRealnameApply> pojoRealNames= enterpriseRealnameApplyDAO.getItem(offset,pageSize,example);
        List<EnterpriseRealNameBean> realNameBeans=new ArrayList<EnterpriseRealNameBean>();
        for (PojoEnterpriseRealnameApply pojoEnterpriseRealnameApply : pojoRealNames) {
            EnterpriseRealNameBean realnameBean=new EnterpriseRealNameBean();
            realnameBean=BeanCopyUtil.copyBean(EnterpriseRealNameBean.class, pojoEnterpriseRealnameApply);
            realNameBeans.add(realnameBean);
        }
        return realNameBeans;
    }

    /**
     *
     * @param page
     * @param pageSize
     * @param example
     * @return
     */
    @Transactional(propagation=Propagation.REQUIRED)
    @Override
    public PagedResult<EnterpriseRealNameBean> queryPaged(int page,
            int pageSize,
            EnterpriseRealNameQueryBean queryBean) {
        long total = getTotal(queryBean);

        page = currentPage(total, page, pageSize);
        int offset = (page - 1) * pageSize;
        List<EnterpriseRealNameBean> items = getItem(offset, pageSize, queryBean);

        return new DefaultPageResult<EnterpriseRealNameBean>(items, total);
    }
    
    private int currentPage(long total, int page, int pageSize) {
        long maxPage = (total % pageSize == 0) ? (total / pageSize) : (total
                / pageSize + 1);
        if (page > maxPage) {
            return Long.valueOf(maxPage).intValue();
        }
        return page;
    }
	
}
