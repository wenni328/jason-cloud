package com.api.gateway.config;

import com.netflix.hystrix.exception.HystrixTimeoutException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author: xieyong
 * @date: 2018/11/16 13:54
 * @Description: 此类作用 回退/失败响应
 * 假设某个消费者服务挂了，给页面返回的情况。
 */
@Component
@Slf4j
public class ApiFallbackProviderConfig implements FallbackProvider {

    /**
     * * 代表的是所有路由生效
     * 也可以写服务id
     *
     * @return
     */
    @Override
    public String getRoute() {
        return "*";
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        log.warn(String.format("route:%s,exceptionType:%s,stackTrace:%s", route, cause.getClass().getName(), cause.getStackTrace()));
        String message;
        if (cause instanceof HystrixTimeoutException) {
            message = "Timeout";
        } else {
            message = "Service exception";
        }
        log.warn(message);
        return fallbackResponse(message);
    }

    public ClientHttpResponse fallbackResponse(String message) {

        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return 200;
            }

            @Override
            public String getStatusText() throws IOException {
                return "OK";
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
                String bodyText = String.format("{\"code\": 1111,\"message\": \"Service unavailable:%s\"}", message);
                return new ByteArrayInputStream(bodyText.getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                return headers;
            }
        };
    }
}
