package cn.wang.store.dao;

import cn.wang.store.entity.User;

/**
 * 用户表的数据库操作
 * Created by 王 on 2017/11/26.
 */
public interface UserDao {

    /**
     * 查找用户的
     * @param user
     * @return
     */
    public User findUser(User user);

}
