package top.zwzx.managersystem.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.zwzx.managersystem.pojo.Student;
import top.zwzx.managersystem.pojo.Teacher;
import top.zwzx.managersystem.pojo.classClass;

import java.util.List;

/**
 * @Author zx
 * @Date 2020/9/29 22:57
 */
@Mapper
@Repository
public interface ClassMapper {

    public List<classClass> showAllClass();
    public void addClass(classClass classClass);
    public int countStudent(classClass classClass);
    public int groupByClass();
    public List<classClass> classSelect();
    public List<Student> queryStudent(int id);
    public List<Teacher> queryTeacherInfo(int id);
    public void addStudentToClass(Student student);
    public List<classClass> queryAllTeacherName();
}
