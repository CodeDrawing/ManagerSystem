package top.zwzx.managersystem.service;

import top.zwzx.managersystem.pojo.Student;
import top.zwzx.managersystem.pojo.Teacher;
import top.zwzx.managersystem.pojo.classClass;

import java.util.List;

/**
 * @Author zx
 * @Date 2020/9/29 22:59
 */
public interface IClassService {

    public List<classClass> showAllClass();
    public void addClass(classClass classClass);
    public int countStudent(classClass classClass);
    public List<classClass> classSelect();
    public List<Student> queryStudent(int id);
    public List<Teacher> queryTeacherInfo(int id);
    public void addStudentToClass(Student student);
}
