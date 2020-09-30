package top.zwzx.managersystem.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.zwzx.managersystem.pojo.Salary;

import java.util.List;

/**
 * @author zx
 * @date 2020/9/30
 **/
@Mapper
@Repository
public interface SalaryMapper {
    public List<Salary> showAllSalary();
}
