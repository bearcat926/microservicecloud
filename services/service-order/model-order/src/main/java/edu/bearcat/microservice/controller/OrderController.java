package edu.bearcat.microservice.controller;


import edu.bearcat.microservice.entities.Order;
import edu.bearcat.microservice.entities.ProductVO;
import edu.bearcat.microservice.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 订单表 前端控制器
 * </p>
 *
 * @author haohao
 * @since 2019-04-11
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @RequestMapping(value = "/ids",method = RequestMethod.GET)
    public List<Order> selectByIds(@RequestBody Order order) {
        return orderService.selectByIds(order);
    }

    @RequestMapping(value = "/id",method = RequestMethod.GET)
    public Order selectByOrderId(@RequestBody Order order) {
        return orderService.selectByOrderId(order);
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    public boolean insertOrder(@RequestBody Order order) {
        return orderService.insertOrder(order);
    }

    @RequestMapping(value = "/details",method = RequestMethod.POST)
    public boolean insertOrderDetails(@RequestBody ProductVO productVO) {
        return orderService.insertOrderDetails(productVO);
    }

    @RequestMapping(value = "",method = RequestMethod.PUT)
    public boolean updateOrder(@RequestBody Order order) {
        return orderService.updateOrder(order);
    }
}
