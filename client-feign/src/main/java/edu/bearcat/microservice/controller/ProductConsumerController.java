package edu.bearcat.microservice.controller;

import edu.bearcat.microservice.entities.Product;
import edu.bearcat.microservice.service.ProductClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by haohao on 2019-4-12.
 */
@SuppressWarnings("unchecked")
@RequestMapping("/consumer/product")
@RestController
public class ProductConsumerController {

    @Autowired
    private ProductClientService productClientService;

    @ResponseBody
    @RequestMapping(value = "/id", method = RequestMethod.GET)
    public Map<String, Object> findByIds(Product product) {
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("product",productClientService.findById(product));
        return resultMap;
    }

    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Map<String, Object> findProductList(Product product) {
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("productList",productClientService.findProductList(product));
        return resultMap;
    }

    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Map<String, Object> addProduct(@RequestBody Product product) {
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("addFlag",productClientService.addProduct(product));
        return resultMap;
    }

    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public Map<String, Object> modifyProduct(@RequestBody Product product) {
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("modifyFlag",productClientService.modifyProduct(product));
        return resultMap;
    }

    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public Map<String, Object> deleteProduct(@RequestBody Product product) {
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("removeFlag",productClientService.removeProduct(product));
        return resultMap;
    }
}
