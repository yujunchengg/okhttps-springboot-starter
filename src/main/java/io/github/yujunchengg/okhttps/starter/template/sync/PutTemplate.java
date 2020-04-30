package io.github.yujunchengg.okhttps.starter.template.sync;

import com.ejlchina.okhttps.HTTP;
import com.ejlchina.okhttps.internal.SyncHttpTask;
import com.google.common.base.Strings;
import io.github.yujunchengg.okhttps.starter.util.BeanUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * okhttps封装的put请求模板
 */
@Component
@Slf4j
public class PutTemplate extends BaseTemplate {
    @Autowired
    private HTTP http;
    /**
     * 发送普通form表单请求
     * @param url                  请求url
     * @return
     */
    public String putForm(String url){
        return putForm(url,null);
    }
    /**
     * 发送普通form表单请求
     * @param url                   请求url
     * @param headers               请求头参数信息
     * @return
     */
    public String putForm(String url,Map<String,String> headers){
        return putForm(url,headers,null);
    }
    /**
     * 发送普通form表单请求
     * @param url                   请求url
     * @param headers               请求头参数
     * @param formData              请求体参数,标准的java bean
     * @return
     */
    public String putForm(String url,Map<String,String> headers,Object formData){
        return putForm(url,headers, BeanUtil.objToMap(formData));
    }
    /**
     * 发送普通form表单请求
     * @param url                   请求url
     * @param headers               请求头参数
     * @param bodyParams            请求体参数(普通form表单形式)以表单key=value&的形式放在报文体内
     * @return
     */
    public String putForm(String url,Map<String,String> headers,Map<String,?> bodyParams){
        SyncHttpTask sync = bodyParamTask(url, headers,bodyParams);
        return null!=sync?responseText(sync.nothrow().put()):null;
    }
    public String putJson(String url,Map<String,String> headers,Map<String,?> jsonParams){
        SyncHttpTask sync = jsonParamTask(url, headers,jsonParams);
        return null!=sync?responseText(sync.nothrow().put()):null;
    }
    public String putJson(String url,Map<String,String> headers,Object jsonParams){
        return putJson(url,headers,jsonParams,null);
    }
    public String putJson(String url,Map<String,String> headers,Object jsonParams,String dateFormat){
        SyncHttpTask sync = jsonParamTask(url, headers,jsonParams,dateFormat);
        return null!=sync?responseText(sync.nothrow().put()):null;
    }
    /**
     * 获取一个同步的http任务
     * @param url
     * @param headers
     * @param bodyParams
     * @return
     */
    private SyncHttpTask bodyParamTask(String url, Map<String,String> headers, Map<String,?> bodyParams) {
        if(Strings.isNullOrEmpty(url)){
            return null;
        }
        SyncHttpTask sync = http.sync(url);
        if(null!=headers && !headers.isEmpty()){
            sync.addHeader(headers);
        }
        if(null!=bodyParams && !bodyParams.isEmpty()){
            sync.addBodyParam(bodyParams);
        }
        return sync;
    }
    /**
     * 构建一个同步的传递json参数的HttpTask类的实例
     * @param url
     * @param headers
     * @param jsonParams
     * @return
     */
    private SyncHttpTask jsonParamTask(String url, Map<String,String> headers, Map<String,?> jsonParams) {
        if(Strings.isNullOrEmpty(url)){
            return null;
        }
        SyncHttpTask sync = http.sync(url);
        if(null!=headers && !headers.isEmpty()){
            sync.addHeader(headers);
        }
        if(null!=jsonParams && !jsonParams.isEmpty()){
            sync.addJsonParam(jsonParams);
        }
        return sync;
    }
    private SyncHttpTask jsonParamTask(String url, Map<String,String> headers, Object jsonParams) {
        return jsonParamTask(url,headers,jsonParams,null);
    }
    private SyncHttpTask jsonParamTask(String url, Map<String,String> headers, Object jsonParams,String dateFormat) {
        if(Strings.isNullOrEmpty(url) || null==jsonParams){
            return null;
        }
        SyncHttpTask sync = http.sync(url);
        if(null!=headers && !headers.isEmpty()){
            sync.addHeader(headers);
        }
        sync.setRequestJson(jsonParams,dateFormat);
        return sync;
    }
}
