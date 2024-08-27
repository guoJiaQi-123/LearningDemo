package com.tyut.payment.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tyut.payment.domain.TPaymentInfo;
import com.tyut.payment.service.TPaymentInfoService;
import com.tyut.payment.mapper.TPaymentInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author HX
* @description 针对表【t_payment_info】的数据库操作Service实现
* @createDate 2024-08-20 18:01:23
*/
@Service
public class TPaymentInfoServiceImpl extends ServiceImpl<TPaymentInfoMapper, TPaymentInfo>
    implements TPaymentInfoService{

}




