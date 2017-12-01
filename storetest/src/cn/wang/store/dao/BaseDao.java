package cn.wang.store.dao;



import cn.wang.store.entity.Ext;
import cn.wang.store.entity.Page;
import cn.wang.store.util.JdbcUtil;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 王 on 2017/11/9.
 */
public class BaseDao {

    /**
     * 执行增删改的SQL语句
     * @param sql 需要执行的SQL语句
     * @param objs 参数列表
     * @return 受影响的行数
     */
    public int runNonQuerySQL(String sql,Object[] objs){
        int count = -1;
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JdbcUtil.getConnection();
            pstmt = conn.prepareStatement(sql);//预编译SQL语句
            //循环赋参数
            if(objs!=null){
                for (int i = 0; i < objs.length; i++) {
                    pstmt.setObject((i+1), objs[i]);
                }
            }
            //执行SQL语句
            count = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return count;
    }

    public static String getSetter(String fieldName){
        //传入属性名 拼接set方法
        return "set"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);

    }

    /**
     * 查询方法
     * @param sql 查询SQL语句
     * @param params 查询参数条件
     * @param T 查询的实体类
     * @return 该类型的列表
     */
    public <T>List<T> queryList(String sql,Class<T> T,Object... params){
        //Class clazz=t.getClass();
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<T> list=new ArrayList<T>();
        try {
            conn=JdbcUtil.getConnection();
            ps=conn.prepareStatement(sql);
            //传参数
            if(params!=null&& params.length>0){
                for(int i=0;i<params.length;i++){
                    ps.setObject(i+1, params[i]);
                }
            }
            rs=ps.executeQuery();
            ResultSetMetaData metaData=rs.getMetaData();//读取该SQL语句返回的列
            int count=metaData.getColumnCount();//得到SQL语句返回的列数
            while(rs.next()){
                //T temp=(T)clazz.newInstance();//动态生成T的对象
                T temp=T.newInstance();//动态生成T的对象
                for(int i=0;i<count;i++){
                    String fieldName=metaData.getColumnName(i+1);
                    Field field=T.getDeclaredField(fieldName);
                    Method method=T.getMethod(getSetter(fieldName), field.getType());
                    method.invoke(temp, rs.getObject(i+1));
                }
                list.add(temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            JdbcUtil.closeAll(conn, ps, rs);
        }
        return list;
    }

    public <T>T selectOne(String sql,Class<T> T,Object... params){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        T temp=null;
        try {
            conn = JdbcUtil.getConnection();
            pstmt = conn.prepareStatement(sql);
            if (params != null) {
                for (int i = 0 ; i <params.length ; i++) {
                    pstmt.setObject(i+1,params[i]);
                }
            }
            rs = pstmt.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            int count = metaData.getColumnCount();
            temp = T.newInstance();
            for (int i = 0 ; i<count ; i++) {
                String columnName = metaData.getColumnName(i+1);
                Field field = T.getField(columnName);
                String methodName = getSetter(field.getName());
                Method method = T.getMethod(methodName,field.getType());
                method.invoke(temp, rs.getObject(i + 1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return temp;
    }



    /**
     * 根据对象向数据库插入数据
     * @param t
     * @return
     */
    public <T>int insert(T t) {
        Class<?> clazz = t.getClass();  //根据对象获取class类
        String sql = "INSERT INTO `" + clazz.getName().substring(clazz.getName().lastIndexOf(".") + 1) + "`";//根据class类获取类名称
        String values = "VALUES(";
        Field[] fields = clazz.getDeclaredFields();   //获取所有的属性类
        List<Object> list = new ArrayList<>();
        boolean flag=true;
        try {
            for (int i = 0 ; i<fields.length ; i++) {
                String methodName = getGetter(fields[i].getName()); //根据数据类获取属性名称，获取get方法名称
                Method method = clazz.getDeclaredMethod(methodName);    //根据get方法名称获取方法对象
                Object obj = method.invoke(t);
                if (obj != null) {
                    if(flag){
                        values+="?";
                        sql+="(";
                        sql += "`" + fields[i].getName() + "`";
                        list.add(obj);
                        flag=false;
                    }else {
                        values+=",?";
                        sql+=",`"+fields[i].getName() +"`";
                        list.add(obj);
                    }
                }
            }
            if (list.size()> 0) {
                sql+=")";
                values += ")";
                sql=sql+values;
            }else {
                throw new RuntimeException("传入的对象属性值都为空");
            }

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return runNonQuerySQL(sql, list.toArray());
    }

    public <T>int delete(T t) {
        Class clazz = t.getClass();
        String sql = "delete from `"+ clazz.getName().substring(clazz.getName().lastIndexOf(".") + 1) + "`";
        Field[] fields = clazz.getDeclaredFields();
        boolean flag = true;
        List<Object> list = new ArrayList<>();
        try {
            for (int i = 0; i < fields.length; i++) {
                String methodName = getGetter(fields[i].getName()); //根据数据类获取属性名称，获取get方法名称
                Method method = clazz.getDeclaredMethod(methodName);    //根据get方法名称获取方法对象
                Object obj = method.invoke(t);
                if (obj != null) {
                    if(flag){
                        sql +=" where " +"`" + fields[i].getName() + "`"+"= ?";
                        list.add(obj);
                    }else {
                        sql += "and "+"`" + fields[i].getName() + "`"+"= ?";
                        list.add(obj);
                    }
                }
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return runNonQuerySQL(sql, list.toArray());
    }



    public String initcap(String str) {
        char[] ch=str.toCharArray();
        if(ch[0]>='a' && ch[0]<='z'){
            ch[0]= (char) (ch[0]-32);
        }
        return new String(ch);
    }

    public String getGetter(String fieldName){
        return "get"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
    }

    public <T>Page getPage(Integer pageNum, String property, Class<T> clazz){
        String sql="SELECT * FROM "+property +"  LIMIT "+((pageNum-1)*20)+","+20;
        Integer totalCount = getTotalCount(property);
        int totalPage = (int) Math.ceil((double)totalCount/20);
        List<T> list = new ArrayList<T>();
        list = (List<T>) queryList(sql, clazz);
        Page page = new Page();
        page.setPageNum(pageNum);
        page.setCurrentPage(20);
        page.setTotalCount(totalCount);
        page.setTotalPage(totalPage);
        page.setData(list);
        return page;
    }

    public Page getExtPage(String sql, Integer pageNum, Integer currentPage) {
        Connection conn = JdbcUtil.getConnection();
        PreparedStatement pstmt = null ;
        ResultSet rs = null ;
        Page<Ext> page = new Page<>() ;
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            rs.last();
            int totalCount = rs.getRow();
            page.setPageNum(pageNum);
            page.setCurrentPage(currentPage);
            page.setTotalCount(totalCount);
            page.setTotalPage((int) Math.ceil((double)totalCount/currentPage));
            sql  = sql+"  LIMIT "+((pageNum-1)*currentPage)+","+currentPage;
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            while (rs.next()) {
                Ext ext = new Ext();
                for (int i= 1 ;i <= columnCount ;i ++) {
                    String columnName = metaData.getColumnName(i);
                    ext.getMap().put(columnName, rs.getObject(i));
                }
                page.getData().add(ext);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return page;
    }

    /**
     * 查找总行数
     * @param property  查找的表名
     * @return
     */
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

    public <T>T select(T t){
        Class clazz = t.getClass();
        String sql = "select * from `"+ clazz.getName().substring(clazz.getName().lastIndexOf(".") + 1) + "`";
        String where = "";
        List<Object> list = new ArrayList<>();
        boolean flag = true;
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            try {
                String methodName = getGetter(field.getName());
                Method method = clazz.getMethod(methodName);
                Object obj = method.invoke(t);
                if (obj != null || !"".equals(obj)) {
                    if (flag) {
                        where = "where "+field.getName()+"=?";
                        flag = false;
                    }else {
                        where +=" and "+field.getName() +"=?" ;
                    }
                    list.add(obj);
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        if (!("".equals(where) || where == null)) {
            sql = sql + " "+where;
        }
        t = (T) selectOne(sql, clazz, list.toArray());
        return t;
    }


}
