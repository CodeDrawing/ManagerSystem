package top.zwzx.managersystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @Author zx
 * @Date 2021/1/18 17:55
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ApplyCourse {
    private Integer applyId;
    private String studentName;
    private String telephone;
    private String weChar;
    private String applyCourse;
    private String comeOnTime;
    private String introducer;
}
