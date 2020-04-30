package io.github.yujunchengg.okhttps.starter.template.sync;

import com.ejlchina.okhttps.HTTP;
import com.ejlchina.okhttps.internal.SyncHttpTask;
import com.google.common.base.Strings;
import io.github.yujunchengg.okhttps.starter.util.BeanUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Slf4j
public class PostTemplate extends BaseTemplate {
    @Autowired
    private HTTP http;
    public String postForm(String url){
        return postForm(url,null);
    }
    public String postForm(String url,Map<String,String> headers){
        return postForm(url,headers,null);
    }
    public String postForm(String url,Map<String,String> headers,Object formData){
        return postForm(url,headers, BeanUtil.objToMap(formData));
    }
    public String postForm(String url,Map<String,String> headers,Map<String,?> bodyParams){
        SyncHttpTask sync = bodyParamTask(url, headers,bodyParams);
        return null!=sync?responseText(sync.nothrow().post()):null;
    }
    public String postJson(String url,Map<String,String> headers,Map<String,?> jsonParams){
        SyncHttpTask sync = jsonParamTask(url, headers,jsonParams);
        return null!=sync?responseText(sync.nothrow().post()):null;
    }
    public String postJson(String url,Map<String,String> headers,Object jsonParams){
        return postJson(url,headers,jsonParams,null);
    }
    public String postJson(String url,Map<String,String> headers,Object jsonParams,String dateFormat){
        SyncHttpTask sync = jsonParamTask(url, headers,jsonParams,dateFormat);
        return null!=sync?responseText(sync.nothrow().post()):null;
    }
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
