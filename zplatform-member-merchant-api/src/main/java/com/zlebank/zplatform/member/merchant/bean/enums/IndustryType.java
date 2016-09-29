/* 
 * IndustryType.java  
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
 * 所属行业: 0餐饮1酒店连锁2其他3大型商场连锁4娱乐5金融6物流
 *
 * @author Luxiaoshuai
 * @version
 * @date 2015年9月9日 下午9:52:24
 * @since 
 */
public enum IndustryType {
    /**餐饮**/
	FOOD (0,"7011"),
    /**酒店连锁**/
	HOTEL (1,"7011"),
    /**其他**/
    OTHER (2,"5611"),
    /**大型商场连锁**/
    MALL(3,"9703"),
    /**娱乐**/
    PLAY (4,"7011"),
    /**金融**/
    FINANCE (5,"5611"),
    /**物流**/
    LOGISTICS(6,"5541"),
    /**未知状态**/
    UNKNOW(9,"9999");

 private Integer code;
 private String mcc;
    
    private IndustryType(Integer code,String mcc){
        this.code = code;
        this.mcc = mcc;
    }
    
    public static IndustryType fromValue(Integer value) {
        for(IndustryType status:values()){
            if(status.code == value){
                return status;
            }
        }
        return UNKNOW;
    }
    
    public Integer getCode(){
        return code;
    }
    
    public String getMcc(){
    	return mcc;
    }
}
