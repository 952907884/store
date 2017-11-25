package cn.wang.store.dao;

import cn.wang.store.entity.Page;

/**
 * Created by 王 on 2017/11/25.
 */
public interface PropertyDao {

    /**
     * 添加商品属性（大类，小类等）
     * @param t 添加商品属性的对象
     * @param <T>
     * @return
     */
    public <T>int addProperty(T t);

    /**
     * 停止使用改商品属性
     * @param t 商品属性对象
     * @param <T>
     * @return
     */
    public <T>int quitProperty(T t);

    /**
     * 修改商品属性
     * @param t
     * @param <T>
     * @return
     */
    public <T>int modifyProperty(T t);

    /**
     * 查找属性，返回一个page对象
     * @param <T>
     * @return
     */
    public <T>Page getPropertyPage(String property,Integer pageNum,Class<T> clazz);



    }
