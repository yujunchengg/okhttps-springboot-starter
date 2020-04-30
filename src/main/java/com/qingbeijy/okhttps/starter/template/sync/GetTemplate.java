package com.qingbeijy.okhttps.starter.template.sync;

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
/**
 * okhttps封装的get请求模板
 */
@Component
@Slf4j
public class GetTemplate extends BaseTemplate {

    @Autowired
    private HTTP http;
    /**
     * 响应体为文本的请求
     * @param url
     * @return
     */
    public String getText(String url){
        return getText(url,null);
    }
    /**
     * 响应体为文本的请求
     * @param url                 请求url
     * @param headers             请求头参数map
     * @return
     */
    public String getText(String url,Map<String,String> headers){
        return getText(url,headers,null,null);
    }
    /**
     * 响应体为文本的请求,使用路径参数的场景
     * @param url                 请求url
     * @param headers             请求头参数map
     * @param pathParams          请求路径参数map
     * @return
     */
    public String getTextWithPathParam(String url,Map<String,String> headers,Map<String,?> pathParams){
        return getText(url,headers,pathParams,null);
    }

    /**
     * 响应体为文本的请求,使用url拼接查询条件的场景
     * @param url
     * @param headers
     * @param urlParams
     * @return
     */
    public String getTextWithUrlParam(String url,Map<String,String> headers,Map<String,?> urlParams){
        return getText(url,headers,null,urlParams);
    }
    /**
     * 响应体为文本的请求
     * @param url                请求url
     * @param headers            请求头参数map
     * @param pathParams         请求路径参数map
     * @param urlParams          请求url参数map
     * @return
     */
    public String getText(String url,Map<String,String> headers,Map<String,?> pathParams,Map<String,?> urlParams){
        SyncHttpTask sync = getSyncHttpTask(url, headers, pathParams, urlParams);
        return null!=sync?responseText(sync.nothrow().get()):null;
    }
    /**
     * 响应体为实体类的请求
     * @param url               请求url
     * @param clazz             响应实体类的Class类型
     * @return
     */
    public <T> T getBean(String url,Class<T> clazz){
        return getBean(url,clazz,null);
    }

    /**
     * 响应体为实体类的请求
     * @param url               请求url
     * @param clazz             响应实体类的Class类型
     * @param headers           请求头参数
     * @param <T>
     * @return
     */
    public <T> T getBean(String url,Class<T> clazz,Map<String,String> headers){
        return getBean(url,clazz,headers,null,null);
    }
    /**
     * 响应体为实体类的请求
     * @param url               请求url
     * @param clazz             响应实体类的Class类型
     * @param headers           请求头参数
     * @param pathParams       请求路径参数
     * @param <T>
     * @return
     */
    public <T> T getBeanWithPathParam(String url,Class<T> clazz,Map<String,String> headers,Map<String,?> pathParams){
        return getBean(url,clazz,headers,pathParams,null);
    }
    /**
     * 响应体为实体类的请求
     * @param url               请求url
     * @param clazz             响应实体类的Class类型
     * @param headers           请求头参数
     * @param urlParams        请求路径参数
     * @param <T>
     * @return
     */
    public <T> T getBeanWithUrlParam(String url,Class<T> clazz,Map<String,String> headers,Map<String,?> urlParams){
        return getBean(url,clazz,headers,null,urlParams);
    }

