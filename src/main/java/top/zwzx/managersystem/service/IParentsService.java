package top.zwzx.managersystem.service;

import top.zwzx.managersystem.pojo.Advice;
import top.zwzx.managersystem.pojo.Parents;
import top.zwzx.managersystem.pojo.haveClass;

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
    Parents showOneParentsAndStudent(Integer id);
    int updatePasswrod(Parents parents);
    List<haveClass> showHaveClass(Integer studentId);
    int addAdvice(Advice advice);
    List<Advice> showAdvice();
    void dropAdvice(Integer adviceId);
    Advice showOneAdvice(Integer adviceId);
    void updateAdvice(Advice advice);
    List<Advice> showAdviceByParentsIdNotFeedBack(Integer parentsId);
    List<Advice> showAdviceByParentsIdAlreadyFeedBack(Integer parentsId);

}
