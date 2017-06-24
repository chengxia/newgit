package cn.bdqn.dao.impl;

import cn.bdqn.dao.EmployeeDao;
import cn.bdqn.entity.Dept;
import cn.bdqn.entity.Employee;
import cn.bdqn.util.BaseDao;
import org.junit.Test;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by FLC on 2017/6/16.
 */
public class EmployeeDaoImpl extends BaseDao implements EmployeeDao {
    public List<Employee> selectEmp(int pageIndex, int pageSize) throws Exception {
        List<Employee> emplist = new ArrayList<Employee>();
        String sql = "select * from Employee limit ?,?";
        Object[] obj = {pageIndex, pageSize};
        ResultSet rs = executeSelect(sql, obj);
        if (rs != null) {
            while (rs.next()) {
                Employee emp = new Employee();
                emp.setEmpid(rs.getInt("empid"));
                emp.setName(rs.getString("name"));
                emp.setDepartment_id(rs.getInt("department_id"));
                emp.setSalary(rs.getDouble("salary"));
                emplist.add(emp);
            }
        }
        return emplist;
    }

    public int getCount() throws Exception {
        int result = 0;
        String sql = "select count(*) as num from Employee";
        ResultSet rs = executeSelect(sql);
        if (rs != null) {
            if (rs.next()) {
                result = rs.getInt("num");
            }
        }
        return result;
    }

    public List<Dept> selectdept() throws Exception {
        List<Dept> deptlist = new ArrayList<Dept>();
        String sql = "select * from department";
        ResultSet rs = executeSelect(sql);
        if (rs != null) {
            while (rs.next()) {
                Dept dept = new Dept();
                dept.setId(rs.getInt("id"));
                dept.setName(rs.getString("name"));
                deptlist.add(dept);
            }
        }
        return deptlist;
    }

    @Test
    public void Tests() throws Exception {
        int count = getempcount("张", 0);
        System.out.println(count);
    }

    public List<Employee> likeemp(String empname, int deptid, int pageIndex, int pageSize) throws Exception {
        List<Employee> emplist = new ArrayList<Employee>();
        //使用StringBuffer拼接sql语句
        StringBuffer sb = new StringBuffer("select * from Employee where 1=1 ");
        if (empname != null) {
            sb.append(" and name like '%" + empname + "%' ");
        }
        if (deptid != 0) {
            sb.append(" and department_id='" + deptid + "'");
        }
        sb.append(" limit ?,?");
        Object[] obj = {pageIndex, pageSize};
        ResultSet rs = executeSelect(sb.toString(), obj);
        if (rs != null) {
            while (rs.next()) {
                Employee emps = new Employee();
                emps.setEmpid(rs.getInt("empid"));
                emps.setName(rs.getString("name"));
                emps.setDepartment_id(rs.getInt("department_id"));
                emps.setSalary(rs.getDouble("salary"));
                emplist.add(emps);
            }
        }
        return emplist;
    }

    public int getempcount(String empname, int deptid) throws Exception {
        int result = 0;
        StringBuffer sb = new StringBuffer("select count(*) as num from Employee where 1=1 ");
        if (empname != null) {
            sb.append(" and name like '%" + empname + "%' ");
        }
        if (deptid != 0) {
            sb.append(" and department_id='" + deptid + "'");
        }
        ResultSet rs = executeSelect(sb.toString());
        if (rs != null) {
            if (rs.next()) {
                result = rs.getInt("num");
            }
        }
        return result;
    }
}
