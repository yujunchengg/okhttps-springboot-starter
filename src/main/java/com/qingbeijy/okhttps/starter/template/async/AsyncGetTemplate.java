package com.qingbeijy.okhttps.starter.template.async;

import com.ejlchina.okhttps.HttpCall;
import com.qingbeijy.okhttps.starter.template.async.callback.OnCompleteCallback;
import com.qingbeijy.okhttps.starter.template.async.callback.OnExceptionCallback;
import com.qingbeijy.okhttps.starter.template.async.callback.OnResponseCallback;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * okhttps封装的get请求模板
 */
@Component
@Slf4j
public class AsyncGetTemplate extends BaseTemplate{

    /**
     * 获取HttpCall异步实例,使用path路径参数
     * @param url
     * @param pathParams
     * @param onResponseCallback
     * @return
     */
    public HttpCall getWithPathParam(String url,Map<String,?> pathParams,OnResponseCallback onResponseCallback){
        return getWithPathParam(url,pathParams,onResponseCallback,null);
    }
    /**
     * 获取HttpCall异步实例,使用path路径参数
     * @param url
     * @param pathParams
     * @param onResponseCallback
     * @param onExceptionCallback
     * @return
     */
    public HttpCall getWithPathParam(String url,Map<String,?> pathParams,OnResponseCallback onResponseCallback, OnExceptionCallback onExceptionCallback){
        return getWithPathParam(url,pathParams,onResponseCallback,onExceptionCallback,null);
    }
    /**
     * 获取HttpCall异步实例,使用path路径参数
     * @param url
     * @param pathParams
     * @param onResponseCallback
     * @param onExceptionCallback
     * @param onCompleteCallback
     * @return
     */
    public HttpCall getWithPathParam(String url,Map<String,?> pathParams,OnResponseCallback onResponseCallback, OnExceptionCallback onExceptionCallback, OnCompleteCallback onCompleteCallback){
        return get(url,null,pathParams,null,onResponseCallback,onExceptionCallback,onCompleteCallback);
    }
    /**
     * 获取HttpCall异步实例,使用path路径参数
     * @param url
     * @param headers
     * @param pathParams
     * @param onResponseCallback
     * @return
     */
    public HttpCall getWithPathParam(String url, Map<String,String> headers, Map<String,?> pathParams,OnResponseCallback onResponseCallback){
        return getWithPathParam(url,headers,pathParams,onResponseCallback,null);
    }
    /**
     * 获取HttpCall异步实例,使用path路径参数
     * @param url
     * @param headers
     * @param pathParams
     * @param onResponseCallback
     * @param onExceptionCallback
     * @return
     */
    public HttpCall getWithPathParam(String url, Map<String,String> headers, Map<String,?> pathParams,OnResponseCallback onResponseCallback, OnExceptionCallback onExceptionCallback){
        return getWithPathParam(url,headers,pathParams,onResponseCallback,onExceptionCallback,null);
    }
    /**
     * 获取HttpCall异步实例,使用path路径参数
     * @param url
     * @param headers
     * @param pathParams
     * @param onResponseCallback
     * @param onExceptionCallback
     * @param onCompleteCallback
     * @return
     */
    public HttpCall getWithPathParam(String url,Map<String,String> headers, Map<String,?> pathParams,OnResponseCallback onResponseCallback, OnExceptionCallback onExceptionCallback, OnCompleteCallback onCompleteCallback){
        return get(url,headers,pathParams,null,onResponseCallback,onExceptionCallback,onCompleteCallback);
    }
    /**
     * 获取HttpCall异步实例,使用url参数
     * @param url                                 请求url
     * @param urlParams                           请求url参数
     * @param onResponseCallback                  响应回调
     * @return
     */
    public HttpCall getWithUrlParam(String url,Map<String,?> urlParams,OnResponseCallback onResponseCallback){
        return getWithUrlParam(url,urlParams,onResponseCallback,null);
    }
    /**
     * 获取HttpCall异步实例,使用url参数
     * @param url                                 请求url
     * @param urlParams                           请求url参数
     * @param onResponseCallback                  响应回调
     * @param onExceptionCallback                 异常回调
     * @return
     */
    public HttpCall getWithUrlParam(String url,Map<String,?> urlParams,OnResponseCallback onResponseCallback, OnExceptionCallback onExceptionCallback){
        return getWithUrlParam(url,urlParams,onResponseCallback,onExceptionCallback,null);
    }
    /**
     * 获取HttpCall异步实例,使用url参数
     * @param url                                 请求url
     * @param urlParams                           请求url参数
     * @param onResponseCallback                  响应回调
     * @param onExceptionCallback                 异常回调
     * @param onCompleteCallback                  请求完成的回调
     * @return
     */
    public HttpCall getWithUrlParam(String url,Map<String,?> urlParams,OnResponseCallback onResponseCallback, OnExceptionCallback onExceptionCallback, OnCompleteCallback onCompleteCallback){
        return getWithUrlParam(url,null,urlParams,onResponseCallback,onExceptionCallback,onCompleteCallback);
    }
    /**
     * 获取HttpCall异步实例,使用url参数
     * @param url                                 请求url
     * @param headers                             请求头
     * @param urlParams                           请求url参数
     * @param onResponseCallback                  响应回调
     * @return
     */
    public HttpCall getWithUrlParam(String url, Map<String,String> headers, Map<String,?> urlParams,OnResponseCallback onResponseCallback){
        return getWithUrlParam(url,headers,urlParams,onResponseCallback,null);
    }
    /**
     * 获取HttpCall异步实例,使用url参数
     * @param url                                 请求url
     * @param headers                             请求头
     * @param urlParams                           请求url参数
     * @param onResponseCallback                  响应回调
     * @param onExceptionCallback                 异常回调
     * @return
     */
    public HttpCall getWithUrlParam(String url, Map<String,String> headers, Map<String,?> urlParams,OnResponseCallback onResponseCallback, OnExceptionCallback onExceptionCallback){
        return getWithUrlParam(url,headers,urlParams,onResponseCallback,onExceptionCallback,null);
    }
    /**
     * 获取HttpCall异步实例,使用url参数
     * @param url                                  请求url
     * @param headers                              请求头
     * @param urlParams                            请求url参数
     * @param onResponseCallback                   响应回调
     * @param onExceptionCallback                  异常回调
     * @param onCompleteCallback                   请求完成回调
     * @return
     */
    public HttpCall getWithUrlParam(String url, Map<String,String> headers, Map<String,?> urlParams,OnResponseCallback onResponseCallback, OnExceptionCallback onExceptionCallback, OnCompleteCallback onCompleteCallback){
        return get(url,headers,null,urlParams,onResponseCallback,onExceptionCallback,onCompleteCallback);
    }
    /**
     * 获取HttpCall异步实例
     * @param url
     * @param onResponseCallback
     * @return
     */
    public HttpCall get(String url,OnResponseCallback onResponseCallback){
        return get(url, null,onResponseCallback);
    }
    /**
     * 获取HttpCall异步实例
     * @param url
     * @param headers
     * @param onResponseCallback
     * @return
     */
    public HttpCall get(String url, Map<String,String> headers,OnResponseCallback onResponseCallback){
        return get(url,headers,null, null,onResponseCallback);
    }
    /**
     * 获取HttpCall异步实例
     * @param url
     * @param headers
     * @param pathParams
     * @param urlParams
     * @param onResponseCallback
     * @return
     */
    public HttpCall get(String url, Map<String,String> headers, Map<String,?> pathParams, Map<String,?> urlParams, OnResponseCallback onResponseCallback){
        return get(url,headers, pathParams, urlParams,onResponseCallback,null);
    }
    /**
     * 获取HttpCall异步实例
     * @param url
     * @param headers
     * @param pathParams
     * @param urlParams
     * @param onResponseCallback
     * @param onExceptionCallback
     * @return
     */
    public HttpCall get(String url, Map<String,String> headers, Map<String,?> pathParams, Map<String,?> urlParams, OnResponseCallback onResponseCallback, OnExceptionCallback onExceptionCallback){
        return get(url,headers, pathParams,urlParams,onResponseCallback,onExceptionCallback,null);
    }
}
