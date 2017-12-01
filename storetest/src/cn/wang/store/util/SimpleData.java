package cn.wang.store.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 王 on 2017/11/30.
 */
public class SimpleData {

    public static String simpleDate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }
}
