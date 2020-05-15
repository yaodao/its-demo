package com.its.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.its.demo.config.properties.MysqlDruidProperties;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;


@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = "com.its.demo.mapper.mysql", sqlSessionFactoryRef = "mysqlSqlSessionFactory")
public class MysqlConfig {

    @Autowired
    private MysqlDruidProperties druidProperties;

    /**
     * 配置数据源
     */
    @Bean(name = "mysqlDataSource")
    public DruidDataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        druidProperties.config(dataSource);
        return dataSource;
    }


    @Bean("mysqlSqlSessionFactory")
    public SqlSessionFactoryBean sqlSessionFactory(@Qualifier("mysqlDataSource") DruidDataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().
                getResources("classpath:mapping/mysql/*.xml"));
        return sessionFactory;
    }



    @Bean(name = "mysqlTxManager")
    public PlatformTransactionManager dataSourceTransactionManager(@Qualifier("mysqlDataSource") DruidDataSource dataSource) {
        // 指定使用DataSourceTransactionManager 事务管理器
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "mysqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("mysqlSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