    /**
     * 响应体为实体类的请求
     * @param url                       请求url
     * @param clazz                     响应实体类的Class类型
     * @param headers                   请求头参数
     * @param pathParams                请求路径参数
     * @param urlParams                 请求url参数
     * @param <T>
     * @return
     */
    public <T> T getBean(String url,Class<T> clazz,Map<String,String> headers,Map<String,?> pathParams,Map<String,?> urlParams){
        SyncHttpTask sync = getSyncHttpTask(url, headers, pathParams, urlParams);
        return null!=sync?responseBean(sync.nothrow().get(),clazz):null;
    }
    /**
     * 响应体为List集合的请求
     * @param url                 请求url
     * @param clazz               响应体List集合中的对象的class的类型
     * @param <T>
     * @return
     */
    public <T> List<T> getList(String url, Class<T> clazz){
        return getList(url,clazz,null);
    }
    /**
     * 响应体为List集合的请求
     * @param url                      请求url
     * @param clazz                    响应体List集合中的对象的class的类型
     * @param headers                  请求头参数
     * @param <T>
     * @return
     */
    public <T> List<T> getList(String url,Class<T> clazz,Map<String,String> headers){
        return getList(url,clazz,headers,null,null);
    }
    /**
     * 响应体为List集合的请求
     * @param url                      请求url
     * @param clazz                    响应体List集合中的对象的class的类型
     * @param headers                  请求头参数
     * @param pathParams               请求路径参数
     * @param <T>
     * @return
     */
    public <T> List<T> getListWithPathParam(String url,Class<T> clazz,Map<String,String> headers,Map<String,?> pathParams){
        return getList(url,clazz,headers,pathParams,null);
    }

    /**
     * 响应体为List集合的请求
     * @param url                      请求url
     * @param clazz                    响应体List集合中的对象的class的类型
     * @param headers                  请求头参数
     * @param urlParams                请求url拼接的查询参数
     * @param <T>
     * @return
     */
    public <T> List<T> getListWithUrlParam(String url,Class<T> clazz,Map<String,String> headers,Map<String,?> urlParams){
        return getList(url,clazz,headers,null,urlParams);
    }
    /**
     * 响应体为List集合的请求
     * @param url                      请求url
     * @param clazz                    响应体List集合中的对象的class的类型
     * @param headers                  请求头参数
     * @param pathParams               请求路径参数
     * @param urlParams                请求url参数
     * @param <T>
     * @return
     */
    public <T> List<T> getList(String url,Class<T> clazz,Map<String,String> headers,Map<String,?> pathParams,Map<String,?> urlParams){
        SyncHttpTask sync = getSyncHttpTask(url, headers, pathParams, urlParams);
        return null!=sync?responseList(sync.nothrow().get(),clazz):null;
    }
    /**
     * 响应体为byte数组
     * @param url                   请求url
     * @return
     */
    public byte[] getByte(String url){
        return getByte(url,null);
    }
    /**
     * 响应体为byte数组
     * @param url                   请求url
     * @param headers               请求头参数
     * @return
     */
    public byte[] getByte(String url,Map<String,String> headers){
        return getByte(url,headers,null,null);
    }
    /**
     * 响应体为byte数组
     * @param url                   请求url
     * @param headers               请求头参数
     * @param pathParams            请求路径参数
     * @return
     */
    public byte[] getByteWithPathParam(String url,Map<String,String> headers,Map<String,?> pathParams){
        return getByte(url,headers,pathParams,null);
    }
    /**
     * 响应体为byte数组
     * @param url                    请求url
     * @param headers                请求头参数
     * @param urlParams              请求url参数
     * @return
     */
    public byte[] getByteWithUrlParam(String url,Map<String,String> headers,Map<String,?> urlParams){
        return getByte(url,headers,null,urlParams);
    }
    /**
     * 响应体为byte数组
     * @param url                   请求url
     * @param headers               请求头参数
     * @param pathParams            请求路径参数
     * @param urlParams             请求url参数
     * @return
     */
    public byte[] getByte(String url,Map<String,String> headers,Map<String,?> pathParams,Map<String,?> urlParams){
        SyncHttpTask sync = getSyncHttpTask(url, headers, pathParams, urlParams);
        return null!=sync?responseByte(sync.nothrow().get()):null;
    }
    /**
     * 响应体为InputStream
     * @param url                       请求url
     * @return
     */
    public InputStream getByteStream(String url){
        return getByteStream(url,null);
    }

    /**
     * 响应体为InputStream
     * @param url                        请求url
     * @param headers                    请求头参数
     * @return
     */
    public InputStream getByteStream(String url,Map<String,String> headers){
        return getByteStream(url,headers,null,null);
    }
    /**
     * 响应体为InputStream
     * @param url                        请求url
     * @param headers                    请求头参数
     * @param pathParams                 请求路径参数
     * @return
     */
    public InputStream getByteStreamWithPathParam(String url,Map<String,String> headers,Map<String,?> pathParams){
        return getByteStream(url,headers,pathParams,null);
    }

