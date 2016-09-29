/* 
 * MemberBussinessException.java  
 * 
 * version TODO
 *
 * 2015年9月10日 
 * 
 * Copyright (c) 2015,zlebank.All rights reserved.
 * 
 */
package com.zlebank.zplatform.member.merchant.exception;


/**
 * Class Description
 *
 * @author yangpeng
 * @version
 * @date 2015年9月10日 下午7:30:30
 * @since 
 */
public class MemberBussinessException extends AbstractMemberException{


    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -8982263131254694025L;
    private String code;
    public MemberBussinessException(String code,Object ...param) {
        this.code=code;
        this.setParams(param);
    }
    public  MemberBussinessException(String code) {
        this.code=code;
    }
    /**
     *
     * @return
     */
    @Override
    public String getCode() {
        return code;
    }
	/**
	 * 
	 */
	public MemberBussinessException() {
		super();
		// TODO Auto-generated constructor stub
	}

}
