package com.fadada.api.utils.date;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author jcf
 * @Description:日期处理函数
 * @Copyright: 深圳法大大网络科技有限公司 (c)2016
 * @Created Date : 2016-3-16
 * @vesion 2.0
 */
public class DateUtil {
    private static final Logger log = LoggerFactory.getLogger(DateUtil.class);

    private DateUtil() {
    }


    /**
     * <b>概要：</b> 将指定格式的时间String转为Date类型 <b>作者：</b>SUXH </br>
     * <b>日期：</b>2015-5-20 </br>
     *
     * @param dateStr 待转换的时间String
     * @param pattern 转换的类型
     * @return 字符串转换成Date类型数据
     */
    public static Date convertStringToDate(String dateStr, String pattern) {
        if (dateStr == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            log.error("将指定格式的时间String转为Date类型发生异常", e);
        }
        return date;
    }

    /**
     * 实例SimpleDateFormat
     *
     * @param formatNum 1 yyyyMMdd
     *                  2 yyyy/MM/dd
     *                  3 yyyy-MM-dd
     *                  4 yyyy-MM-dd HH:mm:ss
     *                  5 yyyyMMddHHmmss
     *                  6 yyyy-MM-dd HH:mm:ss.sss
     *                  7 HH:mm
     *                  8 yyyy年MM月dd日
     *                  9 yyyyMMddHHmmssSSS
     *                  10 yyyy年MM月dd日 HH:mm
     *                  11 yyyy-MM-dd HH
     *                  12 HH:mm:ss
     *                  13 yyyy/MM/dd HH:mm:ss
     *                  14 yyyy-MM-dd'T'HH:mm:ss+08:00
     *                  15 yyyy-MM-dd HH:mm
     *                  16 yyyyMM
     *                  17 yyyy年MM月dd日hh时mm分
     *                  18 yyyy/MM/ddHH:mm:ss
     * @return
     */
    private static SimpleDateFormat dateFormat(int formatNum) {
        SimpleDateFormat dateFormatter = null;
        switch (formatNum) {
            case 1:
                dateFormatter = new SimpleDateFormat("yyyyMMdd");
                break;
            case 2:
                dateFormatter = new SimpleDateFormat("yyyy/MM/dd");
                break;
            case 3:
                dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
                break;
            case 4:
                dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                break;
            case 5:
                dateFormatter = new SimpleDateFormat("yyyyMMddHHmmss");
                break;
            case 6:
                dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.sss");
                break;
            case 7:
                dateFormatter = new SimpleDateFormat("HH:mm");
                break;
            case 8:
                dateFormatter = new SimpleDateFormat("yyyy年MM月dd日");
                break;
            case 9:
                dateFormatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");
                break;
            case 10:
                dateFormatter = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
                break;
            case 11:
                dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH");
                break;
            case 12:
                dateFormatter = new SimpleDateFormat("HH:mm:ss");
                break;
            case 13:
                dateFormatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                break;
            case 14:
                dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss+08:00");
                break;
            case 15:
                dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                break;
            case 16:
                dateFormatter = new SimpleDateFormat("yyyyMM");
                break;
            case 17:
                dateFormatter = new SimpleDateFormat("yyyy年MM月dd日HH时mm分");
                break;
            case 18:
                dateFormatter = new SimpleDateFormat("yyyy/MM/ddHH:mm:ss");
                break;
            default:
                dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                break;
        }
        return dateFormatter;
    }

    /**
     * 把string类型的日期转化为相应的格式
     *
     * @param dateString 字符串日期
     * @param formatNum  需要按照哪种类型
     *                   1 yyyyMMdd
     *                   2 yyyy/MM/dd
     *                   3 yyyy-MM-dd
     *                   4 yyyy-MM-dd HH:mm:ss
     *                   5 yyyyMMddHHmmss
     *                   6 yyyy-MM-dd HH:mm:ss.sss
     *                   7 HH:mm
     *                   8 yyyy年MM月dd日
     *                   9 yyyyMMddHHmmssSSS
     *                   10 yyyy年MM月dd日 HH:mm
     *                   11 yyyy-MM-dd HH
     *                   12 HH:mm:ss
     *                   13 yyyy/MM/dd HH:mm:ss
     *                   14 yyyy-MM-dd'T'HH:mm:ss+08:00
     *                   15 yyyy-MM-dd HH:mm
     *                   16 yyyyMM
     *                   17 yyyy年MM月dd日hh时mm分
     *                   18 yyyy/MM/ddHH:mm:ss
     * @return
     */
    public static Date stringToDate(String dateString, int formatNum) {
        if (dateString == null || dateString.length() == 0) {
            throw new IllegalArgumentException("日期字符串为空");
        }
        try {
            return dateFormat(formatNum).parse(dateString);
        } catch (Exception e) {
            log.error("把string类型的日期转化为相应的格式发生异常", e);
            return null;
        }
    }

