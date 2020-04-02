package cn.itcast.service.client;

import cn.itcast.service.pojo.User;
import org.springframework.stereotype.Component;

import javax.jws.soap.SOAPBinding;

@Component
public class UserClientFallBack implements UserClient {
    @Override
    public User queryUserById(Long id) {
        User user = new User();
        user.setUserName("服务器正忙，请稍后再试!");
        return user;
    }
}
