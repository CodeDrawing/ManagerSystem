package top.zwzx.managersystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zwzx.managersystem.mapper.ClassMapper;
import top.zwzx.managersystem.pojo.classClass;

import java.util.List;

/**
 * @Author zx
 * @Date 2020/9/29 23:00
 */
@Service
public class ClassServiceImpl implements IClassService {

    @Autowired
    ClassMapper classMapper;

    @Override
    public List<classClass> showAllClass() {
        List<classClass> classClasses = classMapper.showAllClass();
        return classClasses;
    }
}
