package store.entity;

import org.apache.poi.ss.formula.functions.T;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 王 on 2017/11/16.
 */
public class PageMsg {
    private static Map<String, Page> map = new HashMap<String, Page>();

    public static Page getPage(String property) {
        Page page = map.get(property);
        if (page == null) {
            page=new Page();
            map.put(property, page);
        }
        return page;
    }

    public static void setPage(String property , Page page) {
        map.put(property, page);
    }
}
