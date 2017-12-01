package store.web;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import store.utils.ExcelAction;

import javax.naming.Context;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * Created by 王 on 2017/11/14.
 */
@WebServlet(name = "UploadServlet",value = "/servlet/uploadServlet")
public class UploadServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FileItemFactory factory=new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        List<FileItem> items=null;
        String name = null;
        OutputStream os=null;
        InputStream is=null;
        try {
            items = upload.parseRequest(request);   //解析上传数据
            for (FileItem item : items) {
                //判断是否上传组件，不是上传组件返回true，上传组件返回false
                if(!item.isFormField()){
                    String fileName = item.getName();//得到文件域中的文件名
                    File fullFile=new File(fileName);
                    File uploadFilePath =new File("f:\\");
                    File servicePath=new File(uploadFilePath,fullFile.getName());
                    try {
                        item.write(servicePath);
                        ExcelAction excel=new ExcelAction();
                        excel.readExcel(servicePath);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }else {
                    String path=item.getFieldName();
                }
            }
            PrintWriter out = response.getWriter();
            out.print(name);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
