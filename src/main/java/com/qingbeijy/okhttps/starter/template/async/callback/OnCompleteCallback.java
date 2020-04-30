package com.qingbeijy.okhttps.starter.template.async.callback;

import com.ejlchina.okhttps.HttpResult;
import com.ejlchina.okhttps.OnCallback;

/**
 * 完成回调，无论成功失败都会执行
 * 并且在   响应|异常回调 之前执行
 */
public interface OnCompleteCallback extends OnCallback<HttpResult.State> {
}
