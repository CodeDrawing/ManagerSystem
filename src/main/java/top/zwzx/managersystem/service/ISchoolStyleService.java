package top.zwzx.managersystem.service;

import top.zwzx.managersystem.mapper.SchoolStyleMapper;
import top.zwzx.managersystem.pojo.SchoolStyle;

import java.util.List;

/**
 * @Author zx
 * @Date 2021/1/16 13:40
 */
public interface ISchoolStyleService {
    public List<SchoolStyle> queryAllSchoolStyle();
    public void addSchoolImage( SchoolStyle schoolStyle);

}
