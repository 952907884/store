package store.entity;

/**
 * Created by 王 on 2017/11/6.
 */
public class OrderDetail {
    private String orderID;
    private String productId;
    private int colorID;
    private int sizeId;
    private int number;
    private float tagprice;
    private float zk;
    private float realisticprice;

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getColorID() {
        return colorID;
    }

    public void setColorID(int colorID) {
        this.colorID = colorID;
    }

    public int getSizeId() {
        return sizeId;
    }

    public void setSizeId(int sizeId) {
        this.sizeId = sizeId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public float getTagprice() {
        return tagprice;
    }

    public void setTagprice(float tagprice) {
        this.tagprice = tagprice;
    }

    public float getZk() {
        return zk;
    }

    public void setZk(float zk) {
        this.zk = zk;
    }

    public float getRealisticprice() {
        return realisticprice;
    }

    public void setRealisticprice(float realisticprice) {
        this.realisticprice = realisticprice;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "orderID='" + orderID + '\'' +
                ", productId='" + productId + '\'' +
                ", colorID=" + colorID +
                ", sizeId=" + sizeId +
                ", number=" + number +
                ", tagprice=" + tagprice +
                ", zk=" + zk +
                ", realisticprice=" + realisticprice +
                '}';
    }
}
