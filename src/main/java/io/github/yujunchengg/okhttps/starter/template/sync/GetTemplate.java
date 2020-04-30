package io.github.yujunchengg.okhttps.starter.template.sync;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ejlchina.okhttps.HTTP;
import com.ejlchina.okhttps.internal.SyncHttpTask;
import com.google.common.base.Strings;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
@Component
@Slf4j
public class GetTemplate extends BaseTemplate {

    @Autowired
    private HTTP http;
    public String getText(String url){
        return getText(url,null);
    }
    public String getText(String url,Map<String,String> headers){
        return getText(url,headers,null,null);
    }
    public String getTextWithPathParam(String url,Map<String,String> headers,Map<String,?> pathParams){
        return getText(url,headers,pathParams,null);
    }
    public String getTextWithUrlParam(String url,Map<String,String> headers,Map<String,?> urlParams){
        return getText(url,headers,null,urlParams);
    }
    public String getText(String url,Map<String,String> headers,Map<String,?> pathParams,Map<String,?> urlParams){
        SyncHttpTask sync = getSyncHttpTask(url, headers, pathParams, urlParams);
        return null!=sync?responseText(sync.nothrow().get()):null;
    }
    public <T> T getBean(String url,Class<T> clazz){
        return getBean(url,clazz,null);
    }
    public <T> T getBean(String url,Class<T> clazz,Map<String,String> headers){
        return getBean(url,clazz,headers,null,null);
    }
    public <T> T getBeanWithPathParam(String url,Class<T> clazz,Map<String,String> headers,Map<String,?> pathParams){
        return getBean(url,clazz,headers,pathParams,null);
    }
    public <T> T getBeanWithUrlParam(String url,Class<T> clazz,Map<String,String> headers,Map<String,?> urlParams){
        return getBean(url,clazz,headers,null,urlParams);
    }
    public <T> T getBean(String url,Class<T> clazz,Map<String,String> headers,Map<String,?> pathParams,Map<String,?> urlParams){
        SyncHttpTask sync = getSyncHttpTask(url, headers, pathParams, urlParams);
        return null!=sync?responseBean(sync.nothrow().get(),clazz):null;
    }
    public <T> List<T> getList(String url, Class<T> clazz){
        return getList(url,clazz,null);
    }
    public <T> List<T> getList(String url,Class<T> clazz,Map<String,String> headers){
        return getList(url,clazz,headers,null,null);
    }
    public <T> List<T> getListWithPathParam(String url,Class<T> clazz,Map<String,String> headers,Map<String,?> pathParams){
        return getList(url,clazz,headers,pathParams,null);
    }
    public <T> List<T> getListWithUrlParam(String url,Class<T> clazz,Map<String,String> headers,Map<String,?> urlParams){
        return getList(url,clazz,headers,null,urlParams);
    }
    public <T> List<T> getList(String url,Class<T> clazz,Map<String,String> headers,Map<String,?> pathParams,Map<String,?> urlParams){
        SyncHttpTask sync = getSyncHttpTask(url, headers, pathParams, urlParams);
        return null!=sync?responseList(sync.nothrow().get(),clazz):null;
    }
    public byte[] getByte(String url){
        return getByte(url,null);
    }
    public byte[] getByte(String url,Map<String,String> headers){
        return getByte(url,headers,null,null);
    }
    public byte[] getByteWithPathParam(String url,Map<String,String> headers,Map<String,?> pathParams){
        return getByte(url,headers,pathParams,null);
    }
    public byte[] getByteWithUrlParam(String url,Map<String,String> headers,Map<String,?> urlParams){
        return getByte(url,headers,null,urlParams);
    }
    public byte[] getByte(String url,Map<String,String> headers,Map<String,?> pathParams,Map<String,?> urlParams){
        SyncHttpTask sync = getSyncHttpTask(url, headers, pathParams, urlParams);
        return null!=sync?responseByte(sync.nothrow().get()):null;
    }
    public InputStream getByteStream(String url){
        return getByteStream(url,null);
    }

    public InputStream getByteStream(String url,Map<String,String> headers){
        return getByteStream(url,headers,null,null);
    }
    public InputStream getByteStreamWithPathParam(String url,Map<String,String> headers,Map<String,?> pathParams){
        return getByteStream(url,headers,pathParams,null);
    }
    public InputStream getByteStreamWithUrlParam(String url,Map<String,String> headers,Map<String,?> urlParams){
        return getByteStream(url,headers,null,urlParams);
    }
    public InputStream getByteStream(String url,Map<String,String> headers,Map<String,?> pathParams,Map<String,?> urlParams){
        SyncHttpTask sync = getSyncHttpTask(url, headers, pathParams, urlParams);
        return null!=sync?responseByteStream(sync.nothrow().get()):null;
    }
    public JSONArray getJsonArray(String url){
        return getJsonArray(url,null);
    }
    public JSONArray getJsonArray(String url,Map<String,String> headers){
        return getJsonArray(url,headers,null);
    }
    public JSONArray getJsonArray(String url,Map<String,String> headers,Map<String,?> pathParams){
        return getJsonArray(url,headers,pathParams,null);
    }
    public JSONArray getJsonArray(String url,Map<String,String> headers,Map<String,?> pathParams,Map<String,?> urlParams){
        SyncHttpTask sync = getSyncHttpTask(url, headers, pathParams, urlParams);
        return null!=sync?responseJSONArray(sync.nothrow().get()):null;
    }
    public JSONObject getJsonObject(String url){
        return getJsonObject(url,null);
    }
    public JSONObject getJsonObject(String url,Map<String,String> headers){
        return getJsonObject(url,headers,null,null);
    }
    public JSONObject getJsonObjectWithPathParam(String url,Map<String,String> headers,Map<String,?> pathParams){
        return getJsonObject(url,headers,pathParams,null);
    }
    public JSONObject getJsonObjectWithUrlParam(String url,Map<String,String> headers,Map<String,?> urlParams){
        return getJsonObject(url,headers,null,urlParams);
    }
    public JSONObject getJsonObject(String url,Map<String,String> headers,Map<String,?> pathParams,Map<String,?> urlParams){
        SyncHttpTask sync = getSyncHttpTask(url, headers, pathParams, urlParams);
        return null!=sync?responseJSONObject(sync.nothrow().get()):null;
    }
    private SyncHttpTask getSyncHttpTask(String url, Map<String,String> headers, Map<String,?> pathParams, Map<String,?> urlParams) {
        if(Strings.isNullOrEmpty(url)){
            return null;
        }
        SyncHttpTask sync = http.sync(url);
        if(null!=headers && !headers.isEmpty()){
            sync.addHeader(headers);
        }
        if(null!=pathParams && !pathParams.isEmpty()){
            sync.addPathParam(pathParams);
        }
        if(null!=urlParams && !urlParams.isEmpty()){
            sync.addUrlParam(urlParams);
        }
        return sync;
    }
}
