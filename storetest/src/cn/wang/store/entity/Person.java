package cn.wang.store.entity;

import java.util.Date;

/**
 * Created by 王 on 2017/11/30.
 */
public class Person {
    private Integer age;
    private Double money;
    private Date birthday;

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", money=" + money +
                ", birthday=" + birthday +
                '}';
    }
}
