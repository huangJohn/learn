package com.example.interceptor;

import com.alibaba.fastjson.JSON;
import com.example.constant.ControllerError;
import com.example.exception.StudyRuntimeException;
import com.google.common.collect.Maps;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class GlobalExceptionInterceptor implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        ModelAndView mv = new ModelAndView();
        System.out.println("全局异常拦截");
        System.out.println(httpServletRequest.getMethod());
        try {
            if (e instanceof StudyRuntimeException) {
                setJsonErrorResponse(httpServletResponse, ((StudyRuntimeException) e).getError());
            } else {
                setJsonErrorResponse(httpServletResponse, ControllerError.SYSTEM_ERROR);
            }
        } catch (Exception ee) {
            ee.printStackTrace();
        }
        return mv;
    }

    private void setJsonErrorResponse(HttpServletResponse response, ControllerError error) throws IOException {
        Map<String, Object> map = Maps.newHashMap();
        map.put("status", "failed");
        map.put("errorCode", error.getErrorCode());
        map.put("errorMsg", error.getErrorDesc());
        response.addHeader("Content-Type", "application/json;chaset=UTF-8");
        System.out.println(error.getErrorDesc());
        response.getOutputStream().write(JSON.toJSONBytes(map));
    }

}

















