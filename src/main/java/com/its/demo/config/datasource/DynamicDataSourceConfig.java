package com.its.demo.config.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import com.its.demo.config.datasource.common.DataSourceKey;
import com.its.demo.config.datasource.common.DynamicRoutingDataSource;
import com.its.demo.config.datasource.properties.MysqlDruidProperties;
import com.its.demo.config.datasource.properties.PostgresqlDruidProperties;
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

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;


@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = "com.its.demo.mapper", sqlSessionFactoryRef = "sqlSessionFactory")
public class DynamicDataSourceConfig {

    @Autowired
    private MysqlDruidProperties mysqlDruidProperties;

    @Autowired
    private PostgresqlDruidProperties pgDruidProperties;


    @Bean(name = "mysqlDataSource")
    public DruidDataSource mysqlDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        mysqlDruidProperties.config(dataSource);
        return dataSource;
    }

    @Bean(name = "pgDataSource")
    public DruidDataSource pgDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        pgDruidProperties.config(dataSource);
        return dataSource;
    }


    @Bean(name = "dynamicDataSource")
    public DataSource dynamicDataSource(@Qualifier("mysqlDataSource") DataSource mysqlDataSource,
                                        @Qualifier("pgDataSource") DataSource pgDataSource) {
        DynamicRoutingDataSource dataSource = new DynamicRoutingDataSource();
        dataSource.setDefaultTargetDataSource(pgDataSource);
        Map<Object, Object> dataSourceMap = new HashMap<>(2);
        dataSourceMap.put(DataSourceKey.DB_PQ, pgDataSource);
        dataSourceMap.put(DataSourceKey.DB_MYSQL, mysqlDataSource);
        dataSource.setTargetDataSources(dataSourceMap);
        return dataSource;
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dynamicDataSource") DataSource dynamicDataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dynamicDataSource);
        //此处设置为了解决找不到mapper文件的问题
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapping/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean(name = "txManager")
    public PlatformTransactionManager platformTransactionManager(@Qualifier("dynamicDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