    /**
     * @param dateString 字符串日期
     * @param formatNum  需要按照哪种类型
     *                   1 yyyyMMdd
     *                   2 yyyy/MM/dd
     *                   3 yyyy-MM-dd
     *                   4 yyyy-MM-dd HH:mm:ss
     *                   5 yyyyMMddHHmmss
     *                   6 yyyy-MM-dd HH:mm:ss.sss
     *                   7 HH:mm
     *                   8 yyyy年MM月dd日
     *                   9 yyyyMMddHHmmssSSS
     *                   10 yyyy年MM月dd日 HH:mm
     *                   11 yyyy-MM-dd HH
     *                   12 HH:mm:ss
     *                   13 yyyy/MM/dd HH:mm:ss
     *                   14 yyyy-MM-dd'T'HH:mm:ss+08:00
     *                   15 yyyy-MM-dd HH:mm
     *                   16 yyyyMM
     *                   17 yyyy年MM月dd日hh时mm分
     *                   18 yyyy/MM/ddHH:mm:ss
     */
    public static Timestamp stringToTimestamp(String dateString, int formatNum) {
        if (dateString == null || dateString.length() == 0) {
            throw new IllegalArgumentException("日期字符串为空");
        }
        Date date = stringToDate(dateString, formatNum);
        if (date != null) {
            return new Timestamp(date.getTime());
        }
        return null;
    }

    /**
     * @param time      字符串日期
     * @param formatNum 需要按照哪种类型
     *                  1 yyyyMMdd
     *                  2 yyyy/MM/dd
     *                  3 yyyy-MM-dd
     *                  4 yyyy-MM-dd HH:mm:ss
     *                  5 yyyyMMddHHmmss
     *                  6 yyyy-MM-dd HH:mm:ss.sss
     *                  7 HH:mm
     *                  8 yyyy年MM月dd日
     *                  9 yyyyMMddHHmmssSSS
     *                  10 yyyy年MM月dd日 HH:mm
     *                  11 yyyy-MM-dd HH
     *                  12 HH:mm:ss
     *                  13 yyyy/MM/dd HH:mm:ss
     *                  14 yyyy-MM-dd'T'HH:mm:ss+08:00
     *                  15 yyyy-MM-dd HH:mm
     *                  16 yyyyMM
     *                  17 yyyy年MM月dd日hh时mm分
     *                  18 yyyy/MM/ddHH:mm:ss
     */
    public static String timestamp2String(Timestamp time, int formatNum) {
        if (time != null) {
            Date date = time;
            return dateToString(date, formatNum);
        }
        return null;
    }

    /**
     * 把string类型的日期转化为相应的格式
     *
     * @param date      字符串日期
     * @param formatNum 1 yyyyMMdd
     *                  2 yyyy/MM/dd
     *                  3 yyyy-MM-dd
     *                  4 yyyy-MM-dd HH:mm:ss
     *                  5 yyyyMMddHHmmss
     *                  6 yyyy-MM-dd HH:mm:ss.sss
     *                  7 HH:mm
     *                  8 yyyy年MM月dd日
     *                  9 yyyyMMddHHmmssSSS
     *                  10 yyyy年MM月dd日 HH:mm
     *                  11 yyyy-MM-dd HH
     *                  12 HH:mm:ss
     *                  14 yyyy-MM-ddTHH:mm:ss+08:00
     *                  15 yyyy-MM-dd HH:mm
     *                  16 yyyyMM
     *                  17 yyyy年MM月dd日hh时mm分
     *                  18 yyyy/MM/ddHH:mm:ss
     * @return
     */
    public static String dateToString(Date date, int formatNum) {
        String str = null;
        if (date != null) {
            str = dateFormat(formatNum).format(date);
        }
        return str;
    }

}
