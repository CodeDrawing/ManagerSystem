package top.zwzx.managersystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author zx
 * @Date 2020/10/15 17:03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassRecord {
    private Integer studentId;
    private Integer Id;
    private String text;
    private Date date;
    private Integer classId;
    private String createTeacher;
}
