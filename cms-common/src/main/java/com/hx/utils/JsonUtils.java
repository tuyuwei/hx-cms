package com.hx.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.hx.cms.exception.SystemException;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class JsonUtils {

    private final static ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.setTimeZone(TimeZone.getTimeZone("GMT+8"))
                // Include.NON_NULL 属性为NULL 不序列化
                //ALWAYS // 默认策略，任何情况都执行序列化
                //NON_EMPTY // null、集合数组等没有内容、空字符串等，都不会被序列化
                //NON_DEFAULT // 如果字段是默认值，就不会被序列化
                //NON_ABSENT // null的不会序列化，但如果类型是AtomicReference，依然会被序列化
                .setSerializationInclusion(JsonInclude.Include.NON_NULL)
                //时间格式
                .setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"))
                //空对象不要抛出异常
                .disable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
                //反序列化时，空字符串对于的实例属性为null
                .disable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
    }

    public static String encode(Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new SystemException("json encode error.", e);
        }
    }

    public static <T> T decode(String jsonStr, Class<T> clazz) {
        try {
            return objectMapper.readValue(jsonStr, clazz);
        } catch (JsonProcessingException e) {
            throw new SystemException("json decode error.", e);
        }
    }

    public static <T> T decode0(String jsonStr, Class<T> clazz) {
        try {
            return objectMapper.readValue(jsonStr, new TypeReference<T>() {});
        } catch (JsonProcessingException e) {
            throw new SystemException("json decode error.", e);
        }
    }


}
