package edu.bearcat.microservice.service;

import edu.bearcat.microservice.entities.Cart;
import edu.bearcat.microservice.entities.ProductVO;
import edu.bearcat.microservice.fallbackFactory.CartClientServiceFallBackFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by haohao on 2019-4-10.
 */
@FeignClient(value = "springcloud-service-cart",fallbackFactory = CartClientServiceFallBackFactory.class)
@RequestMapping("/cart")
public interface CartClientService  {

    @RequestMapping(value = "/ids", method = RequestMethod.GET)
    public Cart findByIds(Cart cart);

    @RequestMapping(value = "/id", method = RequestMethod.GET)
    public Cart findByCartId(Cart cart);

    @RequestMapping(value = "", method = RequestMethod.POST)
    public boolean addCart(@RequestBody Cart cart);

    @RequestMapping(value = "/details", method = RequestMethod.POST)
    public boolean addCartDetails(@RequestBody ProductVO productVO);

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public boolean modifyCart(@RequestBody Cart cart);

    @RequestMapping(value = "/details", method = RequestMethod.PUT)
    public boolean modifyCartDetails(@RequestBody ProductVO productVO);

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public boolean removeCart(@RequestBody Cart cart);

    @RequestMapping(value = "/details", method = RequestMethod.DELETE)
    public boolean removeCartDetails(@RequestBody ProductVO productVO);
}
