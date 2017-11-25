package cn.wang.store.util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

/**
 * Created by 王 on 2017/11/8.
 */
public class FileClassNameUtil {
    private static SAXReader reader=new SAXReader();
    private static Document document;

    static {
        try {
            document = document = reader.read(FileClassNameUtil.class.getResourceAsStream("/fileName-ClassName.xml"));
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }


    public static String getClassName(String name){
        String className=null;
        Element root=document.getRootElement();
        List<Element> eles=root.elements("file-pattern");
        for(Element ele : eles){
            Element fileEle = ele.element("fileName");
            if(name.equalsIgnoreCase(fileEle.getText())){
                return className=fileEle.getParent().element("className").getText();
            }
        }
        return className;
    }

}
