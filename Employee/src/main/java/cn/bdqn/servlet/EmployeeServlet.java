package cn.bdqn.servlet;

import cn.bdqn.entity.Dept;
import cn.bdqn.entity.Employee;
import cn.bdqn.service.impl.EmployeeServiceImpl;
import cn.bdqn.util.Page;

import java.io.IOException;
import java.util.List;

/**
 * Created by FLC on 2017/6/16.
 */
public class EmployeeServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.setHeader("content-type", "text/html;charset=UTF-8");
        //创建service
        EmployeeServiceImpl service = new EmployeeServiceImpl();
        try {
            List<Dept> selectdept = service.selectdept();
            request.setAttribute("deptlist", selectdept);

        } catch (Exception e) {
            e.printStackTrace();
        }
        String select = request.getParameter("select");
        if (select != null) {
            //创建一个Page对象
            Page page = new Page();
            String selectname = request.getParameter("selectname");
            System.out.print(selectname);
            String deptid = request.getParameter("deptid");
            //定义每页显示的记录数
            int pageSize = 3;
            page.setPageSize(pageSize);
            //定义当前页数
            int myIndex = 0;
            String pageIndex = request.getParameter("pageIndex");
            if (pageIndex != null) {
                myIndex = Integer.parseInt(pageIndex);
            } else {
                myIndex = 1;
            }
            page.setPageIndex(myIndex);
            //定义总页数
            int totalpage = 0;
            try {
                int count = service.getempcount(selectname, Integer.parseInt(deptid));
                if (count % pageSize == 0) {
                    totalpage = count / pageSize;
                } else {
                    totalpage = count / pageSize + 1;
                }
                page.setPagetotalpages(totalpage);
                List<Employee> emplist = service.likeemp(selectname, Integer.parseInt(deptid), (page.getPageIndex() - 1) * pageSize, page.getPageSize());
                page.setEmplist(emplist);
                request.setAttribute("Page", page);
                request.setAttribute("selectname",selectname);
                request.setAttribute("deptid",deptid);
                request.getRequestDispatcher("/EmpList.jsp").forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {


            //创建一个Page对象
            Page page = new Page();
            //定义每页显示的记录数
            int pageSize = 3;
            page.setPageSize(pageSize);
            //定义当前页数
            int myIndex = 0;
            String pageIndex = request.getParameter("pageIndex");
            if (pageIndex != null) {
                myIndex = Integer.parseInt(pageIndex);
            } else {
                myIndex = 1;
            }
            page.setPageIndex(myIndex);
            //定义总页数
            int totalpage = 0;
            try {
                int count = service.getCount();
                if (count % pageSize == 0) {
                    totalpage = count / pageSize;
                } else {
                    totalpage = count / pageSize + 1;
                }
                page.setPagetotalpages(totalpage);
                List<Employee> emplist = service.selectEmp((page.getPageIndex() - 1) * pageSize, page.getPageSize());
                page.setEmplist(emplist);
                request.setAttribute("Page", page);
                request.getRequestDispatcher("/EmpList.jsp").forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
