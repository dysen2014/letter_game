package com.dysen.games.base_recycler_adapter;

import android.text.TextUtils;

import androidx.annotation.NonNull;


/**
 * @email dy.sen@qq.com
 * created by dysen on 2018/9/19 - 上午10:38
 * @info
 */
public class StringUtils {
    /**
     * 获取非空的text
     */
    public static String obtainNoNullText(String content) {
        return obtainNoNullText(content, "");
    }

    /**
     * 获取非空的text，null或者empty时候可以设置默认值
     * 对content, defaultContent都进行判空操作
     */
    public static String obtainNoNullText(String content, @NonNull String defaultContent) {
        return !TextUtils.isEmpty(content) ? content
                : (!TextUtils.isEmpty(defaultContent) ? defaultContent : "");
    }


    public static String rePlaceStr(String content) {
        return content.replace("00:00:00", "");
    }

}
