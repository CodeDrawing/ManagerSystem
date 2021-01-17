package top.zwzx.managersystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zwzx.managersystem.mapper.CourseMapper;
import top.zwzx.managersystem.pojo.Course;

import java.util.List;

/**
 * @Author zx
 * @Date 2021/1/17 16:31
 */
@Service
public class CourseServiceImpl implements ICourseService{
    @Autowired
    CourseMapper courseMapper;
    @Override
    public List<Course> showAllCourse() {
        List<Course> courseList = courseMapper.showAllCourse();
        return courseList;
    }

    @Override
    public void dropCourse(Integer courseId) {
        courseMapper.dropCourse(courseId);
    }

    @Override
    public void insertCourse(Course course) {
        courseMapper.insertCourse(course);
    }

    @Override
    public Course showOneCourse(Integer courseId) {
        Course course = courseMapper.showOneCourse(courseId);
        return course;
    }

    @Override
    public void updateCourse(Course course) {
        courseMapper.updateCourse(course);
    }
}
