package cn.wang.store.entity;

/**
 * Created by 王 on 2017/11/26.
 */
public class Privileges {
    private Integer id; //权限id
    private String priName; //权限名称
    private String resource;    //权限访问资源
    private String description; //权限描述
    private String stuffix; //后缀
    private String params;  //资源参数
    private Integer Type;   //权限类型 0-需要权限控制 1-公共资源
    private Integer status; //状态 0-正常使用 1-停用

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPriName() {
        return priName;
    }

    public void setPriName(String priName) {
        this.priName = priName;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStuffix() {
        return stuffix;
    }

    public void setStuffix(String stuffix) {
        this.stuffix = stuffix;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public Integer getType() {
        return Type;
    }

    public void setType(Integer type) {
        Type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
