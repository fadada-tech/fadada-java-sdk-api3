package com.fadada.api;

import com.fadada.api.constants.GlobalConstants;
import com.fadada.api.exception.ApiException;
import com.fadada.api.utils.http.HttpUtil;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

/**
 * @author yh128
 * @className DefaultFadadaApiServiceImpl
 * @description 默认法大大apiService实现
 * @createTime 2020年8月13日 15:30:09
 */
public class DefaultFadadaApiServiceImpl implements FadadaApiService {
    private Logger logger = LoggerFactory.getLogger(DefaultFadadaApiServiceImpl.class);


    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    static {
        //序列化的时候序列对象的所有属性
        OBJECT_MAPPER.setSerializationInclusion(JsonInclude.Include.ALWAYS);

        //取消时间的转化格式,默认是时间戳,可以取消,同时需要设置要表现的时间格式
        OBJECT_MAPPER.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        OBJECT_MAPPER.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

        // 对于空的对象转json的时候不抛出错误
        OBJECT_MAPPER.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);

        // 禁用遇到未知属性抛出异常
        OBJECT_MAPPER.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        OBJECT_MAPPER.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        OBJECT_MAPPER.enable(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT);

        OBJECT_MAPPER.enable(JsonParser.Feature.ALLOW_COMMENTS);
        OBJECT_MAPPER.enable(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES);
        OBJECT_MAPPER.enable(JsonParser.Feature.ALLOW_SINGLE_QUOTES);

    }

    @Override
    public String toJson(Object object) throws ApiException {
        // 针对的是转义字符串
        try {
            String jsonStr = null;
            if (object instanceof String) {
                JsonNode jsonNode = OBJECT_MAPPER.readTree(String.valueOf(object));
                jsonStr = OBJECT_MAPPER.writeValueAsString(jsonNode);
            } else {
                jsonStr = OBJECT_MAPPER.writeValueAsString(object);
            }
            return jsonStr;
        } catch (Exception e) {
            logger.error("toJson失败：{}", e);
            throw new ApiException("toJson失败");
        }
    }

    @Override
    public <T> T toJavaBean(String json, final ParameterizedType parameterizedType) throws ApiException {
        if (json == null) {
            return null;
        }
        try {
            return OBJECT_MAPPER.readValue(json, new TypeReference<T>() {
                @Override
                public Type getType() {
                    return parameterizedType;
                }
            });
        } catch (JsonProcessingException e) {
            logger.error("toJavaBean失败：{}", e);
            throw new ApiException("toJavaBean失败");
        }
    }


    @Override
    public <T> T toJavaBean(String json, Class<T> clzz) throws ApiException {
        try {
            return OBJECT_MAPPER.readValue(json, clzz);
        } catch (JsonProcessingException e) {
            logger.error("toJavaBean失败：{}", e);
            throw new ApiException("toJavaBean失败");
        }
    }

    @Override
    public <T> List<T> toList(String json, Class<T> clzz) throws ApiException {
        JavaType javaType = OBJECT_MAPPER.getTypeFactory().constructParametricType(List.class, clzz);
        try {
            return OBJECT_MAPPER.readValue(json, javaType);
        } catch (JsonProcessingException e) {
            logger.error("toList失败：{}", e);
            throw new ApiException("toList失败");
        }
    }

    @Override
    public String http(String url, String method, Map<String, String> headerMap,
                       Map<String, String> bodyMap, Map<String, File> fileMap) throws ApiException {
        try {
            String result = "";
            if (GlobalConstants.METHOD_GET.equals(method)) {
                result = HttpUtil.get(url, headerMap, bodyMap);
            } else if (GlobalConstants.METHOD_POST.equals(method)) {
                result = HttpUtil.post(url, headerMap, bodyMap, fileMap);
            }
            return result;
        } catch (Exception e) {
            logger.error("http请求失败：{}", e);
            throw new ApiException("http请求失败");
        }
    }

    @Override
    public Object httpDownLoad(String url, String method, Map<String, String> headerMap,
                               Map<String, String> bodyMap) throws ApiException {
        try {
            return HttpUtil.downLoadFiles(url, headerMap, bodyMap);
        } catch (Exception e) {
            logger.error("httpDownLoad请求失败：{}", e);
            throw new ApiException("httpDownLoad请求失败");
        }
    }

}
