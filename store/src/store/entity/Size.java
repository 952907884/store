package store.entity;

import java.util.Date;

/**
 * Created by 王 on 2017/11/6.
 * 尺码
 */
public class Size {
    private Integer sizeId;
    private String sizeName;
    private String disable;
    private Date createdate;
    private Date lastchange;

    public Integer getSizeId() {
        return sizeId;
    }

    public void setSizeId(Integer sizeId) {
        this.sizeId = sizeId;
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
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
        return "Size{" +
                "sizeId=" + sizeId +
                ", String=" + sizeName +
                ", disable=" + disable +
                ", createdate=" + createdate +
                ", lastchange=" + lastchange +
                '}';
    }
}
