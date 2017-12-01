package cn.working.dao;

import cn.working.entity.Working;

import java.util.List;

/**
 * Created by 王 on 2017/11/24.
 */
public interface WorkingMapper {

    /**
     * 获取所有的working对象
     * @return
     */
    public List<Working> getAllWorking();

    /**
     * 根据id获取working对象
     * @param id    working对象的id
     * @return
     */
    public Working getWorking(int id);

    /**
     * 添加working对象
     * @param working
     * @return
     */
    public int addWorking(Working working);


    public int delWorking(int id);

    /**
     * 修改working对象
     * @param working
     * @return
     */
    public int updateWorking(Working working);

}
