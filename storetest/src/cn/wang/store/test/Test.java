package cn.wang.store.test;

import cn.wang.store.entity.Person;
import cn.wang.store.util.JavaBeanUtil;
import cn.wang.store.util.SimpleData;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by 王 on 2017/11/30.
 */
public class Test {
    public static void main(String[] args) {
       /* Map<String, String[]> map = new HashMap<String, String[]>();
        String[] a = {"123"};
        String[] b = {"12.12"};
        String[] c = {"2017-11-28 20:30:18"};
        map.put("age", a);
        map.put("money", b);
        map.put("birthday",c);

        Person p = JavaBeanUtil.populate(Person.class, map);
        System.out.println(p.toString());*/

        System.out.println(SimpleData.simpleDate(new Date()));
    }

    public static boolean typeof() {
        Map<String, String> map = new HashMap<String, String>();;
        String a = "123";
        String b = "12.12";
        map.put("a", a);
        map.put("b", b);
        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            //String key = (String) entry.getKey();
            Object obj = entry.getValue();
            if (obj instanceof String) {
                return true;
            }
        }
        return false;
    }

}

