package com.qingbeijy.okhttps.starter.template.async;

import com.ejlchina.okhttps.HTTP;
import com.ejlchina.okhttps.HttpCall;
import com.ejlchina.okhttps.internal.AsyncHttpTask;
import com.google.common.base.Strings;
import com.qingbeijy.okhttps.starter.template.async.callback.OnCompleteCallback;
import com.qingbeijy.okhttps.starter.template.async.callback.OnExceptionCallback;
import com.qingbeijy.okhttps.starter.template.async.callback.OnResponseCallback;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

@Slf4j
public abstract class BaseTemplate {

    @Autowired
    protected HTTP http;
    /**
     * 获取HttpCall异步实例
     * @param url
     * @param headers
     * @param pathParams
     * @param urlParams
     * @param onResponseCallback
     * @param onExceptionCallback
     * @param onCompleteCallback
     */
    protected HttpCall get(String url, Map<String,String> headers, Map<String,?> pathParams, Map<String,?> urlParams, OnResponseCallback onResponseCallback, OnExceptionCallback onExceptionCallback, OnCompleteCallback onCompleteCallback){
        if(Strings.isNullOrEmpty(url)){
            return null;
        }
        AsyncHttpTask async = http.async(url);
        if(null!=headers && !headers.isEmpty()){
            async.addHeader(headers);
        }
        if(null!=pathParams && !pathParams.isEmpty()){
            async.addPathParam(pathParams);
        }
        if(null!=urlParams && !urlParams.isEmpty()){
            async.addUrlParam(urlParams);
        }
        if(null!=onResponseCallback){
            async.setOnResponse(onResponseCallback);
        }
        if(null!=onExceptionCallback){
            async.setOnException(onExceptionCallback);
        }
        if(null!=onCompleteCallback){
            async.setOnComplete(onCompleteCallback);
        }
        return async.nothrow().get();
    }
    /**
     * 获取HttpCall异步实例
     * @param url
     * @param headers
     * @param onResponseCallback
     * @param onExceptionCallback
     * @param onCompleteCallback
     */
    protected HttpCall postJson(String url,Map<String,String> headers,Object jsonParam,OnResponseCallback onResponseCallback, OnExceptionCallback onExceptionCallback, OnCompleteCallback onCompleteCallback){
        if(Strings.isNullOrEmpty(url)){
            return null;
        }
        AsyncHttpTask async = http.async(url);
        if(null!=headers && !headers.isEmpty()){
            async.addHeader(headers);
        }
        if(null!=jsonParam){
            async.setRequestJson(jsonParam);
        }
        if(null!=onResponseCallback){
            async.setOnResponse(onResponseCallback);
        }
        if(null!=onExceptionCallback){
            async.setOnException(onExceptionCallback);
        }
        if(null!=onCompleteCallback){
            async.setOnComplete(onCompleteCallback);
        }
        return async.nothrow().post();
    }
}
