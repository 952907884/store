package cn.wang.store.dao.impl;

import cn.wang.store.dao.BaseDao;
import cn.wang.store.dao.PrivilegeDao;

/**
 * Created by 王 on 2017/12/1.
 */
public class PrivilegeDaoImpl extends BaseDao implements PrivilegeDao {
    @Override
    public <T> int addPrivilege(T t) {
        return insert(t);
    }
}
