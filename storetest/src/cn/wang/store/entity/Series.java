package cn.wang.store.entity;

import java.util.Date;

/**
 * Created by 王 on 2017/11/28.
 */
public class Series {
    private String seriesId;
    private String seriesName;
    private Integer status;
    private String createdBy;
    private Date createDate;
    private String modifyBy;
    private Date modifyDate;

    public String getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(String seriesId) {
        this.seriesId = seriesId;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    @Override
    public String toString() {
        return "Series{" +
                "seriesId='" + seriesId + '\'' +
                ", seriesName='" + seriesName + '\'' +
                ", status=" + status +
                ", createdBy='" + createdBy + '\'' +
                ", createDate=" + createDate +
                ", modifyBy='" + modifyBy + '\'' +
                ", modifyDate=" + modifyDate +
                '}';
    }
}
