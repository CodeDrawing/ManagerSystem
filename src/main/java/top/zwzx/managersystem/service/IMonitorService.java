package top.zwzx.managersystem.service;

import top.zwzx.managersystem.pojo.Monitor;

import java.util.List;

/**
 * @Author zx
 * @Date 2021/1/17 22:03
 */
public interface IMonitorService {
    List<Monitor> queryAllMonitorLog();
    void addMonitor(Monitor monitor);


}
