package cn.wang.store.entity;

import java.util.Date;

/**
 * Created by 王 on 2017/11/25.
 */
public class Product {
    private String productId;
    private String productName;
    private String unit;
    private Double tagprice;
    private Double costprice;
    private String categoryid;
    private String subclassesid;
    private String bandid;
    private String themeid;
    private String seriesid;
    private Integer year;
    private Integer quarter;
    private Integer status;
    private String picpath;
    private String createdBy;
    private Date createdate;
    private String modifyby;
    private Date modifydate;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getTagprice() {
        return tagprice;
    }

    public void setTagprice(Double tagprice) {
        this.tagprice = tagprice;
    }

    public Double getCostprice() {
        return costprice;
    }

    public void setCostprice(Double costprice) {
        this.costprice = costprice;
    }

    public String getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(String categoryid) {
        this.categoryid = categoryid;
    }

    public String getSubclassesid() {
        return subclassesid;
    }

    public void setSubclassesid(String subclassesid) {
        this.subclassesid = subclassesid;
    }

    public String getBandid() {
        return bandid;
    }

    public void setBandid(String bandid) {
        this.bandid = bandid;
    }

    public String getThemeid() {
        return themeid;
    }

    public void setThemeid(String themeid) {
        this.themeid = themeid;
    }

    public String getSeriesid() {
        return seriesid;
    }

    public void setSeriesid(String seriesid) {
        this.seriesid = seriesid;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getQuarter() {
        return quarter;
    }

    public void setQuarter(Integer quarter) {
        this.quarter = quarter;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPicpath() {
        return picpath;
    }

    public void setPicpath(String picpath) {
        this.picpath = picpath;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getModifyby() {
        return modifyby;
    }

    public void setModifyby(String modifyby) {
        this.modifyby = modifyby;
    }

    public Date getModifydate() {
        return modifydate;
    }

    public void setModifydate(Date modifydate) {
        this.modifydate = modifydate;
    }
}
