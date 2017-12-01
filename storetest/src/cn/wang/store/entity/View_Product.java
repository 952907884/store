package cn.wang.store.entity;
import java.util.Date;

   /**
    * View_Product 实体类
    * Tue Nov 28 23:52:06 CST 2017 wang
    */ 
public class View_Product{
	private String productId;
	private String productName;
	private String colorName;
	private String sizeName;
	private String unit;
	private Double tagprice;
	private Double costprice;
	private String categoryName;
	private String subclassesName;
	private String bandName;
	private String themename;
	private String seriesname;
	private Integer year;
	private Integer quarter;
	private Integer status;
	private String picpath;
	private String createdBy;
	private Date createdate;
	private String modifyby;
	private Date modifydate;
	public void setProductId(String productId){
	this.productId=productId;
	}
	public String getProductId(){
		return productId;
	}
	public void setProductName(String productName){
	this.productName=productName;
	}
	public String getProductName(){
		return productName;
	}
	public void setColorName(String colorName){
	this.colorName=colorName;
	}
	public String getColorName(){
		return colorName;
	}
	public void setSizeName(String sizeName){
	this.sizeName=sizeName;
	}
	public String getSizeName(){
		return sizeName;
	}
	public void setUnit(String unit){
	this.unit=unit;
	}
	public String getUnit(){
		return unit;
	}
	public void setTagprice(Double tagprice){
	this.tagprice=tagprice;
	}
	public Double getTagprice(){
		return tagprice;
	}
	public void setCostprice(Double costprice){
	this.costprice=costprice;
	}
	public Double getCostprice(){
		return costprice;
	}
	public void setCategoryName(String categoryName){
	this.categoryName=categoryName;
	}
	public String getCategoryName(){
		return categoryName;
	}
	public void setSubclassesName(String subclassesName){
	this.subclassesName=subclassesName;
	}
	public String getSubclassesName(){
		return subclassesName;
	}
	public void setBandName(String bandName){
	this.bandName=bandName;
	}
	public String getBandName(){
		return bandName;
	}
	public void setThemename(String themename){
	this.themename=themename;
	}
	public String getThemename(){
		return themename;
	}
	public void setSeriesname(String seriesname){
	this.seriesname=seriesname;
	}
	public String getSeriesname(){
		return seriesname;
	}
	public void setYear(Integer year){
	this.year=year;
	}
	public Integer getYear(){
		return year;
	}
	public void setQuarter(Integer quarter){
	this.quarter=quarter;
	}
	public Integer getQuarter(){
		return quarter;
	}
	public void setStatus(Integer status){
	this.status=status;
	}
	public Integer getStatus(){
		return status;
	}
	public void setPicpath(String picpath){
	this.picpath=picpath;
	}
	public String getPicpath(){
		return picpath;
	}
	public void setCreatedBy(String createdBy){
	this.createdBy=createdBy;
	}
	public String getCreatedBy(){
		return createdBy;
	}
	public void setCreatedate(Date createdate){
	this.createdate=createdate;
	}
	public Date getCreatedate(){
		return createdate;
	}
	public void setModifyby(String modifyby){
	this.modifyby=modifyby;
	}
	public String getModifyby(){
		return modifyby;
	}
	public void setModifydate(Date modifydate){
	this.modifydate=modifydate;
	}
	public Date getModifydate(){
		return modifydate;
	}
}

