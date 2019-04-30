package edu.bearcat.microservice.fallbackFactory;

import edu.bearcat.microservice.entities.User;
import edu.bearcat.microservice.service.UserClientService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * Created by haohao on 2019-4-5.
 */
@Component  //必须添加这个注解，不然Fallback不会生效
public class UserClientServiceFallBackFactory implements FallbackFactory<UserClientService> {

    @Override
    public UserClientService create(Throwable throwable) {
        return new UserClientService() {
            @Override
            public User findUser(User user){
                //查找失败，该ID：" + id + "没有对应的信息 -- Hystrix
                return null;
            }

            @Override
            public boolean addUser(User user) {
                //添加失败 -- Hystrix
                return false;
            }

            @Override
            public boolean modifyUser(User user) {
                //修改失败 -- Hystrix
                return false;
            }
        };
    }
}
