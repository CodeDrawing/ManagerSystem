package top.zwzx.managersystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author zx
 * @Date 2020/10/16 15:46
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DangAn {
    private Integer studentId;
    private String text;
    private Date date;
    private Integer classId;
    private String createTeacher;
    private String image;
    private Integer ID;
    private Date dateTime;
    private String studentName;
    private Date admissionTime;
    private String studentPhotoPath;
    private String className;
    private Integer classRecordId;
}
