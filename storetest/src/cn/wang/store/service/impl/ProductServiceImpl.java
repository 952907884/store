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
    ProductDaoImpl dao = new ProductDaoImpl();
    @Override
    public <T> Page findAllProduct(String property, Integer pageNum, Class<T> clazz) {
        return dao.getProductAll(pageNum, property, clazz);

    }

    @Override
    public Page findProductPage( int pageNum, int currentPage) {
        String sql = "SELECT p.productId,p.productName,p.unit,p.tagprice,p.costprice,c.categoryName,sc.subclassesName,b.bandName,t.themename,s.seriesname,p.year,p.quarter,p.status,p.picpath,p.createdBy,p.createdate,p.modifyby,p.modifydate FROM product p LEFT JOIN `band` b ON p.bandID =b.bandid LEFT JOIN `category` c ON c.categoryid = p.categoryid LEFT JOIN `series` s ON p.seriesid = s.seriesid LEFT JOIN `subclasses`  sc ON sc.subClassesId = p.subClassesId  LEFT JOIN `theme` t ON t.themeid = p.themeid ";
        return dao.getExtPage(sql ,pageNum , currentPage);
    }
}
