package store.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import store.dao.BaseDao;
import store.dao.ProductDao;
import store.entity.*;
import store.utils.Factory;
import store.utils.FileClassNameUtil;
import store.utils.JdbcUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



/**
 * Created by 王 on 2017/11/7.
 */
public class ProductDaoImpl extends BaseDao implements ProductDao {


    public <T> List<T> getProperty(Class<?> T, String property) {
        String sql="SELECT * FROM "+property +"  LIMIT 1,10";
        QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
        List<T> list=new ArrayList<>();
        try {
            list=runner.query(sql,new BeanListHandler<T>((Class<T>) T));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  list;

    }

    @Override
    public boolean disableProperty(String property, int id) {
        return false;
    }

    @Override
    public void addProperty(String property, Object obj) {

    }

    @Override
    public int alterProperty(String property, Object obj) {
        return 0;
    }

    @Override
    public List<Category> getCategory(String sql,QueryRunner runner) {
        List<Category> list=new ArrayList<Category>();
        try {
            list= runner.query(sql,new BeanListHandler<Category>(Category.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Subclass> getSubclass(String sql, QueryRunner runner) {
        List<Subclass> list=new ArrayList<Subclass>();
        try {
            list= runner.query(sql,new BeanListHandler<Subclass>(Subclass.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Clothingband> getClothingband(String sql, QueryRunner runner) {
        List<Clothingband> list=new ArrayList<Clothingband>();
        try {
            list= runner.query(sql,new BeanListHandler<Clothingband>(Clothingband.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Color> getColor(String sql, QueryRunner runner) {

        List<Color> list=new ArrayList<Color>();
        try {
            list= runner.query(sql,new BeanListHandler<Color>(Color.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static <T>List<T> aaa(Class<T> T,String property) throws ClassNotFoundException {
        String sql="SELECT * FROM "+property;
        QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
        List<T> list=new ArrayList<>();
        try {
            list=runner.query(sql,new BeanListHandler<T>(T));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  list;
    }

    @Override
    public List<Size> getSize(String sql, QueryRunner runner) {
        List<Size> list=new ArrayList<Size>();
        try {
            list= runner.query(sql,new BeanListHandler<Size>(Size.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Theme> getTheme(String sql, QueryRunner runner) {
        List<Theme> list=new ArrayList<Theme>();
        try {
            list= runner.query(sql,new BeanListHandler<Theme>(Theme.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Series> getSeries(String sql, QueryRunner runner) {
        List<Series> list=new ArrayList<Series>();
        try {
            list= runner.query(sql,new BeanListHandler<Series>(Series.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Product> findALLProduct() {
        return null;
    }

    @Override
    public Product findProductById(String id) {
        return null;
    }

    @Override
    public int addProduct(Product product) {
        return 0;
    }

    @Override
    public boolean disableProduct(int id) {
        return false;
    }

    @Override
    public boolean alterProduct(Product product) {
        return false;
    }

    @Override
    public <T>Page getTest(Page page, String property, Class<?> clazz) {
        int pageNum = (page.getPageNum() - 1) * page.getCurrentPage() == 0 ? 1 : (page.getPageNum() - 1) * page.getCurrentPage();
        String sql="SELECT * FROM "+property +"  LIMIT "+pageNum+","+page.getCurrentPage();
        int totalCount=getTotalCount(property);
        QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
        List<T> list=new ArrayList<>();
        try {
            list=runner.query(sql,new BeanListHandler<T>((Class<T>) clazz));
            page.setTotalCount(totalCount); //设置总条数
            page.setTotalPage((int) Math.ceil((double) totalCount/page.getCurrentPage()));
            page.setData(list);
            PageMsg.setPage(property, page);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return page;
    }

    public int getTotalCount(String property){
        String sql="SELECT count(*) FROM "+property ;
        Connection conn=JdbcUtil.getConnection();
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        int result=-1;
        try {
            pstmt = conn.prepareStatement(sql);
            rs=pstmt.executeQuery();
            if (rs.next()) {
                result = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
