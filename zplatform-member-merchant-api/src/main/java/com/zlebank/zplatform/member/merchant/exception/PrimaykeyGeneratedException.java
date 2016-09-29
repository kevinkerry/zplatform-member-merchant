package com.zlebank.zplatform.member.merchant.exception;

import java.util.ResourceBundle;

public class PrimaykeyGeneratedException extends AbstractDescribeException{

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1646466665156451742L;
    
    private static final  ResourceBundle RESOURCE = ResourceBundle.getBundle("exception_des");
	@Override
	public ResourceBundle getResourceBundle() {
		return RESOURCE;
	}
    
    @Override
    public String getCode() {
        return "EMS021001";
    }

	/**
	 * 
	 */
	public PrimaykeyGeneratedException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public PrimaykeyGeneratedException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
