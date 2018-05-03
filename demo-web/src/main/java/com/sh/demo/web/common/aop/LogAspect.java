package com.sh.demo.web.common.aop;

import com.alibaba.fastjson.JSON;
import com.sh.demo.common.base.log.SystemLog;
import com.sh.demo.service.impl.AuthorServiceImpl;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wuminggu on 2018/4/23.
 */
@Aspect
@Component
public class LogAspect {
    private Logger log = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("execution(* com.sh.demo.service.impl.*.*(..))")
    public void serviceLogAspect() {
    }

    @Before("serviceLogAspect()")
    public void doBefore(JoinPoint point) {
        log.error("L23_ before update db do Nothing!");
    }

    @After("serviceLogAspect()")
    public void doAfter(JoinPoint point) {
        try {

            // Ŀ���������
            String className = point.getTarget().getClass().getName();
            // ����ǩ������
            String methodName = point.getSignature().getName();
            log.error("L38_ param className is {}, methodName is {}", className, methodName);
            // ����б�
            Object[] arguments = point.getArgs();

            String description = getControllerMethodDescription(point);
            List<Object> list = null;
            log.error("L42_ arguments is {}", JSON.toJSONString(arguments));
            if (null != arguments && arguments.length > 0) {
                list = Arrays.asList(arguments);
            }
            if (className.equals(AuthorServiceImpl.class.getName()) && methodName.equals("searchAuthorList")) {
                log.error("L45_ result is {}", description);
            }
        } catch (Exception e) {
            log.error("doAfter exception e:",e);
        }

    }

    @AfterReturning("serviceLogAspect()")
    public void doAfterReturning() {
        // ִ�гɹ���֪ͨ
        log.error("�����ɹ�ִ�к�֪ͨ ��־��¼");
    }

    @AfterThrowing(pointcut = "serviceLogAspect()", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Throwable e) {
        // �׳��쳣��֪ͨ�����Դ�ӡ����־��ߣ����ߴ������ݿ����
        try {
            String className = joinPoint.getTarget().getClass().getName();
            String methodName = joinPoint.getSignature().getName();
            log.error("L78_className is {},methodName is {}", className, methodName);
        } catch (Exception e1) {
            log.error("L77_exception is:", e);
    }
}
    @SuppressWarnings("rawtypes")
    private static String getControllerMethodDescription(JoinPoint joinPoint)  throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        // ���������Ҫ����ע�����
        Class targetClass = Class.forName(targetName);
        // ���������Ҫ����ע�����
        Method[] methods = targetClass.getMethods();
        String description = "";
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    description = method.getAnnotation(SystemLog.class).description();
                    break;
                }
            }
        }
        return description;
    }

}
