package top.zwzx.managersystem.service;

import top.zwzx.managersystem.pojo.Department;

import java.util.List;

/**
 * @author zx
 * @date 2020/6/2
 **/
public interface DepartmentService {
    //    通过id查询
    public Department queryById(int id);
    //    获取所有的部门信息
    List<Department> all();
}
