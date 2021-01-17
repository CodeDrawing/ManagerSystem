package top.zwzx.managersystem.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.zwzx.managersystem.pojo.Monitor;

import java.util.List;

/**
 * @Author zx
 * @Date 2021/1/17 22:00
 */
@Mapper
@Repository
public interface MonitorMapper {
    List<Monitor> queryAllMonitorLog();
    void addMonitor(Monitor monitor);
}
