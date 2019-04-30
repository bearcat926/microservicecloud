package edu.bearcat.microservice.service;

import edu.bearcat.microservice.entities.Order;
import edu.bearcat.microservice.entities.ProductVO;
import edu.bearcat.microservice.fallbackFactory.OrderClientServiceFallBackFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by haohao on 2019-4-11.
 */
@FeignClient(value = "springcloud-service-order",fallbackFactory = OrderClientServiceFallBackFactory.class)
@RequestMapping("/order")
public interface OrderClientService {

    @RequestMapping(value = "/ids",method = RequestMethod.GET)
    public List<Order> findByIds(Order order);

    @RequestMapping(value = "/id",method = RequestMethod.GET)
    public Order findByOrderId(Order order);

    @RequestMapping(value = "",method = RequestMethod.POST)
    public boolean addOrder(@RequestBody Order order);

    @RequestMapping(value = "/details",method = RequestMethod.POST)
    public boolean addOrderDetails(@RequestBody ProductVO productVO);

    @RequestMapping(value = "",method = RequestMethod.PUT)
    public boolean modifyOrder(@RequestBody Order order);
}
