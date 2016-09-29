package com.zlebank.zplatform.member.merchant.exception;

import java.util.ResourceBundle;

public abstract class AbstractMemberDescException extends AbstractDescribeException{
	 
    /**
	 * 
	 */
	private static final long serialVersionUID = 8484664176033605192L;
	private static final  ResourceBundle RESOURCE = ResourceBundle.getBundle("member_exception_des");
	@Override
	public ResourceBundle getResourceBundle() {
		return RESOURCE;
	}
}
