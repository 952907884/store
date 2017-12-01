package cn.wang.store.dao;

/**
 * Created by 王 on 2017/12/1.
 */
public interface PrivilegeDao {

    /**
     * 添加权限
     * @param t
     * @param <T>
     * @return
     */
    <T>int addPrivilege(T t);
}
