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
public class Advice {
    private String parentsName;
    private Integer parentsId;
    private String content;
    private Date createTime;
    private String  feedBack;
    private String feedBackUser;
    private String courseName;
    private Integer adviceId;
}
