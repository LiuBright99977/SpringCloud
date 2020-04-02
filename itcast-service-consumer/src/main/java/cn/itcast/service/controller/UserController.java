package cn.itcast.service.controller;

import cn.itcast.service.client.UserClient;
import cn.itcast.service.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@RequestMapping("/consumer/user")
//@DefaultProperties(defaultFallback = "fallBack") //定义全局的熔断方法
public class UserController {

//    @Autowired
//    RestTemplate restTemplate;

//    @Autowired
//    DiscoveryClient discoveryClient;//包含了拉取的所有服务信息

    @Autowired
    UserClient userClient;

    @GetMapping
    @ResponseBody
    public String queryUserById(Long id) {
        return userClient.queryUserById(id).toString();
//        if (id == 1) {
//            throw new RuntimeException();
//        }
        //getInstances(微服务名称),返回值是一个集合,因为以后要搭建集群,有多台服务器
        // List<ServiceInstance> instances = discoveryClient.getInstances("service-provider");
        //现在只有一台,获取一个实例
        // ServiceInstance serviceInstance = instances.get(0);
        //获取这台服务器的host和port实现动态拼接
        //return restTemplate.getForObject("http://service-provider/user/" + id, String.class);
        // return restTemplate.getForObject("http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/user/" + id, User.class);
        // return restTemplate.getForObject("http://localhost:8081/user/" + id, User.class);
    }

//    public String fallBack() {
//        return "服务器正忙，请稍候再试";
//    }
}
