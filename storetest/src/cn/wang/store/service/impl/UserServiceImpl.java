package cn.wang.store.service.impl;

import cn.wang.store.dao.UserDao;
import cn.wang.store.dao.impl.UserDaoImpl;
import cn.wang.store.entity.User;
import cn.wang.store.service.UserService;

/**
 * Created by 王 on 2017/11/26.
 */
public class UserServiceImpl implements UserService {
    UserDao dao = new UserDaoImpl();
    @Override
    public User login(User user) {
        return dao.findUser(user);
    }

}
