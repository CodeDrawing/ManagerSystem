package top.zwzx.managersystem.service;

import top.zwzx.managersystem.pojo.User;

import java.util.List;

/**
 * @author zx
 * @date 2020/9/27
 **/
public interface IUserService {
    //    登陆 正确返回1 不正确返回2
    public List<User> loginIn(User user);
    public int queryPermission(String name);

}
