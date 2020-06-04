package com.linxi.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author linxi
 * @function
 * @project linxiblog
 * @package com.linxi.aspect
 * @date 2020/4/28-3:40 下午*/


//日志拦截
//开启组建扫描

@Aspect
@Component
public class LogAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

//    通过注解声明切面，并设置拦截web下所有内容
    @Pointcut("execution(* com.linxi.*.*(..))")
    public void log(){}

//    在切面之前运行
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
//获取日志的url、ip、classMethod、args

        ServletRequestAttributes attributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String url = request.getRequestURI();
        String ip = request.getRemoteAddr();
        String classMethod =
                joinPoint.getSignature().getDeclaringTypeName() + "."
                        +joinPoint.getSignature().getName();
        Object [] args = joinPoint.getArgs();
        RequestLog requestLog = new RequestLog(url, ip,classMethod,args);

        logger.info("Request :{}",requestLog);
    }

    @After("log()")
    public void doAfter(){
        logger.info("====doAfter==");
    }

//    返回之后进行拦截
    @AfterReturning(returning = "result" , pointcut = "log()")
    public void doAfterReturn(Object result){
        logger.info("result :{}", result);
    }


//    用内部类记录日志内容
    private class RequestLog{
        private String url;
        private String ip;
        private String classMethod;
        private Object [] args;

        public RequestLog(String url, String ip, String classMethod, Object[] args) {
            this.url = url;
            this.ip = ip;
            this.classMethod = classMethod;
            this.args = args;
        }

        @Override
        public String toString() {
            return "RequestLog{" +
                    "url='" + url + '\'' +
                    ", ip='" + ip + '\'' +
                    ", classMethod='" + classMethod + '\'' +
                    ", args=" + Arrays.toString(args) +
                    '}';
        }
    }
}
