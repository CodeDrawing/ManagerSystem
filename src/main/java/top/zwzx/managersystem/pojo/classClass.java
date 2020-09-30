package top.zwzx.managersystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author zx
 * @Date 2020/9/29 22:56
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class classClass {
    private int classId;
    private String className;
    private String classRoom;
    private Date classTime;
}
