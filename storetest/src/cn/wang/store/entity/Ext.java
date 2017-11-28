package cn.wang.store.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 王 on 2017/11/28.
 */
public class Ext {
    Map<String, Object> map = new HashMap<String, Object>();

    public Ext(){}


    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public void print() {
        for (String key : map.keySet()) {
            System.out.println(key + "——" + map.get(key));
        }
    }
}
