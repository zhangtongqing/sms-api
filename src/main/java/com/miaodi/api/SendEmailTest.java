package com.miaodi.api;


import com.miaodi.api.Util.DateUtil;
import com.miaodi.api.miaodiyun.httpApiDemo.common.HttpUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.*;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by Useradmin on 2016/8/11.
 */
public class SendEmailTest {

    @org.junit.Test
    public void sendEmail(){
        // 排序加密
        String password = "9ba9666b-3dd1-45d5-8ef5-9df5678b672f";
        String username = "553137c5-d0ee-4e24-bc38-3db42df3e833";
        String content = "你好彩讯！";
        String to  = "15013744700"+"@139.com";
        String receiverName = "徐伟";
        String timestamp = DateUtil.formateGeneral(DateUtil.changTime(new Date(), 60, Calendar.SECOND));
        String title = "恭喜发财！";
        String usernumber = "18126160895";

        String signCode = DigestUtils.md5Hex("app_key" + "caixun_139" + "app_secret"
                + password + "content" + content + "receiver_mail" + to + "receiver_name"
                + receiverName + "request_method" + "sendmail" + "return_format" + "xml" + "sendsmspriority"
                + "0" + "spnumber" + "1065813911111" + "templateId" + "1000257" + "timestamp" + timestamp
                + "title" + title + "username" + username + "usernumber" + usernumber + "version" + "1.0")
                .toUpperCase();


       // String url ="http://121.15.167.240:19090/openAPI/mailservice"; //开发环境
        String url ="http://221.176.9.93:7722/mailnotifythree/qmySmsStatusQuery"; //现网环境

        StringBuilder body = new StringBuilder();
        body.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        body.append("<sendmail>");
        body.append("<request_method>").append("sendmail").append("</request_method>");
        body.append("<timestamp>").append(timestamp).append("</timestamp>");
        body.append("<return_format>").append("xml").append("</return_format>");
        body.append("<app_key>").append(username).append("</app_key>");
        body.append("<app_secret>").append(password).append("</app_secret>");
        body.append("<version>").append("1.0").append("</version>");
        body.append("<sign_code>").append(signCode).append("</sign_code>");
        body.append("<sign_method>").append("md5").append("</sign_method>");

        body.append("<usernumber>").append(usernumber).append("</usernumber>");// 发送邮箱就是usernumber对应的139邮箱，可以填别名
        body.append("<receiver_mail>").append(to).append("</receiver_mail>");
        body.append("<receiver_name>").append(receiverName).append("</receiver_name>");// base64，没有可不填
        body.append("<username>").append(username).append("</username>");// base64
        body.append("<title>").append(title).append("</title>");// base64
        body.append("<content>").append(content).append("</content>");// base64
        body.append("<sendsmspriority>").append("1").append("</sendsmspriority>");
        body.append("<spnumber>").append("1065813911111").append("</spnumber>");
        body.append("<templateId>").append("1000257").append("</templateId>");
        body.append("</sendmail>");

        HashMap<String, String> header = new HashMap<String, String>();
        header.put("Content-Type", "text/xml;charset=UTF-8");
        try {
            System.out.println("发送邮件xml:"+body.toString());
            String rs = HttpUtil.postWithHeaders(url, body.toString(), header);// 要头部才行
            System.out.println("发送邮件返回结果："+rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
