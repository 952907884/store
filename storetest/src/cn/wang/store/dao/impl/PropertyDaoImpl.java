package cn.wang.store.dao.impl;

import cn.wang.store.dao.BaseDao;
import cn.wang.store.dao.PropertyDao;
import cn.wang.store.entity.Page;
import cn.wang.store.util.FileClassNameUtil;

import java.lang.reflect.Field;

/**
 * 属性的增删改查方法
 * Created by 王 on 2017/11/25.
 */
public class PropertyDaoImpl extends BaseDao implements PropertyDao{

    /**
     *
     * @param t 添加商品属性的对象
     * @param <T>
     * @return
     */
    @Override
    public <T> int addProperty(T t) {
        int result = insert(t);
        return result;
    }

    @Override
    public <T> int quitProperty(T t) {
        return 0;
    }

    @Override
    public <T> int modifyProperty(T t) {
        return update(t);
    }

    @Override
    public <T> Page getPropertyPage( String property,Integer pageNum,Class<T> clazz) {
        Page<T> page = null;
        page = getPage(pageNum, property, clazz);
        return page;
    }
}
