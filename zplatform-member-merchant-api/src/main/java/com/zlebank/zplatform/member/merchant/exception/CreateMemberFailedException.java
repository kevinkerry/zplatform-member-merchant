/* 
 * CreateMemberFailException.java  
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
 * 注册会员时发生错误
 *
 * @author Luxiaoshuai
 * @version
 * @date 2016年1月15日 下午4:56:53
 * @since 
 */
public class CreateMemberFailedException  extends AbstractMemberDescException  {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -999540096602965636L;
    public CreateMemberFailedException(Object ... para ) {
        this.params = para;
    }
    /**
     *
     * @return
     */
    @Override
    public String getCode() {
        return "EMSIF0002";
    }
	/**
	 * 
	 */
	public CreateMemberFailedException() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
