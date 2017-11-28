package cn.wang.store.util;

import cn.wang.store.dao.impl.ExtImpl;
import cn.wang.store.entity.Ext;
import cn.wang.store.entity.Page;

import java.io.File;
import java.util.List;

/**
 * Created by 王 on 2017/11/28.
 */
public class FileName {
    public static void main(String[] args) {
        ExtImpl e = new ExtImpl();
        Page<Ext> page = e.getData(1, 20);
        List<Ext> list = page.getData();
        for (Ext ext : list) {
            System.out.println(ext.getMap());
        }
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
