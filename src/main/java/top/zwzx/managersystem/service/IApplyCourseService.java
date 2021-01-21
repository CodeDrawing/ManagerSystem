package top.zwzx.managersystem.service;

import top.zwzx.managersystem.pojo.ApplyCourse;
import top.zwzx.managersystem.pojo.Course;

import java.util.List;

/**
 * @Author zx
 * @Date 2021/1/18 18:12
 */
public interface IApplyCourseService {
    void addApplyCourse(ApplyCourse applyCourse);
    List<ApplyCourse> showAllApplyCourse();

}
