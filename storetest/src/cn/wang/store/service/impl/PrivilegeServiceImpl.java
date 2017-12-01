package cn.wang.store.service.impl;

import cn.wang.store.dao.PrivilegeDao;
import cn.wang.store.dao.impl.PrivilegeDaoImpl;
import cn.wang.store.service.PrivilegeService;

/**
 * Created by 王 on 2017/12/1.
 */
public class PrivilegeServiceImpl implements PrivilegeService {
    private PrivilegeDao dao = new PrivilegeDaoImpl();
    @Override
    public <T> int addPrivelege(T t) {
        return dao.addPrivilege(t);
    }
}
