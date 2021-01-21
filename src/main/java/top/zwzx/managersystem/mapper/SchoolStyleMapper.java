package top.zwzx.managersystem.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.zwzx.managersystem.pojo.SchoolStyle;

import java.util.List;

/**
 * @Author zx
 * @Date 2021/1/16 13:40
 */
@Mapper
@Repository
public interface SchoolStyleMapper {
    public List<SchoolStyle> queryAllSchoolStyle();
    public void addSchoolImage(SchoolStyle schoolStyle);
    SchoolStyle showOneBigImage(Integer id);
}
