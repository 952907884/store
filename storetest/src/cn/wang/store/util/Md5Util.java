package cn.wang.store.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by 王 on 2017/11/26.
 */
public class Md5Util {

    public static String md5(String text) {
        byte[] temp=null;
        try {
            temp = MessageDigest.getInstance("md5").digest(text.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("没有这个算法");
        }
        String md5code = new BigInteger(1, temp).toString(16);
        for (int i = 0 ; i < 32-md5code.length() ; i++) {
            md5code = "0"+md5code;
        }
        return md5code;
    }


}
