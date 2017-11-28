package cn.wang.store.dao;

import cn.wang.store.entity.Page;
import cn.wang.store.entity.Product;

import java.util.List;

/**
 * Created by 王 on 2017/11/28.
 */
public interface ProductDao {
    public <T>Page getProductAll(Integer pageNum, String property, Class<T> clazz);
}
