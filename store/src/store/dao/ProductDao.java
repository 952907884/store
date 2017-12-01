package store.dao;


import org.apache.commons.dbutils.QueryRunner;
import store.entity.*;

import java.util.List;

/**
 * Created by 王 on 2017/11/7.
 */
public interface ProductDao {
    /**
     * 添加商品分类信息（大类，小类，波段等）
     * @param    T
     * @return  返回类型集合
     */
    public <T>List<T> getProperty(Class<?> T,String property);

    /**
     * 停止使用商品类别
     * @param id
     * @return
     */
    public boolean disableProperty(String property ,int id);

    /**
     * 添加商品类别
     * @param property  商品类别名称
     * @param obj 商品类别对象
     */
    public void addProperty(String property,Object obj);

    /**
     * 修改商品类别
     * @param property  商品类别名称
     * @param obj   商品类别对象
     * @return  返回受影响的数量，修改失败返回-1
     */
    public int alterProperty(String property,Object obj);

    /**
     * 查找所有的大类
     * @return
     */
    public List<Category> getCategory(String sql, QueryRunner runner);

    /**
     * 查找所有的小类
     * @return
     */
    public List<Subclass> getSubclass(String sql, QueryRunner runner);

    /**
     * 查找所有的波段
     * @return
     */
    public List<Clothingband> getClothingband(String sql, QueryRunner runner);

    /**
     * 查找所有的颜色
     * @return
     */
    public List<Color> getColor(String sql, QueryRunner runner);

    /**
     * 获取所有的尺码类
     * @return
     */
    public List<Size> getSize(String sql, QueryRunner runner);

    /**
     * 获取所有的主题类
     * @return
     */
    public List<Theme> getTheme(String sql, QueryRunner runner);

    /**
     * 获取所有系类主题
     * @return
     */
    public List<Series> getSeries(String sql, QueryRunner runner);






    /**
     * 获取到所有的商品类
     * @return  商品类集合
     */
    public List<Product> findALLProduct();

    /**
     * 通过商品编号id获取商品类
     * @param id    商品编号
     * @return  商品类
     */
    public Product findProductById(String id);

    /**
     * 添加商品
     * @param product   商品类
     * @return  添加成功返回受影响的行数，添加失败返回-1；
     */
    public int addProduct(Product product);

    /**
     * 停止使用商品
     * @param id    商品id
     * @return  停用成功返回true，失败返回false
     */
    public boolean disableProduct(int id);

    /**
     * 修改商品类
     * @param product   商品对象
     * @return  修改成功返回true，修改失败返回false
     */
    public boolean alterProduct(Product product);


    <T>Page getTest(Page page, String property, Class<?> clazz);
}
