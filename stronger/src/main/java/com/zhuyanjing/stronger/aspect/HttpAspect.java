package com.zhuyanjing.stronger.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpAspect {

    private final  static Logger logger= LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.zhuyanjing.stronger.controller.StrongerController.*(..))")//。。表示只要是这个方法任何都可以拦截
    public void log(){

    }
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){


      ServletRequestAttributes attributes=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
      //用到一个请求对象//
      HttpServletRequest request= attributes.getRequest();

        //url
        logger.info("url={}",request.getRequestURI());

        //method
        logger.info("method={}",request.getMethod());
        //ip
        logger.info("ip={}",request.getRemoteAddr());
        //类方法
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());//传入一个参数
        //参数
        logger.info("args={}",joinPoint.getArgs());

       logger.info("11111");
    }
    @After("log()")//。。表示只要是这个方法任何都可以拦截
    public void doAfter(){
        logger.info("22222");

    }
    @AfterReturning(returning = "object", pointcut = "log()")/*返回一串参数*/
    public void doAfterReturning(Object object){
        logger.info("response={}",object.toString());/*对象打印出来啦,如果像打印具体内容加上toString（）方法*/

    }
}
