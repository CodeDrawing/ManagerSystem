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

    @Override
    public void addTeacher(Teacher teacher) {
        teacherMapper.addTeacher(teacher);
    }

    @Override
    public void dropTeacher(int id) {
        teacherMapper.dropTeacher(id);
    }

    @Override
    public Teacher queryOneTeacher(Integer id) {
        Teacher teacher1 = teacherMapper.queryOneTeacher(id);
        return teacher1;
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        teacherMapper.updateTeacher(teacher);
    }


}
