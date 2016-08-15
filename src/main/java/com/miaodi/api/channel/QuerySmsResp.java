package com.miaodi.api.channel;

import java.util.List;


/**
 * 公用的状态查询返回
 * @author weinianjie
 * @date   2015年11月5日
 */
public class QuerySmsResp
{
	private List<QuerySmsData> list;

	public List<QuerySmsData> getList()
	{
		return list;
	}

	public void setList(List<QuerySmsData> list)
	{
		this.list = list;
	}
}
