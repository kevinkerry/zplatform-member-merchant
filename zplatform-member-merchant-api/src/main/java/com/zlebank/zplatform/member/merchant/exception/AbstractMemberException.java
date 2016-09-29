/* 
 * MemberException.java  
 * 
 * version TODO
 *
 * 2015年9月10日 
 * 
 * Copyright (c) 2015,zlebank.All rights reserved.
 * 
 */
package com.zlebank.zplatform.member.merchant.exception;

import java.util.ResourceBundle;

/**
 * Class Description
 *
 * @author yangpeng
 * @version
 * @date 2015年9月10日 下午6:58:25
 * @since 
 */
public abstract class AbstractMemberException extends AbstractDescribeException{

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 4901729172010673980L;
    
    private static final  ResourceBundle RESOURCE = ResourceBundle.getBundle("exception_des");
	@Override
	public ResourceBundle getResourceBundle() {
		return RESOURCE;
	}
}
