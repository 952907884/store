package store.service;

import store.entity.ExtProperty;
import store.entity.Page;

import java.util.List;

/**
 * Created by 王 on 2017/11/7.
 */
public interface ProductService {
    /**
     * 通过商品类别名称获取所有的商品类别
     * @param property  商品类别名称
     * @return
     */
    List showProperty(String property);


    /**
     * 
     * @param page
     * @return
     */
    public Page showExtProperty(Page page);

    Page showTest(Page page, String property);
}
