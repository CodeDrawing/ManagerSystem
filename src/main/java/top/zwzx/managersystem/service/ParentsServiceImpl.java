package top.zwzx.managersystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zwzx.managersystem.mapper.ParentsMapper;
import top.zwzx.managersystem.pojo.Advice;
import top.zwzx.managersystem.pojo.Parents;
import top.zwzx.managersystem.pojo.haveClass;

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

    @Override
    public Parents showOneParentsAndStudent(Integer id) {
        Parents parents = parentsMapper.showOneParentsAndStudent(id);
        return parents;
    }

    @Override
    public int updatePasswrod(Parents parents) {
        int i = parentsMapper.updatePasswrod(parents);
        return i;
    }

    @Override
    public List<haveClass> showHaveClass(Integer studentId) {
        List<haveClass> haveClasses = parentsMapper.showHaveClass(studentId);
        return haveClasses;
    }

    @Override
    public int addAdvice(Advice advice) {
        int i = parentsMapper.addAdvice(advice);
        return i;
    }

    @Override
    public List<Advice> showAdvice() {
        List<Advice> advice = parentsMapper.showAdvice();
        return advice;
    }

    @Override
    public void dropAdvice(Integer adviceId) {
        parentsMapper.dropAdvice(adviceId);
    }

    @Override
    public Advice showOneAdvice(Integer adviceId) {
        Advice advice = parentsMapper.showOneAdvice(adviceId);
        return advice;
    }

    @Override
    public void updateAdvice(Advice advice) {
        parentsMapper.updateAdvice(advice);
    }

    @Override
    public List<Advice> showAdviceByParentsIdNotFeedBack(Integer parentsId) {
        List<Advice> adviceList = parentsMapper.showAdviceByParentsIdNotFeedBack(parentsId);

        return adviceList;
    }

    @Override
    public List<Advice> showAdviceByParentsIdAlreadyFeedBack(Integer parentsId) {
        List<Advice> adviceList = parentsMapper.showAdviceByParentsIdAlreadyFeedBack(parentsId);
        return adviceList;
    }
}
