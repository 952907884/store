package cn.train.dao.impl;

import cn.train.dao.TrainDao;
import cn.train.entity.Train;
import cn.train.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by 王 on 2017/11/27.
 */
public class TrainDaoImpl implements TrainDao{

    @Override
    public List<Train> getAllTrain() {
        String sql = "SELECT * FROM train_info ";
        List<Train> trains=null;
        QueryRunner r = new QueryRunner(JdbcUtil.getDataSource());
        try {
            trains = r.query(sql, new BeanListHandler<Train>(Train.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trains;
    }

    @Override
    public int delTrain(String[] trainId) {
        String sql = "DELETE FROM train_info WHERE train_no=?";
        QueryRunner r = new QueryRunner(JdbcUtil.getDataSource());
        int resutl=0;
        for (int i =0 ; i<trainId.length ; i++) {
            try {
                r.update(sql, trainId[i]);
                resutl++;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return resutl;
    }

    @Override
    public Train findTrain(String no) {
        String sql = "SELECT * FROM train_info where train_no= ?";
        Train train = null;
        QueryRunner r = new QueryRunner(JdbcUtil.getDataSource());
        try {
            train = r.query(sql, new BeanHandler<Train>(Train.class), no);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return train;
    }

    public int addTrain(Train train) {
        String sql = "INSERT INTO train_info(`train_no`,`start_station`,`arrival_station`,`start_time`,`arrival_time`,`type`,`runtime`,`mile`)VALUES(?,?,?,?,?,?,?,?)";
        QueryRunner r = new QueryRunner(JdbcUtil.getDataSource());
        int result = 0;
        try {
            result = r.update(sql,train.getTrain_no(),train.getStart_station(), train.getArrival_station(), train.getStart_time(), train.getArrival_time(), train.getType(), train.getRuntime(), train.getMile());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
