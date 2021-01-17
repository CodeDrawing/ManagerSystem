package top.zwzx.managersystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author zx
 * @Date 2020/9/29 21:28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

    private Integer teacherId;
    private String teacherName;
    private String position;//职位
    private Date comeTime;
    private String telephoneNumber;
    private String briefIntroduction;//简介
    private String declaration;//宣言
    private String image;//照片

}
