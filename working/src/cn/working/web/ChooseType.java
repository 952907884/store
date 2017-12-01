package cn.working.web;

/**
 * Created by 王 on 2017/11/27.
 */
public class ChooseType {

    public static String chooseType(String type) {
        switch (type) {
            case "1":
                return "技术";
            case "2":
                return "人事";
            case "3":
                return "行政";
        }

        return null;
    }
}
