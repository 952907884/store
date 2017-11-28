package cn.wang.store.util;

import java.io.File;

/**
 * Created by 王 on 2017/11/28.
 */
public class FileName {
    public static void main(String[] args) {
        System.out.println(PicMsg.picPath("1JH4022360090"));
    }

    public static void readFileName() {
        String filePath = "C:\\Users\\王\\Desktop\\欧时力\\images";
        File file = new File(filePath);
        File[] files = file.listFiles();
        for (int i = 0 ; i<files.length ; i++) {
            if (files[i].isDirectory()) {
                System.out.println(files[i].getName() + "是一个目录");
            } else {
                System.out.println(files[i].getName());
            }
        }
    }
}
