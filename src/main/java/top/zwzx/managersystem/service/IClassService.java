package top.zwzx.managersystem.service;

import top.zwzx.managersystem.pojo.ClassRecord;
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
    public classClass showOneClass(Integer id);
    public void updateClass(classClass classClass);
    public void dropClass(int id);
    public void dropStudentOfClass(Integer cId,Integer sId);
    public void comeOn(Integer sId);
    public void classRecord(ClassRecord classRecord);

}
