/* 
 * InvalidMemberData.java  
 * 
 * version v1.2
 *
 * 2016年1月15日 
 * 
 * Copyright (c) 2016,zlebank.All rights reserved.
 * 
 */
package com.zlebank.zplatform.member.merchant.exception;

/**
 * 会员数据不合法
 *
 * @author Luxiaoshuai
 * @version
 * @date 2016年1月15日 下午3:18:01
 * @since 
 */
public class InvalidMemberDataException extends AbstractMemberDescException {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -999540096602965636L;
    public InvalidMemberDataException(Object ... para ) {
        this.params = para;
    }
    
    /**
	 * 
	 */
	public InvalidMemberDataException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
     *
     * @return
     */
    @Override
    public String getCode() {
        return "EMSIF0001";
    }
}
