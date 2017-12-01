package cn.wang.store.entity;

import java.util.List;

/**
 * Created by 王 on 2017/11/26.
 */
public class Role {
    private Integer id;
    private String roleName;
    private Integer status;
    private String description;

    private List<Privileges> priviList;

    public List<Privileges> getPriviList() {
        return priviList;
    }

    public void setPriviList(List<Privileges> priviList) {
        this.priviList = priviList;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
