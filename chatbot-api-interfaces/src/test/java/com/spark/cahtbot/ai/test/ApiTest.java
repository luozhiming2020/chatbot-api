package com.spark.cahtbot.ai.test;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

public class ApiTest {

    @Test
    public void query_unanswer_question() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/28885518425541/topics?scope=all&count=20");
        get.addHeader("cookie","zsxqsessionid=b90033c2fc0722c33498a6c2bea61a5b; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22215542254551141%22%2C%22first_id%22%3A%2218e04abba0beeb-00a697d81b880ab-4c657b58-2073600-18e04abba0ceaf%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThlMDRhYmJhMGJlZWItMDBhNjk3ZDgxYjg4MGFiLTRjNjU3YjU4LTIwNzM2MDAtMThlMDRhYmJhMGNlYWYiLCIkaWRlbnRpdHlfbG9naW5faWQiOiIyMTU1NDIyNTQ1NTExNDEifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22215542254551141%22%7D%2C%22%24device_id%22%3A%2218e04abba0beeb-00a697d81b880ab-4c657b58-2073600-18e04abba0ceaf%22%7D; zsxq_access_token=BCDD5437-425E-8A6D-12AB-3247CECD9339_B327B7F8F69DE2A6; abtest_env=product");
        get.addHeader("Content-Type", "application/json; charset=UTF-8");
        CloseableHttpResponse response = httpClient.execute(get);
        if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void comment() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/8855484244521242/comments");
        post.addHeader("cookie", "zsxqsessionid=b90033c2fc0722c33498a6c2bea61a5b; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22215542254551141%22%2C%22first_id%22%3A%2218e04abba0beeb-00a697d81b880ab-4c657b58-2073600-18e04abba0ceaf%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThlMDRhYmJhMGJlZWItMDBhNjk3ZDgxYjg4MGFiLTRjNjU3YjU4LTIwNzM2MDAtMThlMDRhYmJhMGNlYWYiLCIkaWRlbnRpdHlfbG9naW5faWQiOiIyMTU1NDIyNTQ1NTExNDEifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22215542254551141%22%7D%2C%22%24device_id%22%3A%2218e04abba0beeb-00a697d81b880ab-4c657b58-2073600-18e04abba0ceaf%22%7D; zsxq_access_token=BCDD5437-425E-8A6D-12AB-3247CECD9339_B327B7F8F69DE2A6; abtest_env=product");
        post.addHeader("Content-Type", "application/json;charset=utf8");

        String paramJson = "{\"req_data\":{\"text\":\"我也不会!\\n\",\"image_ids\":[],\"mentioned_user_ids\":[]}}";

        StringEntity stringEntity = new StringEntity(paramJson,  ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);
        CloseableHttpResponse response = httpClient.execute(post);
        if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }
}
