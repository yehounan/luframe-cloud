package com.quanlehui.servicebase.base.vo;

import java.util.List;

/**
 * Desc    : PageInfo data模型
 * Date    : 2018-01-08
 *
 * @author : yxy
 */
public class PageInfoData<T> {

    /**
     * 总条数
     */
    private Long total;

    /**
     * 当前页list
     */
    private List<T> list;

    /**
     * 总页数
     */
    private Integer pages;

    /**
     * 其它数据
     */
    private Object data;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
