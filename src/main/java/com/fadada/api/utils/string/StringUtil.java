package com.fadada.api.utils.string;

/**
 * @author yanghui
 * @version 1.0.0
 * @ClassName StringUtil.java
 * @Description String工具类
 * @Param
 * @createTime 2020年07月29日 11:39:00
 */
public class StringUtil {
    private StringUtil() {
    }
    /**
     * @param value
     * @param length
     * @return
     */
    /**
     * @param value  邮件地址
     * @param length 长度
     * @return true 邮箱格式合法 false 邮箱格式不合法
     */
    public static boolean checkEmail(String value, int length) {
        return value.matches("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*") && value.length() <= length;
    }

    /**
     * 检查电话输入 是否正确 正确格 式 012-87654321、0123-87654321、0123－7654321
     *
     * @param value
     * @return
     */
    public static boolean checkTel(String value) {
        return value.matches("\\d{4}-\\d{8}|\\d{4}-\\d{7}|\\d(3)-\\d(8)");
    }

    /**
     * 检查手机输入 是否正确
     *
     * @param mobile
     * @return 校验通过返回true，否则返回false
     */
    public static boolean checkMobile(String mobile) {
        return mobile.matches("^[1][3,5,7,0,8,4,9,6]+\\d{9}");
    }


    /**
     * 检查字符串是 否含有HTML标签
     *
     * @param value
     * @return
     */

    public static boolean checkHtmlTag(String value) {
        return value.matches("<(\\S*?)[^>]*>.*?</\\1>|<.*? />");
    }

    /**
     * 检查URL是 否合法
     *
     * @param value
     * @return
     */
    public static boolean checkUrl(String value) {
        return value.matches("[a-zA-z]+://[^\\s]*");
    }

    /**
     * 检查IP是否 合法
     *
     * @param value
     * @return
     */
    public static boolean checkIp(String value) {
        return value.matches("\\d{1,3}+\\.\\d{1,3}+\\.\\d{1,3}+\\.\\d{1,3}");
    }


    /**
     * 检查邮编是否 合法
     *
     * @param value
     * @return
     */
    public static boolean checkPostCode(String value) {
        return value.matches("[1-9]\\d{5}(?!\\d)");
    }

    /**
     * 检查身份证是 否合法,15位或18位
     *
     * @param value
     * @return
     */
    public static boolean checkIdCard(String value) {
        return value.matches("\\d{15}|\\d{17}([0-9]|X|x)");
    }

    /**
     * 为空
     *
     * @param cs
     * @return
     */
    public static boolean isEmpty(CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

    /**
     * 不为空
     *
     * @param cs
     * @return
     */
    public static boolean isNotEmpty(CharSequence cs) {
        return !isEmpty(cs);
    }

    /**
     * 为null或者空
     *
     * @param cs
     * @return
     */
    public static boolean isBlank(CharSequence cs) {
        int strLen;
        if (cs != null && (strLen = cs.length()) != 0) {
            for (int i = 0; i < strLen; ++i) {
                if (!Character.isWhitespace(cs.charAt(i))) {
                    return false;
                }
            }

            return true;
        } else {
            return true;
        }
    }

    /**
     * 不为null或者空
     *
     * @param cs
     * @return
     */
    public static boolean isNotBlank(CharSequence cs) {
        return !isBlank(cs);
    }

    /**
     * 去除前后空格
     *
     * @param str
     * @return
     */
    public static String trim(String str) {
        return str == null ? null : str.trim();
    }

    /**
     * 去除空格后长度为0就返回null
     *
     * @param str
     * @return
     */
    public static String trimToNull(String str) {
        String ts = trim(str);
        return isEmpty(ts) ? null : ts;
    }

    /**
     * 去除空格，为null返回空字符串
     *
     * @param str
     * @return
     */
    public static String trimToEmpty(String str) {
        return str == null ? "" : str.trim();
    }

}
