/* 
 * DefaultPageResult.java  
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
 * Default paged query result.
 *
 * @author yangying
 * @version
 * @date 2015-6-25 下午04:41:13
 * @since
 */
public class DefaultPageResult<T> implements PagedResult<T>,Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4555056705299478877L;
	private List<T> result;
	private long total;

	public DefaultPageResult(List<T> result, long total) {
		this.result = result;
		this.total = total;
	}

	/**
	 *
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */ 
	@Override
	public List<T> getPagedResult() throws IllegalAccessException {
		return result;
	}

	/**
	 *
	 * @return
	 */
	@Override
	public long getTotal() {
		return total;
	}

}
