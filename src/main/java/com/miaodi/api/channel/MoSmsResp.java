package com.miaodi.api.channel;

import java.util.List;


/**
 * 公用的上行返回值
 * @author weinianjie
 * @date   2015年11月5日
 */
public class MoSmsResp
{
	private List<MoSmsData> list;

	public List<MoSmsData> getList()
	{
		return list;
	}

	public void setList(List<MoSmsData> list)
	{
		this.list = list;
	}
}
