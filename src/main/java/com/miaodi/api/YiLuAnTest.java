package com.miaodi.api;

import com.miaodi.api.Util.PhoneUtil;
import com.miaodi.api.Util.StringUtil;
import com.miaodi.api.channel.SmsSendResult;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.URI;
import org.apache.commons.httpclient.methods.GetMethod;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Useradmin on 2016/8/3.
 */
public class YiLuAnTest {
    private static final Logger log = LoggerFactory.getLogger(YiLuAnTest.class);

    @Test
    public void send() {
        HttpClient client = new HttpClient();
        GetMethod method = new GetMethod();
        String requestResult = "";
        String url = "http://120.26.65.9/msg/index.jsp";
        String phone = "18126160895";
        String msg = "hello word秒嘀科技-研发部";
        String account = "PPG-qmy730052";
        String password = "Qdiew82da";
        boolean needstatus = true;// 是否需要状态报告，需要true，不需要false
        SmsSendResult result = new SmsSendResult();
        try {
            URI base = new URI(url, false);
            method.setURI(new URI(base, "HttpSendSM", false));
            //针对移动号码做特殊处理
            boolean isYidong = PhoneUtil.isYiDong(phone);
            if (isYidong) {//去掉用户自定义的签名
                if (!StringUtil.empty(msg) && msg.indexOf("【") != -1 && msg.indexOf("】") != -1) {
                    Pattern p = Pattern.compile("【[^】]*】");
                    Matcher m = p.matcher(msg);
                    if (m.find()) {
                        msg = m.replaceFirst("");
                    }
                }
            }
            log.info("sendYiluanNew:  account is {}，password is {}, phone is {},msg is {}", account, password, phone);
            method.setQueryString(new org.apache.commons.httpclient.NameValuePair[]{new org.apache.commons.httpclient.NameValuePair("account", account),
                    new org.apache.commons.httpclient.NameValuePair("pswd", password), new org.apache.commons.httpclient.NameValuePair("mobile", phone),
                    new org.apache.commons.httpclient.NameValuePair("needstatus", String.valueOf(needstatus)), new org.apache.commons.httpclient.NameValuePair("msg", msg)});
            //					new NameValuePair("product", product) });
            int resultCode = client.executeMethod(method);
            if (resultCode == 200) {
                InputStream in = method.getResponseBodyAsStream();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int len = 0;
                while ((len = in.read(buffer)) != -1) {
                    baos.write(buffer, 0, len);
                }
                requestResult = URLDecoder.decode(baos.toString(), "UTF-8");
                log.info("sendYiluanNew result: " + requestResult);
            }
        } catch (Exception e) {
            log.error("sendYiluanNew 发短信给" + phone + "失败", e);
        } finally {
            method.releaseConnection();
        }
    }
}

