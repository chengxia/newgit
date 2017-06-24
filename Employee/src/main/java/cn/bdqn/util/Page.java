package cn.bdqn.util;

import cn.bdqn.entity.Employee;

import java.util.List;

/**
 * Created by FLC on 2017/6/16.
 */
public class Page {
    //当前页数
    private int pageIndex;
    //每页要显示的记录数
    private int pageSize;
    //总页数
    private int pagetotalpages;
    //集合
    private List<Employee> emplist;

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPagetotalpages() {
        return pagetotalpages;
    }

    public void setPagetotalpages(int pagetotalpages) {
        this.pagetotalpages = pagetotalpages;
    }

    public List<Employee> getEmplist() {
        return emplist;
    }

    public void setEmplist(List<Employee> emplist) {
        this.emplist = emplist;
    }
}
