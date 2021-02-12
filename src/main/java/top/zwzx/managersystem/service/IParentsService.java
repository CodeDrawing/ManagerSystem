package top.zwzx.managersystem.service;

import top.zwzx.managersystem.pojo.*;

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
    List<Notice> showNotice();
    void addNotice(Notice notice);
    void updateAllFirerIsFalse();
    Notice showFirstIsOn();
    void addReadedCount(Integer noticeId);
    void addRemindClass(RemindClass remindClass);
    List<RemindClass> showTodayClass(RemindClass remindClass);
    List<RemindClass> showTomorrowClass(RemindClass remindClass);

}
