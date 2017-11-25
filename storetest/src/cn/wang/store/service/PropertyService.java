package cn.wang.store.service;

import cn.wang.store.entity.Page;

/**
 * Created by 王 on 2017/11/25.
 */
public interface PropertyService {

    <T>Page showProperty(String property, Integer pageNum,Class<T> clazz);

}
