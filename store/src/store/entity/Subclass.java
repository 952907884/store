package store.entity;

import java.util.Date;

/**
 * Created by 王 on 2017/11/6.
 * 小类
 */
public class Subclass {

    private String subclassid;
    private  String subclassName;
    private String disable ;
    private Date createdate;
    private Date lastchange;

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public void setLastchange(Date lastchange) {
        this.lastchange = lastchange;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public Date getLastchange() {
        return lastchange;
    }

    public String getSubclassid() {
        return subclassid;
    }

    public void setSubclassid(String subclassid) {
        this.subclassid = subclassid;
    }

    public String getSubclassName() {
        return subclassName;
    }

    public void setSubclassName(String subclassName) {
        this.subclassName = subclassName;
    }

    public String getDisable() {
        return disable;
    }

    public void setDisable(String disable) {
        this.disable = disable;
    }

    @Override
    public String toString() {
        return "Subclass{" +
                "subclassid=" + subclassid +
                ", subclassName='" + subclassName + '\'' +
                ", disable=" + disable +
                '}';
    }
}
