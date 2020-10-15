package top.zwzx.managersystem.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.zwzx.managersystem.pojo.User;

import java.util.List;

/**
 * @author zx
 * @date 2020/9/27
 **/
@Mapper
@Repository
public interface UserMapper {
//    登陆 正确返回1 不正确返回2
   public List<User> loginIn(User user);
   //查询权限
   public int queryPermission(String name);
}
