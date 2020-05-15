package com.its.demo.config.properties;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

public class CommonAttribute {
    private static Integer initialSize = 10;

    private static Integer minIdle = 3;

    private static Integer maxActive = 60;

    private static Integer maxWait = 60000;

    private static Boolean removeAbandoned = true;

    private static Integer removeAbandonedTimeout = 180;

    private static Integer timeBetweenEvictionRunsMillis = 60000;

    private static Integer minEvictableIdleTimeMillis = 300000;

    private static String validationQuery = "SELECT 'x'";

    private static Boolean testWhileIdle = true;

    private static Boolean testOnBorrow = false;

    private static Boolean testOnReturn = false;

    private static Boolean poolPreparedStatements = true;

    private static Integer maxPoolPreparedStatementPerConnectionSize = 50;

    private static String filters = "stat";

    public  static void config(DruidDataSource dataSource) {
        dataSource.setInitialSize(initialSize);     // 定义初始连接数
        dataSource.setMinIdle(minIdle);             // 最小空闲
        dataSource.setMaxActive(maxActive);         // 定义最大连接数
        dataSource.setMaxWait(maxWait);             // 获取连接等待超时的时间
        dataSource.setRemoveAbandoned(removeAbandoned); // 超过时间限制是否回收
        dataSource.setRemoveAbandonedTimeout(removeAbandonedTimeout); // 超过时间限制多长

        // 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
        dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        // 配置一个连接在池中最小生存的时间，单位是毫秒
        dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        // 用来检测连接是否有效的sql，要求是一个查询语句
        dataSource.setValidationQuery(validationQuery);
        // 申请连接的时候检测
        dataSource.setTestWhileIdle(testWhileIdle);
        // 申请连接时执行validationQuery检测连接是否有效，配置为true会降低性能
        dataSource.setTestOnBorrow(testOnBorrow);
        // 归还连接时执行validationQuery检测连接是否有效，配置为true会降低性能
        dataSource.setTestOnReturn(testOnReturn);
        // 打开PSCache，并且指定每个连接上PSCache的大小
        dataSource.setPoolPreparedStatements(poolPreparedStatements);
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
        // 属性类型是字符串，通过别名的方式配置扩展插件，常用的插件有：
        // 监控统计用的filter:stat
        // 日志用的filter:log4j
        // 防御SQL注入的filter:wall
        try {
            dataSource.setFilters(filters);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}