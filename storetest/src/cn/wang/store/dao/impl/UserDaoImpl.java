package cn.wang.store.dao.impl;

import cn.wang.store.dao.BaseDao;
import cn.wang.store.dao.UserDao;
import cn.wang.store.entity.User;
import cn.wang.store.util.JdbcUtil;
import cn.wang.store.util.Md5Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * Created by 王 on 2017/11/26.
 */
public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User findUser(User user) {
        String sql = "SELECT * FROM `user` WHERE userAccount = ? AND `password` = ?";
//        User u = selectOne(sql, User.class, user.getUserAccount(), Md5Util.md5(user.getPassword()));
        QueryRunner r = new QueryRunner(JdbcUtil.getDataSource());
        User u = null;
        try {
            System.out.println(Md5Util.md5(user.getPassword()));
            u = r.query(sql,new BeanHandler<User>(User.class),user.getUserAccount(), Md5Util.md5(user.getPassword()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }
}
