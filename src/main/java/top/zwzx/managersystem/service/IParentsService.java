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
    List<Parents> showAllParentsList();
    void dropParents(Integer id);
    Parents showOneParents(Integer id);
    void updateParents(Parents parents);
    List<Parents> showOneParentsByTelephoneNumber(String telephoneNumber);

}
