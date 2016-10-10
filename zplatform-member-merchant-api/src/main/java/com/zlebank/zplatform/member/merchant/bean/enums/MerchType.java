/* 
 * MerchType.java  
 * 
 * version TODO
 *
 * 2015年9月9日 
 * 
 * Copyright (c) 2015,zlebank.All rights reserved.
 * 
 */
package com.zlebank.zplatform.member.merchant.bean.enums;

/**
 * Class Description
 *
 * @author Luxiaoshuai
 * @version
 * @date 2015年9月9日 下午9:44:54
 * @since 
 */
public enum MerchType {
    /**0代理商**/
    AGENCY(0),
    /**1普通商户**/
    NORMAL_MERCHANT(1),
    /**未知状态**/
    UNKNOW(0);

 private Integer code;
    
    private MerchType(Integer code){
        this.code = code;
    }
    
    public static MerchType fromValue(Integer value) {
        for(MerchType status:values()){
            if(status.code.equals(value)){
                return status;
            }
        }
        return UNKNOW;
    }
    public Integer getCode(){
        return code;
    }
}
