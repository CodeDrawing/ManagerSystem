package top.zwzx.managersystem.service;

import top.zwzx.managersystem.pojo.Teacher;

import java.util.List;

/**
 * @Author zx
 * @Date 2020/9/29 21:35
 */
public interface ITeacherService {
    public List<Teacher> showAllTeacher();
    public void addTeacher( Teacher teacher);
    public void dropTeacher(int id);
    public Teacher queryOneTeacher(Integer id);
    public void updateTeacher(Teacher teacher);
}
