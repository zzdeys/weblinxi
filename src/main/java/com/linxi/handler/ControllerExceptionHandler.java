package com.linxi.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author linxi
 * @function
 * @project linxiblog
 * @package com.linxi.handler
 * @date 2020/4/28-12:01 上午
 */
//拦截controller注解控制器
@ControllerAdvice
public class ControllerExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

//    控制返回的页面
//        表示方法可以进行异常处理
    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHander(HttpServletRequest request,Exception e) throws Exception {

//        记录异常信息
        logger.error("Request URL :{},Exception : {} ", request.getRequestURI(),e);

//        不拦截的情况
        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) {
            throw e;
        }
//        返回错误页面
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("url",request.getRequestURI());
        modelAndView.addObject("exception",e);
//        返回错误页面的路径
        modelAndView.setViewName("error/error");

        return modelAndView;
    }

}
