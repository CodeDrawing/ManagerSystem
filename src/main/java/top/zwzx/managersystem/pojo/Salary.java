package top.zwzx.managersystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zx
 * @date 2020/9/30
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Salary {
    private int salaryId;
    private float baseSalary;//基础工资
    private float classMoney;//课时费
    private float commission;//提成
    private Integer leaveDays;//请假天数
    private String dateTime;//年月
    private Integer issue;//是否发放过工资
    private String teacherName;
    private Integer teacherId;
    private float deductions;
    private float realWages;
}
