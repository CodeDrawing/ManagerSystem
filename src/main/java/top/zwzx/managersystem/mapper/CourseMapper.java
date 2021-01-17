package top.zwzx.managersystem.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.zwzx.managersystem.pojo.*;

import java.util.List;

/**
 * @Author zx
 * @Date 2020/9/29 22:57
 */
@Mapper
@Repository
public interface CourseMapper {
public List<Course> showAllCourse();
public void dropCourse(Integer courseId);
public void insertCourse(Course course);
Course showOneCourse(Integer courseId);
void updateCourse(Course course);
}
