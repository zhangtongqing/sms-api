package com.miaodi.api.miaodiyun.httpApiDemo.common;

/**
 * 系统常量
 */
public class Config
{
	/**
	 * url前半部分
	 * 开发者注册后系统自动生成的账号，可在官网登录后查看
	 * 开发者注册后系统自动生成的TOKEN，可在官网登录后查看
	 * 响应数据类型, JSON或XML
	 */
	//线上
//	public static final String BASE_URL = "https://api.miaodiyun.com/20150822";
//	public static final String ACCOUNT_SID = "00fb6959fe95475f8a9b4ec8c13a2d81";
//	public static final String AUTH_TOKEN = "9431a041fd9d478598b2a6cd315bf688";
//	public static final String RESP_DATA_TYPE = "json";
	//本地模式
	public static final String BASE_URL = "http://127.0.0.1:8079/20150822";
	public static final String ACCOUNT_SID = "db6526e7382049b893119a0535b218b4";
	public static final String AUTH_TOKEN = "abc2c9bbac5b4442b386b5f756437bce";
	public static final String RESP_DATA_TYPE = "json";

	//测试环境
//	public static final String BASE_URL = "http://113.31.65.254:8080/distributor/20150822";
//	public static final String ACCOUNT_SID = "5d589cd2a88c45f99f0c6c87f3d98e34";
//	public static final String AUTH_TOKEN = "154febf9f49946a2a44077c5f0ac8708";
//	public static final String RESP_DATA_TYPE = "json";

}