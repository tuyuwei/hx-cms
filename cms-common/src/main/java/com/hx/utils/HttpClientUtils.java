package com.hx.utils;

import com.hx.cms.exception.OperateException;
import com.hx.cms.exception.RequestException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

public class HttpClientUtils {


    private final static RestTemplate restTemplate = new RestTemplate();

    public static <T> T post() {

        return null;
    }

    public static <T, P> T get(String url, Class<T> clazz, P params) {
        if (StringUtils.isBlank(url)) {
            throw new RequestException("url is blank.");
        }
        if (Objects.isNull(clazz)) {
            throw new RequestException("response class type is blank.");
        }

        ResponseEntity<T> response = restTemplate.getForEntity(url, clazz, params);
        if (!Objects.equals(response.getStatusCode(), HttpStatus.OK)) {
            throw new OperateException("http request error.");
        }
        return response.getBody();
    }

}
