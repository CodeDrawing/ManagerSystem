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
    private Integer studentId;
    private String studentName;
    private Integer age;
    private Date admissionTime;
    private String sex;
    private Integer restOfClass;
    private String parentsName;
    private String telephoneNumber;
    private String relationshipWithStudent;
    private Integer parentsId;
    private Integer classId;

}
