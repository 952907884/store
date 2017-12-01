package cn.wang.store.service;

import cn.wang.store.entity.Page;

/**
 * Created by 王 on 2017/11/28.
 */
public interface ProductService {

    public <T> Page findAllProduct(String property, Integer pageNum,Class<T> clazz);

    public Page findProductPage( int pageNum, int currentPage);
}
