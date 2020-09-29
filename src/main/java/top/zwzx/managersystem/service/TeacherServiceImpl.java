package top.zwzx.managersystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zwzx.managersystem.mapper.TeacherMapper;
import top.zwzx.managersystem.pojo.Teacher;

import java.util.List;

/**
 * @Author zx
 * @Date 2020/9/29 21:35
 */
@Service
public class TeacherServiceImpl implements ITeacherService {
    @Autowired
    TeacherMapper teacherMapper;


    @Override
    public List<Teacher> showAllTeacher() {
        List<Teacher> teachers = teacherMapper.showAllTeacher();
        return teachers;
    }
}
