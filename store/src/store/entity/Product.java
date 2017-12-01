package store.entity;

import java.util.Date;

/**
 * Created by 王 on 2017/11/6.
 * 商品类
 */
public class Product {
    private String productId;   //商品编号
    private String ProductName; //商品名称
    private float tagprice; //吊牌价
    private int  subclassID;    //小类id
    private int categoryId; //大类id
    private int colourID;   //颜色id
    private int sizeid; //尺码id
    private int year;   //年度
    private int season; //季节
    private float costing;  //成本
    private int seriesid;   //系列id
    private int themeid;    //主题id
    private int ClothingbandID; //波段id
    private String pic; //图片
    private String disable;
    private Date createdate;
    private Date lastchange;

    public Date getCreatedate() {
        return createdate;
    }

    public Date getLastchange() {
        return lastchange;
    }

    public String getDisable() {
        return disable;
    }

    public void setDisable(String disable) {
        this.disable = disable;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public float getTagprice() {
        return tagprice;
    }

    public void setTagprice(float tagprice) {
        this.tagprice = tagprice;
    }

    public int getSubclassID() {
        return subclassID;
    }

    public void setSubclassID(int subclassID) {
        this.subclassID = subclassID;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getColourID() {
        return colourID;
    }

    public void setColourID(int colourID) {
        this.colourID = colourID;
    }

    public int getSizeid() {
        return sizeid;
    }

    public void setSizeid(int sizeid) {
        this.sizeid = sizeid;
    }

    public int getYear() {
        return year;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getCosting() {
        return costing;
    }

    public void setCosting(float costing) {
        this.costing = costing;
    }

    public int getSeriesid() {
        return seriesid;
    }

    public void setSeriesid(int seriesid) {
        this.seriesid = seriesid;
    }

    public int getThemeid() {
        return themeid;
    }

    public void setThemeid(int themeid) {
        this.themeid = themeid;
    }

    public int getClothingbandID() {
        return ClothingbandID;
    }

    public void setClothingbandID(int clothingbandID) {
        ClothingbandID = clothingbandID;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }


    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", ProductName='" + ProductName + '\'' +
                ", tagprice=" + tagprice +
                ", subclassID=" + subclassID +
                ", categoryId=" + categoryId +
                ", colourID=" + colourID +
                ", sizeid=" + sizeid +
                ", year=" + year +
                ", costing=" + costing +
                ", seriesid=" + seriesid +
                ", themeid=" + themeid +
                ", ClothingbandID=" + ClothingbandID +
                ", pic='" + pic + '\'' +
                '}';
    }
}
