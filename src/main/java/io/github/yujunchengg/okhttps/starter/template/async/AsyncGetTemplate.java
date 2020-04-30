package io.github.yujunchengg.okhttps.starter.template.async;

import com.ejlchina.okhttps.HttpCall;
import io.github.yujunchengg.okhttps.starter.template.async.callback.OnCompleteCallback;
import io.github.yujunchengg.okhttps.starter.template.async.callback.OnExceptionCallback;
import io.github.yujunchengg.okhttps.starter.template.async.callback.OnResponseCallback;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;
@Component
@Slf4j
public class AsyncGetTemplate extends BaseTemplate{

    public HttpCall getWithPathParam(String url, Map<String,?> pathParams, OnResponseCallback onResponseCallback){
        return getWithPathParam(url,pathParams,onResponseCallback,null);
    }
    public HttpCall getWithPathParam(String url,Map<String,?> pathParams,OnResponseCallback onResponseCallback, OnExceptionCallback onExceptionCallback){
        return getWithPathParam(url,pathParams,onResponseCallback,onExceptionCallback,null);
    }
    public HttpCall getWithPathParam(String url,Map<String,?> pathParams,OnResponseCallback onResponseCallback, OnExceptionCallback onExceptionCallback, OnCompleteCallback onCompleteCallback){
        return get(url,null,pathParams,null,onResponseCallback,onExceptionCallback,onCompleteCallback);
    }
    public HttpCall getWithPathParam(String url, Map<String,String> headers, Map<String,?> pathParams,OnResponseCallback onResponseCallback){
        return getWithPathParam(url,headers,pathParams,onResponseCallback,null);
    }
    public HttpCall getWithPathParam(String url, Map<String,String> headers, Map<String,?> pathParams,OnResponseCallback onResponseCallback, OnExceptionCallback onExceptionCallback){
        return getWithPathParam(url,headers,pathParams,onResponseCallback,onExceptionCallback,null);
    }
    public HttpCall getWithPathParam(String url,Map<String,String> headers, Map<String,?> pathParams,OnResponseCallback onResponseCallback, OnExceptionCallback onExceptionCallback, OnCompleteCallback onCompleteCallback){
        return get(url,headers,pathParams,null,onResponseCallback,onExceptionCallback,onCompleteCallback);
    }
    public HttpCall getWithUrlParam(String url,Map<String,?> urlParams,OnResponseCallback onResponseCallback){
        return getWithUrlParam(url,urlParams,onResponseCallback,null);
    }
    public HttpCall getWithUrlParam(String url,Map<String,?> urlParams,OnResponseCallback onResponseCallback, OnExceptionCallback onExceptionCallback){
        return getWithUrlParam(url,urlParams,onResponseCallback,onExceptionCallback,null);
    }
    public HttpCall getWithUrlParam(String url,Map<String,?> urlParams,OnResponseCallback onResponseCallback, OnExceptionCallback onExceptionCallback, OnCompleteCallback onCompleteCallback){
        return getWithUrlParam(url,null,urlParams,onResponseCallback,onExceptionCallback,onCompleteCallback);
    }
    public HttpCall getWithUrlParam(String url, Map<String,String> headers, Map<String,?> urlParams,OnResponseCallback onResponseCallback){
        return getWithUrlParam(url,headers,urlParams,onResponseCallback,null);
    }
    public HttpCall getWithUrlParam(String url, Map<String,String> headers, Map<String,?> urlParams,OnResponseCallback onResponseCallback, OnExceptionCallback onExceptionCallback){
        return getWithUrlParam(url,headers,urlParams,onResponseCallback,onExceptionCallback,null);
    }
    public HttpCall getWithUrlParam(String url, Map<String,String> headers, Map<String,?> urlParams,OnResponseCallback onResponseCallback, OnExceptionCallback onExceptionCallback, OnCompleteCallback onCompleteCallback){
        return get(url,headers,null,urlParams,onResponseCallback,onExceptionCallback,onCompleteCallback);
    }
    public HttpCall get(String url,OnResponseCallback onResponseCallback){
        return get(url, null,onResponseCallback);
    }
    public HttpCall get(String url, Map<String,String> headers,OnResponseCallback onResponseCallback){
        return get(url,headers,null, null,onResponseCallback);
    }
    public HttpCall get(String url, Map<String,String> headers, Map<String,?> pathParams, Map<String,?> urlParams, OnResponseCallback onResponseCallback){
        return get(url,headers, pathParams, urlParams,onResponseCallback,null);
    }
    public HttpCall get(String url, Map<String,String> headers, Map<String,?> pathParams, Map<String,?> urlParams, OnResponseCallback onResponseCallback, OnExceptionCallback onExceptionCallback){
        return get(url,headers, pathParams,urlParams,onResponseCallback,onExceptionCallback,null);
    }
}
