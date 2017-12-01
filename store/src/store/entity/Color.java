package store.entity;

import java.util.Date;

/**
 * Created by 王 on 2017/11/6.
 * 颜色类
 */
public class Color {
    private Integer colorID;
    private String colorName;
    private Integer disable;
    private Date createdate;
    private Date lastchange;

    public Integer getColorID() {
        return colorID;
    }

    public void setColorID(Integer colorID) {
        this.colorID = colorID;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public Integer getDisable() {
        return disable;
    }

    public void setDisable(Integer disable) {
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
        return "Color{" +
                "colorID=" + colorID +
                ", colorName='" + colorName + '\'' +
                ", disable=" + disable +
                ", createdate=" + createdate +
                ", lastchange=" + lastchange +
                '}';
    }
}
