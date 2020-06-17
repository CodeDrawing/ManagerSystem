package top.zwzx.managersystem.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.zwzx.managersystem.pojo.Department;

import java.util.List;

/**
 * @author zx
 * @date 2020/6/2
 **/
@Mapper
@Repository
public interface DepartmentMapper {
//    通过id查询
    public Department queryById(int id);
//    获取所有的部门信息
    List<Department> all();

}
