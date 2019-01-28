package com.utilsClass;

import org.apache.http.util.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RexUtil {


    public static boolean isNumber(String args) {
        if (!TextUtils.isEmpty(args)) {
            //配置字符串：百度为您找到相关结果约4,570,000个  ^[1-9]\d{5}$
            Pattern pattern = Pattern.compile("[0-9]\\d*");
            Matcher matcher = pattern.matcher(args);
            //若匹配成功,返回true
            return matcher.matches();
        } else {
            return false;
        }
    }

    }