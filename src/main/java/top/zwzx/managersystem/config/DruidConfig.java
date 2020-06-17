package top.zwzx.managersystem.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;

/**
 * @author zx
 * @date 2020/6/2
 **/
@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix="spring.datasource")
    @Bean
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }
    //配置 Druid 监控管理后台的Servlet；
//内置 Servlet 容器时没有web.xml文件，所以使用 Spring Boot 的注册 Servlet 方式
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");

//        后台需要有人登陆
         HashMap<String,String> initParameters=new HashMap<>();
//         增加配置
        initParameters.put("loginUsername","zwzx");//loginUsername,loginPassword 是固定的
        initParameters.put("loginPassword","08290516");
//        运行谁可以访问
        initParameters.put("allow","localhost");
//        禁止谁能访问
        initParameters.put("aaa","192.168.9.12");

        bean.setInitParameters(initParameters);
        return bean;
    }
        @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();

        bean.setFilter(new WebStatFilter());

//        可以过滤哪些请求
        HashMap<String,String> initParameters = new HashMap<>();

//        这些东西不进行统计
        initParameters.put("exclusions","*.js,*.css,/druid/*");

        bean.setInitParameters(initParameters);

        return bean;

    }

}
