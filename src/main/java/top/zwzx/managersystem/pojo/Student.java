package top.zwzx.managersystem.pojo;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author zx
 * @date 2020/9/29
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int studentId;
    private String studentName;
    private int age;
    private Date admissionTime;
    private String sex;
    private int restOfClass;
}
