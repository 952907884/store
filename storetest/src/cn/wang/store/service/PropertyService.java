package cn.wang.store.service;

import cn.wang.store.entity.Page;
import org.apache.poi.ss.formula.functions.T;

/**
 * Created by 王 on 2017/11/25.
 */
public interface PropertyService {

    <T>Page showProperty(String property, Integer pageNum,Class<T> clazz);

    /**
     * 修改属性信息
     * @param t
     * @param <T>
     * @return
     */
    <T>int modify(T t);
}
