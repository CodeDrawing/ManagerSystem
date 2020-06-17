package top.zwzx.managersystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author zx
 * @date 2020/6/1
 **/
@Data

@NoArgsConstructor
public class Employee {
    private Integer id;
    private String lastName;
    private String email;
    private String gender;// 0 女     1 男
    private Integer dep_id;
    private Date birth;

    public Employee(Integer id, String lastName, String email, String gender) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;

//       默认的创建日期
        this.birth=new Date();
    }
}
