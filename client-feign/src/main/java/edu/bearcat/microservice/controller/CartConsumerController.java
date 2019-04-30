package edu.bearcat.microservice.controller;

import edu.bearcat.microservice.entities.Cart;
import edu.bearcat.microservice.entities.ProductVO;
import edu.bearcat.microservice.service.CartClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by haohao on 2019-4-10.
 * 购物车消费者控制层
 */
@SuppressWarnings("unchecked")
@RequestMapping("/consumer/cart")
@RestController
public class CartConsumerController {

    @Autowired
    private CartClientService cartClientService;
    
    @ResponseBody
    @RequestMapping(value = "/ids", method = RequestMethod.GET)
    public Map<String,Object> findByIds(Cart cart) {
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("cart",cartClientService.findByIds(cart));
        return resultMap;
    }

    @ResponseBody
    @RequestMapping(value = "/id", method = RequestMethod.GET)
    public Map<String,Object> findByCartId(Cart cart) {
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("cart",cartClientService.findByCartId(cart));
        return resultMap;
    }

    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Map<String,Object> addCart(@RequestBody Cart cart) {
        Map<String,Object> resultMap = new HashMap<>();
        //创建UUID
        String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        //设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // new Date()为获取当前系统时间
        String date = df.format(new Date());
        resultMap.put("addFlag",cartClientService.addCart(cart.setCartId(uuid).setCartPrice(0.0).setPocketNum(1).setCreateTime(date).setUpdateTime(date)));
        return resultMap;
    }

    @ResponseBody
    @RequestMapping(value = "/details", method = RequestMethod.POST)
    public Map<String,Object> addCartDetails(@RequestBody ProductVO productVO) {
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("addFlag",cartClientService.addCartDetails(productVO));
        return resultMap;
    }

    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public Map<String,Object> modifyCart(@RequestBody Cart cart) {
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("modifyFlag",cartClientService.modifyCart(cart));
        return resultMap;
    }

    @ResponseBody
    @RequestMapping(value = "/details", method = RequestMethod.PUT)
    public Map<String,Object> modifyCartDetails(@RequestBody ProductVO productVO) {
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("modifyFlag",cartClientService.modifyCartDetails(productVO));
        return resultMap;
    }

    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public Map<String,Object> removeCart(@RequestBody Cart cart) {
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("removeFlag",cartClientService.removeCart(cart));
        return resultMap;
    }

    @ResponseBody
    @RequestMapping(value = "/details", method = RequestMethod.DELETE)
    public Map<String,Object> removeCartDetails(ProductVO productVO) {
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("removeFlag",cartClientService.removeCartDetails(productVO));
        return resultMap;
    }
}
