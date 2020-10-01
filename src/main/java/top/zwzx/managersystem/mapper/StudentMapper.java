package top.zwzx.managersystem.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import top.zwzx.managersystem.pojo.Student;

import java.util.List;

/**
 * @author zx
 * @date 2020/9/29
 **/
@Mapper
@Repository
public interface StudentMapper {
    //查询所有学生信息
    public List<Student> showAllStudent();
    public int queryStudentId(Student student);
    public int queryParentsId(Student student);
    public void addStudent(Student student);
    public void addStudentParents(Student student);//添加parents表里的studentId
    public void addParentsStudent(Student student);//添加student表里的parentsId

}
