package com.tyut.feign;

import com.tyut.domain.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @version v1.0
 * @author OldGj 2024/8/21
 * @apiNote openFeign 远程调用服务
 */
@Component
@FeignClient(value = "payment-service")
public interface PaymentFeignService {


    @GetMapping("/api/payment/findPaymentInfoById")
    R findPaymentInfoById(@RequestParam("id") Long id);

    @GetMapping("/api/payment/info")
    R info();
}
