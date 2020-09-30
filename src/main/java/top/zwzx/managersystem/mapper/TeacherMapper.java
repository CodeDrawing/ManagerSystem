package top.zwzx.managersystem.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.zwzx.managersystem.pojo.Teacher;

import java.util.List;

/**
 * @Author zx
 * @Date 2020/9/29 21:24
 */
@Mapper
@Repository
public interface TeacherMapper {

     public List<Teacher> showAllTeacher();
    
}
