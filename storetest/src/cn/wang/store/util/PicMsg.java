package cn.wang.store.util;

import java.io.File;
import java.net.URISyntaxException;

/**
 * Created by 王 on 2017/11/28.
 */
public class PicMsg {

    public static String picPath(String picName) {
        String path=null;
        String abs = "images";
        path = abs +"\\"+picName;
        return path;
    }
}
