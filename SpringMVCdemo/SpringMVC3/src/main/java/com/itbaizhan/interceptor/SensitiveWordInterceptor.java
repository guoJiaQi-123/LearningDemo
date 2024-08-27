package com.itbaizhan.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Set;

public class  SensitiveWordInterceptor implements HandlerInterceptor {
    //url到达控制器前执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("asdas");
        return true;
    }

    //执行jsp前执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //定义敏感词列表
        String[] sensitiveWords = {"笨蛋","坏人"};
        //获取model中数据
        Map<String, Object> model = modelAndView.getModel();
        Set<Map.Entry<String, Object>> entries = model.entrySet();
        for (Map.Entry<String, Object> entry : entries) {
            String key = entry.getKey();
            String value = entry.getValue().toString();
            for (String sensitiveWord : sensitiveWords) {
                if(value.contains(sensitiveWord)){
                    String replaced = value.replaceAll(sensitiveWord, "***");
                    model.put(key,replaced);
                }
            }
        }
    }

}
