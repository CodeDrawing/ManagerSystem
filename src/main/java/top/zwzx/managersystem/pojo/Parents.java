package top.zwzx.managersystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zx
 * @date 2020/10/2
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Parents {
    private Integer parentsId;
    private String parentsName;
    private Integer studentId;
    private String studentName;
    private String telephoneNumber;
    private String email;
    private String password;
    private String finalPassword;
    private String newPassword;
}
