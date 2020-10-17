package top.zwzx.managersystem.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.zwzx.managersystem.pojo.DangAn;

import java.util.List;

/**
 * @Author zx
 * @Date 2020/10/16 19:30
 */
@Mapper
@Repository
public interface DangAnMapper {
    public List<DangAn> showClassRecord(Integer id);
    public List<DangAn> showImage(Integer id);
    public DangAn showOneClassRecord(Integer id);
    public void updateClassRecord(DangAn dangAn);
    public void addImage(DangAn dangAn);
    public List<DangAn> showStudentOfImage(DangAn dangAn);

}
