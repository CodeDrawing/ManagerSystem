package top.zwzx.managersystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zwzx.managersystem.mapper.ClassMapper;
import top.zwzx.managersystem.pojo.Student;
import top.zwzx.managersystem.pojo.Teacher;
import top.zwzx.managersystem.pojo.classClass;

import java.util.List;

/**
 * @Author zx
 * @Date 2020/9/29 23:00
 */
@Service
public class ClassServiceImpl implements IClassService {

    @Autowired
    ClassMapper classMapper;

    @Override
    public List<classClass> showAllClass() {
        List<classClass> classClasses = classMapper.showAllClass();
        return classClasses;
    }

    @Override
    public void addClass(classClass classClass) {
        classMapper.addClass(classClass);
    }

    @Override
    public int countStudent(classClass classClass) {
        int i = classMapper.countStudent(classClass);
        return i;
    }

    @Override
    public List<classClass> classSelect() {
        List<classClass> classClasses = classMapper.classSelect();
        return classClasses;
    }

    @Override
    public List<Student> queryStudent(int id) {
        List<Student> students = classMapper.queryStudent(id);
        return students;
    }

    @Override
    public List<Teacher> queryTeacherInfo(int id) {
        List<Teacher> teachers = classMapper.queryTeacherInfo(id);
        return teachers;
    }

    @Override
    public void addStudentToClass(Student student) {
        classMapper.addStudentToClass(student);
    }


}
