package top.zwzx.managersystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RemindClass {
    private Integer remindClassId;
    private Integer classId;
    private String createUser;
    private String classTime;
    private Date createTime;
    private Integer studentId;
    private String className;
    private Integer parentsId;
    private String classRoom;
    private String text;
}
