package com.itbaizhan.service.impl;


import com.alibaba.dubbo.config.annotation.Reference;
import com.itbaizhan.pojo.CommonResult;
import com.itbaizhan.service.IOrderService;
import com.itbaizhan.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {


    /**
     *
     *  @ Autowired : 本地注入<br></br>
     *  -----------------------<br></br>
     *  @ Reference : 远程调用<br></br>
     *  1. 从zookeeper注册中心获取IOrderService访问的url。<br></br>
     *  2. 进行远程调用RPC。<br></br>
     *  3. 将结果封装为一个代理对象，给这个变量赋值。<br></br>
     *
     */
    @Reference(cache = "jcache")
    private IOrderService orderService;

    @Override
    public CommonResult findByUserId(long userId) {
        return orderService.findByUserId(userId);
    }
}
