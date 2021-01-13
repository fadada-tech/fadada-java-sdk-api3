package com.fadada.api.utils;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.exception.ApiException;
import com.fadada.api.utils.string.StringUtil;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;

/**
 * @author wuhao
 */
public class PreconditionsUtil {
    private PreconditionsUtil() {
    }

    private static final String NOT_NULL_FORMAT_STR = "%s 不能为空";
    private static final String ILLEGAL_STR = "%s 值非法";
    private static final String ILLEGAL_MIN_LENGTH_STR = "%s 长度不能小于%s";
    private static final String ILLEGAL_MAX_LENGTH_STR = "%s 长度不能大于%s";
    private static final String ILLEGAL_MIN_SIZE_STR = "%s 元素个数不能小于%s";
    private static final String ILLEGAL_MAX_SIZE_STR = "%s 元素个数不能大于%s";
    private static final String ILLEGAL_MIN_VALUE_STR = "%s 值不能小于%s";
    private static final String ILLEGAL_MAX_VALUE_STR = "%s 值不能大于%s";
    private static final String GET_VALUE_FAIL_STR = "参数%s获取值失败";
    private static final String REQUEST_OBJECT_NOT_NULL_STR = "请求对象为空";

    /**
     * 校验不为Null
     *
     * @param reference
     * @param errorMessage
     */
    public static void checkNotNull(Object reference, String errorMessage) {
        // 不校验
//        if (reference == null) {
//            throw new NullPointerException(errorMessage);
//        }
    }


    /**
     * 校验不为空
     *
     * @param reference
     * @param errorMessage
     */
    public static void checkNotEmpty(Object reference, String errorMessage) {
        checkNotNull(reference, errorMessage);
        boolean isReference = false;
        if (reference instanceof String) {
            String str = (String) reference;
            isReference = str.trim().length() == 0;
        } else if (reference instanceof Collection) {
            isReference = ((Collection) reference).isEmpty();
        }
        checkArgument(isReference, errorMessage);
    }

    /**
     * 校验布尔值
     *
     * @param expression
     * @param errorMessage
     */
    public static void checkArgument(boolean expression, String errorMessage) {
        // 不校验
//        if (expression) {
//            throw new IllegalArgumentException(errorMessage);
//        }
    }

    public static void checkObject(Object req) throws ApiException {
//        checkObject(req, REQUEST_OBJECT_NOT_NULL_STR);
    }

    public static void checkObject(Object req, String message) throws ApiException {
        checkNotNull(req, message);
        checkFields(req);
    }

