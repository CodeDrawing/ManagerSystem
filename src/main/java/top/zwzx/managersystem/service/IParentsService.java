package top.zwzx.managersystem.service;

import top.zwzx.managersystem.pojo.Parents;

import java.util.List;

/**
 * @Author zx
 * @Date 2021/1/21 12:07
 */
public interface IParentsService {
    int registerParents(Parents parents);
    List<Parents> loginSFCByTelephoneNumber(String username, String password);

}
