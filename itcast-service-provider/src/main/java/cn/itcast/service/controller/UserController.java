package cn.itcast.service.controller;

import cn.itcast.service.pojo.User;
import cn.itcast.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    public User queryUserById(@PathVariable("id") Long id) {
//        Thread.sleep(6000);
        return userService.queryUserById(id);
    }
}
