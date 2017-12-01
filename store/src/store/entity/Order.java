package store.entity;

import java.util.Date;

/**
 * Created by 王 on 2017/11/6.
 * 订单类
 */
public class Order {
    private String orderID;
    private Date createdate;
    private String userid;
    private int number;
    private String address;
    private float totalprice;
    private float realisticprice;
    private Date deliverydate;
    private Date acceptdate;
    private String remark;

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(float totalprice) {
        this.totalprice = totalprice;
    }

    public float getRealisticprice() {
        return realisticprice;
    }

    public void setRealisticprice(float realisticprice) {
        this.realisticprice = realisticprice;
    }

    public Date getDeliverydate() {
        return deliverydate;
    }

    public void setDeliverydate(Date deliverydate) {
        this.deliverydate = deliverydate;
    }

    public Date getAcceptdate() {
        return acceptdate;
    }

    public void setAcceptdate(Date acceptdate) {
        this.acceptdate = acceptdate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID='" + orderID + '\'' +
                ", createdate=" + createdate +
                ", userid='" + userid + '\'' +
                ", number=" + number +
                ", address='" + address + '\'' +
                ", totalprice=" + totalprice +
                ", realisticprice=" + realisticprice +
                ", deliverydate=" + deliverydate +
                ", acceptdate=" + acceptdate +
                ", remark='" + remark + '\'' +
                '}';
    }
}
