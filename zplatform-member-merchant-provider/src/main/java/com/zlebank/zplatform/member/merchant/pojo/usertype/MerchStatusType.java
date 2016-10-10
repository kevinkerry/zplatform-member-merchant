/* 
 * MemberStatusType.java  
 * 
 * version TODO
 *
 * 2015年9月9日 
 * 
 * Copyright (c) 2015,zlebank.All rights reserved.
 * 
 */
package com.zlebank.zplatform.member.merchant.pojo.usertype;

/**
 * Class Description
 *
 * @author Luxiaoshuai
 * @version
 * @date 2015年9月9日 下午12:20:09
 * @since 
 */
public enum MerchStatusType {
    /**正常**/
    NORMAL("00"),
    /**注册待初审**/
    ZCDCS("10"),
    /**注册初审未过**/
    ZCCSWG("11"),
    /**注册待复审**/
    ZCDFS("20"),
    /**注册复审未过**/
    ZCFSWG("21"),  
    /**变更待初审**/
    BGCFS("30"),  
    /**变更初审未过**/
    BGCSWG("31"),
    /**变更待复审**/
    BGDFS("40"), 
    /**变更复审未过**/
    BGFSWG("41"),
    /**注销复审未过**/
    ZXFSWG("61"),
    /**注销待复审**/
    ZXDFS("60"),
    /**注销初审未过**/
    ZXCSWG("51"),
    /**注销待初审**/
    ZXDCS("50"),
    /**未知状态**/
    UNKNOW("88");



 private String code;
    
    private MerchStatusType(String code){
        this.code = code;
    }
    
    public static MerchStatusType fromValue(String value) {
        for(MerchStatusType status:values()){
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
