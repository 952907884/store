package store.utils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.Iterator;
import java.util.List;

/**
 * Created by 王 on 2017/11/8.
 */
public class XmlReader {
    SAXReader reader=new SAXReader();
    private Document  getDocument(String filePath) {
        Document document = null;
        try {
            document = reader.read(new File(filePath));
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return document;
    }

    public String getValue(String filePath,String fileName){
        String value=null;
        Document document=getDocument(filePath);
        Element root=document.getRootElement();
        for(Iterator it=root.elementIterator();it.hasNext();){
            Element ele= (Element) it.next();
        }
        return value;
    }

}
