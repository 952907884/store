package store.entity;

import java.util.Date;

/**
 * Created by 王 on 2017/11/6.
 * 大类
 */
public class Category {
    private String categoryId;
    private  String categoryName;
    private String disable ;
    private Date createdate;
    private Date lastchange;

    public Date getCreatedate() {
        return createdate;
    }

    public Date getLastchange() {
        return lastchange;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public void setLastchange(Date lastchange) {
        this.lastchange = lastchange;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDisable() {
        return disable;
    }

    public void setDisable(String disable) {
        this.disable = disable;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", disable=" + disable +
                '}';
    }
}
