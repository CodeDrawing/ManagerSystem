package top.zwzx.managersystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zwzx.managersystem.mapper.UserMapper;
import top.zwzx.managersystem.pojo.User;

import java.util.List;

/**
 * @author zx
 * @date 2020/9/27
 **/
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> loginIn(User user) {
        List<User> users = userMapper.loginIn(user);
        return users;
    }
}
