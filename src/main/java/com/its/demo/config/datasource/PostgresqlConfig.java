//package com.its.demo.config.datasource;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import com.its.demo.config.datasource.properties.PostgresqlDruidProperties;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//import tk.mybatis.spring.annotation.MapperScan;
//
//@Configuration
//@EnableTransactionManagement
//@MapperScan(basePackages = "com.its.demo.mapper.pq", sqlSessionFactoryRef = "pgSqlSessionFactory")
//public class PostgresqlConfig {
//    @Autowired
//    private PostgresqlDruidProperties druidProperties;
//
//    /**
//     * 配置数据源
//     */
//    @Primary
//    @Bean(name = "pgDataSource")
//    public DruidDataSource dataSource() {
//        DruidDataSource dataSource = new DruidDataSource();
//        druidProperties.config(dataSource);
//        return dataSource;
//    }
//
//
//    @Primary
//    @Bean("pgSqlSessionFactory")
//    public SqlSessionFactoryBean sqlSessionFactory(@Qualifier("pgDataSource") DruidDataSource dataSource) throws Exception {
//        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
//        sessionFactory.setDataSource(dataSource);
//        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().
//                getResources("classpath:mapping/postgresql/*.xml"));
//        return sessionFactory;
//    }
//
//
//
//    @Primary
//    @Bean(name = "pgTxManager")
//    public PlatformTransactionManager dataSourceTransactionManager(@Qualifier("pgDataSource") DruidDataSource dataSource) {
//        // 指定使用DataSourceTransactionManager 事务管理器
//        return new DataSourceTransactionManager(dataSource);
//    }
//
//    @Primary
//    @Bean(name = "pgSessionTemplate")
//    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("pgSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
//}
