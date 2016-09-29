/* 
 * CardType.java  
 * 
 * version TODO
 *
 * 2015年9月17日 
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
 * @date 2015年9月17日 下午4:28:03
 * @since 
 */
public enum CardType {
    /**身份证*/
    SFZ("0"),
    /**护照/户口本**/
    HZ_HKB("1"),
    /**士兵证/军官证**/
    SBZ_JGZ("2"),
    /**未知状态**/
    UNKNOW("9");

 private String code;
    
    private CardType(String code){
        this.code = code;
    }
    
    public static CardType fromValue(String value) {
        for(CardType status:values()){
            if(status.code.equals(value)){
                return status;
            }
        }
        return UNKNOW;
    }

    public String getCode(){
        return code;
    }
}
