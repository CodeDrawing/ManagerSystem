package top.zwzx.managersystem.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Repository;
import top.zwzx.managersystem.pojo.Department;
import top.zwzx.managersystem.pojo.Employee;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zx
 * @date 2020/6/1
 **/
@Repository
public class EmployeeDao {
////    模拟数据库
//
//    private static Map<Integer, Employee> employees = null;
//    //    员工有所属部门
//    @Autowired
//    private DepartmentDao departmentDao;
//
//    static {
//        employees = new HashMap<Integer, Employee>();
//        employees.put(1001, new Employee(1001, "aa", "845391058@qq.com", 1, new Department(101, "教学部")));
//        employees.put(1002, new Employee(1002, "bb", "25345431s@qq.com", 0, new Department(102, "市场部")));
//        employees.put(1003, new Employee(1003, "cc", "564724353@qq.com", 1, new Department(103, "教研部")));
//        employees.put(1004, new Employee(1004, "dd", "543253432@qq.com", 0, new Department(104, "运营部")));
//        employees.put(1005, new Employee(1005, "ee", "457564345@qq.com", 1, new Department(105, "后勤部")));
//    }
//
//    //    增加员工
////    id自增
//    private static Integer iniId = 1006;
//
//    public void add(Employee employee) {
//        if (employee.getId() == null) {
//            employee.setId(iniId++);
//        }
//
//        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
//        employees.put(employee.getId(), employee);
//    }
//
////    查询全部员工
//    public Collection<Employee> getAll(){
//        return employees.values();
//    }
//
////    通过id查询员工
//    public Employee getEmployee(Integer id){
//        return employees.get(id);
//    }
////    删除员工
//    public void delete(Integer id){
//        employees.remove(id);
//    }
//
//    public void add() {
//    }
}
