package com.miaodi.api.common;



import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class NetUtils {
    //Increase max total connection
    private static final int DEFAULT_MAX_TOTAL_CONNECTIONS = 200;

    //Increase default max connection per route
    private static final int DEFAULT_MAX_CONNECTIONS_PER_ROUTE = 20;

    private static final CloseableHttpClient client ;

    static {
        client = HttpClientBuilder.create()
                .setMaxConnTotal(DEFAULT_MAX_TOTAL_CONNECTIONS)
                .setMaxConnPerRoute(DEFAULT_MAX_CONNECTIONS_PER_ROUTE)
                .build();
    }

    public static String getReq(String url) throws URISyntaxException, IOException {
        HttpResponse response = client.execute(new HttpGet(url));
        return EntityUtils.toString(response.getEntity(), "UTF-8");
    }

    public static String postReq(String url,Map<String, String> params) throws IOException {
        HttpPost post = new HttpPost(url);
        post.setEntity(new UrlEncodedFormEntity(NetUtils.mapToNVPairList(params), "UTF-8"));
        return EntityUtils.toString(client.execute(post).getEntity(), "UTF-8");
    }

    /**
     * Map转换成List<NameValuePair>
     * @param map
     * @return
     */
    public static List<NameValuePair> mapToNVPairList(Map<String, String> map){
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        Set<String> keySet = map.keySet();
        for(String key : keySet){
            params.add(new BasicNameValuePair(key, map.get(key)));
        }

        return params;
    }

    public static void main(String[] args) throws Exception{
        //System.out.println(NetUtils.getReq("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wxc27b20411d46b8de&secret=73fb4ae352d9e86c2015f57350043ddc"));
    }
}
