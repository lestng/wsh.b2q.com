package com.b2q.wsh.PortPackag;


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpUtil {

    //连接池
    private static PoolingHttpClientConnectionManager connectionMgr;
    //超时时间
    private static final int MAX_TIMEOUT = 7000;

    private static RequestConfig requestConfig;

    private static HttpUtil httpUtil;

    private HttpUtil() {
    }

    public static HttpUtil getInstance() {
        if (null == httpUtil)
            httpUtil = new HttpUtil();
        return httpUtil;
    }

    static{
        //设置连接池
        connectionMgr = new PoolingHttpClientConnectionManager();
        //设置连接池大小
        connectionMgr.setMaxTotal(100);
        connectionMgr.setDefaultMaxPerRoute(connectionMgr.getMaxTotal());

        RequestConfig.Builder configBuilder = RequestConfig.custom();
        //设置连接超时
        configBuilder.setConnectTimeout(MAX_TIMEOUT);
        //设置读取超时
        configBuilder.setSocketTimeout(MAX_TIMEOUT);
        //设置从连接池获取连接实例的超时
        configBuilder.setConnectionRequestTimeout(MAX_TIMEOUT);

        requestConfig = configBuilder.build();

    }
    /**
     *   GET 请求       带输入参数
     * @param Url      请求host地址
     * @param params   参数
     * @return
     */
    public String httpGet(String Url,Map<String, Object>params)
    {
        //返回结果
        String result = null;
        //拼接url
        StringBuilder builder = new StringBuilder(Url);
        if (Url.contains("?")) {
            builder.append("&");
        }else{
            builder.append("?");
        }
        int i=0;
        for (String key : params.keySet()) {
            if (i != 0 ) {
                builder.append("&");
            }
            builder.append(key);
            builder.append("=");
            builder.append(params.get(key));

            i++;
        }
        String apiUrl = builder.toString();
        //创建client
        HttpClient client = HttpClients.createDefault();

        try {
            HttpGet get = new HttpGet(apiUrl);
            HttpResponse response = client.execute(get);
            //获取请求状态码
            int statusCode = response.getStatusLine().getStatusCode();
            System.out.println(statusCode);

            HttpEntity entity = response.getEntity();
            if (entity != null) {
                result = EntityUtils.toString(entity,"UTF-8");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.err.println("get请求");
        return result;
    }

    /**
     *  Post请求
     * @param url       请求url地址
     * @param map       参数
     * @param charset   编码格式
     * @return
     */
    public String doPost(String url, Map<String,String> map, String charset){
        CloseableHttpClient httpClient = null;
        HttpPost httpPost = null;
        String result = null;
        try{
            httpClient = HttpClients.createDefault();
            httpPost = new HttpPost(url);
            //设置参数
            List<NameValuePair> list = new ArrayList<NameValuePair>();
            Iterator iterator = map.entrySet().iterator();
            while(iterator.hasNext()){
                Map.Entry<String,String> elem = (Map.Entry<String, String>) iterator.next();
                list.add(new BasicNameValuePair(elem.getKey(),elem.getValue()));
            }
            if(list.size() > 0){
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,charset);
                httpPost.setEntity(entity);
            }
            HttpResponse response = httpClient.execute(httpPost);
            if(response != null){
                HttpEntity resEntity = response.getEntity();
                if(resEntity != null){
                    result = EntityUtils.toString(resEntity,charset);
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        System.out.println(unicodeToString(result));
        return unicodeToString(result);
    }
    public String unicodeToString(String str) {

        Pattern pattern = Pattern.compile("(\\\\u(\\p{XDigit}{4}))");
        Matcher matcher = pattern.matcher(str);
        char ch;
        while (matcher.find()) {
            //group 6728
            String group = matcher.group(2);
            //ch:'木' 26408
            ch = (char) Integer.parseInt(group, 16);
            //group1 \u6728
            String group1 = matcher.group(1);
            str = str.replace(group1, ch + "");
        }
        return str;
    }

}


