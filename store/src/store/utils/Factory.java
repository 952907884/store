package store.utils;


/**
 * Created by 王 on 2017/11/8.
 */
public class Factory {
    public static <T> T newInstance(String clazzName){
        T t=null;
        try {
            t=(T) Class.forName(FileClassNameUtil.getClassName(clazzName)).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return t;
    }
}
