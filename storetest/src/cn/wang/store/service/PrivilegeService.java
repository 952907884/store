package cn.wang.store.service;

/**
 * Created by 王 on 2017/12/1.
 */
public interface PrivilegeService {
    /**
     * 添加权限
     * @param t
     * @param <T>
     * @return
     */
    <T>int addPrivelege(T t);
}
