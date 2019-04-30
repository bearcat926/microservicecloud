package edu.bearcat.microservice.controller;

import edu.bearcat.microservice.entities.User;
import edu.bearcat.microservice.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by haohao on 2019-4-7.
 * 用户Controller层
 */

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public User findUser(@RequestBody User user){
        return userService.findUser(user);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public boolean addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public boolean modifyUser(@RequestBody User user){
        return userService.modifyUser(user);
    }

}
