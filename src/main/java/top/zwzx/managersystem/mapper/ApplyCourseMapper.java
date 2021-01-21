package top.zwzx.managersystem.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.zwzx.managersystem.pojo.ApplyCourse;

import java.util.List;


/**
 * @Author zx
 * @Date 2021/1/18 17:58
 */
@Mapper
@Repository
public interface ApplyCourseMapper {
    void addApplyCourse(ApplyCourse applyCourse);
    List<ApplyCourse> showAllApplyCourse();
}
