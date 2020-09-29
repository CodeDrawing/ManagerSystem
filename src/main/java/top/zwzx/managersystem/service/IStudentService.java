package top.zwzx.managersystem.service;

import top.zwzx.managersystem.pojo.Student;

import java.util.List;

/**
 * @author zx
 * @date 2020/9/29
 **/
public interface IStudentService {
    //查询所有学生信息
    public List<Student> showAllStudent();
}
