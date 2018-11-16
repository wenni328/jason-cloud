package com.cloud.eureka.client.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

/**
 * @author: xieyong
 * @date: 2018/11/16 11:02
 * @Description: https://blog.csdn.net/qq_24210767/article/details/78992374
 */
@Slf4j
public class ThrowErrorHandler implements ResponseErrorHandler {
    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        if (response.getStatusCode().is5xxServerError()) {
            log.info("服务端出现5XXX错误：{}", response.getStatusText());
            return false;
        }
        if (response.getStatusCode().is4xxClientError()){
            log.info("客户端找不到路径4x错误：{}",response.getStatusText());
            return false;
        }
        return true;
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {

    }
}
