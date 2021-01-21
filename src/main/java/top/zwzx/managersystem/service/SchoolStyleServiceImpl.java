package top.zwzx.managersystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zwzx.managersystem.mapper.SchoolStyleMapper;
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
}
