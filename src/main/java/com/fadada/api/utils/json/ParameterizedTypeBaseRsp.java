package com.fadada.api.utils.json;

import com.fadada.api.bean.rsp.BaseRsp;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author yh128
 * @className ParameterizedTypeBaseRsp
 * @description BaseRsp类嵌套类型
 * @createTime 2020年8月13日 15:33:09
 */
public class ParameterizedTypeBaseRsp implements ParameterizedType {
    Class clazz;

    public ParameterizedTypeBaseRsp(Class clz) {
        clazz = clz;
    }

    @Override
    public Type[] getActualTypeArguments() {
        return new Type[]{clazz};
    }

    @Override
    public Type getRawType() {
        return BaseRsp.class;
    }

    @Override
    public Type getOwnerType() {
        return null;
    }
}
