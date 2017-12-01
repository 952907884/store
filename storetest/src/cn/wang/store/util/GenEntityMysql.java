package cn.wang.store.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Date;

/**
 * Created by 王 on 2017/11/28.
 */
public class GenEntityMysql {
    private String packageOutPath = "cn.wang.store.entity";//指定实体生成所在包的路径
    private String authorName = "wang";//作者名字
    private String tablename = "View_Product";//表名  具体名称 或者设置*表示该数据库下所有的表
    private String[] colnames; // 列名数组
    private String[] colTypes; //列名类型数组
    private int[] colSizes; //列名大小数组
    private int[] colNullable;//列是否为空数组
    private boolean f_util = false; // 是否需要导入包java.util.*
    private boolean f_sql = false; // 是否需要导入包java.sql.*

    //数据库连接
    /*private static final String URL ="jdbc:mysql://localhost:3306/newsmgr";
    private static final String NAME = "root";
    private static final String PASS = "123456";
    private static final String DRIVER ="com.mysql.jdbc.Driver";*/

    /*
     * 构造函数
     */
    public GenEntityMysql(){
        //创建连接
        Connection con = null;
        //查要生成实体类的表
        String sql = "select * from " + tablename;
        PreparedStatement pStemt = null;
        try {
            con = JdbcUtil.getConnection();
            pStemt = con.prepareStatement(sql);
            ResultSetMetaData rsmd = pStemt.getMetaData();
            int size = rsmd.getColumnCount();//统计列数
            colnames = new String[size];
            colTypes = new String[size];
            colSizes = new int[size];
            colNullable = new int[size];
            for (int i = 0; i < size; i++) {
                colnames[i] = rsmd.getColumnName(i + 1);
                colTypes[i] = rsmd.getColumnTypeName(i + 1);
                colNullable[i] = rsmd.isNullable(i + 1);
                colSizes[i] = rsmd.getColumnDisplaySize(i + 1);
                //再查询一下还有那些列需要导此包
                if(colTypes[i].equalsIgnoreCase("datetime") || colTypes[i].equalsIgnoreCase("timestamp")){
                    f_util = true;
                }
                //??????
                if(colTypes[i].equalsIgnoreCase("image") || colTypes[i].equalsIgnoreCase("text")){
                    f_sql = true;
                }
            }
            //功能：生成实体类主体代码
            String content = parse(colnames,colTypes,colSizes,colNullable);
            //将生成的实体类代码以文件流形式保存起来
            try {
                File directory = new File("");
                /*String path=this.getClass().getResource("").getPath();
                System.out.println(directory.getAbsolutePath());*/
                String outputPath = directory.getAbsolutePath()+ "/storetest/src/"+this.packageOutPath.replace(".", "/")+"/"+initcap(tablename) + ".java";
                FileWriter fw = new FileWriter(outputPath);
                PrintWriter pw = new PrintWriter(fw);
                pw.println(content);
                pw.flush();
                pw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("实体生成成功");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {

                e.printStackTrace();
            }
        }
    }

    /**
     * 功能：生成实体类主体代码
     * @param colnames
     * @param colTypes
     * @param colSizes
     * @return
     */
    private String parse(String[] colnames, String[] colTypes, int[] colSizes, int[] colNullable) {
        StringBuffer sb = new StringBuffer();
        sb.append("package " + this.packageOutPath + ";\r\n");//声明包必须在导包前
        //判断是否导入工具包
        if(f_util){
            sb.append("import java.util.Date;\r\n");
        }
        if(f_sql){
            sb.append("import java.sql.*;\r\n");
        }
        sb.append("\r\n");
        //注释部分
        sb.append("   /**\r\n");
        sb.append("    * "+tablename+" 实体类\r\n");
        sb.append("    * "+new Date()+" "+this.authorName+"\r\n");
        sb.append("    */ \r\n");
        //实体部分
        sb.append("public class " + initcap(tablename) + "{\r\n");
        processAllAttrs(sb);//属性
        processAllMethod(sb);//get set方法
        sb.append("}\r\n");

        return sb.toString();
    }

    /**
     * 功能：生成所有属性
     * @param sb
     */
    private void processAllAttrs(StringBuffer sb) {

        for (int i = 0; i < colnames.length; i++) {
            sb.append("\tprivate " + sqlType2JavaType(colTypes[i],colNullable[i]) + " " + colnames[i] + ";\r\n");
        }

    }

    /**
     * 功能：生成get/set方法
     * @param sb
     */
    private void processAllMethod(StringBuffer sb) {

        for (int i = 0; i < colnames.length; i++) {
            sb.append("\tpublic void set" + initcap(colnames[i]) + "(" + sqlType2JavaType(colTypes[i],colNullable[i]) + " " +
                    colnames[i] + "){\r\n");
            sb.append("\tthis." + colnames[i] + "=" + colnames[i] + ";\r\n");
            sb.append("\t}\r\n");
            sb.append("\tpublic " + sqlType2JavaType(colTypes[i],colNullable[i]) + " get" + initcap(colnames[i]) + "(){\r\n");
            sb.append("\t\treturn " + colnames[i] + ";\r\n");
            sb.append("\t}\r\n");
        }

    }

    /**
     * 功能：将输入字符串的首字母改成大写
     * @param str
     * @return
     */
    private String initcap(String str) {

        char[] ch = str.toCharArray();
        if(ch[0] >= 'a' && ch[0] <= 'z'){
            ch[0] = (char)(ch[0] - 32);
        }

        return new String(ch);
    }

    /**
     * 功能：获得列的数据类型
     * @param sqlType
     * @return
     */
    private String sqlType2JavaType(String sqlType,int colNullable) {

        if(sqlType.equalsIgnoreCase("bit")){
            return "Boolean";
        }else if(sqlType.equalsIgnoreCase("tinyint")){
            return "Byte";
        }else if(sqlType.equalsIgnoreCase("smallint")){
            return "Short";
        }else if(sqlType.equalsIgnoreCase("int") || sqlType.equalsIgnoreCase("INTEGER")){
            return "Integer";
        }else if(sqlType.equalsIgnoreCase("bigint")){
            return "Long";
        }else if(sqlType.equalsIgnoreCase("float")){
            return "Float";
        }else if(sqlType.equalsIgnoreCase("decimal") || sqlType.equalsIgnoreCase("numeric")
                || sqlType.equalsIgnoreCase("real") || sqlType.equalsIgnoreCase("money")
                || sqlType.equalsIgnoreCase("smallmoney")|| sqlType.equalsIgnoreCase("double")){
            return "Double";
        }else if(sqlType.equalsIgnoreCase("varchar") || sqlType.equalsIgnoreCase("char")
                || sqlType.equalsIgnoreCase("nvarchar") || sqlType.equalsIgnoreCase("nchar")
                || sqlType.equalsIgnoreCase("text")){
            return "String";
        }else if(sqlType.equalsIgnoreCase("datetime")||sqlType.equalsIgnoreCase("timestamp")){
            return "Date";
        }else if(sqlType.equalsIgnoreCase("image")){
            return "Blod";
        }

        return null;
    }

    public static void main(String[] args) {
        new GenEntityMysql();
    }


}
