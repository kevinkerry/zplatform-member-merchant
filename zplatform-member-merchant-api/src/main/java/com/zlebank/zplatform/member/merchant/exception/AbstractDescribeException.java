/* 
 * AbstractDescribeException.java  
 * 
 * version 1.0
 *
 * 2015年8月31日 
 * 
 * Copyright (c) 2015,zlebank.All rights reserved.
 * 
 */
package com.zlebank.zplatform.member.merchant.exception;

import java.util.ResourceBundle;

/**
 * <p>
 * code rule description: </br></br>
 * <table border="1">
 * <tr>
 * <td>field</td>
 * <td>type</td>
 * <td>description</td>
 * <td>value</td>
 * </tr>
 * <tr>
 * <td>exception</td>
 * <td>a1</td>
 * <td>exception</td>
 * <td>"E"</td>
 * </tr>
 * <tr>
 * <td>subSystem</td>
 * <td>an2</td>
 * <td>MS-member system,AS-account system,TS-trade system,SS-specification system and so on</td>
 * <td>MS|AS|TS|SS</td>
 * </tr>
 * <tr>
 * <td>module</td>
 * <td>an2</td>
 * <td>specify in different subSystem</td>
 * <td>specify in different subSystem</td>
 * </tr>
 * <tr>
 * <td>serial number</td>
 * <td>n4</td>
 * <td>serial number</td>
 * <td>serial number</td>
 * </tr>
 * </table>
 * </p>
 *
 * @author yangying
 * @version
 * @date 2015年8月31日 下午12:12:56
 * @since
 */
public abstract class AbstractDescribeException extends BaseException {
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 4880611538778827974L;
    
    @Override
    public String getMessage() {
        String message = getResourceBundle().getString(getCode());
        return String.format(message, getParams());
    }
    
    public abstract ResourceBundle getResourceBundle();
    
    public abstract String getCode();
    
    public AbstractDescribeException() {
        super();
    }
    
    public AbstractDescribeException(Throwable cause) {
        super(cause);
    }
}