    private static void checkFields(Object req) throws ApiException {
        if (req == null) {
            return;
        }
        Class<?> aClass = req.getClass();
        if (!aClass.isAnnotationPresent(ParamsVerif.class)) {
            return;
        }
        Field[] fields = aClass.getDeclaredFields();
        if (fields == null || fields.length == 0) {
            return;
        }
        for (Field field : fields) {
            ParamsVerif annotation = field.getAnnotation(ParamsVerif.class);
            if (annotation != null) {
                boolean checkNull = annotation.checkNotNull();
                boolean checkEmpty = annotation.checkNotEmpty();
                int maxLength = annotation.maxLength();
                boolean isMax = maxLength > 0;
                int minLength = annotation.minLength();
                boolean isMin = minLength > 0;
                int equalLength = annotation.equalLength();
                boolean isEqual = equalLength > 0;

                field.setAccessible(true);
                String fieldName = field.getName();
                Object object = null;
                try {
                    object = field.get(req);
                } catch (IllegalAccessException e) {
                    checkArgument(true, String.format(GET_VALUE_FAIL_STR, fieldName));
                }

                // 检查是否为null 和 空
                if (checkEmpty) {
                    checkNotEmpty(object, String.format(NOT_NULL_FORMAT_STR, fieldName));
                } else if (checkNull) {
                    checkNotNull(object, String.format(NOT_NULL_FORMAT_STR, fieldName));
                }

                // 不为空就校验里面的参数数据
                if (object != null) {
                    Class<?> type = field.getType();
                    Class<?>[] interfaces = type.getInterfaces();
                    HashSet<Class<?>> interfaceSet = new HashSet<>(Arrays.asList(interfaces));
                    Class<?> superclass = type.getSuperclass();

                    if (type.equals(String.class)) {
                        int length = object == null ? 0 : object.toString().length();
                        // 校验长度是不是小于最小值
                        checkArgument(isMin && length < minLength, String.format(ILLEGAL_MIN_LENGTH_STR, fieldName, minLength));
                        // 校验长度是不是大于最大值
                        checkArgument(isMax && length > maxLength, String.format(ILLEGAL_MAX_LENGTH_STR, fieldName, maxLength));

                        // 校验长度是否相等
                        checkArgument(isEqual && length != equalLength, String.format(ILLEGAL_STR, fieldName));
                        String str = (String) object;
                        String[] array = annotation.strContains();
                        if (array.length > 0) {
                            HashSet<String> stringHashSet = new HashSet<>(Arrays.asList(array));
                            // 是否包含值
                            checkArgument(!stringHashSet.contains(str), String.format(ILLEGAL_STR, fieldName));
                        }
                        // 电话号码校验
                        checkArgument(annotation.checkMobile() && !StringUtil.checkMobile(str),
                                String.format(ILLEGAL_STR, fieldName));
                        // 请求地址的校验
                        checkArgument(annotation.checkUrl() && !StringUtil.checkUrl(str), String.format(ILLEGAL_STR,
                                fieldName));
                    } else if (Number.class.equals(superclass)) {
                        Number number = (Number) object;
                        String minValue = annotation.minValue();
                        String maxValue = annotation.maxValue();
                        boolean isMinValue = !Objects.equals(minValue, "");
                        boolean isMaxValue = !Objects.equals(maxValue, "");
                        boolean checkMin = false;
                        boolean checkMax = false;
                        Set<Object> objectSet = new HashSet<>();
                        Object objectValue = null;
                        if (type.equals(Integer.class)) {
                            int intValue = number.intValue();
                            checkMin = isMinValue && intValue < Integer.valueOf(minValue);
                            checkMax = isMaxValue && intValue > Integer.valueOf(maxValue);
                            int[] ints = annotation.intContains();
                            for (int anInt : ints) {
                                objectSet.add(anInt);
                            }
                            objectValue = intValue;
                        } else if (type.equals(Long.class)) {
                            long longValue = number.longValue();
                            checkMin = isMinValue && longValue < Long.valueOf(minValue);
                            checkMax = isMaxValue && longValue > Long.valueOf(maxValue);
                            long[] longs = annotation.longContains();
                            for (long anLong : longs) {
                                objectSet.add(anLong);
                            }
                            objectValue = longValue;
                        } else if (type.equals(Double.class)) {
                            double doubleValue = number.doubleValue();
                            checkMin = isMinValue && doubleValue < Double.valueOf(minValue);
                            checkMax = isMaxValue && doubleValue > Double.valueOf(maxValue);
                            double[] doubles = annotation.doubleContains();
                            for (double aDouble : doubles) {
                                objectSet.add(aDouble);
                            }
                            objectValue = doubleValue;
                        }
                        // 校验是否小于最小值
                        checkArgument(checkMin, String.format(ILLEGAL_MIN_VALUE_STR, fieldName, minValue));
                        // 校验是否大于最大值
                        checkArgument(checkMax, String.format(ILLEGAL_MAX_VALUE_STR, fieldName, maxValue));
                        // 校验是否在固定的值里面
                        checkArgument(objectSet.size() > 0 && !objectSet.contains(objectValue),
                                String.format(ILLEGAL_STR,
                                        fieldName));
                    } else if (type.isAnnotationPresent(ParamsVerif.class)) {
                        // 如果是使用了NotNull注解的类进行里面参数校验
                        checkFields(object);
                    } else if (interfaceSet.contains(Collection.class)) {
                        // 当前集合的泛型类型
                        // 得到泛型里的class类型对象
                        Collection collection = (Collection) object;
                        int collectionSize = collection == null ? 0 : collection.size();
                        // 校验元素个数是否小于最小值
                        checkArgument(isMin && collectionSize < minLength, String.format(ILLEGAL_MIN_SIZE_STR, fieldName, minLength));
                        // 校验元素个数是否大于最大值
                        checkArgument(isMax && collectionSize > maxLength, String.format(ILLEGAL_MAX_SIZE_STR, fieldName, maxLength));
                        // 校验元素个数是否等于固定值
                        checkArgument(isEqual && collectionSize != equalLength, String.format(ILLEGAL_MAX_SIZE_STR, fieldName,
                                maxLength));
                        // 当个数大于0才获取泛型里面的对象进行校验
                        if (collectionSize == 0) {
                            continue;
                        }

                        // 得到泛型里的class类型对象
                        Type genericType = field.getGenericType();
                        ParameterizedType pt = (ParameterizedType) genericType;
                        Class<?> actualTypeArgument = (Class<?>) pt.getActualTypeArguments()[0];
                        if (actualTypeArgument.isAnnotationPresent(ParamsVerif.class)) {
                            for (Object genericObject : collection) {
                                checkFields(genericObject);
                            }
                        }
                    } else if (type.isArray()) {
                        // 数组判断
                        Object[] objects = (Object[]) object;
                        int arrayLength = objects == null ? 0 : objects.length;
                        checkArgument(isMin && arrayLength < minLength, String.format(ILLEGAL_MIN_SIZE_STR, fieldName, minLength));
                        // 校验元素个数是否大于最大值
                        checkArgument(isMax && arrayLength > maxLength, String.format(ILLEGAL_MAX_SIZE_STR, fieldName, maxLength));
                        // 校验元素个数是否等于固定值
                        checkArgument(isEqual && arrayLength != equalLength, String.format(ILLEGAL_MAX_SIZE_STR, fieldName,
                                maxLength));

                        Class<?> componentType = objects.getClass().getComponentType();
                        for (int i = 0; arrayLength > 0 && componentType.isAnnotationPresent(ParamsVerif.class) && i < objects.length; i++) {
                            checkFields(objects[i]);
                        }
                    }
                }
            }
        }
    }
}
