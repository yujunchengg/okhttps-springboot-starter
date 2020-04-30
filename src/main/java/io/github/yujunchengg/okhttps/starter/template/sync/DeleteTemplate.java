package io.github.yujunchengg.okhttps.starter.template.sync;

import com.ejlchina.okhttps.HTTP;
import com.ejlchina.okhttps.internal.SyncHttpTask;
import com.google.common.base.Strings;
import io.github.yujunchengg.okhttps.starter.util.BeanUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class DeleteTemplate extends BaseTemplate {
    @Autowired
    private HTTP http;
    public String deleteForm(String url){
        return deleteForm(url,null);
    }
    public String deleteForm(String url,Map<String,String> headers){
        return deleteForm(url,headers,null);
    }
    public String deleteForm(String url,Map<String,String> headers,Object formData){
        return deleteForm(url,headers, BeanUtil.objToMap(formData));
    }
    public String deleteForm(String url,Map<String,String> headers,Map<String,?> bodyParams){
        SyncHttpTask sync = bodyParamTask(url, headers,bodyParams);
        return null!=sync?responseText(sync.nothrow().delete()):null;
    }
    public String deleteJson(String url,Map<String,String> headers,Map<String,?> jsonParams){
        SyncHttpTask sync = jsonParamTask(url, headers,jsonParams);
        return null!=sync?responseText(sync.nothrow().delete()):null;
    }

    public String deleteById(String url,Map<String,String> headers,Integer...ids){
        return deleteJson(url,headers,ids);
    }
    public String deleteById(String url,Map<String,String> headers,Long...ids){
        return deleteJson(url,headers,ids);
    }
    public String deleteById(String url,Map<String,String> headers,String...ids){
        return deleteJson(url,headers,ids);
    }
    public String deleteById(String url, Map<String,String> headers, List ids){
        return deleteJson(url,headers,ids);
    }
    public String deleteJson(String url,Map<String,String> headers,Object jsonParams){
        return deleteJson(url,headers,jsonParams,null);
    }
    public String deleteJson(String url,Map<String,String> headers,Object jsonParams,String dateFormat){
        SyncHttpTask sync = jsonParamTask(url, headers,jsonParams,dateFormat);
        return null!=sync?responseText(sync.nothrow().delete()):null;
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
