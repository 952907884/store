package store.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import store.dao.ProductDao;
import store.utils.JdbcUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by 王 on 2017/11/9.
 */
public class ProductDaoHandler implements InvocationHandler{
    private ProductDao dao;

    public ProductDaoHandler(ProductDao dao) {
        this.dao = dao;
    }

    private String getMethodName(String m){
        return "get"+m.substring(0,1).toUpperCase()+m.substring(1);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        /*for (Object obj : args) {
            if (obj instanceof String) {
                if ("Category".equalsIgnoreCase((String) obj)) {
                    result = dao.getCategory();
                }
            }
        }*/
        Object result = null;
        if(method.getName().equalsIgnoreCase("getProperty")){
            for (Object obj : args) {
                if (obj instanceof String) {
                    String sql="SELECT * FROM "+obj;
                    String methodName= getMethodName((String) obj);
                    Method m=dao.getClass().getDeclaredMethod(methodName,String.class,QueryRunner.class);
                    QueryRunner runner =new QueryRunner(JdbcUtil.getDataSource());
                    result=m.invoke(dao,sql,runner);
                }
            }
        }else {
            result = method.invoke(dao,args);
        }
        return result;
    }

    public Object getProductDaoProxy(){
        return  Proxy.newProxyInstance(dao.getClass().getClassLoader(),dao.getClass().getInterfaces(),this);
    }

}
