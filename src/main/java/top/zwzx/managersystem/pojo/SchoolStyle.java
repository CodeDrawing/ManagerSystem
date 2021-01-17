package top.zwzx.managersystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @Author zx
 * @Date 2021/1/16 13:38
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SchoolStyle {
    private Integer imageId;
    private String createUser;
    private Date createTime;
    private String image;

}
