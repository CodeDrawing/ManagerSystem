package top.zwzx.managersystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zwzx.managersystem.mapper.DangAnMapper;
import top.zwzx.managersystem.pojo.DangAn;

import java.util.List;

/**
 * @Author zx
 * @Date 2020/10/16 19:46
 */
@Service
public class DangAnServiceImpl implements IDangAnSerivce {
    @Autowired
    DangAnMapper dangAnMapper;
    @Override
    public List<DangAn> showClassRecord(Integer id) {
        List<DangAn> dangAns = dangAnMapper.showClassRecord(id);
        return dangAns;
    }

    @Override
    public List<DangAn> showImage(Integer id) {
        List<DangAn> dangAns = dangAnMapper.showImage(id);
        return dangAns;
    }

    @Override
    public DangAn showOneClassRecord(Integer id) {
        DangAn dangAn = dangAnMapper.showOneClassRecord(id);
        return dangAn;
    }

    @Override
    public void updateClassRecord(DangAn dangAn) {
        dangAnMapper.updateClassRecord(dangAn);
    }

    @Override
    public void addImage(DangAn dangAn) {
        dangAnMapper.addImage(dangAn);
    }

    @Override
    public List<DangAn> showStudentOfImage(DangAn dangAn) {
        List<DangAn> dangAn1 = dangAnMapper.showStudentOfImage(dangAn);
        return dangAn1;
    }
}
