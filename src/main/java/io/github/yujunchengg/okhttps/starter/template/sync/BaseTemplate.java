package io.github.yujunchengg.okhttps.starter.template.sync;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ejlchina.okhttps.HttpResult;
import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;
import java.util.List;

@Slf4j
public abstract class BaseTemplate {
    protected String responseText(HttpResult httpResult){
        String text=null;
        if(null!=httpResult){
            HttpResult.State state = httpResult.getState();
            log.info("HTTP Status: {}", state.name());
            switch (state){
                case RESPONSED:
                    HttpResult.Body body = httpResult.getBody();
                    text=null!=body?body.toString() :null;
                    break;
                case CANCELED:
                    break;
                case NETWORK_ERROR:
                    break;
                case TIMEOUT:
                    break;
                case EXCEPTION:
                    break;
            }
        }
        return text;
    }
    protected <T> T responseBean(HttpResult httpResult,Class<T> clazz){
        T t=null;
        if(null!=httpResult){
            HttpResult.State state = httpResult.getState();
            log.info("HTTP Status: {}", state.name());
            switch (state){
                case RESPONSED:
                    HttpResult.Body body = httpResult.getBody();
                    t=null!=body?body.toBean(clazz):null;
                    break;
                case CANCELED:
                    break;
                case NETWORK_ERROR:
                    break;
                case TIMEOUT:
                    break;
                case EXCEPTION:
                    break;
            }
        }
        return t;
    }
    protected <T> List<T> responseList(HttpResult httpResult, Class<T> clazz){
        List<T> list=null;
        if(null!=httpResult){
            HttpResult.State state = httpResult.getState();
            log.info("HTTP Status: {}", state.name());
            switch (state){
                case RESPONSED:
                    HttpResult.Body body = httpResult.getBody();
                    list=null!=body?body.toList(clazz):null;
                    break;
                case CANCELED:
                    break;
                case NETWORK_ERROR:
                    break;
                case TIMEOUT:
                    break;
                case EXCEPTION:
                    break;
            }
        }
        return list;
    }
    protected byte[] responseByte(HttpResult httpResult){
        byte[] bytes=null;
        if(null!=httpResult){
            HttpResult.State state = httpResult.getState();
            log.info("HTTP Status: {}", state.name());
            switch (state){
                case RESPONSED:
                    HttpResult.Body body = httpResult.getBody();
                    bytes=null!=body?body.toBytes():null;
                    break;
                case CANCELED:
                    break;
                case NETWORK_ERROR:
                    break;
                case TIMEOUT:
                    break;
                case EXCEPTION:
                    break;
            }
        }
        return bytes;
    }
    protected InputStream responseByteStream(HttpResult httpResult){
        InputStream byteStream=null;
        if(null!=httpResult){
            HttpResult.State state = httpResult.getState();
            log.info("HTTP Status: {}", state.name());
            switch (state){
                case RESPONSED:
                    HttpResult.Body body = httpResult.getBody();
                    byteStream=null!=body?body.toByteStream():null;
                    break;
                case CANCELED:
                    break;
                case NETWORK_ERROR:
                    break;
                case TIMEOUT:
                    break;
                case EXCEPTION:
                    break;
            }
        }
        return byteStream;
    }
    protected JSONArray responseJSONArray(HttpResult httpResult){
        JSONArray jsonArray=null;
        if(null!=httpResult){
            HttpResult.State state = httpResult.getState();
            log.info("HTTP Status: {}", state.name());
            switch (state){
                case RESPONSED:
                    HttpResult.Body body = httpResult.getBody();
                    jsonArray=null!=body?body.toJsonArray():null;
                    break;
                case CANCELED:
                    break;
                case NETWORK_ERROR:
                    break;
                case TIMEOUT:
                    break;
                case EXCEPTION:
                    break;
            }
        }
        return jsonArray;
    }
    protected JSONObject responseJSONObject(HttpResult httpResult){
        JSONObject jsonObject=null;
        if(null!=httpResult){
            HttpResult.State state = httpResult.getState();
            log.info("HTTP Status: {}", state.name());
            switch (state){
                case RESPONSED:
                    HttpResult.Body body = httpResult.getBody();
                    jsonObject=null!=body?body.toJsonObject():null;
                    break;
                case CANCELED:
                    break;
                case NETWORK_ERROR:
                    break;
                case TIMEOUT:
                    break;
                case EXCEPTION:
                    break;
            }
        }
        return jsonObject;
    }
}
