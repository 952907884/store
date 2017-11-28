package cn.wang.store.dao.impl;

import cn.wang.store.dao.BaseDao;
import cn.wang.store.dao.ProductDao;
import cn.wang.store.entity.Page;
import cn.wang.store.entity.Product;

import java.util.List;

/**
 * Created by 王 on 2017/11/28.
 */
public class ProductDaoImpl extends BaseDao implements ProductDao {

    @Override
    public <T>Page getProductAll(Integer pageNum, String property, Class<T> clazz) {
        Page<T> page= null;
        page = getPage(pageNum,property,clazz);
        return page;
    }
}
