package cn.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * @Description mybatis配置,因为@ConfigurationProperties默认从application.xml(yml、yaml)中读取配置（即spring的环境中），所以此处
 * 需要引入jdbc.properties文件，将其存储到spring的环境中，使用@PropertySource注解引入
 * @Author myf
 * @CreateDate 2020/11/10 9:29
 * @Version 1.0
 **/
@Configuration
@PropertySource("classpath:jdbc.properties")
public class DatasourceConfiguration {

    /**
     *  使用druid连接池作为数据源
     *  druid、dbcp、c3p0三大连接池的区别：
     *
     * @return
     */
    @Bean("dataSource")
    @ConfigurationProperties(prefix = "db")
    public DataSource setDruidDataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setMaxActive(15);
        dataSource.setInitialSize(5);
        return dataSource;
    }
}
