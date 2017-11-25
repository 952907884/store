package cn.wang.store.entity;

import java.util.List;

/**
 * Created by 王 on 2017/11/25.
 */
public class Page<T> {
    private int currentPage; //没页行数
    private int pageNum; //当前页码
    private int totalPage; //总页数
    private int totalCount; //总行数
    private List<T> data;   //查询的内容

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
