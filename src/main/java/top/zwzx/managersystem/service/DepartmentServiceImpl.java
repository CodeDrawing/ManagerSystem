package top.zwzx.managersystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zwzx.managersystem.mapper.DepartmentMapper;
import top.zwzx.managersystem.pojo.Department;

import java.util.List;

/**
 * @author zx
 * @date 2020/6/2
 **/
@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    DepartmentMapper departmentMapper;

    @Override
    public Department queryById(int id) {
        return departmentMapper.queryById(id);
    }

    @Override
    public List<Department> all() {
        return departmentMapper.all();
    }
}
