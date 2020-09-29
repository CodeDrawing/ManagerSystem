package top.zwzx.managersystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zwzx.managersystem.mapper.StudentMapper;
import top.zwzx.managersystem.pojo.Student;

import java.util.List;

/**
 * @author zx
 * @date 2020/9/29
 **/
@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    StudentMapper studentMapper;

    @Override
    public List<Student> showAllStudent() {
        List<Student> students = studentMapper.showAllStudent();
        return students;
    }
}
