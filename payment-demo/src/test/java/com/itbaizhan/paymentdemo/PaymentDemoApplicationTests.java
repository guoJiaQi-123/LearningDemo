package com.itbaizhan.paymentdemo;

import com.itbaizhan.paymentdemo.config.WxPayConfig;
import com.itbaizhan.paymentdemo.entity.OrderInfo;
import com.itbaizhan.paymentdemo.mapper.OrderInfoMapper;
import com.itbaizhan.paymentdemo.service.impl.OrderInfoServiceImpl;
import com.itbaizhan.paymentdemo.service.impl.RefundInfoServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.PrivateKey;
import java.util.List;

@SpringBootTest
class PaymentDemoApplicationTests {

    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @Autowired
    private RefundInfoServiceImpl refundInfoService;

    /**
     * 测试代码生成器生成的代码是否可用
     */
    @Test
    void contextLoads() {
        List<OrderInfo> orderInfos = orderInfoMapper.selectList(null);
        for (OrderInfo orderInfo : orderInfos) {
            System.out.println(orderInfo);
        }
    }

    @Autowired
    private WxPayConfig wxPayConfig;

    /**
     * 测试商户私钥
     */
    @Test
    void testGetPrivateKey() {
        PrivateKey privateKey = wxPayConfig.getPrivateKey();
        String domain = wxPayConfig.getDomain();// 微信支付的服务器域名地址
        System.out.println(domain);
        System.out.println(privateKey);
    }

    @Test
    void test(){
        refundInfoService.updateRefundStatus("{\n" +
                "    \"mchid\": \"1532379511\",\n" +
                "    \"out_trade_no\": \"1713572478697\",\n" +
                "    \"transaction_id\": \"4200002158202404201938001659\",\n" +
                "    \"out_refund_no\": \"1713572617227\",\n" +
                "    \"refund_id\": \"50301009332024042017723744966\",\n" +
                "    \"refund_status\": \"SUCCESS\",\n" +
                "    \"success_time\": \"2024-04-20T08:23:52+08:00\",\n" +
                "    \"amount\": {\n" +
                "        \"total\": 1,\n" +
                "        \"refund\": 1,\n" +
                "        \"payer_total\": 1,\n" +
                "        \"payer_refund\": 1\n" +
                "    },\n" +
                "    \"user_received_account\": \"支付用户零钱通\"\n" +
                "}\n");
    }


}
