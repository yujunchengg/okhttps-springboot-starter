package com.qingbeijy.okhttps.starter.template.sync;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ejlchina.okhttps.HttpResult;
import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;
import java.util.List;

@Slf4j
public abstract class BaseTemplate {

    /**
     * 响应文本
     * @param httpResult
     * @return
     */
    protected String responseText(HttpResult httpResult){
        String text=null;
        if(null!=httpResult){
            HttpResult.State state = httpResult.getState();
            log.info("HTTP Status: {}", state.name());
            switch (state){
                case RESPONSED:         //请求正常响应
                    HttpResult.Body body = httpResult.getBody();
                    text=null!=body?body.toString() :null;
                    break;
                case CANCELED:          //请求已被取消
                    break;
                case NETWORK_ERROR:     //网络错误，说明用户没网了
                    break;
                case TIMEOUT:           //请求超时
                    break;
                case EXCEPTION:         //其它异常
                    break;
            }
        }
        return text;
    }

    /**
     * 响应一个java bean
     * @param httpResult
     * @param clazz
     * @param <T>
     * @return
     */
    protected <T> T responseBean(HttpResult httpResult,Class<T> clazz){
        T t=null;
        if(null!=httpResult){
            HttpResult.State state = httpResult.getState();
            log.info("HTTP Status: {}", state.name());
            switch (state){
                case RESPONSED:         //请求正常响应
                    HttpResult.Body body = httpResult.getBody();
                    t=null!=body?body.toBean(clazz):null;
                    break;
                case CANCELED:          //请求已被取消
                    break;
                case NETWORK_ERROR:     //网络错误，说明用户没网了
                    break;
                case TIMEOUT:           //请求超时
                    break;
                case EXCEPTION:         //其它异常
                    break;
            }
        }
        return t;
    }

    /**
     * 响应一个java 集合
     * @param httpResult
     * @param clazz
     * @param <T>
     * @return
     */
    protected <T> List<T> responseList(HttpResult httpResult, Class<T> clazz){
        List<T> list=null;
        if(null!=httpResult){
            HttpResult.State state = httpResult.getState();
            log.info("HTTP Status: {}", state.name());
            switch (state){
                case RESPONSED:         //请求正常响应
                    HttpResult.Body body = httpResult.getBody();
                    list=null!=body?body.toList(clazz):null;
                    break;
                case CANCELED:          //请求已被取消
                    break;
                case NETWORK_ERROR:     //网络错误，说明用户没网了
                    break;
                case TIMEOUT:           //请求超时
                    break;
                case EXCEPTION:         //其它异常
                    break;
            }
        }
        return list;
    }
    /**
     * 响应byte数组
     * @param httpResult
     * @return
     */
    protected byte[] responseByte(HttpResult httpResult){
        byte[] bytes=null;
        if(null!=httpResult){
            HttpResult.State state = httpResult.getState();
            log.info("HTTP Status: {}", state.name());
            switch (state){
                case RESPONSED:         //请求正常响应
                    HttpResult.Body body = httpResult.getBody();
                    bytes=null!=body?body.toBytes():null;
                    break;
                case CANCELED:          //请求已被取消
                    break;
                case NETWORK_ERROR:     //网络错误，说明用户没网了
                    break;
                case TIMEOUT:           //请求超时
                    break;
                case EXCEPTION:         //其它异常
                    break;
            }
        }
        return bytes;
    }
    /**
     * 响应byteStream
     * @param httpResult
     * @return
     */
    protected InputStream responseByteStream(HttpResult httpResult){
        InputStream byteStream=null;
        if(null!=httpResult){
            HttpResult.State state = httpResult.getState();
            log.info("HTTP Status: {}", state.name());
            switch (state){
                case RESPONSED:         //请求正常响应
                    HttpResult.Body body = httpResult.getBody();
                    byteStream=null!=body?body.toByteStream():null;
                    break;
                case CANCELED:          //请求已被取消
                    break;
                case NETWORK_ERROR:     //网络错误，说明用户没网了
                    break;
                case TIMEOUT:           //请求超时
                    break;
                case EXCEPTION:         //其它异常
                    break;
            }
        }
        return byteStream;
    }

    /**
     * 响应JSONArray
     * @param httpResult
     * @return
     */
    protected JSONArray responseJSONArray(HttpResult httpResult){
        JSONArray jsonArray=null;
        if(null!=httpResult){
            HttpResult.State state = httpResult.getState();
            log.info("HTTP Status: {}", state.name());
            switch (state){
                case RESPONSED:         //请求正常响应
                    HttpResult.Body body = httpResult.getBody();
                    jsonArray=null!=body?body.toJsonArray():null;
                    break;
                case CANCELED:          //请求已被取消
                    break;
                case NETWORK_ERROR:     //网络错误，说明用户没网了
                    break;
                case TIMEOUT:           //请求超时
                    break;
                case EXCEPTION:         //其它异常
                    break;
            }
        }
        return jsonArray;
    }

    /**
     * 响应JSONObject
     * @param httpResult
     * @return
     */
    protected JSONObject responseJSONObject(HttpResult httpResult){
        JSONObject jsonObject=null;
        if(null!=httpResult){
            HttpResult.State state = httpResult.getState();
            log.info("HTTP Status: {}", state.name());
            switch (state){
                case RESPONSED:         //请求正常响应
                    HttpResult.Body body = httpResult.getBody();
                    jsonObject=null!=body?body.toJsonObject():null;
                    break;
                case CANCELED:          //请求已被取消
                    break;
                case NETWORK_ERROR:     //网络错误，说明用户没网了
                    break;
                case TIMEOUT:           //请求超时
                    break;
                case EXCEPTION:         //其它异常
                    break;
            }
        }
        return jsonObject;
    }
}
