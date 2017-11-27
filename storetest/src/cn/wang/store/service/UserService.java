package cn.wang.store.service;

import cn.wang.store.dao.UserDao;
import cn.wang.store.dao.impl.UserDaoImpl;
import cn.wang.store.entity.User;

/**
 * Created by 王 on 2017/11/26.
 */
public interface UserService {

    public User login(User user);
}
