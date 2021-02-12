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
public class Notice {
    private Integer noticeId;
    private String title;
    private String Content;
    private Integer readedCount;
    private String createUser;
    private Date  createTime;
    private String first;
}
