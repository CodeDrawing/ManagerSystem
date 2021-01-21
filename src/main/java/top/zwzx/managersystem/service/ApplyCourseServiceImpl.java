package top.zwzx.managersystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zwzx.managersystem.mapper.ApplyCourseMapper;
import top.zwzx.managersystem.pojo.ApplyCourse;

import java.util.List;


/**
 * @Author zx
 * @Date 2021/1/18 18:12
 */
@Service
public class ApplyCourseServiceImpl implements IApplyCourseService{

    @Autowired
    ApplyCourseMapper applyCourseMapper;

    @Override
    public void addApplyCourse(ApplyCourse applyCourse) {
        applyCourseMapper.addApplyCourse(applyCourse);

    }

    @Override
    public List<ApplyCourse> showAllApplyCourse() {
        List<ApplyCourse> applyCourses = applyCourseMapper.showAllApplyCourse();
        return applyCourses;
    }
}
