package com.miaodi.api;

import com.miaodi.api.common.NetUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Useradmin on 2016/8/5.
 */
public class HandlerStatusTest {
    private static String resStatus = "http://127.0.0.1:8089/mqConsumer/inner/smsStatusExplain";
    @Test
    public void resStatus(){
        long timestamp = System.currentTimeMillis();
        String url = resStatus;
        String rs =null;
        Map<String, String> params = new HashMap<String, String>();
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<Report num=\"3\">\n" +
                "<Item smsId=\"127281470391366813\" to_mobile=\"18126160895\" status=\"3\" reportTime=\"2016-08-05 12:00:03\" desc=\"发送失败\"/>\n" +
                "</Report>\n";
        params.put("reportXml", xml);
        try{
            rs = NetUtils.postReq(url, params);

            System.out.println("服务器返回："+rs);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void Urls(){
        String url ="http://www.baidu.com&commahttp://www.qq.com";
        String[] urls = url.split("&comma");
        System.out.println(urls[1]);
    }
}
