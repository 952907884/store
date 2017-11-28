package cn.wang.store.service.impl;

import cn.wang.store.dao.ProductDao;
import cn.wang.store.dao.impl.ProductDaoImpl;
import cn.wang.store.entity.Page;
import cn.wang.store.entity.Product;
import cn.wang.store.service.ProductService;

/**
 * Created by 王 on 2017/11/28.
 */
public class ProductServiceImpl implements ProductService {
    ProductDao dao = new ProductDaoImpl();
    @Override
    public <T> Page findAllProduct(String property, Integer pageNum, Class<T> clazz) {
        return dao.getProductAll(pageNum, property, clazz);

    }
}
