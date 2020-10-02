package top.zwzx.managersystem;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.zwzx.managersystem.pojo.Student;
import top.zwzx.managersystem.service.IStudentService;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Date;

@SpringBootTest
class ManagersystemApplicationTests {
    @Autowired
    DataSource dataSource;
    @Autowired
    IStudentService iStudentService;

    @Test
    void contextLoads() throws SQLException {
        System.out.println(dataSource.getClass());
        System.out.println(dataSource.getConnection());
    }
    @Test
    void text()  {
        Student student = new Student();
        student.setAdmissionTime(new Date());
        student.setAge(10);
        student.setParentsName("lisi");
        student.setRelationshipWithStudent("父");
        student.setRestOfClass(70);
        student.setSex("男");
        student.setStudentName("李四");
        student.setTelephoneNumber("12345656812");
        iStudentService.addStudent(student);
        int i = iStudentService.queryStudentId(student);
        System.out.println(i);
        student.setStudentId(i);
    }
    @Test
    void text2(){
        Student student = new Student();
        student.setStudentName("张三");
        int i = iStudentService.queryStudentId(student);
        System.out.println(i);
    }
    @Test
    void text3(){
        Student student = new Student();
        student.setAdmissionTime(new Date());
        student.setAge(20);
        student.setParentsName("赵兴");
        student.setRelationshipWithStudent("父");
        student.setRestOfClass(20);
        student.setSex("男");
        student.setStudentName("张薇");
        student.setTelephoneNumber("1231241231");
        iStudentService.addStudent(student);
    }

}
