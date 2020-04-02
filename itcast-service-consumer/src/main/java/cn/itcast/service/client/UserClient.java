package cn.itcast.service.client;

import cn.itcast.service.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "service-provider", fallback = UserClientFallBack.class)//声明一个接口是Feign接口,指定服务的id,针对哪个服务的Feign接口
public interface UserClient {
    @GetMapping("user/{id}")
    public User queryUserById(@PathVariable("id") Long id);
}
