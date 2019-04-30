package edu.bearcat.microservice.controller;

import edu.bearcat.microservice.entities.Cart;
import edu.bearcat.microservice.entities.Order;
import edu.bearcat.microservice.entities.ProductVO;
import edu.bearcat.microservice.service.CartClientService;
import edu.bearcat.microservice.service.OrderClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by haohao on 2019-4-11.
 */
@SuppressWarnings("unchecked")
@RequestMapping("/consumer/order")
@RestController
public class OrderConsumerController {

    @Autowired
    private OrderClientService orderClientService;

    @Autowired
    private CartClientService cartClientService;

    @ResponseBody
    @RequestMapping(value = "/ids",method = RequestMethod.GET)
    public Map<String,Object> findByIds(Order order){
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("order",orderClientService.findByIds(order));
        return resultMap;
    }

    @ResponseBody
    @RequestMapping(value = "/id",method = RequestMethod.GET)
    public Map<String,Object> findByOrderId(Order order){
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("order",orderClientService.findByOrderId(order));
        return resultMap;
    }

    @ResponseBody
    @RequestMapping(value = "",method = RequestMethod.POST)
    public Map<String,Object> addOrder(@RequestBody Order order){
        Map<String,Object> resultMap = new HashMap<>();
        //创建UUID
        String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        //设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // new Date()为获取当前系统时间
        String date = df.format(new Date());
        String cartId = order.getOrderId();
        //创建flag判断订单是否添加成功
        boolean tempFlag;
        boolean orderFlag = orderClientService.addOrder(order.setOrderId(uuid).setCreateTime(date).setUpdateTime(date));
        Cart cart =  cartClientService.findByCartId(new Cart().setCartId(cartId));
        for(ProductVO productVO : cart.getProducts()) {
            tempFlag = orderClientService.addOrderDetails(productVO.setId(uuid));
            orderFlag &= tempFlag;
        }
        if(orderFlag){  //成功
            cartClientService.removeCart(new Cart().setCartId(cartId));
            cartClientService.removeCartDetails(new ProductVO().setId(cartId));
            resultMap.put("orderId",uuid);
        }else{
            orderClientService.modifyOrder(order.setOrderStatus("4").setUpdateTime(date));
        }
        resultMap.put("addFlag",orderFlag);
        return resultMap;
    }


    @ResponseBody
    @RequestMapping(value = "",method = RequestMethod.PUT)
    public Map<String,Object> modifyOrder(@RequestBody Order order){
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("modifyFlag",orderClientService.modifyOrder(order));
        return resultMap;
    }
}
