package edu.bearcat.microservice.service;

import edu.bearcat.microservice.entities.Product;
import edu.bearcat.microservice.fallbackFactory.ProductClientServiceFallBackFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by haohao on 2019-4-12.
 */
@FeignClient(value = "springcloud-service-menu",fallbackFactory = ProductClientServiceFallBackFactory.class)
@RequestMapping("/product")
public interface ProductClientService {

    @RequestMapping(value = "/id",method = RequestMethod.GET)
    public Product findById(Product product);

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Product> findProductList(Product product);

    @RequestMapping(value = "",method = RequestMethod.POST)
    public boolean addProduct(@RequestBody Product product);

    @RequestMapping(value = "",method = RequestMethod.PUT)
    public boolean modifyProduct(@RequestBody Product product);

    @RequestMapping(value = "",method = RequestMethod.DELETE)
    public boolean removeProduct(@RequestBody Product product);

}
