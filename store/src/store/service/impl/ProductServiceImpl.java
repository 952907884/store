package store.service.impl;

import store.dao.ProductDao;
import store.dao.impl.ProductDaoHandler;
import store.dao.impl.ProductDaoImpl;
import store.entity.ExtProperty;
import store.entity.Page;
import store.service.ProductService;
import store.utils.FileClassNameUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 王 on 2017/11/7.
 */
public class ProductServiceImpl implements ProductService{
    ProductDao dao=new ProductDaoImpl();

    @Override
    public List showProperty(String property) {
        Class<?> clazz = null;
        try {
            clazz = Class.forName(FileClassNameUtil.getClassName(property));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return dao.getProperty(clazz,property);
    }


    public Page showExtProperty(Page page) {

        return null;
    }

    @Override
    public Page showTest(Page page, String property) {
        Class<?> clazz = null;
        try {
            clazz = Class.forName(FileClassNameUtil.getClassName(property));
            page= dao.getTest(page, property, clazz);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return page;
    }
}
