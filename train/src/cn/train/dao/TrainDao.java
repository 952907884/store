package cn.train.dao;

import cn.train.entity.Train;

import java.util.List;

/**
 * train增删改查
 * Created by 王 on 2017/11/27.
 */
public interface TrainDao {

    /**
     * 查找所有的班次
     * @return
     */
    List<Train> getAllTrain();

    /**
     * 根据班次号删除班次
     * @param trainId   班次号
     * @return
     */
    int delTrain(String[] trainId);

    /**
     * 根据班次号查找班次
     * @param no
     * @return
     */
    Train findTrain(String no);

    public int addTrain(Train train);
}
