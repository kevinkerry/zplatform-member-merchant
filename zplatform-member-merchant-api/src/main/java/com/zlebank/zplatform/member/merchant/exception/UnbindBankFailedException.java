/* 
 * UnbindBankFailedException.java  
 * 
 * version TODO
 *
 * 2016年1月18日 
 * 
 * Copyright (c) 2016,zlebank.All rights reserved.
 * 
 */
package com.zlebank.zplatform.member.merchant.exception;

/**
 * Class Description
 *
 * @author Luxiaoshuai
 * @version
 * @date 2016年1月18日 下午7:31:50
 * @since 
 */
public class UnbindBankFailedException  extends AbstractMemberDescException  {
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -999540096602965636L;
    public UnbindBankFailedException(Object ... para ) {
        this.params = para;
    }
    /**
     *
     * @return
     */
    @Override
    public String getCode() {
        return "EMSIF0007";
    }
	/**
	 * 
	 */
	public UnbindBankFailedException() {
		super();
		// TODO Auto-generated constructor stub
	}

}
