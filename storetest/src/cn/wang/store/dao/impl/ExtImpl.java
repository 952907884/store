package cn.wang.store.dao.impl;

import cn.wang.store.dao.BaseDao;
import cn.wang.store.entity.Ext;
import cn.wang.store.entity.Page;
import cn.wang.store.util.JdbcUtil;

import java.sql.*;
import java.util.List;
import java.util.Map;

/**
 * Created by 王 on 2017/11/28.
 */
public class ExtImpl extends BaseDao {

    public Page getData(Integer pageNum,Integer currentPage){
        Connection conn = JdbcUtil.getConnection();
        PreparedStatement pstmt=null;
        ResultSet rs = null ;
        Page<Ext> page = new Page();
        page.setPageNum(pageNum);
        page.setCurrentPage(currentPage);
        String sql ="SELECT p.productId,p.productName,p.unit,p.tagprice,p.costprice,c.categoryName,sc.subclassesName,b.bandName,t.themename,s.seriesname,p.year,p.quarter,p.status,p.picpath,p.createdBy,p.createdate,p.modifyby,p.modifydate FROM product p LEFT JOIN `band` b ON p.bandID =b.bandid LEFT JOIN `category` c ON c.categoryid = p.categoryid LEFT JOIN `series` s ON p.seriesid = s.seriesid LEFT JOIN `subclasses`  sc ON sc.subClassesId = p.subClassesId  LEFT JOIN `theme` t ON t.themeid = p.themeid  LIMIT "+((pageNum-1)*currentPage)+","+currentPage;
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            ResultSetMetaData meta = rs.getMetaData();
            int columnCount = meta.getColumnCount();
            while (rs.next()) {
                Ext ext = new Ext();
                Map<String,Object> map = ext.getMap();
                for (int i = 0 ; i<columnCount ; i ++) {
                    String columnName = meta.getColumnName(i + 1);
                    map.put(columnName, rs.getObject(i + 1));
                }
                page.getData().add(ext);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return page;
    }
}
