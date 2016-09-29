/* 
 * LoginFailedException.java  
 * 
 * version TODO
 *
 * 2016年1月15日 
 * 
 * Copyright (c) 2016,zlebank.All rights reserved.
 * 
 */
package com.zlebank.zplatform.member.merchant.exception;

/**
 * 登陆失败
 *
 * @author Luxiaoshuai
 * @version
 * @date 2016年1月15日 下午8:03:29
 * @since 
 */
public class LoginFailedException  extends AbstractMemberDescException  {
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -999540096602965636L;
    public LoginFailedException(Object ... para ) {
        this.params = para;
    }
    /**
     *
     * @return
     */
    @Override
    public String getCode() {
        return "EMSIF0005";
    }
	/**
	 * 
	 */
	public LoginFailedException() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}