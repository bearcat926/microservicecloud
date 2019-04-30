package edu.bearcat.microservice.service;

import edu.bearcat.microservice.entities.Menu;
import edu.bearcat.microservice.fallbackFactory.MenuClientServiceFallBackFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by haohao on 2019-4-12.
 */
@FeignClient(value = "springcloud-service-menu",fallbackFactory = MenuClientServiceFallBackFactory.class)
@RequestMapping("/menu")
public interface MenuClientService {

    @RequestMapping(value = "",method = RequestMethod.GET)
    public List<Menu> findById(Menu menu);

    @RequestMapping(value = "",method = RequestMethod.POST)
    public boolean addMenu(@RequestBody Menu menu);

    @RequestMapping(value = "",method = RequestMethod.PUT)
    public boolean modifyMenu(@RequestBody Menu menu);

    @RequestMapping(value = "",method = RequestMethod.DELETE)
    public boolean removeMenu(@RequestBody Menu menu);
}
