package com.hx.cms.config;

import com.google.common.collect.Lists;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.util.List;

/**
 * 全局配置
 */
@Configuration
public class GlobalConfiguration {

    @Bean(name = "restTemplate")
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.setConnectTimeout(Duration.ofSeconds(10L)).setReadTimeout(Duration.ofSeconds(10L)).additionalMessageConverters(new WxMappingJackson2HttpMessageConverter()).build();
    }

    public static class WxMappingJackson2HttpMessageConverter extends MappingJackson2HttpMessageConverter {
        public WxMappingJackson2HttpMessageConverter() {
            List<MediaType> mediaTypes = Lists.newArrayListWithCapacity(2);
            mediaTypes.add(MediaType.TEXT_PLAIN);
            mediaTypes.add(MediaType.TEXT_HTML);
            setSupportedMediaTypes(mediaTypes);
        }
    }
}
