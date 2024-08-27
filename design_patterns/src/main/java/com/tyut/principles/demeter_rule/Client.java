package com.tyut.principles.demeter_rule;

/**
 * @author HX 2024/02/19
 * @version v1.0
 * @apiNote 测试类
 */
public class Client {
    public static void main(String[] args) {
        // 创建经纪人对象
        Agent agent = new Agent();
        // 创建明星对象
        Star star = new Star("迪丽热巴");
        // 创建媒体公司对象
        Company company = new Company("无忧传媒");
        // 创建粉丝对象
        Fans fans = new Fans("狗仔");
        agent.setCompany(company);
        agent.setFans(fans);
        agent.setStar(star);

        agent.meeting();
        agent.business();
    }
}
