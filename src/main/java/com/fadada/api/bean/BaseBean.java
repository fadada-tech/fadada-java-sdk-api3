package com.fadada.api.bean;

import com.fadada.api.FadadaApiConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * @author yh128
 * @version 1.0.0
 * @ClassName BaseBean.java
 * @Description 父类bean
 * @Param
 * @createTime 2020年07月03日 11:20:00
 */
public class BaseBean implements Serializable {

    private static final long serialVersionUID = 8207184311239927313L;

    private Logger log = LoggerFactory.getLogger(BaseBean.class);


    @Override
    public String toString() {
        String jsonStr = null;
        try {
            jsonStr = FadadaApiConfig.getFadadaApiService().toJson(this);
        } catch (Exception e) {
            log.error("实体json失败：{}", e);
        }
        return jsonStr;
    }
}
