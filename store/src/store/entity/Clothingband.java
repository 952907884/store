package store.entity;

import java.util.Date;

/**
 * Created by 王 on 2017/11/6.
 * 波段
 */
public class Clothingband {
    private String clothingbandID;
    private String clothingbandName;
    private Integer disable;
    private Date createdate;
    private Date lastchange;

    public String getClothingbandID() {
        return clothingbandID;
    }

    public void setClothingbandID(String clothingbandID) {
        this.clothingbandID = clothingbandID;
    }

    public String getClothingbandName() {
        return clothingbandName;
    }

    public void setClothingbandName(String clothingbandName) {
        this.clothingbandName = clothingbandName;
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
}
