package cn.wang.store.service.impl;

import cn.wang.store.dao.PropertyDao;
import cn.wang.store.dao.impl.PropertyDaoImpl;
import cn.wang.store.entity.Page;
import cn.wang.store.service.PropertyService;
import org.apache.poi.ss.formula.functions.T;

/**
 * Created by 王 on 2017/11/25.
 */
public class PropertyServiceImple implements PropertyService {
    PropertyDao dao = new PropertyDaoImpl();
    @Override
    public <T>Page showProperty(String property, Integer pageNum,Class<T> clazz) {
        return dao.getPropertyPage(property,pageNum,clazz);
    }
}
