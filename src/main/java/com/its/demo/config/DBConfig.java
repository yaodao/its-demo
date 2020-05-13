package com.its.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import com.its.demo.config.properties.DruidProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;


@Configuration
@EnableTransactionManagement
public class DBConfig {

    @Resource
    private DruidProperties druidProperties;

    /**
     * 配置数据源
     */
    @Bean(name = "dataSource")
    public DruidDataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        druidProperties.config(dataSource);
        return dataSource;
    }

    // 这段不需要配置。若要配置，还需要同时在该函数里指定xml文件的位置，不然会爆出找不到xml文件中方法的错误。
//    @Bean(name = "sqlSessionFactory")
//    public SqlSessionFactoryBean sqlSessionFactory(DruidDataSource dataSource) throws Exception {
//        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
//        sessionFactory.setDataSource(dataSource);
//        return sessionFactory;
//    }

    @Bean(name = "txManager")
    public PlatformTransactionManager dataSourceTransactionManager(DruidDataSource dataSource) {
        // 指定使用DataSourceTransactionManager 事务管理器
        return new DataSourceTransactionManager(dataSource);
    }
}
