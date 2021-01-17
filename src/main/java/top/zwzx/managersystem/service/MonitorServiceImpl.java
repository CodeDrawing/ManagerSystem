package top.zwzx.managersystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zwzx.managersystem.mapper.MonitorMapper;
import top.zwzx.managersystem.pojo.Monitor;

import java.util.List;

/**
 * @Author zx
 * @Date 2021/1/17 22:04
 */
@Service
public class MonitorServiceImpl implements IMonitorService{
    @Autowired
    MonitorMapper monitorMapper;

    @Override
    public List<Monitor> queryAllMonitorLog() {
        List<Monitor> monitors = monitorMapper.queryAllMonitorLog();
        return monitors;
    }

    @Override
    public void addMonitor(Monitor monitor) {
        monitorMapper.addMonitor(monitor);
    }
}
