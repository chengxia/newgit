package cn.bdqn.dao;

import cn.bdqn.entity.Dept;
import cn.bdqn.entity.Employee;

import java.util.List;

/**
 * Created by FLC on 2017/6/16.
 */
public interface EmployeeDao {
    //分页显示员工数据
    public List<Employee> selectEmp(int pageIndex, int pageSize) throws Exception;

    //查询记录数
    public int getCount() throws Exception;

    //查询部门
    public List<Dept> selectdept() throws Exception;

    //多条件查询加分页
    public List<Employee> likeemp(String empname, int deptid, int pageIndex, int pageSize) throws Exception;
    //多条件查询记录数
    public int getempcount(String empname, int deptid)throws Exception;

}
