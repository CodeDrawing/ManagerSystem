package top.zwzx.managersystem.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.zwzx.managersystem.pojo.ClassRecord;
import top.zwzx.managersystem.pojo.Image;
import top.zwzx.managersystem.pojo.ImageStyle;
import top.zwzx.managersystem.pojo.SchoolStyle;

import java.util.List;

/**
 * @Author zx
 * @Date 2021/1/16 13:40
 */
@Mapper
@Repository
public interface SchoolStyleMapper {
    List<SchoolStyle> queryAllSchoolStyle();
    void addSchoolImage(SchoolStyle schoolStyle);
    SchoolStyle showOneBigImage(Integer id);
    List<ClassRecord> showAllClassRecord(Integer studentId);
    List<Image> showImageByClassRecordId(Integer classRecordId);
    List<ImageStyle> showAllClassImageByStudentId(Integer studentId);
}
