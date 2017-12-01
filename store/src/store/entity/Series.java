package store.entity;

import java.util.Date;

/**
 * Created by 王 on 2017/11/6.
 * 系列
 */
public class Series {
    private Integer seriesid;
    private String seriesName;
    private String disable;
    private Date createdate;
    private Date lastchange;

    public Date getCreatedate() {
        return createdate;
    }

    public Date getLastchange() {
        return lastchange;
    }

    public Integer getSeriesid() {
        return seriesid;
    }

    public void setSeriesid(Integer seriesid) {
        this.seriesid = seriesid;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public String getDisable() {
        return disable;
    }

    public void setDisable(String disable) {
        this.disable = disable;
    }

    @Override
    public String toString() {
        return "Series{" +
                "seriesid=" + seriesid +
                ", seriesName='" + seriesName + '\'' +
                ", disable=" + disable +
                '}';
    }
}
