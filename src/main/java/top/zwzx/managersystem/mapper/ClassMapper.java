package top.zwzx.managersystem.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.zwzx.managersystem.pojo.classClass;

import java.util.List;

/**
 * @Author zx
 * @Date 2020/9/29 22:57
 */
@Mapper
@Repository
public interface ClassMapper {

    public List<classClass> showAllClass();

}
