package com.its.demo.config.datasource.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;


public class DynamicRoutingDataSource extends AbstractRoutingDataSource {
    private static final Logger LOG = LoggerFactory.getLogger(DynamicRoutingDataSource.class);

    @Override
    protected Object determineCurrentLookupKey() {
        LOG.info("threadLocal current datasource：{}" + DynamicDataSourceContextHolder.get());
        return DynamicDataSourceContextHolder.get();
    }
}
