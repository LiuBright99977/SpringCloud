package cn;

import cn.itcast.service.ItcastServiceConsumerApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = ItcastServiceConsumerApplication.class)
@RunWith(SpringRunner.class)
public class RibbonLoadBalanceTest {
    @Autowired
    RibbonLoadBalancerClient loadBalancerClient;

    @Test
    public void test() {
        for (int i = 0; i < 50; i++) {
            //返回一个实例，哪一个实例就是由ribbon客户端负载均衡决定
            ServiceInstance instance = loadBalancerClient.choose("service-provider");
            System.out.println(instance.getHost() + ":" + instance.getPort());
        }
    }
}
