package com.its.demo.config.datasource.common;

import org.apache.commons.lang3.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DynamicDataSourceContextHolder {
    private static final Logger LOG = LoggerFactory.getLogger(DynamicDataSourceContextHolder.class);

    private static final ThreadLocal<DataSourceKey> currentDatesource = new ThreadLocal<>();

    /**
     * 清除当前数据源
     */
    public static void clear() {
        currentDatesource.remove();
    }

    /**
     * 获取当前使用的数据源
     */
    public static DataSourceKey get() {
        return currentDatesource.get();
    }

    /**
     * 设置当前使用的数据源
     */
    public static void set(DataSourceKey value) {
        currentDatesource.set(value);
    }


    public static void setDefault() {
        DynamicDataSourceContextHolder.set(DataSourceKey.DB_PQ);
    }
}
