package top.zwzx.managersystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @Author zx
 * @Date 2021/1/17 21:59
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Monitor {
    private Integer monitorId;
    private String worker;
    private Date createTime;
    private String request;
    private String operationContent;
}
