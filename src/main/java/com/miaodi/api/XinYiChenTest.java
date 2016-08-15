package com.miaodi.api;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.google.gson.Gson;
import com.miaodi.api.Util.PhoneUtil;
import com.miaodi.api.Util.StringUtil;
import com.miaodi.api.channel.SmsSendResult;
import com.miaodi.api.common.MD5Util;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.URI;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.fluent.Request;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Useradmin on 2016/8/3.
 */
public class XinYiChenTest {
    /**
     * 发送短信
     */
    @Test
    public void send(){
        XmlMapper xmlMapper = new XmlMapper();
        List<NameValuePair> paramList = new ArrayList<NameValuePair>();
        paramList.add(new BasicNameValuePair("enterpriseID", "16899"));
        paramList.add(new BasicNameValuePair("loginName", "admin"));
        //密码采用32位小写MD5加密.
        paramList.add(new BasicNameValuePair("password", MD5Util.encodeByMD5("1188zxc")));
        paramList.add(new BasicNameValuePair("content", "【水滴平台】您的验证码为322658，请于5分钟内使用。如非您操作，请忽略。"));
        paramList.add(new BasicNameValuePair("mobiles", "18126160895"));


        try {
            //String statusUrl = "http://121.201.38.146/getSmsReport.action";
            String sendUrl = "http://121.201.38.146/sendSMS.action";
            //String moUrl = "http://121.201.38.146/getSmsMo.action";
            String requestResult = Request.Post(sendUrl).body(new UrlEncodedFormEntity(paramList, "UTF-8")).execute().returnContent().asString(Charset.forName("UTF-8"));
            System.out.println(new Gson().toJson(xmlMapper.readValue(requestResult, Response.class)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @JacksonXmlRootElement(localName = "Response")
    static class Response {
        @JacksonXmlProperty(localName = "Result")
        private String result;
        @JacksonXmlProperty(localName = "SmsId")
        private String SmsId;
        @JacksonXmlProperty(localName = "Report")
        private List<StatusItem> Report;
        @JacksonXmlProperty(localName = "Mo")
        private List<MoItem> mo;

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }

        public String getSmsId() {
            return SmsId;
        }

        public void setSmsId(String smsId) {
            SmsId = smsId;
        }

        public List<StatusItem> getReport() {
            return Report;
        }

        public void setReport(List<StatusItem> report) {
            Report = report;
        }


        public List<MoItem> getMo() {
            return mo;
        }

        public void setMo(List<MoItem> mo) {
            this.mo = mo;
        }
    }

    static class MoItem {
        private String id;
        private String content;
        private String from_mobile;
        private String to_port;
        private String rec_time;

        public String getFrom_mobile() {
            return from_mobile;
        }

        public void setFrom_mobile(String from_mobile) {
            this.from_mobile = from_mobile;
        }

        public String getTo_port() {
            return to_port;
        }

        public void setTo_port(String to_port) {
            this.to_port = to_port;
        }

        public String getRec_time() {
            return rec_time;
        }

        public void setRec_time(String rec_time) {
            this.rec_time = rec_time;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }

    static class StatusItem {
        private String smsId;
        private String to_mobile;
        private String status;
        private String reportTime;
        private String desc;

        public String getSmsId() {
            return smsId;
        }

        public void setSmsId(String smsId) {
            this.smsId = smsId;
        }

        public String getTo_mobile() {
            return to_mobile;
        }

        public void setTo_mobile(String to_mobile) {
            this.to_mobile = to_mobile;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getReportTime() {
            return reportTime;
        }

        public void setReportTime(String reportTime) {
            this.reportTime = reportTime;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }

    /**
     * Created by Useradmin on 2016/8/3.
     */
    public static class YiLuAnTest {
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

        @Test
        public void handlerStatus() {
            HttpClient client = new HttpClient();
            PostMethod method = new PostMethod();
            String requestResult = "";
            String url = "http://127.0.0.1:8089/mqConsumer/inner/smsStatusExplain";
            try {
                URI base = new URI(url, false);
                method.setURI(new URI(base, "HttpSendSM", false));
                method.setQueryString(
                        new org.apache.commons.httpclient.NameValuePair[]{
                                new org.apache.commons.httpclient.NameValuePair("reportXml", "")
                        });
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
                    log.info(" result: " + requestResult);
                }
            } catch (Exception e) {
                log.error("失败", e);
            } finally {
                method.releaseConnection();
            }

        }
    }
}
