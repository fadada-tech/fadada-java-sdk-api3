package com.fadada.api.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author yh128
 * @version 1.0.0
 * @ClassName ParamsVerif.java
 * @Description 非空, 以及长度，大小限制注解
 * @Param
 * @createTime 2020年07月11日 11:04:00
 */
@Target({FIELD, ElementType.TYPE})
@Retention(RUNTIME)
public @interface ParamsVerif {


    /**
     * 默认检查为空
     *
     * @return
     */
    boolean checkNotNull() default true;


    /**
     * 是否检测为空（字符串去除前后空格）一定会先验证是否为null
     *
     * @return
     */
    boolean checkNotEmpty() default false;

    /**
     * 长度最小值，集合最小值
     *
     * @return
     */
    int minLength() default 0;

    /**
     * 长度最大值，集合最小值
     *
     * @return
     */
    int maxLength() default 0;

    /**
     * 长度固定值
     *
     * @return
     */
    int equalLength() default 0;

    /**
     * 最小值 (针对基本数据类型)
     *
     * @return
     */
    String minValue() default "";

    /**
     * 最大值 (针对基本数据类型)
     *
     * @return
     */
    String maxValue() default "";

    /**
     * String包含的数值
     *
     * @return
     */
    String[] strContains() default {};


    /**
     * int包含的数值
     *
     * @return
     */
    int[] intContains() default {};

    /**
     * long包含的数值
     *
     * @return
     */
    long[] longContains() default {};


    /**
     * double包含的数值
     *
     * @return
     */
    double[] doubleContains() default {};

    /**
     * 是否检验手机号码
     *
     * @return
     */
    boolean checkMobile() default false;

    /**
     * 检测地址
     *
     * @return
     */
    boolean checkUrl() default false;

}
