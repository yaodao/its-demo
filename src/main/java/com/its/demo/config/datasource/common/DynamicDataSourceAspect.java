package com.its.demo.config.datasource.common;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


@Aspect
@Order(-1)
@Component
public class DynamicDataSourceAspect {
    private static final Logger LOG = LoggerFactory.getLogger(DynamicDataSourceAspect.class);

//    @Pointcut("execution(* com.its.demo.service.*.*(..))")
//    public void pointCut() {
//    }

    /**
     * 执行方法前更换数据源
     */
    @Before("@annotation(targetDataSource)")
    public void doBefore(JoinPoint joinPoint, Db targetDataSource) {
        DataSourceKey dataSourceKey = targetDataSource.value();
        if (dataSourceKey == DataSourceKey.DB_MYSQL) {
            LOG.info(String.format("set datasource to  %s", DataSourceKey.DB_MYSQL));
            DynamicDataSourceContextHolder.set(DataSourceKey.DB_MYSQL);
        } else {
            LOG.info(String.format("use default datasource  %s", DataSourceKey.DB_PQ));
            DynamicDataSourceContextHolder.set(DataSourceKey.DB_PQ);
        }
    }

    /**
     * 执行方法后清除数据源设置
     */
    @After("@annotation(targetDataSource)")
    public void doAfter(JoinPoint joinPoint, Db targetDataSource) {
        LOG.info(String.format("doAfter, current datasource  %s, clear threadlocal", targetDataSource.value()));
        DynamicDataSourceContextHolder.clear();
    }

    // 这个函数用来设置默认的数据源，可以不要。因为在配置datasource时，已经指定了默认数据源。
//    @Before(value = "pointCut()")
//    public void doBeforeWithDefault(JoinPoint joinPoint) {
//        System.out.println("hehe");
//        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
//        //获取当前切点方法对象
//        Method method = methodSignature.getMethod();
//        if (method.getDeclaringClass().isInterface()) {//判断是否为接口方法
//            try {
//                //获取实际类型的方法对象
//                method = joinPoint.getTarget().getClass()
//                        .getDeclaredMethod(joinPoint.getSignature().getName(), method.getParameterTypes());
//            } catch (NoSuchMethodException e) {
//                LOG.error("{} method not exist！", joinPoint.getSignature().getName(), e);
//            }
//        }
//        if (null == method.getAnnotation(Db.class)) {
//            DynamicDataSourceContextHolder.setDefault();
//        }
//    }
}
