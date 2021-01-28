package top.zwzx.managersystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zwzx.managersystem.mapper.ParentsMapper;
import top.zwzx.managersystem.pojo.Parents;

import java.util.List;

/**
 * @Author zx
 * @Date 2021/1/21 12:07
 */
@Service
public class ParentsServiceImpl implements IParentsService{
    @Autowired
    ParentsMapper parentsMapper;
    @Override
    public int registerParents(Parents parents) {
        int i = parentsMapper.registerParents(parents);
        return i;
    }

    @Override
    public List<Parents> loginSFCByTelephoneNumber(String username, String password) {
       List<Parents> parents = parentsMapper.loginSFCByTelephoneNumber(username, password);
        return parents;
    }

    @Override
    public List<Parents> showAllParentsList() {
        List<Parents> parents = parentsMapper.showAllParentsList();
        return parents;
    }

    @Override
    public void dropParents(Integer id) {
        parentsMapper.dropParents(id);
    }

    @Override
    public Parents showOneParents(Integer id) {
        Parents parents = parentsMapper.showOneParents(id);
        return parents;
    }

    @Override
    public void updateParents(Parents parents) {
        parentsMapper.updateParents(parents);
    }

    @Override
    public List<Parents> showOneParentsByTelephoneNumber(String telephoneNumber) {
        List<Parents> parents = parentsMapper.showOneParentsByTelephoneNumber(telephoneNumber);
        return parents;
    }
}
