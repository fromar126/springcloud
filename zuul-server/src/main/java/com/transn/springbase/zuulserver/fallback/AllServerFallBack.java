package com.transn.springbase.zuulserver.fallback;

import org.json.simple.JSONObject;
import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 针对请求进行回退，比如用户请求zuul网关是成功的，但是网关到后端服务的请求超时，
 * 不应该把api的404,500等问题抛给客户端
 *
 * @Author bryan.wu
 * @Date 2018/4/28
 */
@Component
public class AllServerFallBack implements ZuulFallbackProvider {

    /**
     * 返回值表示需要针对此微服务做回退处理（该名称一定要是注册进入 eureka 微服务中的那个 serviceId 名称）；
     *
     * @return
     */
    @Override
    public String getRoute() {

        return "*";//api服务id，如果需要所有调用都支持回退，则return "*"或return null
    }

    @Override
    public ClientHttpResponse fallbackResponse() {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return HttpStatus.OK.value();
            }

            @Override
            public String getStatusText() throws IOException {
                return HttpStatus.OK.getReasonPhrase();
            }

            @Override
            public void close() {

            }

            /**
             * 当微服务出现宕机后，客户端再请求时候就会返回 fallback 等字样的字符串提示；
             *
             * 但对于复杂一点的微服务，我们这里就得好好琢磨该怎么友好提示给用户了；
             *
             * 如果请求用户服务失败，返回什么信息给消费者客户端
             * @return
             * @throws IOException
             */
            @Override
            public InputStream getBody() throws IOException {
                JSONObject r = new JSONObject();
                r.put("state", "9999");
                r.put("msg", "系统错误，请求失败");
                return new ByteArrayInputStream(r.toString().getBytes("UTF-8"));
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                //和body中的内容编码一致，否则容易乱码
                headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
                return headers;
            }
        };
    }
}
