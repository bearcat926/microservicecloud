package edu.bearcat.microservice.service;

import edu.bearcat.microservice.entities.User;
import edu.bearcat.microservice.fallbackFactory.UserClientServiceFallBackFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * Created by haohao on 2019-4-5.
 */

@FeignClient(value = "springcloud-service-user",fallbackFactory = UserClientServiceFallBackFactory.class)
@RequestMapping("/user")
public interface UserClientService {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public User findUser(User user);

    @RequestMapping(value = "", method = RequestMethod.POST)
    public boolean addUser(@RequestBody User user);

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public boolean modifyUser(@RequestBody User user);
}
