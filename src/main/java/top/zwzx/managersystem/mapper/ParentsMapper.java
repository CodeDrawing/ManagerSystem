package top.zwzx.managersystem.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.zwzx.managersystem.pojo.Parents;

import java.util.List;

/**
 * @Author zx
 * @Date 2021/1/21 12:02
 */
@Mapper
@Repository
public interface ParentsMapper {
    int registerParents(Parents parents);
    List<Parents> loginSFCByTelephoneNumber(String username, String password);
}
