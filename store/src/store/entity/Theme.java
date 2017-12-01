package store.entity;

import java.util.Date;

/**
 * Created by 王 on 2017/11/6.
 * 主题类
 */
public class Theme {
    private Integer themeid;
    private String themeName;
    private String disable;
    private Date createdate;
    private Date lastchange;

    public Integer getThemeid() {
        return themeid;
    }

    public void setThemeid(Integer themeid) {
        this.themeid = themeid;
    }

    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }

    public String getDisable() {
        return disable;
    }

    public void setDisable(String disable) {
        this.disable = disable;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getLastchange() {
        return lastchange;
    }

    public void setLastchange(Date lastchange) {
        this.lastchange = lastchange;
    }

    @Override
    public String toString() {
        return "Theme{" +
                "themeid=" + themeid +
                ", themeName='" + themeName + '\'' +
                ", disable=" + disable +
                ", createdate=" + createdate +
                ", lastchange=" + lastchange +
                '}';
    }
}
