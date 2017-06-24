package cn.bdqn.service.impl;

import cn.bdqn.dao.EmployeeDao;
import cn.bdqn.dao.impl.EmployeeDaoImpl;
import cn.bdqn.entity.Dept;
import cn.bdqn.entity.Employee;
import cn.bdqn.service.EmployeeService;

import java.util.List;

/**
 * Created by FLC on 2017/6/16.
 */
public class EmployeeServiceImpl implements EmployeeService{
    //植入dao对象
    EmployeeDaoImpl daoimpl=new EmployeeDaoImpl();
    public List<Employee> selectEmp(int pageIndex, int pageSize) throws Exception {
        return daoimpl.selectEmp(pageIndex,pageSize);
    }

    public int getCount() throws Exception {
        return daoimpl.getCount();
    }

    public List<Dept> selectdept() throws Exception {
        return daoimpl.selectdept();
    }

    public List<Employee> likeemp(String empname, int deptid, int pageIndex, int pageSize) throws Exception {
        return daoimpl.likeemp(empname,deptid,pageIndex,pageSize);

    }

    public int getempcount(String empname, int deptid) throws Exception {
        return daoimpl.getempcount(empname,deptid);
    }
}