    /**
     * 响应体为InputStream
     * @param url                        请求url
     * @param headers                    请求头参数
     * @param urlParams                  请求url拼接参数
     * @return
     */
    public InputStream getByteStreamWithUrlParam(String url,Map<String,String> headers,Map<String,?> urlParams){
        return getByteStream(url,headers,null,urlParams);
    }
    /**
     * 响应体为InputStream
     * @param url                        请求url
     * @param headers                    请求头参数
     * @param pathParams                 请求路径参数
     * @param urlParams                  请求url参数
     * @return
     */
    public InputStream getByteStream(String url,Map<String,String> headers,Map<String,?> pathParams,Map<String,?> urlParams){
        SyncHttpTask sync = getSyncHttpTask(url, headers, pathParams, urlParams);
        return null!=sync?responseByteStream(sync.nothrow().get()):null;
    }
    /**
     * 响应体为JSONArray的请求
     * @param url                         请求url
     * @return
     */
    public JSONArray getJsonArray(String url){
        return getJsonArray(url,null);
    }
    /**
     * 响应体为JSONArray的请求
     * @param url                           请求url
     * @param headers                       请求头参数
     * @return
     */
    public JSONArray getJsonArray(String url,Map<String,String> headers){
        return getJsonArray(url,headers,null);
    }
    /**
     * 响应体为JSONArray的请求
     * @param url                           请求url
     * @param headers                       请求头参数
     * @param pathParams                    请求路径参数
     * @return
     */
    public JSONArray getJsonArray(String url,Map<String,String> headers,Map<String,?> pathParams){
        return getJsonArray(url,headers,pathParams,null);
    }
    /**
     * 响应体为JSONArray的请求
     * @param url                           请求url
     * @param headers                       请求头参数
     * @param pathParams                    请求路径参数
     * @param urlParams                     请求url参数
     * @return
     */
    public JSONArray getJsonArray(String url,Map<String,String> headers,Map<String,?> pathParams,Map<String,?> urlParams){
        SyncHttpTask sync = getSyncHttpTask(url, headers, pathParams, urlParams);
        return null!=sync?responseJSONArray(sync.nothrow().get()):null;
    }

    /**
     * 响应体为JSONObject的请求
     * @param url                         请求url
     * @return
     */
    public JSONObject getJsonObject(String url){
        return getJsonObject(url,null);
    }
    /**
     * 响应体为JSONObject的请求
     * @param url                           请求url
     * @param headers                       请求头参数
     * @return
     */
    public JSONObject getJsonObject(String url,Map<String,String> headers){
        return getJsonObject(url,headers,null,null);
    }
    /**
     * 响应体为JSONObject的请求
     * @param url                           请求url
     * @param headers                       请求头参数
     * @param pathParams                    请求路径参数
     * @return
     */
    public JSONObject getJsonObjectWithPathParam(String url,Map<String,String> headers,Map<String,?> pathParams){
        return getJsonObject(url,headers,pathParams,null);
    }
    /**
     * 响应体为JSONObject的请求
     * @param url                           请求url
     * @param headers                       请求头参数
     * @param urlParams                     请求url参数
     * @return
     */
    public JSONObject getJsonObjectWithUrlParam(String url,Map<String,String> headers,Map<String,?> urlParams){
        return getJsonObject(url,headers,null,urlParams);
    }
    /**
     * 响应体为JSONObject的请求
     * @param url                           请求url
     * @param headers                       请求头参数
     * @param pathParams                    请求路径参数
     * @param urlParams                     请求url参数
     * @return
     */
    public JSONObject getJsonObject(String url,Map<String,String> headers,Map<String,?> pathParams,Map<String,?> urlParams){
        SyncHttpTask sync = getSyncHttpTask(url, headers, pathParams, urlParams);
        return null!=sync?responseJSONObject(sync.nothrow().get()):null;
    }
    /**
     * 获取一个同步的http任务
     * @param url
     * @param headers
     * @param pathParams
     * @param urlParams
     * @return
     */
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
