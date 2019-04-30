package edu.bearcat.microservice.controller;


import edu.bearcat.microservice.entities.Cart;
import edu.bearcat.microservice.entities.ProductVO;
import edu.bearcat.microservice.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 购物车表 前端控制器
 * </p>
 *
 * @author haohao
 * @since 2019-04-10
 */
@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private ICartService cartService;

    @RequestMapping(value = "/ids", method = RequestMethod.GET)
    public Cart selectByIds(@RequestBody Cart cart) {
        return cartService.selectByIds(cart);
    }

    @RequestMapping(value = "/id", method = RequestMethod.GET)
    public Cart selectByCartId(@RequestBody Cart cart) {
        return cartService.selectByCartId(cart);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public boolean insertCart(@RequestBody Cart cart) {
        return cartService.insertCart(cart);
    }

    @RequestMapping(value = "/details", method = RequestMethod.POST)
    public boolean insertCartDetails(@RequestBody ProductVO productVO) {
        return cartService.insertCartDetails(productVO);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public boolean updateCart(@RequestBody Cart cart) {
        return cartService.updateCart(cart);
    }

    @RequestMapping(value = "/details", method = RequestMethod.PUT)
    public boolean updateCartDetails(@RequestBody ProductVO productVO) {
        return cartService.updateCartDetails(productVO);
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public boolean deleteCart(@RequestBody Cart cart) {
        return cartService.deleteCart(cart);
    }

    @RequestMapping(value = "/details", method = RequestMethod.DELETE)
    public boolean deleteCartDetails(@RequestBody ProductVO productVO) {
        return cartService.deleteCartDetails(productVO);
    }
}
