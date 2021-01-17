package top.zwzx.managersystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author zx
 * @Date 2021/1/17 16:29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Course {
    private Integer courseId;
    private String courseName;
    private String briefIntroduction;
    private String image;
    private String detailedIntroduction;
}
