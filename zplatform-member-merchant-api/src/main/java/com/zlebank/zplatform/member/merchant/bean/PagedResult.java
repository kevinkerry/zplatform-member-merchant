/* 
 * PageResult.java  
 * 
 * version TODO
 *
 * 2015-6-25 
 * 
 * Copyright (c) 2015,.All rights reserved.
 * 
 */
package com.zlebank.zplatform.member.merchant.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Represent paged query result.
 *
 * @author yangying
 * @version
 * @date 2015-6-25 下午04:37:33
 * @since 
 */
public interface PagedResult<T> extends Serializable {     
    long getTotal();
    List<T> getPagedResult() throws  IllegalAccessException;
}
