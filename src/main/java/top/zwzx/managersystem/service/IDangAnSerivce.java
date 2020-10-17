package top.zwzx.managersystem.service;

import top.zwzx.managersystem.pojo.DangAn;

import java.util.List;

/**
 * @Author zx
 * @Date 2020/10/16 19:45
 */
public interface IDangAnSerivce {
    public List<DangAn> showClassRecord(Integer id);
    public List<DangAn> showImage(Integer id);
    public DangAn showOneClassRecord(Integer id);
    public void updateClassRecord(DangAn dangAn);
    public void addImage(DangAn dangAn);
    public List<DangAn> showStudentOfImage(DangAn dangAn);
}
