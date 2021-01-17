package top.zwzx.managersystem.service;

import top.zwzx.managersystem.pojo.Course;

import java.util.List;

/**
 * @Author zx
 * @Date 2021/1/17 16:30
 */
public interface ICourseService {
    public List<Course> showAllCourse();
    public void dropCourse(Integer courseId);
    public void insertCourse(Course course);
    Course showOneCourse(Integer courseId);
    void updateCourse(Course course);


}
