package top.zwzx.managersystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zwzx.managersystem.mapper.SchoolStyleMapper;
import top.zwzx.managersystem.pojo.ClassRecord;
import top.zwzx.managersystem.pojo.Image;
import top.zwzx.managersystem.pojo.ImageStyle;
import top.zwzx.managersystem.pojo.SchoolStyle;

import java.util.List;

/**
 * @Author zx
 * @Date 2021/1/16 13:44
 */
@Service
public class SchoolStyleServiceImpl implements ISchoolStyleService {
    @Autowired
    SchoolStyleMapper schoolStyleMapper;

    @Override
    public List<SchoolStyle> queryAllSchoolStyle() {
        List<SchoolStyle> schoolStyleMappers = schoolStyleMapper.queryAllSchoolStyle();
        return schoolStyleMappers;
    }

    @Override
    public void addSchoolImage( SchoolStyle schoolStyle) {
        schoolStyleMapper.addSchoolImage(schoolStyle);
    }

    @Override
    public SchoolStyle showOneBigImage(Integer id) {
        SchoolStyle schoolStyle = schoolStyleMapper.showOneBigImage(id);
        return schoolStyle;
    }

    @Override
    public List<ClassRecord> showAllClassRecord(Integer studentId) {
        List<ClassRecord> classRecords = schoolStyleMapper.showAllClassRecord(studentId);
        return classRecords;
    }

    @Override
    public List<Image> showImageByClassRecordId(Integer classRecordId) {
        List<Image> images = schoolStyleMapper.showImageByClassRecordId(classRecordId);
        return images;
    }

    @Override
    public List<ImageStyle> showAllClassImageByStudentId(Integer studentId) {
        List<ImageStyle> imageStyles = schoolStyleMapper.showAllClassImageByStudentId(studentId);
        return imageStyles;
    }
}
