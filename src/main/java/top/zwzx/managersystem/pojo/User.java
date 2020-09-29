package top.zwzx.managersystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author zx
 * @date 2020/9/27
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    Integer userId;
    String userName;
    String password;
    String permission;
    Date createTime;
}
