package top.zwzx.managersystem.pojo;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author zx
 * @Date 2020/10/9 21:32
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassStyle {
    private Integer id;
    private Integer studentId;
    private String path;
    private String createUser;
    private Date createTime;
    private Integer classId;
}
