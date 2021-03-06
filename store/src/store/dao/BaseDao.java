package store.dao;

import store.entity.Color;
import store.utils.JdbcUtil;

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
     * @param t 查询的实体类
     * @return 该类型的列表
     */
    public <T>List<T> queryList(String sql, Object[] params, T t){
        Class clazz=t.getClass();
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
                T temp=(T)clazz.newInstance();//动态生成T的对象
                for(int i=0;i<count;i++){
                    String fieldName=metaData.getColumnName(i+1);
                    Field field=clazz.getDeclaredField(fieldName);
                    Method method=clazz.getMethod(getSetter(fieldName), field.getType());
                    method.invoke(temp, rs.getObject(i+1));
                }
                list.add(temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
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

    public <T>int delProperty(T t) {
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
}
